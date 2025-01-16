package com.example.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParkingSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer parkingId;
    private String parkingSlotNo;
    private Integer parkingLevel;
    private Boolean parkingIsAvailable;
    private String parkingVehicleType;  // (e.g., Car, Bike, Truck)

    @OneToOne(mappedBy = "parkingSlot")
    private Reservation reservation;

//    private static Integer slotCounter = 1;
//
//    @PrePersist
//    private void generateParkingSlotNo() {
//        if (parkingSlotNo == null || parkingSlotNo.isEmpty()) {
//            this.parkingSlotNo = String.format("P%1d", slotCounter);
//        }
//    }
}
