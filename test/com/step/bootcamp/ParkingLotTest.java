package com.step.bootcamp;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ParkingLotTest {
  private ParkingLot parkingLot;

  @Before
  public void setUp() {
    parkingLot = new ParkingLot();
  }

  @Test
  public void shouldBeAbleParkACar() {
    assertTrue( parkingLot.park(new Car(1234)));
    assertTrue(parkingLot.hasCar(1234));
  }

  @Test
  public void shouldCheckoutTheCarOfGivenNumber() {
    Car car = new Car(123);
    parkingLot.park(car);
    assertThat(parkingLot.checkout(123), is(car));
  }

  @Test
  public void checkedOutCarShouldNotPresent() {
    Car car = new Car(123);
    parkingLot.park(car);
    parkingLot.checkout(123);
    assertFalse(parkingLot.hasCar(123));
  }

  @Test
  public void shouldNotParkSameCarAgain() {
    Car car = new Car(123);
    parkingLot.park(car);
    assertFalse(parkingLot.park(car));
  }

  @Test(expected = CarNotFoundException.class)
  public void shouldThrowExceptionWhenCarIsNotPresent() {
    parkingLot.checkout(123);
  }
}
