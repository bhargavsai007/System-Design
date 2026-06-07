package org.lld.usecase.service;

import org.lld.usecase.entity.ParkingTicket;
import org.lld.usecase.entity.VehicleSize;

import java.util.Map;

public class VehicleSizeFeeStrategy implements ParkingFeeStrategy{


    private final Map<VehicleSize, Integer> feeAsPerVehicleSize;

    public VehicleSizeFeeStrategy(Map<VehicleSize, Integer> feeAsPerVehicleSize) {
            this.feeAsPerVehicleSize = feeAsPerVehicleSize;
    }

    @Override
    public int calculateParkingFee(ParkingTicket parkingTicket) {

        long totalDuration = (parkingTicket.getExitTime() - parkingTicket.getEntryTime())/(1000*60*60); // converting milliseconds to hours

        if(totalDuration<1)
            return feeAsPerVehicleSize.get(parkingTicket.getParkedVehicle().getVehicleSize());

        else
            return feeAsPerVehicleSize.get(parkingTicket.getParkedVehicle().getVehicleSize())* (int)totalDuration;
    }
}
