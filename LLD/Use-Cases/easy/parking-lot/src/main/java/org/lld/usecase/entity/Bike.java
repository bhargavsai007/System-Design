package org.lld.usecase.entity;

public class Bike extends Vehicle{

    public Bike(String licenceNumber) {
        super(licenceNumber, VehicleSize.SMALL);
    }
}
