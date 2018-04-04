package com.step.bootcamp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MeasurementTest {
  @Test
  public void hundredCShouldEqualTo212F() {
    Measurement twoHundred12F = Measurement.inFahrenheit(212);
    Measurement hundredC = Measurement.inCelsius(100);
    assertEquals(twoHundred12F, hundredC);
  }

  @Test
  public void twoHundred12FShouldEqualHundredCelsius() {
    Measurement twoHundred12F = Measurement.inFahrenheit(212);
    Measurement hundredC = Measurement.inCelsius(100);
    assertEquals(hundredC, twoHundred12F);
    assertEquals(hundredC.hashCode(), twoHundred12F.hashCode());
  }

  @Test
  public void hundredCShouldEqualHundredCelsius() {
    Measurement hundredC = Measurement.inCelsius(100);
    Measurement anotherHundredC = Measurement.inCelsius(100);
    assertEquals(anotherHundredC, hundredC);
  }

  @Test
  public void hundredFShouldEqualHundredF() {
    Measurement hundredF = Measurement.inFahrenheit(100);
    Measurement anotherHundredF = Measurement.inFahrenheit(100);
    assertEquals(hundredF, anotherHundredF);
    assertEquals(hundredF.hashCode(), anotherHundredF.hashCode());
  }
}
