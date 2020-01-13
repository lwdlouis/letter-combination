package com.test.lettercombination.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ApplicationConfig {

    @Bean("digitLettersMap")
    public Map<Integer, String[]> getDigitLettersMap() {

        Map<Integer, String[]> digitLettersMap = new HashMap<>();

        digitLettersMap.put(0, new String[]{});
        digitLettersMap.put(1, new String[]{});
        digitLettersMap.put(2, new String[]{"a", "b", "c"});
        digitLettersMap.put(3, new String[]{"d", "e", "f"});
        digitLettersMap.put(4, new String[]{"g", "h", "i"});
        digitLettersMap.put(5, new String[]{"j", "k", "l"});
        digitLettersMap.put(6, new String[]{"m", "n", "o"});
        digitLettersMap.put(7, new String[]{"p", "q", "r", "s"});
        digitLettersMap.put(8, new String[]{"t", "u", "v"});
        digitLettersMap.put(9, new String[]{"w", "x", "y", "z"});

        return digitLettersMap;
    }
}
