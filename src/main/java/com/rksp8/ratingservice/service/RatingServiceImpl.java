package com.rksp8.ratingservice.service;

import com.rksp8.ratingservice.context.UsernameContext;
import com.rksp8.ratingservice.dto.RatingCreateDto;
import com.rksp8.ratingservice.dto.RatingDto;
import com.rksp8.ratingservice.entity.Rating;
import com.rksp8.ratingservice.mapper.RatingMapper;
import com.rksp8.ratingservice.repository.RatingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {

    private final RatingRepository ratingRepository;
    private final RatingMapper ratingMapper;

    @Override
    public RatingDto createRating(RatingCreateDto ratingCreateDto) {
        Rating rating = ratingMapper.toRating(ratingCreateDto);

        rating.setAuthor(UsernameContext.getUsername());
        rating.setCreatedAt(LocalDateTime.now());

        rating = ratingRepository.save(rating);

        return ratingMapper.toRatingDto(rating);
    }

    @Override
    public void deleteRating(Long id) {
        ratingRepository.deleteById(id);
    }

    @Override
    public RatingDto getRatingById(Long id) {
        return ratingMapper.toRatingDto(ratingRepository.findById(id).orElse(null));
    }

    @Override
    public List<RatingDto> getAllRatings() {
        return ratingRepository.findAll().stream().map(ratingMapper::toRatingDto).toList();
    }

    @Override
    public List<RatingDto> getAllUsersRatings(String author) {
        return ratingRepository.findByAuthor(author).stream().map(ratingMapper::toRatingDto).toList();
    }

    @Override
    public List<RatingDto> getAllPostsRatings(Long postId) {
        return ratingRepository.findByPostId(postId).stream().map(ratingMapper::toRatingDto).toList();
    }

    @Override
    public RatingDto getRatingByPostIdAndAuthor(Long postId, String author) {
        return ratingMapper.toRatingDto(ratingRepository.findByPostIdAndAuthor(postId, author));
    }
}
