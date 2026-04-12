package com.example.RatingService.RatingService.services.imple;

import com.example.RatingService.RatingService.entities.Rating;
import com.example.RatingService.RatingService.repository.RatingRepository;
import com.example.RatingService.RatingService.services.RatingServcice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingServcice {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating creteRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRating() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getAllRatingByUserId(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getAllRatingByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }
}
