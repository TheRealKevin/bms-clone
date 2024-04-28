package com.kevin.bmsclone.model.request;

import com.kevin.bmsclone.model.entity.Seat;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
public class BookingRequest {

    private String email;

    private Date bookingDate;

    private int showId;

    private List<Seat> seatList; // TODO : Try to not use ShowSeatDTO
}
