package com.step.bootcamp;

public class CarNotFoundException extends RuntimeException {
  public CarNotFoundException() {
    super("Car of given number is not present");
  }
}
