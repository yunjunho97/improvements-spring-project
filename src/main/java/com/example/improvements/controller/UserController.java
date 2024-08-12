package com.example.improvements.controller;

import com.example.improvements.domain.dto.UserJoinDTO;
import com.example.improvements.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
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
}
