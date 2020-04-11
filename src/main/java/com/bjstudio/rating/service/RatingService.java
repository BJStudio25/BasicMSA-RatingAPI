package com.bjstudio.rating.service;

import java.util.List;
import java.util.Map;

import com.bjstudio.rating.persistence.domain.Rating;
import com.bjstudio.rating.repository.RatingRepository;
import com.bjstudio.rating.service.exception.RatingNotFoundException;
import com.google.common.base.Preconditions;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

/**
 * RatingService
 */
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class RatingService {

    private final RatingRepository ratingRepository;

	public List<Rating> findAllRatings() {
		return ratingRepository.findAll();
    }
    
    public Rating findRatingById(Long ratingId) {
        return ratingRepository.findById(ratingId).orElseThrow(() -> new RatingNotFoundException("There is no rating. ID: "+ratingId));
    }

	public List<Rating> findRatingsByBookId(Long bookId) {
		return ratingRepository.findRatingsByBookId(bookId);
	}

    @Transactional(propagation = Propagation.REQUIRED)
	public Rating createRating(Rating rating) {
		return ratingRepository.save(rating);
	}

    @Transactional(propagation = Propagation.REQUIRED)
	public void deleteRating(Long ratingId) {
        ratingRepository.deleteById(ratingId);
	}

    @Transactional(propagation = Propagation.REQUIRED)
	public Rating updateRating(Long ratingId, Rating rating) {
        Preconditions.checkNotNull(rating);
        Preconditions.checkState(rating.getId() == ratingId);
        Preconditions.checkNotNull(ratingRepository.findById(ratingId));
        return ratingRepository.save(rating);
	}

    @Transactional(propagation = Propagation.REQUIRED)
	public Rating updateRating(Long ratingId, Map<String, String> updates) {
        final Rating rating = this.findRatingById(ratingId);
        updates.keySet().forEach(k -> {
            switch(k) {
                case "starts":
                    rating.updateStars(Integer.parseInt(updates.get(k)));
            }
        });
        return ratingRepository.save(rating);
    }
    
}