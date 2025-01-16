package com.example.service;

import com.example.entity.Reservation;

import java.util.List;

public interface ReservationService {
    String creatingNewReservation(Reservation reservation) ;

    String cancelActiveReservation(String vehicleNo);

    List<Reservation> getAllReservation();
}
