package com.step.bootcamp;

import java.util.ArrayList;

public class Attendant {
  private final ArrayList<ParkingLot> parkingLots;
  private final String name;

  public Attendant(String name) {
    this.name = name;
    parkingLots = new ArrayList<>();
  }

  public void add(ParkingLot parkingLot) {
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

  public String report() {
    String report = String.format("Name: %s  Total Lots: %d", name, parkingLots.size());
    for (ParkingLot parkingLot : parkingLots) {
      report += String.format("\n    %s", parkingLot.report());
    }
    return report;
  }

  public String toHTML() {
    String report = String.format("<h2>%s  :- %d</h2>", name, parkingLots.size()) +
        "<table><thead>" +
        "<th>Lot ID</th><th>Capacity</th>" +
        "</thead><tbody>";
    for (ParkingLot parkingLot : parkingLots) {
      report += String.format("%s", parkingLot.toHTML());
    }
    return report + "</tbody></table>";
  }
}
