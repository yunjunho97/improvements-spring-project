package com.example.improvements.entity;

import com.example.improvements.domain.constant.Role;
import com.example.improvements.domain.entity.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("유저 테스트")
public class UserTest {

    @DisplayName("유저 생성 테스트")
    @Test
    void testUserCreation(){
        User user = User.createUser("testUser", "password", "test@gmail.com");

        assertThat(user).isNotNull();
        assertThat(user.getUsername()).isEqualTo("testUser");
        assertThat(user.getPassword()).isEqualTo("password");
        assertThat(user.getEmail()).isEqualTo("test@gmail.com");
        assertThat(user.getRole()).isEqualTo(Role.ROLE_USER);
    }
}
