package com.airbnb.airbnbapp.dto;

import com.airbnb.airbnbapp.entity.Hotel;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class RoomDto {

    private Long id;
    private String type;
    private BigDecimal basePrice;
    private List<String> amenities;
    private List<String> photos;
    private Integer totalCount;
    private Integer capacity;

}
