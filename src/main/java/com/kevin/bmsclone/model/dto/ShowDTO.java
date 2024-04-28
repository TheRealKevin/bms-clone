package com.kevin.bmsclone.model.dto;

import lombok.Data;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Data
public class ShowDTO {

    private int showId;

    private MovieDTO movie;

    private Date showDate;

    private Time showTime;

    private List<ShowSeatDTO> showSeatList;

    private List<BookingDTO> bookingList;
}
