package org.lld.usecase.service;

import org.lld.usecase.entity.ParkingTicket;

public interface ParkingFeeStrategy {

    int calculateParkingFee(ParkingTicket parkingTicket);
}
