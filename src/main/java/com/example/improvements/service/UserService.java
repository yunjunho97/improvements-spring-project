package com.example.improvements.service;

import com.example.improvements.domain.dto.LoginRequest;
import com.example.improvements.domain.dto.UserJoinDTO;
import com.example.improvements.domain.entity.User;
import com.example.improvements.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
//    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * 회원등록<br>
     * username 중복검사 진행 - existUserName(username)
     * @param userJoinDTO - username, password, email
     */
    public void save(UserJoinDTO userJoinDTO) {
        String username = userJoinDTO.getUsername();
        existUserName(username); //username 중복검사
//        String password = bCryptPasswordEncoder.encode(userJoinDTO.getPassword());
        String password = userJoinDTO.getPassword();
        String email = userJoinDTO.getEmail();
        userRepository.save(User.createUser(username, password, email));
    }

    public void login(LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
    }

    /**
     * username 중복검사
     * @param username 이름
     * @exception DataIntegrityViolationException 이미 해당 username이 존재할때
     */
    private void existUserName(String username){
        if(userRepository.existsByUsername(username)) {
            throw new DataIntegrityViolationException("이미 존재하는 이름");
        }
    }
}
