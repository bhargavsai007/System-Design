package org.lld.usecase.service;

import org.lld.usecase.entity.ParkingFloor;
import org.lld.usecase.entity.ParkingSpot;
import org.lld.usecase.entity.Vehicle;

import java.util.List;
import java.util.Optional;

public class FarthestFirstStrategy implements ParkingStrategy{

    @Override
    public Optional<ParkingSpot> getParkingSpot(List<ParkingFloor> parkingFloors, Vehicle vehicle) {

        for(int i = parkingFloors.size() - 1; i >= 0; i--){
            Optional<ParkingSpot> spot = parkingFloors.get(i).getAvailableSpot(vehicle);

            if(spot.isPresent()){
                return spot;
            }
        }

        return Optional.empty();
    }

}
