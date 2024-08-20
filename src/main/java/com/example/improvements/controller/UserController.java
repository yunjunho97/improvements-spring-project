package com.example.improvements.controller;

import com.example.improvements.domain.dto.LoginRequest;
import com.example.improvements.domain.dto.UserJoinDTO;
import com.example.improvements.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody UserJoinDTO userJoinDTO){
        userService.save(userJoinDTO);
        return ResponseEntity.ok("회원가입 완료");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok("로그인 완료");
    }
}
