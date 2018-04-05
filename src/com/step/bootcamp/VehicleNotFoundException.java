package com.step.bootcamp;

public class VehicleNotFoundException extends Exception {
  public VehicleNotFoundException() {
    super("Car of given number is not present");
  }
}
