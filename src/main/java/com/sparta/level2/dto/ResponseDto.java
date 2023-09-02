package com.sparta.level2.dto;

import com.sparta.level2.entity.Api;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ResponseDto {
    private final Long id;
    private final String title;
    private final String username;
    private final String contents;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public ResponseDto(Api api) {
        this.id = api.getId();
        this.title = api.getTitle();
        this.username = api.getUsername();
        this.contents = api.getContent();
        this.createdAt = api.getCreatedAt();
        this.modifiedAt = api.getModifiedAt();
    }

}
