package com.step.bootcamp;

import java.util.Objects;

public class Car {
  private final int number;

  public Car(int number) {
    this.number = number;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Car car = (Car) o;
    return Objects.equals(number, car.number);
  }

  @Override
  public int hashCode() {
    return Objects.hash(number);
  }

  public boolean hasNumber(int number) {
    return this.number == number;
  }
}
