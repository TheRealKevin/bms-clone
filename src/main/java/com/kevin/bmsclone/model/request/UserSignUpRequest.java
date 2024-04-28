package com.kevin.bmsclone.model.request;

import lombok.Data;

@Data
public class UserSignUpRequest {

    private String name;

    private String email;

    private String password;    // TODO : Encrypt

    private String contactNumber;

}
