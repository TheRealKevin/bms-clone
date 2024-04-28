package com.kevin.bmsclone.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDTO {

    private int userId;

    private String name;

    private String email;

    private String password;

    private String contactNumber;

    private List<BookingDTO> bookingList;
}
