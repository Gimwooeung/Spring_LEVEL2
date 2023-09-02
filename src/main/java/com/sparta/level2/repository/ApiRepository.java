package com.sparta.level2.repository;

import com.sparta.level2.entity.Api;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApiRepository extends JpaRepository<Api, Long>{
    List<Api> findAllByOrderByModifiedAtDesc();
}
