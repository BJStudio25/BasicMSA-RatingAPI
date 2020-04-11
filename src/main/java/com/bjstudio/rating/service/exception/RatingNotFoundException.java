package com.bjstudio.rating.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * RatingNotFoundException
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class RatingNotFoundException extends RuntimeException {
    
    private static final long serialVersionUID = -6274807542996204416L;

    public RatingNotFoundException() {
    }

    public RatingNotFoundException(String message) {
        super(message);
    }

    public RatingNotFoundException(Throwable cause) {
        super(cause);
    }

    public RatingNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public RatingNotFoundException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}