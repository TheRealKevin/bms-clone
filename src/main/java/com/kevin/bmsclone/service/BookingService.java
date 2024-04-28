package com.kevin.bmsclone.service;

import com.kevin.bmsclone.model.dto.BookingDTO;
import com.kevin.bmsclone.model.request.BookingRequest;
import com.kevin.bmsclone.model.response.BookingResponse;
import com.kevin.bmsclone.model.response.GetBookingResponse;

import java.util.List;

public interface BookingService {

    List<BookingDTO> fetchAllBookings();

    GetBookingResponse fetchBookings(int showId);

    BookingDTO fetchBooking(int bookingId);

    BookingResponse bookShow(BookingRequest bookingRequest);

}
