package org.lld.usecase.entity;

public class Car extends Vehicle{

    public Car(String licenceNumber) {

        super(licenceNumber, VehicleSize.MEDIUM);
    }
}
