package com.step.bootcamp;

public class Measurement {
  private final double value;
  private final Unit unit;

  public Measurement(double value, Unit unit) {
    this.value = value;
    this.unit = unit;
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

  public Measurement add(Measurement other) {
    if(!unit.isSameType(other.unit)) throw new TypeMismatchException();
    double sum = value + other.unit.toUnit(other.value, unit);
    return new Measurement(sum, unit);
  }

  public Measurement toUnit(Unit targetUnit) {
    if(!unit.isSameType(targetUnit)) throw new TypeMismatchException();
    double targetUnitValue = unit.toUnit(value, targetUnit);
    return new Measurement(targetUnitValue, targetUnit);
  }


}
