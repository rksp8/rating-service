package com.rksp8.ratingservice.service;

import com.rksp8.ratingservice.dto.RatingCreateDto;
import com.rksp8.ratingservice.dto.RatingDto;

import java.util.List;

public interface RatingService {

    RatingDto createRating(RatingCreateDto ratingCreateDto);

    void deleteRating(Long id);

    RatingDto getRatingById(Long id);

    List<RatingDto> getAllRatings();

    List<RatingDto> getAllUsersRatings(String author);

    List<RatingDto> getAllPostsRatings(Long postId);

    RatingDto getRatingByPostIdAndAuthor(Long postId, String author);
}
