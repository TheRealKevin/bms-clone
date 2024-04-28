package com.kevin.bmsclone.mapper;

import com.kevin.bmsclone.model.dto.*;
import com.kevin.bmsclone.model.entity.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DtoMapper {

    @Autowired
    private ModelMapper mapper;

    public CityDTO convertToDto(City city) {
        CityDTO cityDTO = mapper.map(city, CityDTO.class);
        return cityDTO;
    }

    public MovieDTO convertToDto(Movie movie) {
        MovieDTO movieDTO = mapper.map(movie, MovieDTO.class);
        return movieDTO;
    }

    public UserDTO convertToDto(User user) {
        UserDTO userDTO = mapper.map(user, UserDTO.class);
        return userDTO;
    }

    public BookingDTO convertToDto(Booking booking) {
        BookingDTO bookingDTO = mapper.map(booking, BookingDTO.class);
        return bookingDTO;
    }

    public ShowSeatDTO convertToDto(ShowSeat showSeat) {
        ShowSeatDTO showSeatDTO = mapper.map(showSeat, ShowSeatDTO.class);
        return showSeatDTO;
    }
}
