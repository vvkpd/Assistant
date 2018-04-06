package com.step.bootcamp;

import java.util.ArrayList;
import java.util.HashMap;

class ParkingLot {
  private final HashMap<Object, Vehicle> vehicles;
  private final int capacity;
  private final ArrayList<Listener> listeners;

  ParkingLot(int capacity) {
    this.capacity = capacity;
    vehicles = new HashMap<>();
    listeners = new ArrayList<>();
  }

  public void addListener(Listener listener) {
    listeners.add(listener);
  }

  public Object park(Vehicle vehicle) throws CannotParkException {
    if(has(vehicle)) throw new CannotParkException("Car is already parked");
    if(isFull()) throw new CannotParkException("Parking is full");
    Object token = vehicle.hashCode();
    vehicles.put(token, vehicle);
    if(isFull()) broadcastFull();
    return token;
  }

  private void broadcastFull() {
    for (Listener listener : listeners) {
      listener.full();
    }
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
    if(wasFull) broadcastSpaceAvailable();
    return vehicle;
  }

  private void broadcastSpaceAvailable() {
    for (Listener listener : listeners) {
      listener.spaceAvailable();
    }
  }

  public boolean isFull() {
    return vehicles.size() == capacity;
  }
}
