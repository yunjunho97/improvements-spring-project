package com.example.improvements.repository;

import com.example.improvements.domain.entity.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(locations = "classpath:application.yml")
@DisplayName("유저 레파지토리 테스트")
public class UserRepositoryTest {

    @Autowired private UserRepository userRepository;

    private User user;

    @BeforeEach
    void setUp() {
        user = User.createUser("testUser", "password", "test@gmail.com");
        userRepository.save(user);
    }

    @Test
    @DisplayName("유저 이름으로 검색 테스트")
    void testFindByUsername() {
        User foundUser = userRepository.findByUsername(user.getUsername()).orElse(null);

        assertThat(foundUser).isNotNull();
        assertThat(foundUser.getId()).isNotNull();
        assertThat(foundUser.getUsername()).isEqualTo(user.getUsername());
        assertThat(foundUser.getPassword()).isEqualTo(user.getPassword());
        assertThat(foundUser.getEmail()).isEqualTo(user.getEmail());
        assertThat(foundUser.getRole()).isEqualTo(user.getRole());
    }
}
