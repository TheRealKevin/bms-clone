package com.kevin.bmsclone.model.response;

import com.kevin.bmsclone.model.dto.ShowSeatDTO;
import lombok.Data;

import java.util.List;

@Data
public class BookingResponse extends BaseResponse {

    private int bookingId;

    private String email;

    private double totalPrice;

}
