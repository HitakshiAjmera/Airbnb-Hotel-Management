package com.airbnb.airbnbapp.controller;

import com.airbnb.airbnbapp.dto.HotelDto;
import com.airbnb.airbnbapp.service.HotelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/admin/hotels")
@RequiredArgsConstructor
public class HotelController {

    private final HotelService hotelService; //it will inject the srvice impl bean automatically

    @PostMapping
    public ResponseEntity<HotelDto> createNewHotel (@RequestBody HotelDto hotelDto){
        log.info("Attempting to create a new hotel");
        HotelDto hotel = hotelService.createNewHotel(hotelDto);
        return new ResponseEntity<>(hotel, HttpStatus.CREATED);
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<HotelDto> getHotelById(@PathVariable Long hotelId){
        HotelDto hotel = hotelService.getHotelById(hotelId);
        return ResponseEntity.ok(hotel);
    }

    @PutMapping({"/{hotelId}"})
    public ResponseEntity<HotelDto> updateHotelById(@PathVariable Long hotelId, @RequestBody HotelDto hotelDto){
        HotelDto hotel = hotelService.updateHotelById(hotelId,hotelDto);
        return ResponseEntity.ok(hotel);
    }

    @DeleteMapping({"/{hotelId}"})
    public ResponseEntity<HotelDto> deleteById(@PathVariable Long hotelId){
        hotelService.deleteHotelById(hotelId);
        return ResponseEntity.noContent().build();
    }

}
