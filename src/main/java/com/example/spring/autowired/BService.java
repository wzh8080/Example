package com.example.spring.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author 56465
 * @Create 2024/6/11 15:19
 */
@Service
public class BService {
    private final AService aService;

    public BService(AService aService) {
        this.aService = aService;
    }
}
