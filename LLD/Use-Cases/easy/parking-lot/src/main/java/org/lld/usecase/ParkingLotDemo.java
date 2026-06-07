package org.lld.usecase;

import org.lld.usecase.entity.*;
import org.lld.usecase.service.FlatRateFeeStrategy;
import org.lld.usecase.service.NearestFirstStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ParkingLotDemo {

    private static final int NUMBER_OF_FLOORS = 3;

    public static void main(String[] args) {

        List<ParkingFloor>parkingFloors = new ArrayList<>();

        for(int i=0; i<NUMBER_OF_FLOORS; i++){

            Map<String, ParkingSpot> parkingSpotMap = new HashMap<>();
            List<ParkingSpot> parkingSpots = getParkingSpots(i);

            for(ParkingSpot parkingSpot: parkingSpots){
                parkingSpotMap.put(parkingSpot.getSpotId(), parkingSpot);
            }

            parkingFloors.add(new ParkingFloor(i, parkingSpotMap));
        }

        ParkingLot parkingLot = new ParkingLot(parkingFloors, new NearestFirstStrategy(), new FlatRateFeeStrategy(10));

        Vehicle bike1 = new Bike("AP16EH4583");
        Vehicle car1 = new Car("AP16EH4584");
        Vehicle truck1 = new Truck("AP16EH4585");

        Vehicle bike2 = new Bike("AP16EH4586");
        Vehicle car2 = new Car("AP16EH4587");
        Vehicle truck2 = new Truck("AP16EH4588");

        ParkingTicket bikeParkingTicket = parkingLot.parkVehicle(bike1);
        ParkingTicket carParkingTicket = parkingLot.parkVehicle(car1);
        ParkingTicket truckParkingTicket = parkingLot.parkVehicle(truck1);

        parkingLot.unParkVehicle(truckParkingTicket);

        parkingLot.parkVehicle(truck2);

        truckParkingTicket = parkingLot.parkVehicle(truck1);

    }

    private static List<ParkingSpot> getParkingSpots(int floorNumber) {

        List<ParkingSpot>parkingSpots = new ArrayList<>();

        for(int i=0; i<3; i++){

            if(i==0)
                parkingSpots.add(new ParkingSpot("L"+floorNumber+0, VehicleSize.SMALL));
            else if(i==1)
                parkingSpots.add(new ParkingSpot("L"+floorNumber+1, VehicleSize.MEDIUM));
            else
                parkingSpots.add(new ParkingSpot("L"+floorNumber+2, VehicleSize.LARGE));
        }

        return parkingSpots;
    }

}



