package com.airbnb.airbnbapp.dto;

import com.airbnb.airbnbapp.entity.HotelContactInfo;
import com.airbnb.airbnbapp.entity.User;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class HotelDto {


    private Long id;
    private String name;
    private String city;
    private List<String> photos;
    private List<String> amenities;
    private HotelContactInfo contactInfo;
    private Boolean active;
    private User owner ;
}
