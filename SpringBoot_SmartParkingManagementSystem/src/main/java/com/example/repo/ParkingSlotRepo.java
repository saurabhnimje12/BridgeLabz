package com.example.repo;

import com.example.entity.ParkingSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingSlotRepo extends JpaRepository<ParkingSlot, Integer> {
    List<ParkingSlot> findByVehicleTypeAndIsAvailable(String parkingVehicleType, boolean b);
}
