package com.example.improvements.service;

import com.example.improvements.domain.dto.UserJoinDTO;
import com.example.improvements.domain.entity.User;
import com.example.improvements.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void save(UserJoinDTO userJoinDTO) {
        String username = userJoinDTO.getUsername();
        String password = passwordEncoder.encode(userJoinDTO.getPassword());
        String email = userJoinDTO.getEmail();
        existUserName(username);
        userRepository.save(User.createUser(username, password, email));
    }

    private void existUserName(String username){
        if(userRepository.existsByUsername(username)) {
            throw new DataIntegrityViolationException("이미 존재하는 이름");
        }
    }
}
