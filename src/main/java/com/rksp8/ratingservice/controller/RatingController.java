package com.rksp8.ratingservice.controller;

import com.rksp8.ratingservice.dto.RatingCreateDto;
import com.rksp8.ratingservice.dto.RatingDto;
import com.rksp8.ratingservice.service.RatingService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
@RequiredArgsConstructor
public class RatingController {

    private final RatingService ratingService;

    @GetMapping
    public List<RatingDto> getAllRatings() {
        return ratingService.getAllRatings();
    }

    @PostMapping
    @Parameter(in = ParameterIn.HEADER, name = "x-username", required = true)
    public RatingDto createRating(@RequestBody RatingCreateDto ratingDto) {
        return ratingService.createRating(ratingDto);
    }

    @GetMapping("/{id}")
    public RatingDto getRatingById(@PathVariable Long id) {
        return ratingService.getRatingById(id);
    }

    @GetMapping("/user/{author}")
    public List<RatingDto> getAllUsersRatings(@PathVariable String author) {
        return ratingService.getAllUsersRatings(author);
    }

    @GetMapping("/post/{postId}")
    public List<RatingDto> getAllPostsRatings(@PathVariable Long postId) {
        return ratingService.getAllPostsRatings(postId);
    }

    @DeleteMapping("/{id}")
    public void deleteRating(@PathVariable Long id) {
        ratingService.deleteRating(id);
    }
}
