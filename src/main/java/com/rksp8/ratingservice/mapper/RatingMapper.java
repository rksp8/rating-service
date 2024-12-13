package com.rksp8.ratingservice.mapper;

import com.rksp8.ratingservice.dto.RatingCreateDto;
import com.rksp8.ratingservice.dto.RatingDto;
import com.rksp8.ratingservice.entity.Rating;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RatingMapper {

    Rating toRating(RatingCreateDto ratingDto);

    RatingDto toRatingDto(Rating rating);
}
