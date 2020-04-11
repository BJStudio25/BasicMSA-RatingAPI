package com.bjstudio.rating.web.controller;

import java.util.List;
import java.util.Map;

import com.bjstudio.rating.persistence.domain.Rating;
import com.bjstudio.rating.service.RatingService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RequestMapping(Ratingcontroller.BASE_URL)
@RestController
public class Ratingcontroller {

    public static final String BASE_URL = "/ratings";

    private final RatingService ratingService;

    @GetMapping()
    public List<Rating> findRatingsByBookId(@RequestParam(required = false, defaultValue = "0") Long bookId) {
        if(bookId.equals(0L)) {
            return ratingService.findAllRatings();
        }
        return ratingService.findRatingsByBookId(bookId);
    }

    @PostMapping
    public Rating createRating(@RequestBody Rating rating) {
        return ratingService.createRating(rating);
    }

    @DeleteMapping("/{ratingId}")
    public void deleteRating(@PathVariable Long ratingId) {
        ratingService.deleteRating(ratingId);
    }

    @PutMapping("/{ratingId}")
    public Rating updateRating(@PathVariable Long ratingId, @RequestBody Rating rating) {
        return ratingService.updateRating(ratingId, rating);
    }

    @PatchMapping("/{ratingId}")
    public Rating updateRating(@PathVariable Long ratingId, @RequestBody Map<String, String> updates) {
        return ratingService.updateRating(ratingId, updates);
    }
   


}