package com.kevin.bmsclone.mapper;

import com.kevin.bmsclone.enums.BookingStatus;
import com.kevin.bmsclone.enums.ResponseCode;
import com.kevin.bmsclone.model.dto.BookingDTO;
import com.kevin.bmsclone.model.entity.Show;
import com.kevin.bmsclone.model.request.BookingRequest;
import com.kevin.bmsclone.model.request.UserSignUpRequest;
import com.kevin.bmsclone.model.response.BookingResponse;
import com.kevin.bmsclone.model.response.GetBookingResponse;
import com.kevin.bmsclone.model.response.ShowResponse;
import com.kevin.bmsclone.model.response.UserSignUpResponse;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Component
public class ResponseMapper {

    public UserSignUpResponse mapUserSignUpResponse(UserSignUpRequest request) {
        UserSignUpResponse response = new UserSignUpResponse();
        response.setEmail(request.getEmail());
        return response;
    }

    public UserSignUpResponse mapUserSignUpResponse(UserSignUpRequest request, ResponseCode responseCode) {
        UserSignUpResponse response = mapUserSignUpResponse(request);
        response.setResponseCode(responseCode.getResponseCode());
        response.setResponseMessage(responseCode.getResponseMessage());
        return response;
    }

    public BookingResponse mapBookingResponse(BookingRequest request, ResponseCode responseCode) {
        BookingResponse response = new BookingResponse();
        response.setEmail(request.getEmail());
        response.setResponseCode(responseCode.getResponseCode());
        response.setResponseMessage(response.getResponseMessage());
        return response;
    }

    public BookingResponse mapBookingResponse(BookingRequest request, BookingStatus bookingStatus) {
        BookingResponse response = new BookingResponse();
        response.setEmail(request.getEmail());
        response.setResponseMessage(bookingStatus.name());
        return response;
    }

    public GetBookingResponse mapGetBookingResponse(Set<BookingDTO> bookingSet, ResponseCode responseCode) {
        GetBookingResponse response = new GetBookingResponse();
        response.setResponseMessage(responseCode.getResponseMessage());
        response.setBookingList(bookingSet);
        return response;
    }

    public ShowResponse mapCreateShowResponse(ResponseCode responseCode) {
        ShowResponse showResponse = new ShowResponse();
        showResponse.setResponseMessage(responseCode.getResponseMessage());
        return showResponse;
    }

    public ShowResponse mapShowResponse(int showId, ResponseCode responseCode) {
        ShowResponse showResponse = new ShowResponse();
        showResponse.setShowId(showId);
        showResponse.setResponseMessage(responseCode.getResponseMessage());
        return showResponse;
    }

}
