package com.example.userservice.UserServic.servies.userserviceimplementaiton;

import com.example.userservice.UserServic.entities.Hotel;
import com.example.userservice.UserServic.entities.Ratings;
import com.example.userservice.UserServic.entities.User;
import com.example.userservice.UserServic.repositories.UserRepository;
import com.example.userservice.UserServic.servies.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class userServiceImple implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate; //bean banana padega in


    private Logger logger = LoggerFactory.getLogger(UserService.class);

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user=  userRepository.findById(userId).orElseThrow(()-> new RuntimeException("User not found with id" + userId));
        Ratings[] forObject = restTemplate.getForObject("http://RATINGSERVICE/rating/users/"+user.getUserId() , Ratings[].class);
        /*ArrayList<Ratings> forObject = restTemplate.getForObject("http://localhost:8083/rating/users/" + user.getUserId() , ArrayList.class);*/
        logger.info("{}",forObject);

        List<Ratings> ratings = Arrays.stream(forObject).toList();

        ratings.stream().map(rating -> {
            // api call to hotel service to get the hotel
            // set it to ratings/return the rating
            // http://localhost:8082/hotels/kuckkuch
             ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTELSERVICE/hotel/"+ rating.getHotelId(), Hotel.class);
             Hotel hotel = forEntity.getBody();

             rating.setHotel(hotel);

             return rating;
        }).collect(Collectors.toList());
        user.setRatings(ratings);
        return user;
    }
    // fetch rating of other user from rating service
    //localhost:8083/rating/users/3f997ddb-9a09-46eb-bc22-1ae4c2a8761c
    // hume yaha pe ek userclient clientservice chahiye jisse rating service se contact ho paaye..
    //rest template ya feign client ka option rehta he..



   /* @Override
    public Optional<User> getUser(String userId) {
        return userRepository.findById(userId);
    }*/

}
