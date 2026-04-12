package com.example.HotelService.HotelService.services.HotelServiceImple;

import com.example.HotelService.HotelService.Repository.HotelRepo;
import com.example.HotelService.HotelService.entities.Hotel;
import com.example.HotelService.HotelService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class HotelServiceImple implements HotelService {

    @Autowired
    private HotelRepo hotelRepo;

    @Override
    public Hotel create(Hotel hotel) {
        return hotelRepo.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        List<Hotel> hotels = hotelRepo.findAll();
        return hotels;
    }

    @Override
    public Hotel get(@PathVariable  String id) {
        return hotelRepo.findById(id).orElseThrow(()-> new NoSuchElementException("not found hotel"));
    }

}
