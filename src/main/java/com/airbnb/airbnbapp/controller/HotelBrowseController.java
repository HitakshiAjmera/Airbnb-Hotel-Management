package com.airbnb.airbnbapp.controller;


import com.airbnb.airbnbapp.dto.HotelSearchRequest;
import com.airbnb.airbnbapp.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hotels")
@RequiredArgsConstructor
public class HotelBrowseController {

    private final InventoryService inventoryService;

    @GetMapping("/search")
    public ResponseEntity<List<HotelSearchRequest>> searchHotels(@RequestBody HotelSearchRequest hotelSearchRequest){
        inventoryService
    }

}
