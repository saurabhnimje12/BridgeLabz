package com.example.service;

import com.example.entity.ParkingSlot;
import com.example.repo.ParkingSlotRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParkingSlotServiceImpl implements ParkingSlotService {
    private ParkingSlotRepo parkingSlotRepo;

    public ParkingSlotServiceImpl(ParkingSlotRepo parkingSlotRepo) {
        this.parkingSlotRepo = parkingSlotRepo;
    }

    @Override
    public List<ParkingSlot> getStatusAllParkingSlots() {
        return parkingSlotRepo.findAll();
    }

    @Override
    public String reserveParkingSlot(ParkingSlot parkingSlot) {
        Optional<ParkingSlot> byParkingSlotNo = parkingSlotRepo.findByParkingSlotNo(parkingSlot.getParkingSlotNo());
        if (byParkingSlotNo.isPresent() && byParkingSlotNo.get().getParkingIsAvailable()) {
            return "Parking Is Already Booked For : " + parkingSlot.getParkingVehicleType();
        }

        if (byParkingSlotNo.isPresent()) {
            ParkingSlot parkingSlot1 = byParkingSlotNo.get();
            parkingSlot1.setParkingLevel(parkingSlot.getParkingLevel());
            parkingSlot1.setParkingIsAvailable(true);
            parkingSlot1.setParkingVehicleType(parkingSlot.getParkingVehicleType());
            parkingSlotRepo.save(parkingSlot1);
            return "Slot Reserved Updated Successfully :" + parkingSlot.getParkingSlotNo() + " For : " + parkingSlot.getParkingVehicleType();
        } else {
            parkingSlot.setParkingIsAvailable(true);
            parkingSlotRepo.save(parkingSlot);
            return "Slot Reserved Successfully : " + parkingSlot.getParkingSlotNo();
        }
    }

    @Override
    public String ReleaseParkingSlot(String parkingSlotNo) {
        String str;
        Optional<ParkingSlot> optionalParkingSlot = parkingSlotRepo.findByParkingSlotNo(parkingSlotNo);
        if (optionalParkingSlot.isPresent()) {
            ParkingSlot parkingSlot = optionalParkingSlot.get();
            parkingSlot.setParkingLevel(0);
            parkingSlot.setParkingIsAvailable(false);
            parkingSlot.setParkingVehicleType("No-Vehicle");
            parkingSlotRepo.save(parkingSlot);
            str = "Slot Released : " + optionalParkingSlot.get().getParkingSlotNo();
        } else {
            str = "Slot Not Found with Id : " + parkingSlotNo;
        }
        return str;
    }
}
