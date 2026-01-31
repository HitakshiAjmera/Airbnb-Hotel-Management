package com.airbnb.airbnbapp.repository;

import com.airbnb.airbnbapp.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room,Long> {
}
