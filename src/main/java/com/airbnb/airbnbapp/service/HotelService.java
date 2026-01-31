package com.airbnb.airbnbapp.service;

import com.airbnb.airbnbapp.dto.HotelDto;
import com.airbnb.airbnbapp.entity.Hotel;

public interface HotelService {

    HotelDto createNewHotel(HotelDto hotelDto);
    HotelDto getHotelById(Long id);
    HotelDto updateHotelById(Long id,HotelDto hotelDto);
    void deleteHotelById(Long id);
}
