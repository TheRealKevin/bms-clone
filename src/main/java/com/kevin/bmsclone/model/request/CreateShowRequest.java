package com.kevin.bmsclone.model.request;

import lombok.Data;

import java.sql.Date;
import java.sql.Time;

@Data
public class CreateShowRequest {

    private int movieId;

    private Date showDate;

    private Time showTime;

    private int hallId;

    private double seatPrice;

}
