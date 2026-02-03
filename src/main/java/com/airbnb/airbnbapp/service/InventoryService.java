package com.airbnb.airbnbapp.service;


import com.airbnb.airbnbapp.entity.Room;

public interface InventoryService {

    void initializeRoomForAYear(Room room);

    void deleteFutureInventories(Room room);

}
