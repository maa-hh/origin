package com.example.demo.Sever;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class Cache {
    @Cacheable(value = "code", key = "#num")
    public String getCodeFromCache(String num) {
        return null;
    }
}
