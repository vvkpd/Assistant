package com.step.bootcamp;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ParkingLotTest {
  private ParkingLot parkingLot;
  private Car car;
  private Listener owner;

  private class Car implements Vehicle {}

  @Before
  public void setUp() {
    parkingLot = new ParkingLot(2);
    car = new Car();
    owner = mock(Listener.class);
  }

  @Test
  public void shouldCheckoutTheCarOfGivenNumber() throws VehicleNotFoundException, CannotParkException {
    Object token = parkingLot.park(car);
    assertThat(parkingLot.checkoutFor(token), is(car));
  }

  @Test
  public void shouldBeAbleParkACar() throws CannotParkException {
    assertNotNull(parkingLot.park(new Car()));
  }

  @Test(expected = VehicleNotFoundException.class)
  public void checkedOutCarShouldNotPresent() throws CannotParkException, VehicleNotFoundException {
    Object token = parkingLot.park(car);
    parkingLot.checkoutFor(token);
    assertNull(parkingLot.checkoutFor(token));
  }

  @Test(expected = VehicleNotFoundException.class)
  public void shouldThrowExceptionWhenCarIsNotPresent() throws VehicleNotFoundException {
    parkingLot.checkoutFor(123);
  }

  @Test(expected = CannotParkException.class)
  public void shouldNotParkSameCarAgain() throws CannotParkException {
    parkingLot.park(car);
    parkingLot.park(car);
  }

  @Test
  public void shouldReturnFalseIfParkingIsNotFull() {
    assertFalse(parkingLot.isFull());
  }

  @Test
  public void shouldReturnTrueIfParkingIsFull() throws CannotParkException {
    parkingLot.park(car);
    parkingLot.park(new Car());
    assertTrue(parkingLot.isFull());
  }

  @Test(expected = CannotParkException.class)
  public void shouldNotAddTheCarWhenItIsFull() throws CannotParkException {
    parkingLot.park(car);
    parkingLot.park(new Car());
    parkingLot.park(new Car());
  }


  @Test
  public void shouldNotifyEveryOneWhenALotIsFull() throws CannotParkException {
    parkingLot.addListener(owner);
    parkingLot.park(car);
    parkingLot.park(new Car());
    verify(owner).full();
  }

  @Test
  public void shouldNotifyEveryOneWhenSpaceIsAvailable() throws CannotParkException, VehicleNotFoundException {
    parkingLot.addListener(owner);
    parkingLot.park(car);
    Object token = parkingLot.park(new Car());
    parkingLot.checkoutFor(token);
    verify(owner).spaceAvailable();
  }

  @Test
  public void shouldOnlyNotifyOnceWhenSpaceIsAvailable() throws CannotParkException, VehicleNotFoundException {
    parkingLot.addListener(owner);
    Object token = parkingLot.park(car);
    Object token2 = parkingLot.park(new Car());
    parkingLot.checkoutFor(token);
    parkingLot.checkoutFor(token2);
    verify(owner, times(1)).spaceAvailable();
  }
}
