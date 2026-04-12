package com.example.RatingService.RatingService.services;

import com.example.RatingService.RatingService.entities.Rating;

import java.util.List;

public interface RatingServcice {

        //create
        Rating creteRating(Rating rating);


        //getallratings
        List<Rating> getAllRating();

        //getallbyuserid
        List<Rating> getAllRatingByUserId(String userId);

       //getallratingbyhotelid
       List<Rating> getAllRatingByHotelId(String hotelId);
}
