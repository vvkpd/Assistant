package com.step.bootcamp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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
    attendant.add(new ParkingLot(1, 1));
    attendant.add(new ParkingLot(3, 21));
    Visitor visitor = mock(Visitor.class);
    attendant.accept(visitor);

    verify(visitor).visitAttendant("Neeraj", 2);
    verify(visitor).visitParkingLot(1, 1);
    verify(visitor).visitParkingLot(21, 3);
  }
}
