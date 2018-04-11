package com.step.bootcamp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class AttendantTest {
  private class Car implements Vehicle {
  }
  @Test
  public void shouldBeAbleToParkCar() throws CannotParkException {
    Attendant attendant = new Attendant(new CapacityBasedSelector());
    attendant.add(new ParkingLot(1));
    assertNotNull(attendant.park(new Car()));
  }

  @Test(expected = CannotParkException.class)
  public void shouldBeAbleToParkCarWhenNoLotAreAdded() throws CannotParkException {
    Attendant attendant = new Attendant(new CapacityBasedSelector());
    assertNotNull(attendant.park(new Car()));
  }

  @Test
  public void shouldBeAbleToParkCarWhenOneLotIsFull() throws CannotParkException {
    Attendant attendant = new Attendant(new CapacityBasedSelector());
    attendant.add(new ParkingLot(1));
    attendant.add(new ParkingLot(1));
    attendant.park(new Car());
    assertNotNull(attendant.park(new Car()));
  }

  @Test(expected = CannotParkException.class)
  public void shouldThrowExceptionWhenAllLotsAreFull() throws CannotParkException {
    Attendant attendant = new Attendant(new CapacityBasedSelector());
    attendant.add(new ParkingLot(1));
    attendant.park(new Car());
    attendant.park(new Car());
  }

  @Test
  public void shouldCheckoutCar() throws CannotParkException, VehicleNotFoundException {
    Attendant attendant = new Attendant(new CapacityBasedSelector());
    attendant.add(new ParkingLot(1));
    Car car = new Car();
    Object token = attendant.park(car);
    assertEquals(attendant.checkoutFor(token), car);
  }

  @Test
  public void shouldParkCarToHighestCapacityLot() throws CannotParkException, VehicleNotFoundException {
    Attendant attendant = new Attendant(new CapacityBasedSelector());
    ParkingLot parkingLot3 = new ParkingLot(3);
    attendant.add(parkingLot3);
    attendant.add(new ParkingLot(1));
    attendant.add(new ParkingLot(2));
    ParkingLot parkingLot4 = new ParkingLot(4);
    attendant.add(parkingLot4);
    Object token = attendant.park(new Car());
    attendant.park(new Car());
    attendant.park(new Car());
    attendant.park(new Car());

    Object token1 = attendant.park(new Car());
    assertTrue(parkingLot4.hasCar(token));
    assertTrue(parkingLot4.isFull());
    assertTrue(parkingLot3.hasCar(token1));
  }

  @Test
  public void shouldParkCarToLotHavingHighestSpace() throws CannotParkException, VehicleNotFoundException {
    Attendant attendant = new Attendant(new VacantSpaceBasedSelector());

    ParkingLot parkingLot3 = new ParkingLot(3);
    attendant.add(parkingLot3);

    attendant.add(new ParkingLot(1));
    attendant.add(new ParkingLot(2));

    ParkingLot parkingLot4 = new ParkingLot(4);
    attendant.add(parkingLot4);

    Object token1 = attendant.park(new Car());
    Object token2 = attendant.park(new Car());
    Object token3 = attendant.park(new Car());

    assertTrue(parkingLot4.hasCar(token1));
    assertTrue(parkingLot4.hasCar(token2));
    assertTrue(parkingLot3.hasCar(token3));
  }
}
