package com.bjstudio.rating.repository;

import java.util.List;

import com.bjstudio.rating.persistence.domain.Rating;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * RatingRepository
 */
public interface RatingRepository extends JpaRepository<Rating, Long> {

    List<Rating> findRatingsByBookId(Long bookId);
    
}