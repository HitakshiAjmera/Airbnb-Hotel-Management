package com.airbnb.airbnbapp.service;

import com.airbnb.airbnbapp.dto.HotelDto;
import com.airbnb.airbnbapp.entity.Hotel;
import com.airbnb.airbnbapp.entity.Room;
import com.airbnb.airbnbapp.exception.ResourceNotFoundException;
import com.airbnb.airbnbapp.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;

@Service
@Slf4j //Lombok automatically generates the following field during compilation:
@RequiredArgsConstructor //create the constructuction so here it has constructor base injection
public class HotelServiceImpl implements HotelService{

    private final HotelRepository hotelRepository ;
    private final ModelMapper modelMapper ;
    private final InventoryService inventoryService;
    @Override
    public HotelDto createNewHotel(HotelDto hotelDto)
    {
        log.info("Creating a new hotel with name: {}",hotelDto.getName());
        Hotel hotel = modelMapper.map(hotelDto,Hotel.class);
        hotel.setActive(false);
        hotel = hotelRepository.save(hotel);
        log.info("Created a new hotel with name: {}",hotelDto.getName());
        return modelMapper.map(hotel, HotelDto.class);
    }

    @Override
    public HotelDto getHotelById(Long id) {
        log.info("Getting the hotel with Id: {}",id);
       Hotel hotel = hotelRepository
               .findById(id)
               .orElseThrow(()->new ResourceNotFoundException("Hotel not found with Id : "+id));
        return modelMapper.map(hotel,HotelDto.class);
    }

    @Override
    public HotelDto updateHotelById(Long id,HotelDto hoteldto) {
        log.info("updating the hotel with Id: {}",id);
        Hotel hotel = hotelRepository
                .findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Hotel not found with Id : "+id));
         modelMapper.map(hoteldto,hotel);
         hotel = hotelRepository.save(hotel);
         return modelMapper.map(hotel,HotelDto.class);
    }


    @Override
   /* public void deleteHotelById(Long id) {
        boolean exist = hotelRepository.existsById(id);
        if(!exist) throw new ResourceNotFoundException("Hotel not found with Id : "+id);
        hotelRepository.deleteById(id);

    }*/
    public void deleteHotelById(Long id) {
        Hotel hotel = hotelRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with ID: "+id));

        hotelRepository.deleteById(id);
        for(Room room: hotel.getRooms()) {
            inventoryService.deleteFutureInventories(room);
        }
    }
    @Override
    public void activateHotel(Long hotelId) {
        log.info("Activating the hotel with ID: {}", hotelId);
        Hotel hotel = hotelRepository
                .findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with ID: "+hotelId));

        hotel.setActive(true);

        // assuming only do it once
        for(Room room: hotel.getRooms()) {
            inventoryService.initializeRoomForAYear(room);
        }

    }
}
