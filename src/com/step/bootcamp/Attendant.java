package com.step.bootcamp;

import java.util.ArrayList;

public class Attendant {
  private final ArrayList<ParkingLot> parkingLots;
  private final ArrayList<ParkingLot> availableLots;
  private final ParkBasedOn parkBasedOn;

  public Attendant(ParkBasedOn parkBasedOn) {
    this.parkBasedOn = parkBasedOn;
    parkingLots = new ArrayList<>();
    availableLots = new ArrayList<>();
  }

  public void add(ParkingLot parkingLot) {
    parkingLots.add(parkingLot);
    availableLots.add(parkingLot);
  }

  public Object park(Vehicle vehicle) throws CannotParkException {
    if(availableLots.isEmpty())
      throw new CannotParkException("Parking is full");

    ParkingLot lot = parkBasedOn.getLot(availableLots);
    Object token = lot.park(vehicle);
    if(lot.isFull()) availableLots.remove(lot);
    return token;
  }

  public Vehicle checkoutFor(Object token) throws VehicleNotFoundException {
    for (ParkingLot parkingLot : parkingLots) {
      try {
        Vehicle vehicle = parkingLot.checkoutFor(token);
        if(!availableLots.contains(parkingLot)){
          availableLots.add(parkingLot);
        }
        return vehicle;
      } catch (VehicleNotFoundException ignored){}
    }
    throw new VehicleNotFoundException();
  }

  @Override
  public String toString() {
    return "Attendant{" +
        "parkingLots=" + parkingLots +
        ", availableLots=" + availableLots +
        '}';
  }
}
