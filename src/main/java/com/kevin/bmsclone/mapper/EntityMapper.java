package com.kevin.bmsclone.mapper;

import com.kevin.bmsclone.model.entity.User;
import com.kevin.bmsclone.model.request.UserSignUpRequest;
import org.springframework.stereotype.Component;

@Component
public class EntityMapper {

    public User mapUser(UserSignUpRequest userSignUpRequest) {
        User user = new User(); // TODO : Try using modelMapper
        user.setName(userSignUpRequest.getName());
        user.setEmail(userSignUpRequest.getEmail());
        user.setPassword(userSignUpRequest.getPassword());
        user.setContactNumber(userSignUpRequest.getContactNumber());

        return user;
    }

}
