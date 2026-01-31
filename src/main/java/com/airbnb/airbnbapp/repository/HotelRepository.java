package com.airbnb.airbnbapp.repository;

import com.airbnb.airbnbapp.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,Long> {
}
