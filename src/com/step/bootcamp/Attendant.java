package com.step.bootcamp;

import java.util.ArrayList;

public class Attendant implements Listener{
  private final ArrayList<ParkingLot> parkingLots;
  private final Assistant assistant;

  public Attendant(Assistant assistant) {
    this.assistant = assistant;
    parkingLots = new ArrayList<>();
  }

  public void add(ParkingLot parkingLot) {
    parkingLot.addListener(assistant);
    parkingLot.addListener(this);
    parkingLots.add(parkingLot);
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
  public void full() {
    System.out.println("Full");
  }

  @Override
  public void spaceAvailable() {
    System.out.println("Space Available");
  }
}
