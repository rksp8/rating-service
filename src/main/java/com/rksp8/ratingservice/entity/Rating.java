package com.rksp8.ratingservice.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "ratings")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "comment")
    private String comment;

    @JoinColumn(name = "post_id")
    private Long postId;

    @JoinColumn(name = "review_author")
    private String author;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

}
