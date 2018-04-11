package com.step.bootcamp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AttendantTest {
  private class Car implements Vehicle {
  }
  @Test
  public void shouldBeAbleToParkCar() throws CannotParkException {
    Attendant attendant = new Attendant("Attendant");
    attendant.add(new ParkingLot(1, 1234));
    assertNotNull(attendant.park(new Car()));
  }

  @Test(expected = CannotParkException.class)
  public void shouldBeAbleToParkCarWhenNoLotAreAdded() throws CannotParkException {
    Attendant attendant = new Attendant("Attendant");
    assertNotNull(attendant.park(new Car()));
  }

  @Test
  public void shouldBeAbleToParkCarWhenOneLotIsFull() throws CannotParkException {
    Attendant attendant = new Attendant("Neeraj");
    attendant.add(new ParkingLot(1, 1));
    attendant.add(new ParkingLot(3, 2));;
    attendant.park(new Car());
    assertNotNull(attendant.park(new Car()));
  }

  @Test(expected = CannotParkException.class)
  public void shouldThrowExceptionWhenAllLotsAreFull() throws CannotParkException {
    Attendant attendant = new Attendant("Attendant");
    attendant.add(new ParkingLot(1, 1234));
    attendant.park(new Car());
    attendant.park(new Car());
  }

  @Test
  public void shouldCheckoutCar() throws CannotParkException, VehicleNotFoundException {
    Attendant attendant = new Attendant("Attendant");
    attendant.add(new ParkingLot(1, 1234));
    Car car = new Car();
    Object token = attendant.park(car);
    assertEquals(attendant.checkoutFor(token), car);
  }

  @Test
  public void shouldReturnReportOfAttendant() {
    Attendant attendant = new Attendant("Neeraj");
    Attendant attendant2 = new Attendant("Pragya");
    attendant.add(new ParkingLot(1, 1));
    attendant.add(new ParkingLot(3, 2));
    attendant.add(new ParkingLot(5, 3));
    attendant2.add(new ParkingLot(4, 3));
    attendant2.add(new ParkingLot(9, 3));
    System.out.println(attendant.toHTML());
    assertEquals("Name: Neeraj  Total Lots: 3\n" +
        "    Lot Id: 1 Capacity: 1\n" +
        "    Lot Id: 2 Capacity: 3\n" +
        "    Lot Id: 3 Capacity: 5", attendant.report());
  }
}
