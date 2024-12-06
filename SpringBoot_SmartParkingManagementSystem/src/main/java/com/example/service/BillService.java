package com.example.service;

public interface BillService {

    String updatePaymentStatus(String findByVehicleNo, String status);

    String generateBill(String findByVehicleNo);
}
