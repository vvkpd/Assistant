package com.step.bootcamp;

import java.util.ArrayList;

public class Attendant {
  public static final String FULL = "Full";
  public static final String SPACE_AVAILABLE = "Space Available";
  public static final String NOT_FULL = "Not Full";
  private final ArrayList<ParkingLot> parkingLots;
  private final Assistant assistant;
  private final ArrayList<Listener> listeners;

  public Attendant(Assistant assistant) {
    this.assistant = assistant;
    parkingLots = new ArrayList<>();
    listeners = new ArrayList<>();
  }

  public void add(ParkingLot parkingLot) {
    parkingLots.add(parkingLot);
  }

  public Object park(Vehicle vehicle) throws CannotParkException {
    for (ParkingLot parkingLot : parkingLots) {
     if(!parkingLot.isFull()) {
       Object token = parkingLot.park(vehicle);
       System.out.println(FULL);
       if(parkingLot.isFull()) broadcast(FULL);
       return token;
     }
    }
    throw new CannotParkException("Parking is full");
  }

  private void broadcast(String msg) {
    assistant.updateDisplay(msg);
    for (Listener listener : listeners) {
      listener.listen(msg);
    }
  }

  public Vehicle checkoutFor(Object token) throws VehicleNotFoundException {
    for (ParkingLot parkingLot : parkingLots) {
      try {
        Vehicle vehicle =parkingLot.checkoutFor(token);
        System.out.println(NOT_FULL);
        broadcast(SPACE_AVAILABLE);
        return vehicle;
      } catch (VehicleNotFoundException ignored){}
    }
    throw new VehicleNotFoundException();
  }

  public void addListener(Listener listener) {
    listeners.add(listener);
  }
}
