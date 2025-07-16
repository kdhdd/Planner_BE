package com.example.planner_be.Service;

import com.example.planner_be.Model.User;
import com.example.planner_be.Model.UserRole;
import com.example.planner_be.Repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdminAccountInitializer {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Value("${admin.username:}")
    private String adminUsername;

    @Value("${admin.password:}")
    private String adminPassword;

    @PostConstruct
    public void createAdminIfNotExists() {
        if (adminUsername.isBlank() || adminPassword.isBlank()) {
            return;
        }

        if (!userRepository.existsByUsername(adminUsername)) {
            User admin = User.signupBuilder()
                    .username(adminUsername)
                    .password(bCryptPasswordEncoder.encode(adminPassword))
                    .nickname("관리자")
                    .role(UserRole.ADMIN)
                    .build();
            userRepository.save(admin);
        }
    }
}
