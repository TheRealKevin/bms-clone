package com.kevin.bmsclone.model.dto;

import com.kevin.bmsclone.enums.SeatStatus;
import lombok.Data;

@Data
public class ShowSeatDTO {

    private int showSeatId;

    private char seatRow;

    private int seatNumber;

    private SeatStatus seatStatus;

    private double price;

}
