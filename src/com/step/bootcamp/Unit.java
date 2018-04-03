package com.step.bootcamp;

import java.util.Objects;

import static com.step.bootcamp.MeasurementType.*;

public enum Unit {
  FEET(30, LENGTH),INCH(2.5, LENGTH),CENTIMETRES(1, LENGTH),MILLIMETRES(0.1, LENGTH),
  KILOGRAM(1000, MASS),TON(1000000, MASS),GRAM(1, MASS),
  GALLON(3.78, VOLUME),LITRES(1, VOLUME);

  private final double baseMultiplier;
  private final MeasurementType type;

  public double toBaseUnit(double value) {
    return this.baseMultiplier * value;
  }

  Unit(double ratio, MeasurementType type) {
    this.baseMultiplier = ratio;
    this.type = type;
  }

  public boolean isSameType(Unit unit) {
    return unit.type == this.type;
  }

  public double fromBaseUnit(double value){
    return value / baseMultiplier;
  }

  public int hash(double value) {
    return Objects.hash(toBaseUnit(value), type);
  }
}
