package com.rksp8.ratingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RatingCreateDto {

    private Integer rating;
    private String comment;
    private Long postId;
}
