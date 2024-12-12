package com.rksp8.ratingservice.repository;

import com.rksp8.ratingservice.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RatingRepository extends JpaRepository<Rating, Long> {

    Optional<Rating> findByPostIdAndAuthor(Long postId, String author);

    List<Rating> findByPostId(Long postId);

    List<Rating> findByAuthor(String author);
}
