package com.step.bootcamp;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ParkingLotTest {
  private ParkingLot parkingLot2;

  private class Car implements Vehicle {
  }

  @Before
  public void setUp() {
    parkingLot2 = new ParkingLot(2);
  }

  @Test
  public void shouldCheckoutTheCarOfGivenNumber() throws VehicleNotFoundException, CannotParkException {
    Car car = new Car();
    Object token = parkingLot2.park(car);
    assertThat(parkingLot2.checkoutFor(token), is(car));
  }

  @Test
  public void shouldBeAbleParkACar() throws CannotParkException {
    assertNotNull(parkingLot2.park(new Car()));
  }

  @Test(expected = VehicleNotFoundException.class)
  public void checkedOutCarShouldNotPresent() throws CannotParkException, VehicleNotFoundException {
    Car car = new Car();
    Object token = parkingLot2.park(car);
    parkingLot2.checkoutFor(token);
    assertNull(parkingLot2.checkoutFor(token));
  }

  @Test(expected = VehicleNotFoundException.class)
  public void shouldThrowExceptionWhenCarIsNotPresent() throws VehicleNotFoundException {
    parkingLot2.checkoutFor(123);
  }

  @Test(expected = CannotParkException.class)
  public void shouldNotParkSameCarAgain() throws CannotParkException {
    Car car = new Car();
    parkingLot2.park(car);
    parkingLot2.park(car);
  }

  @Test
  public void shouldReturnFalseIfParkingIsNotFull() {
    assertFalse(parkingLot2.isFull());
  }

  @Test
  public void shouldReturnTrueIfParkingIsFull() throws CannotParkException {
    parkingLot2.park(new Car());
    parkingLot2.park(new Car());
    assertTrue(parkingLot2.isFull());
  }

  @Test(expected = CannotParkException.class)
  public void shouldNotAddTheCarWhenItIsFull() throws CannotParkException {
    parkingLot2.park(new Car());
    parkingLot2.park(new Car());
    parkingLot2.park(new Car());
  }

  @Test
  public void shouldReturnDifferenceBetweenCapacity() {
    assertEquals(parkingLot2.compareTo(new ParkingLot(3)), -1);
    assertEquals(parkingLot2.compareTo(new ParkingLot(2)), 0);
  }

  @Test
  public void shouldReturnComparisonOfAvailableSpace() throws CannotParkException {
    ParkingLot parkingLot3 = new ParkingLot(3);
    parkingLot2.park(new Car());
    parkingLot3.park(new Car());
    assertEquals(parkingLot2.compareTo(parkingLot3), -1);
    parkingLot3.park(new Car());
    assertEquals(parkingLot2.compareTo(new ParkingLot(2)), 0);
  }
}
