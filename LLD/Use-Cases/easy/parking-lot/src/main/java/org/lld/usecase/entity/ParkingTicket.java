package org.lld.usecase.entity;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class ParkingTicket {

    private String ticketId;
    private Long entryTime;
    private Long exitTime;
    private Vehicle parkedVehicle;
    private ParkingSpot parkingSpot;

    public ParkingTicket(ParkingSpot parkingSpot, Vehicle parkedVehicle) {
        this.ticketId = UUID.randomUUID().toString();
        this.entryTime = new Date().getTime();
        this.parkingSpot = parkingSpot;
        this.parkedVehicle = parkedVehicle;
    }

    public void setExitTime() {
        this.exitTime = new Date().getTime();
    }
}
