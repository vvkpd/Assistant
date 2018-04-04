package com.step.bootcamp;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class CarTest {
  @Test
  public void hasNumberShouldGiveTrueForSameNumber() {
    Car car = new Car(1234);
    assertTrue(car.hasNumber(1234));
  }

  @Test
  public void hasNumberShouldGiveFalseForAnotherNumber() {
    Car car = new Car(1234);
    assertFalse(car.hasNumber(134));
  }
}
