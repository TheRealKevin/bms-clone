package com.kevin.bmsclone.helper;

import com.kevin.bmsclone.enums.ResponseCode;
import com.kevin.bmsclone.exception.BookingException;
import com.kevin.bmsclone.model.entity.Hall;
import com.kevin.bmsclone.model.entity.Seat;
import com.kevin.bmsclone.model.entity.ShowSeat;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class BookingServiceHelper {

    public List<ShowSeat> getShowSeats(List<Seat> seatsToBeBookedList, List<ShowSeat> showSeatList, final Hall hall) throws BookingException {
        List<ShowSeat> seatIds = new ArrayList<>();

        for (Seat seat : seatsToBeBookedList) {
            if (!isValidSeat(seat, hall)) {
                // TODO : Throw Exception
                throw new BookingException(ResponseCode.BAD_REQUEST);
            }

            ShowSeat desiredShowSeat = showSeatList.stream().filter(showSeat ->
                            (showSeat.getSeatRow() == seat.getSeatRow() && showSeat.getSeatNumber() == seat.getSeatNumber()))
                    .toList().get(0);

            seatIds.add(desiredShowSeat);
        }

        return seatIds;
    }

    private boolean isValidSeat(Seat seatInfo, Hall hall) {
        int row = seatInfo.getSeatRow() - 'A' + 1;
        int seat = seatInfo.getSeatNumber();

        int totalRows = hall.getTotalRows();
        int totalSeats = hall.getTotalSeats();

        return (row >= 1 && row <= totalRows) && (seat >= 1 && seat <= totalSeats);
    }
}
