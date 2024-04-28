package com.kevin.bmsclone.model.dto;

import com.kevin.bmsclone.enums.BookingStatus;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
public class BookingDTO {

    private int bookingId;

    private BookingStatus bookingStatus;

    private double totalPrice;

    private Date bookingDate;

    private List<ShowSeatDTO> showSeatList;

    private UserDTO user;

}
