package org.lld.usecase.entity;

import lombok.Data;

import java.util.Map;
import java.util.Optional;

@Data
public class ParkingFloor {

    private int floorNumber;
    private Map<String, ParkingSpot> parkingSpots;

    public ParkingFloor(int floorNumber, Map<String, ParkingSpot> parkingSpots) {
        this.floorNumber = floorNumber;
        this.parkingSpots = parkingSpots;
    }

    public int numberOfAvailableSpots() {

        int count = 0;
        for(ParkingSpot spot : parkingSpots.values()) {
            if (!spot.isOccupied()) {
                count++;
            }
        }
        return count;
    }

    public Optional<ParkingSpot> getAvailableSpot(Vehicle vehicle) {

        for(ParkingSpot spot : parkingSpots.values()) {
            if (spot.canFitVehicle(vehicle)) {
                    return Optional.of(spot);
            }
        }
        return Optional.empty();
    }

    public void addParkingSpot(ParkingSpot parkingSpot) {
        parkingSpots.put(parkingSpot.getSpotId(), parkingSpot);
    }

}
