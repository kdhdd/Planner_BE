package com.example.planner_be.Dto.User;

import com.example.planner_be.Model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class ResponseUserDto {
    private String username;
    private String nickname;

    public static ResponseUserDto entityToDto(User user) {
        return ResponseUserDto.builder()
                .username(user.getUsername())
                .nickname(user.getNickname())
                .build();
    }
}
