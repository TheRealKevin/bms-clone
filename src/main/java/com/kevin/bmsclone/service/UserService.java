package com.kevin.bmsclone.service;

import com.kevin.bmsclone.model.request.UserSignUpRequest;
import com.kevin.bmsclone.model.response.UserSignUpResponse;
import com.kevin.bmsclone.model.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserSignUpResponse signupUser(UserSignUpRequest userSignUpRequestDTO);

    List<UserDTO> fetchAllUsers();
}
