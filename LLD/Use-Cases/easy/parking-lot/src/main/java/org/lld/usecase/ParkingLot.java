package org.lld.usecase;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.lld.usecase.entity.ParkingFloor;
import org.lld.usecase.entity.ParkingSpot;
import org.lld.usecase.entity.ParkingTicket;
import org.lld.usecase.entity.Vehicle;
import org.lld.usecase.service.ParkingFeeStrategy;
import org.lld.usecase.service.ParkingStrategy;

import java.util.*;

@Data
@Slf4j
public class ParkingLot {

    private List<ParkingFloor>parkingFloors;
    private ParkingStrategy parkingStrategy;
    private ParkingFeeStrategy parkingFeeStrategy;
    private Map<String, ParkingTicket> activeTickets;

    public ParkingLot(ParkingStrategy parkingStrategy, ParkingFeeStrategy parkingFeeStrategy) {
        this.parkingFloors = new ArrayList<>();
        this.parkingStrategy = parkingStrategy;
        this.parkingFeeStrategy = parkingFeeStrategy;
        this.activeTickets = new HashMap<>();
    }

    public synchronized ParkingTicket parkVehicle(Vehicle vehicle){

        Optional<ParkingSpot> parkingSpot = parkingStrategy.getParkingSpot(parkingFloors, vehicle);

        if(parkingSpot.isEmpty()){
            log.info("No parking spot available for vehicle type: {}", vehicle.getVehicleSize());
            return null;
        }

        else{
            ParkingTicket ticket = parkingSpot.get().parkVehicle(vehicle);
            activeTickets.put(ticket.getTicketId(), ticket);
            log.info("Vehicle parked at spot: {} with ticket id: {}", parkingSpot.get().getSpotId(), ticket.getTicketId());
            return ticket;
        }
    }

    public synchronized void unParkVehicle(ParkingTicket parkingTicket){

        ParkingSpot parkingSpot = parkingTicket.getParkingSpot();
        parkingSpot.unParkVehicle(parkingTicket);
        activeTickets.remove(parkingTicket.getTicketId());
        int fee = parkingFeeStrategy.calculateParkingFee(parkingTicket);
        log.info("Vehicle unparked from spot: {} with ticket id: {}. Parking fee: {}", parkingSpot.getSpotId(), parkingTicket.getTicketId(), fee);
    }

    public void addFloor(ParkingFloor parkingFloor){
        parkingFloors.add(parkingFloor);
    }

     public void removeFloor(ParkingFloor parkingFloor){
        parkingFloors.remove(parkingFloor);
     }

}
