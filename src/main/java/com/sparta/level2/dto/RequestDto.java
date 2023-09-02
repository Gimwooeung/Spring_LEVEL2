package com.sparta.level2.dto;

import lombok.Getter;

@Getter
public class RequestDto {
    private Long id;
    private String title;
    private String username;
    private String password;
    private String content;
}