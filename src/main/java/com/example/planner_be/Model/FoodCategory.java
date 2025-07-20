package com.example.planner_be.Model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum FoodCategory {
    한식, 분식, 치킨, 동양식, 서양식, 패스트푸드, 뷔페, 퓨전;

    public static FoodCategory from(String value) {
        return Arrays.stream(values())
                .filter(v -> v.name().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("지원하지 않는 카테고리: " + value));
    }
}
