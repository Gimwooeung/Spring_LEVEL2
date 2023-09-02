package com.sparta.level2.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDto {
    private String msg;
    private int statusCode;


    public LoginResponseDto(String msg, int statusCode) {
        this.msg = msg;
        this.statusCode = statusCode;
    }

}
