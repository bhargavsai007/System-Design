package org.lld.usecase.entity;

public class Truck extends Vehicle{

    public Truck(String licenceNumber) {
        super(licenceNumber, VehicleSize.LARGE);
    }
}
