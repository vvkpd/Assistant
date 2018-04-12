package com.step.bootcamp;

import java.util.ArrayList;

public class Attendant implements Visitable{
  private final ArrayList<ParkingLot> parkingLots;
  private final String name;

  public Attendant(String name) {
    this.name = name;
    parkingLots = new ArrayList<>();
  }

  public Attendant add(ParkingLot parkingLot) {
    parkingLots.add(parkingLot);
    return this;
  }

  public Object park(Vehicle vehicle) throws CannotParkException {
    for (ParkingLot parkingLot : parkingLots) {
      if (!parkingLot.isFull()) {
        return parkingLot.park(vehicle);
      }
    }
    throw new CannotParkException("Parking is full");
  }

  public Vehicle checkoutFor(Object token) throws VehicleNotFoundException {
    for (ParkingLot parkingLot : parkingLots) {
      try {
        return parkingLot.checkoutFor(token);
      } catch (VehicleNotFoundException ignored) {
      }
    }
    throw new VehicleNotFoundException();
  }

  @Override
  public void accept(Visitor visitor){
    visitor.visitAttendant(name, parkingLots.size());
    parkingLots.forEach(parkingLot->parkingLot.accept(visitor));
  }
}
