package com.example.controller;

import com.example.service.BillService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bill")
public class BillController {

    private BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    @PostMapping("/generate/{parkingSlotNo}")
    public ResponseEntity<String> generateBill(@PathVariable String findByVehicleNo){
        return new ResponseEntity<String>(billService.generateBill(findByVehicleNo), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<String> updatePaymentStatus(@PathVariable String findByVehicleNo, @PathVariable String status){
        return new ResponseEntity<String>(billService.updatePaymentStatus(findByVehicleNo,status), HttpStatus.OK);
    }
}
