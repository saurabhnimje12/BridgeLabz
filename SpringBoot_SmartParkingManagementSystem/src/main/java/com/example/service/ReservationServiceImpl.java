package com.example.service;

import com.example.entity.ParkingSlot;
import com.example.entity.Reservation;
import com.example.entity.User;
import com.example.exception.CustomException;
import com.example.exception.SlotUnavailableException;
import com.example.repo.ParkingSlotRepo;
import com.example.repo.ReservationRepo;
import com.example.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationRepo reservationRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ParkingSlotRepo parkingSlotRepo;

    @Override
    public String creatingNewReservation(Reservation reservation) {
        String str;

        Optional<Reservation> existingReservation = reservationRepo.findByVehicleNo(reservation.getVehicleNo());
        if (existingReservation.isPresent() && "Active".equalsIgnoreCase(existingReservation.get().getStatus())) {
            str = "Vehicle Already Parked: " + reservation.getVehicleNo();
        }

        Optional<User> userOptional = userRepo.findByRegisteredVehicles(reservation.getVehicleNo());
        if (userOptional.isEmpty()) {
            str = "!! User Not Found !!     |   Please Register User";
        }

        Optional<ParkingSlot> parkingSlotOptional = parkingSlotRepo.findByParkingSlotNo(reservation.getParkingSlot().getParkingSlotNo());
        if (parkingSlotOptional.isEmpty() || parkingSlotOptional.get().getParkingIsAvailable()) {
           str = "Parking Slot is not available: " + reservation.getParkingSlot().getParkingSlotNo();
        }

        User user = userOptional.get();
        reservation.setUser(user);

        ParkingSlot parkingSlot = parkingSlotOptional.get();
        parkingSlot.setParkingIsAvailable(false);
        parkingSlotRepo.save(parkingSlot);

        reservation.setParkingSlot(parkingSlot);
        reservation.setStartTime(LocalTime.now());
        //    reservation.setEndTime(LocalTime.now().plusHours(reservation.getEndTime()).toNanoOfDay());
        reservation.setStatus("Active");
        reservationRepo.save(reservation);
        str =  "Reservation Created Successfully";

        return str;
    }


    @Override
    public String cancelActiveReservation(String vehicleNo) {
        String str;

        Optional<Reservation> reservationOptional = reservationRepo.findByVehicleNo(vehicleNo);

        if (reservationOptional.isEmpty() || "Cancelled".equalsIgnoreCase(reservationOptional.get().getStatus())) {
            str = "No ACTIVE Reservation Found For Vehicle: " + vehicleNo;
        }

        Reservation reservation = reservationOptional.get();
        reservation.setStatus("Cancelled");

        ParkingSlot parkingSlot = reservation.getParkingSlot();
        parkingSlot.setParkingIsAvailable(true);

        parkingSlotRepo.save(parkingSlot);
        reservationRepo.save(reservation);
        str =  "Reservation Cancelled Successfully for Vehicle: " + vehicleNo;

        return str;
    }

    @Override
    public List<Reservation> getAllReservation() {
        return reservationRepo.findAll();
    }
}
