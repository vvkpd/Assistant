package com.step.bootcamp;

import java.util.ArrayList;

public class ParkingLot {
  private final ArrayList<Car> parking;

  public ParkingLot() {
    parking = new ArrayList<>();
  }

  public boolean park(Car car) {
    parking.add(car);
    return true;
  }

  public boolean hasCar(int number) {
    for (Car car : parking) {
      if(car.hasNumber(number)) return true;
    }
    return false;
  }

  public Car checkout(int number) {
    for (Car car : parking) {
      if(car.hasNumber(number)){
        parking.remove(car);
        return car;
      }
    }
    throw new CarNotFoundException();
  }
}
