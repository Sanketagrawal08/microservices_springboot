package com.example.RatingService.RatingService.controller;

import com.example.RatingService.RatingService.entities.Rating;
import com.example.RatingService.RatingService.services.RatingServcice;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {
    @Autowired
    private RatingServcice ratingServcice;

            @PostMapping
            Rating createRating(@RequestBody  Rating rating) {
                return ratingServcice.creteRating(rating);
            }

            @GetMapping()
            List<Rating> getAllRating() {
                return ratingServcice.getAllRating();
            }

            @GetMapping("/users/{userId}")
            List<Rating> getRatingByUserId(@PathVariable String userId) {
                return ratingServcice.getAllRatingByUserId(userId);
            }

            @GetMapping("/hotels/{hotelId}")
            List<Rating> getRatingByHotelId(@PathVariable String hotelId) {
                return ratingServcice.getAllRatingByHotelId(hotelId);
            }

}
