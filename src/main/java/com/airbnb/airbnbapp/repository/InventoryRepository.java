package com.airbnb.airbnbapp.repository;

import com.airbnb.airbnbapp.entity.Inventory;
import com.airbnb.airbnbapp.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface InventoryRepository extends JpaRepository<Inventory,Long> {
    void deleteByDateAfterAndRoom(LocalDate date, Room room);
}
