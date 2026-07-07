package com.example.userservice.UserServic.Controller;

import com.example.userservice.UserServic.entities.User;
import com.example.userservice.UserServic.servies.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Executable;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User user1 = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    @GetMapping("/{userId}")
    @CircuitBreaker(name = "ratingHotelBreaker" , fallbackMethod = "ratingHotelFallback")
    public  ResponseEntity<User> getSingleUser(@PathVariable String userId){
        User user  = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }
    // same return type and same parameter should be mentioned for fallback and the controller above

    //creatign fallback md for circuit breaker
    public ResponseEntity<User> ratingHotelFallback(String userId , Exception ex) {
        log.info("fallback is executed becaise service is down :" + ex.getMessage());
        User user = new User();
        user.setName("danke");
        user.setEmail("ssns");
        user.setAbout("dfbudn");
        user.setUserId("1");
        return new ResponseEntity<>(user , HttpStatus.OK);
    }

    @GetMapping
    public  ResponseEntity<List<User>> getAllUser() {
        List<User> users = userService.getAllUser();
        return ResponseEntity.ok(users);
    }


}
