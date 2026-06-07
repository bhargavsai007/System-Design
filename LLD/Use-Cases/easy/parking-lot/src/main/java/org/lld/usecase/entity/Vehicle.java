package org.lld.usecase.entity;

import lombok.Data;

@Data
public abstract class Vehicle {

    private String licenceNumber;
    private VehicleSize vehicleSize;

     public Vehicle(String licenceNumber, VehicleSize vehicleSize) {
        this.licenceNumber = licenceNumber;
        this.vehicleSize = vehicleSize;
    }
}
