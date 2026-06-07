package org.lld.usecase.service;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.lld.usecase.entity.ParkingTicket;

@Slf4j
@Data
public class FlatRateFeeStrategy implements ParkingFeeStrategy{

    private int flatRatePerHour;

    public FlatRateFeeStrategy(int flatRatePerHour) {
        this.flatRatePerHour = flatRatePerHour;
    }

    @Override
    public int calculateParkingFee(ParkingTicket parkingTIcket) {

        long totalDuration = (parkingTIcket.getExitTime() - parkingTIcket.getEntryTime())/(1000*60*60); // converting milliseconds to hours

        if(totalDuration<1)
                return flatRatePerHour;
        else
            return flatRatePerHour * (int)totalDuration;
    }
}
