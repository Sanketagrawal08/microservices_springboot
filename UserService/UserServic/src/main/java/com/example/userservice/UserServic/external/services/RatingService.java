package com.example.userservice.UserServic.external.services;

import com.example.userservice.UserServic.entities.Ratings;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(name = "RatingService")
public interface RatingService {


        // suppose post rating
        @PostMapping("/rating")
        public ResponseEntity<Ratings> createRating(@RequestBody  Ratings values);

        // put
        @PutMapping("/rating/{ratingId}")
        public Ratings updateRating(@PathVariable String ratingId , Ratings rating);

       @DeleteMapping("/rating/{ratingId}")
       public void deleteRating(@PathVariable String ratingId);


       // builder pattern padho
}
