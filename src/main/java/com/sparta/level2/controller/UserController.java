package com.sparta.level2.controller;

import com.sparta.level2.dto.LoginRequestDto;
import com.sparta.level2.dto.LoginResponseDto;
import com.sparta.level2.dto.SignupRequestDto;
import com.sparta.level2.dto.SignupResponseDto;
import com.sparta.level2.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup") // 회원가입
    public SignupResponseDto signup(@RequestBody @Valid SignupRequestDto requestDto) {
        userService.signup(requestDto);
        return new SignupResponseDto("회원가입성공", 200);
    }

    @PostMapping("/login") // 로그인
    public LoginResponseDto login(@RequestBody LoginRequestDto requestDto, HttpServletResponse res) {
        userService.login(requestDto, res);
        return new LoginResponseDto("로그인성공", 200);
    }
}