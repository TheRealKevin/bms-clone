package com.kevin.bmsclone.service.impl;

import com.kevin.bmsclone.enums.BookingStatus;
import com.kevin.bmsclone.enums.ResponseCode;
import com.kevin.bmsclone.enums.SeatStatus;
import com.kevin.bmsclone.exception.BookingException;
import com.kevin.bmsclone.helper.BookingServiceHelper;
import com.kevin.bmsclone.mapper.DtoMapper;
import com.kevin.bmsclone.mapper.ResponseMapper;
import com.kevin.bmsclone.model.dto.BookingDTO;
import com.kevin.bmsclone.model.entity.*;
import com.kevin.bmsclone.model.request.BookingRequest;
import com.kevin.bmsclone.model.response.BookingResponse;
import com.kevin.bmsclone.model.response.GetBookingResponse;
import com.kevin.bmsclone.repository.BookingRepository;
import com.kevin.bmsclone.repository.ShowRepository;
import com.kevin.bmsclone.repository.ShowSeatRepository;
import com.kevin.bmsclone.repository.UserRepository;
import com.kevin.bmsclone.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.sql.Date;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private ShowSeatRepository showSeatRepository;

    @Autowired
    private BookingServiceHelper bookingServiceHelper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DtoMapper dtoMapper;

    @Autowired
    private ResponseMapper responseMapper;

    @Override
    public BookingResponse bookShow(BookingRequest bookingRequest) {
        try {

            Optional<User> optionalUser = userRepository.findUserByEmail(bookingRequest.getEmail());

            if (optionalUser.isEmpty() || CollectionUtils.isEmpty(bookingRequest.getSeatList())) {
                throw new BookingException(ResponseCode.BAD_REQUEST);
            }

            Optional<Show> optionalShow = showRepository.findById(bookingRequest.getShowId());

            if (optionalShow.isEmpty()) {
                return responseMapper.mapBookingResponse(bookingRequest, ResponseCode.NO_SHOW_AVAILABLE);
            }

            List<ShowSeat> showSeatList = showSeatRepository.findByShow(optionalShow.get());

            if (CollectionUtils.isEmpty(showSeatList)) {
                return responseMapper.mapBookingResponse(bookingRequest, ResponseCode.INTERNAL_SERVER_ERROR);
            }

            Hall hall = showSeatList.get(0).getShow().getHall();

            List<Seat> seatsToBeBooked = bookingRequest.getSeatList();

            // TODO : One optimization is that we can have a SeatStatus.EMPTY check within this method
            List<ShowSeat> showSeatsToBeBooked = bookingServiceHelper.getShowSeats(seatsToBeBooked, showSeatList, hall);

            for (ShowSeat showSeat : showSeatsToBeBooked) {
                if (!(showSeat.getSeatStatus() == SeatStatus.EMPTY)) {
                    throw new BookingException(ResponseCode.SEAT_NOT_AVAILABLE);
                }
            }

            double amountToPay = 0;

            for (ShowSeat showSeat : showSeatsToBeBooked) {
                amountToPay += showSeat.getPrice();

                showSeat.setSeatStatus(SeatStatus.LOCKED);
                showSeatRepository.save(showSeat);
            }

            Booking booking = new Booking();

            booking.setUser(optionalUser.get());
            booking.setBookingStatus(BookingStatus.PENDING);
            booking.setBookingDate(new Date(System.currentTimeMillis()));
            booking.setTotalPrice(amountToPay);

            Booking persistedBooking = bookingRepository.save(booking);

            BookingResponse bookingResponse = responseMapper.mapBookingResponse(bookingRequest, BookingStatus.PENDING);
            bookingResponse.setBookingId(booking.getBookingId());
            bookingResponse.setTotalPrice(amountToPay);

            // TODO : ADD Payment gateway!
            // TODO : Post payment flow below

            for (ShowSeat showSeat : showSeatsToBeBooked) {
                showSeat.setBooking(persistedBooking);
                showSeat.setSeatStatus(SeatStatus.RESERVED);
                showSeatRepository.save(showSeat);
            }

            bookingResponse.setResponseMessage(BookingStatus.CONFIRMED.name());

            booking.setBookingStatus(BookingStatus.CONFIRMED);
            bookingRepository.save(booking);

            return bookingResponse;

        } catch (BookingException ex) {
            return responseMapper.mapBookingResponse(bookingRequest, BookingStatus.FAILURE);
        }
    }

    @Override
    public List<BookingDTO> fetchAllBookings() {
        List<Booking> bookingList = bookingRepository.findAll();

        return bookingList.stream().map(booking -> dtoMapper.convertToDto(booking)).collect(Collectors.toList());
    }

    @Override
    public GetBookingResponse fetchBookings(int showId) {
        Optional<Show> optionalShow = showRepository.findById(showId);

        if (optionalShow.isEmpty()) {
            return responseMapper.mapGetBookingResponse(Collections.EMPTY_SET, ResponseCode.NO_SHOW_AVAILABLE);
        }

        List<ShowSeat> showSeatList = showSeatRepository.findByShow(optionalShow.get());

        Set<BookingDTO> bookingSet = new HashSet<>();

        for (ShowSeat showSeat : showSeatList) {
            if (!ObjectUtils.isEmpty(showSeat.getBooking())) {
                bookingSet.add(dtoMapper.convertToDto(showSeat.getBooking()));
            }
        }

        return responseMapper.mapGetBookingResponse(bookingSet, ResponseCode.SUCCESS);
    }

    @Override
    public BookingDTO fetchBooking(int bookingId) {
        Optional<Booking> optionalBooking = bookingRepository.findById(bookingId);

        if (optionalBooking.isEmpty()) {
            BookingResponse bookingResponse = new BookingResponse();
            bookingResponse.setBookingId(bookingId);
            bookingResponse.setResponseMessage(ResponseCode.BOOKING_NOT_FOUND.getResponseMessage());
        }

        return dtoMapper.convertToDto(optionalBooking.get());
    }
}
