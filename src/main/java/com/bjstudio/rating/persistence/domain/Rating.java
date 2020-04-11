package com.bjstudio.rating.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Builder;
import lombok.Getter;

/**
 * Rating
 */
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long bookId;
    private int stars;

    @Builder
    public Rating(Long bookId, int stars) {
        this.bookId = bookId;
        this.stars = stars;
    }

    public void updateStars(int stars) {
        this.stars = stars;
    }
    
}