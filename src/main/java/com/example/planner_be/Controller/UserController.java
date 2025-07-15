package com.example.planner_be.Controller;

import com.example.planner_be.Code.ResponseCode;
import com.example.planner_be.Dto.Response.ResponseDTO;
import com.example.planner_be.Dto.User.RegisterUserDto;
import com.example.planner_be.Dto.User.ResponseUserDto;
import com.example.planner_be.Model.User;
import com.example.planner_be.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@Validated
public class UserController {
    private final UserService userService;

    @PostMapping()
    public ResponseEntity<ResponseDTO<?>> registerUser(@Valid @RequestBody RegisterUserDto registerUserDto) {
        userService.register(registerUserDto);
        return ResponseEntity
                .status(ResponseCode.SUCCESS_REGISTER.getStatus().value())
                .body(new ResponseDTO<>(ResponseCode.SUCCESS_REGISTER, null));
    }

    @GetMapping("/mypage")
    public ResponseEntity<ResponseDTO<?>> getMyUserInfo(@Valid @AuthenticationPrincipal User user) {
        ResponseUserDto dto = userService.getUsernameAndNickname(user.getUsername());
        return ResponseEntity
                .status(ResponseCode.SUCCESS_RETRIEVE_USER.getStatus().value())
                .body(new ResponseDTO<>(ResponseCode.SUCCESS_RETRIEVE_USER, dto));
    }
}
