package com.kevin.bmsclone.exception;

import com.kevin.bmsclone.enums.ResponseCode;

public class ShowException extends Exception {

    private int errorCode;
    private String errorMessage;

    public ShowException (ResponseCode responseCode) {
        errorCode = responseCode.getResponseCode();
        errorMessage = responseCode.getResponseMessage();
    }
}
