package com.sparta.level2.entity;

import com.sparta.level2.dto.RequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity // JPA가 관리할 수 있는 Entity 클래스 지정
@Getter
@Setter
@Table
@NoArgsConstructor
public class Api extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "author", nullable = false)
    private String author;
    @Column(name = "password", nullable = false, unique = true)
    private String password;
    @Column(name = "content", nullable = false)
    private String content;

    public Api(RequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.author = requestDto.getAuthor();
        this.password = requestDto.getPassword();
        this.content = requestDto.getContent();
    }

    public void update(RequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.author = requestDto.getAuthor();
    }
}
