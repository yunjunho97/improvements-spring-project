package com.example.improvements.domain.dto;

import com.example.improvements.domain.entity.Post;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostDTO {
    private String title;
    private String content;

    public static PostDTO fromPost(Post post) {
        return PostDTO.builder()
                .title(post.getTitle())
                .content(post.getContent())
                .build();
    }
}
