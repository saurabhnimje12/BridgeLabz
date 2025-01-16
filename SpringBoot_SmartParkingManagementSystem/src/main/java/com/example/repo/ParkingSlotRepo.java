package com.example.repo;

import com.example.entity.ParkingSlot;
import com.example.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParkingSlotRepo extends JpaRepository<ParkingSlot, Integer> {
    Optional<ParkingSlot> findByParkingSlotNo(String parkingSlotNo);
    //   ParkingSlot findByParkingVehicleType(String parkingVehicleType, boolean status);
}
