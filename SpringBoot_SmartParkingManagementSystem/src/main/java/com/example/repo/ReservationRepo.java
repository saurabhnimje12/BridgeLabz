package com.example.repo;

import com.example.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReservationRepo extends JpaRepository<Reservation, Integer> {
    Optional<Reservation> findByVehicleNo(String vehicleNo);
}
