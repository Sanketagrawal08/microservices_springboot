package com.example.HotelService.HotelService.services;

import com.example.HotelService.HotelService.entities.Hotel;

import java.util.List;

public interface HotelService {

    //create
    Hotel create(Hotel hotel);
    //getall

    List<Hotel> getAll();

    //get single
    Hotel get(String id);

}
