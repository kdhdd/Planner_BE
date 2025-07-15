package com.example.planner_be.Dto.User;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RegisterUserDto {
    @NotEmpty(message = "아이디는 비워둘 수 없습니다.")
    private String username;
    @NotEmpty(message = "비밀번호는 비워둘 수 없습니다.")
    private String password;
    @NotEmpty(message = "닉네임은 비워둘 수 없습니다.")
    private String nickname;
}