package com.example.improvements.service;

import com.example.improvements.domain.dto.PostDTO;
import com.example.improvements.domain.entity.Post;
import com.example.improvements.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    /**
     * 게시글을 페이징 처리 후 반환
     * @param pageable 페이징 정보
     * @return Page&lt;PostDTO&gt; 페이징된 게시글 DTO 목록
     */
    public Page<PostDTO> getAllPosts(Pageable pageable) {
        PageRequest pageRequest = getPageRequestByIdSortByDescending(pageable);
        return postRepository.findAll(pageRequest).map(PostDTO::fromPost);
    }

    /**
     * 주어진 ID에 해당하는 게시글을 조회하고, PostDTO(title, content)로 반환
     * @param id 게시글 ID
     * @return ID에 해당하는 게시글의 PostDTO(title, content)를 반환
     * @throws EntityNotFoundException ID에 해당하는 게시글이 존재하지 않는 경우
     */

    public PostDTO getPostById(Long id) {
        return PostDTO.fromPost(postRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new));
    }

    /**
     * 정렬된 PageRequest 반환
     * @param pageable 페이징 정보
     * @return PageRequest 정렬된 페이지 요청 객체
     */
    private PageRequest getPageRequestByIdSortByDescending(Pageable pageable) {
        return PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("id").descending());
    }

//    private boolean isAdmin(UserDetails userDetails) {
//        return userDetails.getAuthorities().
//    }
}
