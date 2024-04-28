package com.kevin.bmsclone.model.response;

import lombok.Data;

@Data
public class BaseResponse {

    private int responseCode;

    private String responseMessage;

}
