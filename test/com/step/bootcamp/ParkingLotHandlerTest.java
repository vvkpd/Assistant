package com.step.bootcamp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ParkingLotHandlerTest {
  private class Car implements Vehicle {
  }
  @Test
  public void shouldBeAbleToParkCar() throws CannotParkException {
    ParkingLotHandler parkingLotHandler = new ParkingLotHandler();
    parkingLotHandler.add(new ParkingLot(1));
    assertNotNull(parkingLotHandler.park(new Car()));
  }

  @Test(expected = CannotParkException.class)
  public void shouldBeAbleToParkCarWhenNoLotAreAdded() throws CannotParkException {
    ParkingLotHandler parkingLotHandler = new ParkingLotHandler();
    assertNotNull(parkingLotHandler.park(new Car()));
  }

  @Test
  public void shouldBeAbleToParkCarWhenOneLotIsFull() throws CannotParkException {
    ParkingLotHandler parkingLotHandler = new ParkingLotHandler();
    parkingLotHandler.add(new ParkingLot(1));
    parkingLotHandler.add(new ParkingLot(1));
    parkingLotHandler.park(new Car());
    assertNotNull(parkingLotHandler.park(new Car()));
  }

  @Test(expected = CannotParkException.class)
  public void shouldThrowExceptionWhenAllLotsAreFull() throws CannotParkException {
    ParkingLotHandler parkingLotHandler = new ParkingLotHandler();
    parkingLotHandler.add(new ParkingLot(1));
    parkingLotHandler.park(new Car());
    parkingLotHandler.park(new Car());
  }

  @Test
  public void shouldCheckoutCar() throws CannotParkException, VehicleNotFoundException {
    ParkingLotHandler parkingLotHandler = new ParkingLotHandler();
    parkingLotHandler.add(new ParkingLot(1));
    Car car = new Car();
    Object token = parkingLotHandler.park(car);
    assertEquals(parkingLotHandler.checkoutFor(token), car);
  }
}
