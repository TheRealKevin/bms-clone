package com.kevin.bmsclone.enums;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ResponseCode {

    SUCCESS("SUCCESS", 200),
    FAILURE("FAILURE",400),
    BAD_REQUEST("BAD_REQUEST", 400),
    INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR", 500),
    ALREADY_CREATED("An account with the email provided is already created", 201),
    NO_SHOW_AVAILABLE("No such show is currently playing", 400),
    MOVIE_NOT_PLAYING("No such movie is currently playing", 400),
    SEAT_NOT_AVAILABLE("The selected seat/s are unavailable.", 411),
    BOOKING_NOT_FOUND("Booking not found for the requested bookingId", 412);

    ResponseCode(String responseMessage, int responseCode) {
        this.responseMessage = responseMessage;
        this.responseCode = responseCode;
    }

    private final String responseMessage;
    private final int responseCode;

}
