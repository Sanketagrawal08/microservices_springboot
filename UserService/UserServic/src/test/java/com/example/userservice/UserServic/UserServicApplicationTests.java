package com.example.userservice.UserServic;

import com.example.userservice.UserServic.entities.Ratings;
import com.example.userservice.UserServic.external.services.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class UserServicApplicationTests {

	@Test
	void contextLoads() {
	}

	/*@Autowired
	private RatingService ratingService;

	@Test
	void createRating() {
		// Ratings ratings = Ratings.builder().rating(10).userId("").hotelId("").feedback("nothing").build();
			Ratings ratings = new Ratings();
			ratings.setRating(10);
		ratings.setUserId("");
		ratings.setHotelId("");
		ratings.setRemark("kuch");

		 ResponseEntity<Ratings> rr = ratingService.createRating(ratings);
		System.out.println(rr.getStatusCode());
		System.out.println("ho gyi created using feign client");
	}*/
}
