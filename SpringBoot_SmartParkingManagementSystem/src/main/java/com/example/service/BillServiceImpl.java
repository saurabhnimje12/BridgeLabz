package com.example.service;

import com.example.entity.Bill;
import com.example.entity.Reservation;
import com.example.exception.CustomException;
import com.example.repo.BillRepo;
import com.example.repo.ParkingSlotRepo;
import com.example.repo.ReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Optional;

@Service
public class BillServiceImpl implements BillService {
    @Autowired
    private BillRepo billRepo;
    @Autowired
    private ReservationRepo reservationRepo;

    @Override
    public String updatePaymentStatus(String findByVehicleNo, String status) {
        return "";
    }

    @Override
    public String generateBill(String findByVehicleNo) {
        return "";
    }


//
//    @Override
//    public String updatePaymentStatus(String findByVehicleNo, String status) {
//        Optional<Bill> optionalBill = billRepo.findByReservationVehicleNo(findByVehicleNo);
//        if (optionalBill.isEmpty()) {
//            throw new CustomException("No bill found for vehicle: " + findByVehicleNo);
//        }
//
//        Bill bill = optionalBill.get();
//        bill.setPaymentStatus(status);
//        billRepo.save(bill);
//
//        return "Payment status updated to: " + status;
//    }
//
//    @Override
//    public String generateBill(String findByVehicleNo) {
//        Optional<Reservation> optionalReservation = reservationRepo.findByVehicleNo(findByVehicleNo);
//        if (optionalReservation.isEmpty()) {
//            throw new CustomException("Enter A Valid Vehicle No : " + findByVehicleNo);
//        }
//
//        Reservation reservation = optionalReservation.get();
//
//        if (!"Active".equalsIgnoreCase(reservation.getStatus())) {
//            throw new CustomException("Reservation Is Not ACTIVE For Vehicle No : " + findByVehicleNo);
//        }
//
//        LocalTime startTime = reservation.getStartTime();
//        LocalTime endTimes = LocalTime.now();
//
//
//        long duration = Duration.between(startTime, endTimes).toHours();
//
//       String vehicleType = reservation.getParkingSlot().getParkingVehicleType();
//
//        double amount;
//        if (vehicleType.equalsIgnoreCase("Car")) {
//            amount = duration * 3;
//        } else if (vehicleType.equalsIgnoreCase("Bike")) {
//            amount = duration;
//        } else if (vehicleType.equalsIgnoreCase("Truck")) {
//            amount = duration * 5;
//        } else {
//            amount = 0;
//        }
//
//        Bill bill = new Bill();
//        bill.setAmount(amount);
//        bill.setPaymentStatus("Unpaid");
//        bill.setReservation(reservation);
//        reservation.setBill(bill);
//
//        reservation.setEndTime(endTimes);
//        reservation.setStatus("Completed");
//        reservationRepo.save(reservation);
//        billRepo.save(bill);
//        return "Bill Generated Successfully";
//    }
}
