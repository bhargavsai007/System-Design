package org.lld.usecase.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Data
@Slf4j
public class ParkingFloor {

    private int floorNumber;
    private Map<String, ParkingSpot> parkingSpots;

    public ParkingFloor(int floorNumber) {
        this.floorNumber = floorNumber;
        this.parkingSpots = new HashMap<>();
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

    public void removeParkingSpot(ParkingSpot parkingSpot) {

        if (parkingSpot.isOccupied() || !parkingSpots.containsKey(parkingSpot.getSpotId())) {
            log.info("Cannot remove parking spot: {}. It is either occupied or does not exist.", parkingSpot.getSpotId());
            return;
        }
        parkingSpots.remove(parkingSpot.getSpotId());
    }

}
