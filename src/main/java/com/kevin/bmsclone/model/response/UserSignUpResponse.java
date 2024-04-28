package com.kevin.bmsclone.model.response;

import com.kevin.bmsclone.enums.ResponseCode;
import lombok.Data;

@Data
public class UserSignUpResponse extends BaseResponse {

    private String email;

}
