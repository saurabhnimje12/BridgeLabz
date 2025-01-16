package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer resId;

    @ManyToOne
    @JoinColumn(name = "userId")
    @JsonIgnore
    private User user;

    @OneToOne
    @JoinColumn(name = "parkingId")
    private ParkingSlot parkingSlot;
    private String vehicleNo;
    private LocalTime startTime;
    private LocalTime endTime;
    private String status;  // (e.g., Active, Completed, Cancelled)

    @OneToOne(mappedBy = "reservation", cascade = CascadeType.ALL)
    private Bill bill;
}
