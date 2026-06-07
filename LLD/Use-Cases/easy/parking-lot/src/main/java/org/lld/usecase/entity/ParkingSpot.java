package org.lld.usecase.entity;

import lombok.Data;

@Data
public class ParkingSpot {

    private String spotId;
    private VehicleSize spotSize;
    private Vehicle parkedVehicle;
    private boolean isOccupied;

    public ParkingSpot(String spotId, VehicleSize spotSize) {
        this.spotId = spotId;
        this.spotSize = spotSize;
        this.isOccupied = false;
    }

    public ParkingTicket parkVehicle(Vehicle vehicle){

        this.parkedVehicle = vehicle;
        this.isOccupied = true;
        return new ParkingTicket(this, vehicle);
    }

    public void unParkVehicle(ParkingTicket parkingTicket){

        parkingTicket.setExitTime();
        parkingTicket.setParkedVehicle(null);
        parkingTicket.setParkingSpot(null);
        this.parkedVehicle = null;
        this.isOccupied = false;
    }

    public boolean canFitVehicle(Vehicle vehicle){
        
        return !isOccupied && spotSize.equals(vehicle.getVehicleSize());
    }
}
