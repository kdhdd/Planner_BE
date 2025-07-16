package com.example.planner_be.Service;

import com.example.planner_be.Dto.User.RegisterUserDto;
import com.example.planner_be.Dto.User.ResponseUserDto;
import com.example.planner_be.Exception.DuplicateLoginIdException;
import com.example.planner_be.Exception.UserNotExistException;
import com.example.planner_be.Model.User;
import com.example.planner_be.Model.UserRole;
import com.example.planner_be.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    public void register(RegisterUserDto registerUserDto) {
        String username = registerUserDto.getUsername();
        
        if (userRepository.existsByUsername(username)) {
            throw new DuplicateLoginIdException("중복된 아이디로는 가입할 수 없습니다.");
        }

        User user = User.signupBuilder()
                .username(registerUserDto.getUsername())
                .password(bCryptPasswordEncoder.encode(registerUserDto.getPassword()))
                .nickname(registerUserDto.getNickname())
                .role(UserRole.USER)
                .build();

        userRepository.save(user);
    }

    public ResponseUserDto getUsernameAndNickname(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotExistException("존재하지 않는 유저입니다."));

        return ResponseUserDto.entityToDto(user);
    }
}
