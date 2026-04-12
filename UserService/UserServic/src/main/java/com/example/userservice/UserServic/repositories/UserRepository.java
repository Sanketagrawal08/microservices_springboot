package com.example.userservice.UserServic.repositories;

import com.example.userservice.UserServic.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

//jiske saath kaam krna wo and uski primary key ka data type..
public interface UserRepository extends JpaRepository<User , String> {
    //custom mds will be generated here feel free;

}
