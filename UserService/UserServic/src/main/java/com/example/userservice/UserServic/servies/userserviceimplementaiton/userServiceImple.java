package com.example.userservice.UserServic.servies.userserviceimplementaiton;

import com.example.userservice.UserServic.entities.User;
import com.example.userservice.UserServic.repositories.UserRepository;
import com.example.userservice.UserServic.servies.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class userServiceImple implements UserService {

    @Autowired
    private UserRepository userRepository;

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
        return userRepository.findById(userId).orElseThrow(()-> new RuntimeException("User not found with id" + userId));
    }


   /* @Override
    public Optional<User> getUser(String userId) {
        return userRepository.findById(userId);
    }*/

}
