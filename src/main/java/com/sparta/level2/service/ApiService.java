package com.sparta.level2.service;

import com.sparta.level2.dto.RequestDto;
import com.sparta.level2.dto.ResponseDto;
import com.sparta.level2.entity.Api;
import com.sparta.level2.repository.ApiRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ApiService {
    private final ApiRepository apiRepository;

    public ApiService(ApiRepository apiRepository) {
        this.apiRepository = apiRepository;
    }

    public ResponseDto createApi(RequestDto requestDto) {
        // RequestDto -> Entity
        Api api = new Api(requestDto);

        // DB 저장
        Api saveApi = apiRepository.save(api);

        // Entity -> ResponseDto
        ResponseDto ResponseDto = new ResponseDto(saveApi);

        return ResponseDto;
    }

    public List<ResponseDto> getAllApi() {
        // DB 모두조회
        return apiRepository.findAllByOrderByModifiedAtDesc().stream().map(ResponseDto::new).toList();
    }

    public ResponseDto getApiSelect(Long id) {
        // DB 선택조회
        Api api = apiRepository.findById(id).orElse(null);
        if (api != null) {
            return new ResponseDto(api); // ResponseDto 생성자를 활용하여 엔티티를 DTO로 변환
        }
        return null; // 또는 원하는 에러 처리
    }

    @Transactional
    public Api updateApi(Long id, RequestDto requestDto) {
        Api api = findApi(id);

        // memo 내용 수정
        api.update(requestDto);

        return api;
    }


    public boolean deleteApi(Long id, String password) {
        Api api = findApi(id);

        if (api.getPassword().equals(password)) {
            apiRepository.delete(api);
            return true;
        } else {
            return false;
        }
    }

    private Api findApi(Long id) {
        return apiRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 메모는 존재하지 않습니다.")
        );
    }
}

