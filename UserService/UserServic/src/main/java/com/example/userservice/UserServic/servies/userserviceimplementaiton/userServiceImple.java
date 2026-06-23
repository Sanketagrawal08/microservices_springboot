package com.example.userservice.UserServic.servies.userserviceimplementaiton;

import com.example.userservice.UserServic.entities.Ratings;
import com.example.userservice.UserServic.entities.User;
import com.example.userservice.UserServic.repositories.UserRepository;
import com.example.userservice.UserServic.servies.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        ArrayList<Ratings> forObject = restTemplate.getForObject("http://localhost:8083/rating/users/"+user.getUserId() , ArrayList.class);
        logger.info("{}",forObject);

        user.setRatings(forObject);
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
