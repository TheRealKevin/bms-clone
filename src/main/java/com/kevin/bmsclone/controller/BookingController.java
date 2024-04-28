package com.kevin.bmsclone.controller;

import com.kevin.bmsclone.model.request.BookingRequest;
import com.kevin.bmsclone.model.response.BookingResponse;
import com.kevin.bmsclone.model.response.GetBookingResponse;
import com.kevin.bmsclone.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/book")
    public BookingResponse bookShow(@RequestBody BookingRequest bookingRequest) {
        return bookingService.bookShow(bookingRequest);
    }

    @GetMapping("/fetch/{showId}")
    public GetBookingResponse getAllBookingsForShow(@PathVariable int showId) {
        return bookingService.fetchBookings(showId);
    }
}
