package com.example.spring.autowired;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author 56465
 * @Create 2024/6/11 15:18
 */
@Service
@RequiredArgsConstructor
public class AService {
    private final CService cService;
}
