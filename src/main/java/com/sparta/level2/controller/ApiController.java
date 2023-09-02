package com.sparta.level2.controller;

import com.sparta.level2.dto.RequestDto;
import com.sparta.level2.dto.ResponseDto;
import com.sparta.level2.entity.Api;
import com.sparta.level2.service.ApiService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final ApiService apiService;

    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @PostMapping("/post") //입력
    public ResponseDto createApi(@RequestBody RequestDto requestDto) {
        return apiService.createApi(requestDto);
    }

    @GetMapping("/posts") // 모두 조회
    public List<ResponseDto> getAllApi() {
        return apiService.getAllApi();
    }

    @GetMapping("/post/{id}") // 선택 조회
    public ResponseDto getApiSelect(@PathVariable Long id) {
        return apiService.getApiSelect(id);
    }

    @PutMapping("post/{id}") // 내용 수정
    public ResponseDto updateApi(@PathVariable Long id, @RequestBody RequestDto requestDto) {
        Api updatedApi = apiService.updateApi(id, requestDto);
        ResponseDto responseDto = new ResponseDto(updatedApi);
        return responseDto;
    }

    @DeleteMapping("post/{id}") // 내용 삭제
    public Map<String, Boolean> deleteApi(@PathVariable Long id, @RequestBody Map<String, String> requestBody) {
        boolean success = apiService.deleteApi(id, requestBody.get("password"));
        Map<String, Boolean> response = new HashMap<>();
        response.put("success", success);
        return response;
    }
}