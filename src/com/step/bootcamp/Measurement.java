package com.step.bootcamp;

public class Measurement {
  protected final double value;
  protected final Unit unit;

  protected Measurement(double value, Unit unit) {
    this.value = value;
    this.unit = unit;
  }

  public static Measurement inCelsius(double celsius) {
    return new Measurement(celsius,Unit.CELSIUS);
  }

  public static Measurement inFahrenheit(double fahrenheits) {
    return new Measurement(fahrenheits,Unit.FAHRENHEIT);
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null || getClass() != other.getClass()) return false;
    Measurement measurement = (Measurement) other;
    if(!measurement.unit.isSameType(unit)) return false;
    return Math.abs(measurement.unit.toUnit(measurement.value, unit) - value) <= 0.01;
  }

  @Override
  public String toString() {
    return "Measurement{" +
        "value=" + value +
        ", unit=" + unit +
        '}';
  }

  @Override
  public int hashCode() {
    return unit.hash(value);
  }

  public Measurement toUnit(Unit targetUnit) {
    if(!unit.isSameType(targetUnit)) throw new TypeMismatchException();
    double targetUnitValue = unit.toUnit(value, targetUnit);
    return new Measurement(targetUnitValue, targetUnit);
  }
}
