package com.step.bootcamp;

import static com.step.bootcamp.Unit.*;

public class ArithmeticMeasurement extends Measurement{
  private ArithmeticMeasurement(double value, Unit unit) {
    super(value, unit);
  }

  public static ArithmeticMeasurement inMillimetres(double millimeters) {
    return  new ArithmeticMeasurement(millimeters,MILLIMETRES);
  }

  public static ArithmeticMeasurement inLitres(double litres) {
    return new ArithmeticMeasurement(litres,LITRES);
  }

  public static ArithmeticMeasurement inGallons(double gallons) {
    return new ArithmeticMeasurement(gallons,GALLON);
  }

  public static ArithmeticMeasurement inKilograms(double kg) {
    return new ArithmeticMeasurement(kg,KILOGRAM);
  }

  public static ArithmeticMeasurement inGrams(double grams) {
    return new ArithmeticMeasurement(grams,GRAM);
  }

  public static ArithmeticMeasurement inTons(double tons) {
    return new ArithmeticMeasurement(tons,TON);
  }

  public static ArithmeticMeasurement inCentimetres(double centimeters) {
    return new ArithmeticMeasurement(centimeters,CENTIMETRES);
  }

  public static ArithmeticMeasurement inFeet(double value) {
    return new ArithmeticMeasurement(value, FEET);
  }

  public static ArithmeticMeasurement inInches(double value) {
    return new ArithmeticMeasurement(value, INCH);
  }

  public ArithmeticMeasurement add(ArithmeticMeasurement other) {
    if(!unit.isSameType(other.unit)) throw new TypeMismatchException();
    double sum = value + other.unit.toUnit(other.value, unit);
    return new ArithmeticMeasurement(sum, unit);
  }

  public ArithmeticMeasurement toUnit(Unit targetUnit) {
    return new ArithmeticMeasurement(super.toUnit(targetUnit).value, targetUnit);
  }
}
