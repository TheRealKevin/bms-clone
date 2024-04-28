package com.kevin.bmsclone.model.response;

import com.kevin.bmsclone.model.dto.BookingDTO;
import lombok.Data;

import java.util.Set;

@Data
public class GetBookingResponse extends BaseResponse{

    Set<BookingDTO> bookingList;
}
