package com.example.userservice.UserServic.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "micro_users")
public class User {

        @Id
        @GeneratedValue(strategy =  GenerationType.UUID)
        @Column(name = "id")
        private String userId;

        @Column(name="NAME" , length = 25)
        private String name;

        @Column(name="EMAIL")
        private String email;

        @Column(name="ABOUT")
        private String about;

        @Transient // it means ki isko database me save nahi karna he
        private List<Ratings> ratings = new ArrayList<>();

        public List<Ratings> getRatings() {
                return ratings;
        }

        public void setRatings(List<Ratings> ratings) {
                this.ratings = ratings;
        }

        public String getUserId() {
                return userId;
        }

        public void setUserId(String userId) {
                this.userId = userId;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getAbout() {
                return about;
        }

        public void setAbout(String about) {
                this.about = about;
        }
}
