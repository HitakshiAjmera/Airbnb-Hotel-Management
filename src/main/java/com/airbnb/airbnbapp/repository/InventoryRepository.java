package com.airbnb.airbnbapp.repository;

import com.airbnb.airbnbapp.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory,Long> {
}
