package com.example.HotelService.HotelService.controller;

import com.example.HotelService.HotelService.entities.Hotel;
import com.example.HotelService.HotelService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")

//diff ask in controller vs restcontroller
public class HotelController {

    @Autowired
    private HotelService hotelService;

        @PostMapping
        public ResponseEntity<Hotel> create(@RequestBody Hotel hotel) {
             return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
        }

        @GetMapping("/{id}")
        public ResponseEntity<Hotel> getById(@PathVariable  String id) {
            return ResponseEntity.status(HttpStatus.FOUND).body(hotelService.get(id));
        }

            @GetMapping
            public List<Hotel> getAll(){
            return hotelService.getAll();
        }

}
