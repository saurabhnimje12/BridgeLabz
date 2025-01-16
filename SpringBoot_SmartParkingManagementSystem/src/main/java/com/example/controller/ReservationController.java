package com.example.controller;

import com.example.entity.Reservation;
import com.example.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    private ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/addReservation")
    public ResponseEntity<String> creatingNewReservation(@RequestBody Reservation reservation)  {
        return new ResponseEntity<String>(reservationService.creatingNewReservation(reservation), HttpStatus.CREATED);
    }

    @DeleteMapping("/cancelActiveReservation/{vehicleNo}")
    public ResponseEntity<String> cancelActiveReservation(@PathVariable String vehicleNo) {
        return new ResponseEntity<String>(reservationService.cancelActiveReservation(vehicleNo), HttpStatus.OK);
    }

    @GetMapping("/getAllReservation")
    public ResponseEntity<List<Reservation>> getAllReservation() {
        return new ResponseEntity<List<Reservation>>(reservationService.getAllReservation(), HttpStatus.OK);
    }
}
