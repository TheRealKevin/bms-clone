package com.kevin.bmsclone.controller;

import com.kevin.bmsclone.model.request.UserSignUpRequest;
import com.kevin.bmsclone.model.response.UserSignUpResponse;
import com.kevin.bmsclone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/signup", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserSignUpResponse signupUser(@RequestBody UserSignUpRequest userSignUpRequest) {
        return userService.signupUser(userSignUpRequest);
    }

}
