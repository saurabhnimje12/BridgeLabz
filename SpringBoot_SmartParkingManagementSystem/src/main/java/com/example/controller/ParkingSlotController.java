package com.example.controller;

import com.example.entity.ParkingSlot;
import com.example.entity.Reservation;
import com.example.service.ParkingSlotService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking")
public class ParkingSlotController {

    private ParkingSlotService parkingSlotService;

    public ParkingSlotController(ParkingSlotService parkingSlotService) {
        this.parkingSlotService = parkingSlotService;
    }

    @GetMapping("/statusAllParkingSlot")
    public List<ParkingSlot> statusAllParkingSlot() {
        return parkingSlotService.getStatusAllParkingSlots();
    }

    @PostMapping("/reserveParkingSlot")
    public String reserveParkingSlot(@RequestBody ParkingSlot parkingSlot){
        return parkingSlotService.reserveParkingSlot(parkingSlot);
    }

    @GetMapping("/releaseParkingSlot/{parkingSlotNo}")
    private String releaseParkingSlot(@PathVariable String parkingSlotNo){
        return parkingSlotService.ReleaseParkingSlot(parkingSlotNo);
    }

}
