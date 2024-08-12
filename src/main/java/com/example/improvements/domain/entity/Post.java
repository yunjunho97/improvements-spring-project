package com.example.improvements.domain.entity;

import com.example.improvements.domain.dto.PostDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "posts")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public static Post toPostDTO(PostDTO postDTO){
        return Post.builder()
                .title(postDTO.getTitle())
                .content(postDTO.getContent())
                .build();
    }
}
