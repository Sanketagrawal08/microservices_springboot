package com.example.userservice.UserServic.entities;

import lombok.*;


@NoArgsConstructor

public class Ratings {
    public String getRatingId() {
        return ratingId;
    }

    public Ratings(String ratingId, String userId, String hotelId, int rating, String remark) {
        this.ratingId = ratingId;
        this.userId = userId;
        this.hotelId = hotelId;
        this.rating = rating;
        this.remark = remark;
    }

    public void setRatingId(String ratingId) {
        this.ratingId = ratingId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    private String ratingId;
    private String userId;
    private String hotelId;
    private int rating;
    private String remark;

    private Hotel hotel;

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}