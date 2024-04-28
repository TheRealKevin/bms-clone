package com.kevin.bmsclone.service.impl;

import com.kevin.bmsclone.enums.ResponseCode;
import com.kevin.bmsclone.mapper.DtoMapper;
import com.kevin.bmsclone.mapper.EntityMapper;
import com.kevin.bmsclone.mapper.ResponseMapper;
import com.kevin.bmsclone.model.dto.UserDTO;
import com.kevin.bmsclone.model.entity.User;
import com.kevin.bmsclone.model.request.UserSignUpRequest;
import com.kevin.bmsclone.model.response.UserSignUpResponse;
import com.kevin.bmsclone.repository.UserRepository;
import com.kevin.bmsclone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ResponseMapper responseMapper;

    @Autowired
    private EntityMapper entityMapper;

    @Autowired
    private DtoMapper dtoMapper;

    @Override
    public UserSignUpResponse signupUser(UserSignUpRequest userSignUpRequest) {
        Optional<User> optionalUser = userRepository.findUserByEmail(userSignUpRequest.getEmail());
        if (optionalUser.isPresent()) {
            return responseMapper.mapUserSignUpResponse(userSignUpRequest, ResponseCode.ALREADY_CREATED);
        }

        User user = entityMapper.mapUser(userSignUpRequest);

        userRepository.save(user);

        return responseMapper.mapUserSignUpResponse(userSignUpRequest, ResponseCode.SUCCESS);
    }

    @Override
    public List<UserDTO> fetchAllUsers() {
        List<User> userList = userRepository.findAll();

        return userList.stream().map(user -> {
            UserDTO userDTO = dtoMapper.convertToDto(user);
            return userDTO;
        }).collect(Collectors.toList());
    }
}
