package com.example.userservice.UserServic.servies;

import com.example.userservice.UserServic.entities.User;

import java.util.List;
public interface UserService {

        User saveUser(User user);

        List<User> getAllUser();

/*
        Optional<User> getUser(String userId);
*/

        User getUser(String userId);

        /*/todo: delete, update*/
}
