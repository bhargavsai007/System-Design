package org.lld.usecase.service;

import org.lld.usecase.entity.ParkingFloor;
import org.lld.usecase.entity.ParkingSpot;
import org.lld.usecase.entity.Vehicle;

import java.util.List;
import java.util.Optional;

public interface ParkingStrategy {

    Optional<ParkingSpot> getParkingSpot(List<ParkingFloor> parkingFloors, Vehicle vehicle);
}
