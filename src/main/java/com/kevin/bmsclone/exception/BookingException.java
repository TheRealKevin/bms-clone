package com.kevin.bmsclone.exception;

import com.kevin.bmsclone.enums.ResponseCode;
import lombok.Data;

@Data
public class BookingException extends Exception {

    private int errorCode;
    private String errorMessage;

    public BookingException (ResponseCode responseCode) {
        errorCode = responseCode.getResponseCode();
        errorMessage = responseCode.getResponseMessage();
    }
}
