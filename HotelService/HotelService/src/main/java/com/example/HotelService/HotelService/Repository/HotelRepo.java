package com.example.HotelService.HotelService.Repository;

import com.example.HotelService.HotelService.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepo extends JpaRepository<Hotel , String> {

}
