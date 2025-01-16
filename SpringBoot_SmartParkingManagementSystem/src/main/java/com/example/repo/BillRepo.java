package com.example.repo;

import com.example.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BillRepo extends JpaRepository<Bill, Integer> {
    Optional<Bill> findByReservationVehicleNo(String findByVehicleNo);
}
