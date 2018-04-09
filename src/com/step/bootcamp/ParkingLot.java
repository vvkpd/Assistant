package com.step.bootcamp;

import java.util.HashMap;

class ParkingLot {
  private final HashMap<Object, Vehicle> vehicles;
  private final int capacity;
  private final Event subscribers;

  ParkingLot(int capacity, Event subscribers) {
    this.capacity = capacity;
    vehicles = new HashMap<>();
    this.subscribers = subscribers;
  }

  public Object park(Vehicle vehicle) throws CannotParkException {
    if(has(vehicle)) throw new CannotParkException("Car is already parked");
    if(isFull()) throw new CannotParkException("Parking is full");
    Object token = vehicle.hashCode();
    vehicles.put(token, vehicle);
    if(isFull()) subscribers.broadcastFull();
    return token;
  }

  private boolean has(Vehicle vehicle) {
    return vehicles.containsValue(vehicle);
  }

  public Vehicle checkoutFor(Object token) throws VehicleNotFoundException {
    boolean wasFull = isFull();
    Vehicle vehicle = vehicles.remove(token);
    if(vehicle == null){
      throw new VehicleNotFoundException();
    }
    if(wasFull) subscribers.broadcastSpaceAvailable();
    return vehicle;
  }

  public boolean isFull() {
    return vehicles.size() == capacity;
  }

}
