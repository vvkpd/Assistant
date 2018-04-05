package com.step.bootcamp;

import java.util.ArrayList;

public class ParkingLotHandler {
  private final ArrayList<ParkingLot> parkingLots;

  public ParkingLotHandler() {
    parkingLots = new ArrayList<>();
  }

  public void add(ParkingLot parkingLot) {
    parkingLots.add(parkingLot);
  }

  public Object park(Vehicle vehicle) throws CannotParkException {
    for (ParkingLot parkingLot : parkingLots) {
     if(!parkingLot.isFull()) return parkingLot.park(vehicle);
    }
    throw new CannotParkException("Parking is full");
  }

  public Vehicle checkoutFor(Object token) throws VehicleNotFoundException {
    for (ParkingLot parkingLot : parkingLots) {
      try {
        return parkingLot.checkoutFor(token);
      } catch (VehicleNotFoundException ignored){}
    }
    throw new VehicleNotFoundException();
  }
}
