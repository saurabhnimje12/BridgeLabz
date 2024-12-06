package com.example.service;

import com.example.entity.ParkingSlot;
import com.example.entity.Reservation;

import java.util.List;

public interface ParkingSlotService {
    List<ParkingSlot> getStatusAllParkingSlots();

    String reserveParkingSlot(ParkingSlot parkingSlot);

    String ReleaseParkingSlot(String parkingSlotNo);
}
