package com.sparta.level2.dto;

import com.sparta.level2.entity.Api;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ResponseDto {
    private final Long id;
    private final String title;
    private final String author;
//    private final String password;
    private final String contents;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public ResponseDto(Api api) {
        this.id = api.getId();
        this.title = api.getTitle();
        this.author = api.getAuthor();
//        this.password = api.getPassword();
        this.contents = api.getContent();
        this.createdAt = api.getCreatedAt();
        this.modifiedAt = api.getModifiedAt();
    }

}
