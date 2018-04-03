package com.step.bootcamp;

import java.util.Objects;

import static com.step.bootcamp.MeasurementType.*;

public enum Unit {
  FEET(Constants.A_FOOT_IN_CM, LENGTH),INCH(Constants.A_INCH_IN_CM, LENGTH),
  CENTIMETRES(1, LENGTH),MILLIMETRES(Constants.A_MM_IN_CM, LENGTH),

  KILOGRAM(Constants.A_KG_IN_G, MASS),TON(Constants.A_TON_IN_G, MASS),GRAM(1, MASS),

  GALLON(Constants.A_GALLON_IN_LITRES, VOLUME),LITRES(1, VOLUME);

  private final double baseMultiplier;
  private final MeasurementType type;

  private double toBaseUnit(double value) {
    return (double) Math.round(this.baseMultiplier * value * 1000) / 1000;
  }

  Unit(double ratio, MeasurementType type) {
    this.baseMultiplier = ratio;
    this.type = type;
  }

  public boolean isSameType(Unit unit) {
    return unit.type == this.type;
  }

  public double toUnit(double value, Unit target){
    return  toBaseUnit(value)/target.baseMultiplier;
  }

  public int hash(double value) {
    return Objects.hash(toBaseUnit(value), type);
  }

  private static class Constants {
    static final int A_FOOT_IN_CM = 30;
    static final double A_INCH_IN_CM = 2.5;
    static final double A_MM_IN_CM = 0.1;
    static final int A_KG_IN_G = 1000;
    static final int A_TON_IN_G = 1000000;
    static final double A_GALLON_IN_LITRES = 3.78;
  }
}
