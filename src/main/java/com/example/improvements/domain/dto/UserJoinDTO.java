package com.example.improvements.domain.dto;

import com.example.improvements.domain.entity.User;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class UserJoinDTO {
    private String username;
    private String password;
    private String email;

    public static UserJoinDTO fromUser(User user) {
        return UserJoinDTO.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .email(user.getEmail())
                .build();
    }
}
