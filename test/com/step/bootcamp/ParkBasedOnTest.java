package com.step.bootcamp;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ParkBasedOnTest {
  private class  TestCar implements Vehicle {
  }

  @Test
  public void availabilityReturnsFirstAvailableLot() {
    ArrayList<ParkingLot> lots = new ArrayList();
    ParkingLot parkingLot = new ParkingLot(3);
    ParkingLot parkingLot2 = new ParkingLot(3);
    lots.add(parkingLot);
    lots.add(parkingLot2);
    ParkingLot availableLot = ParkBasedOn.AVAILABILITY.getLot(lots);

    assertEquals(availableLot,parkingLot);
  }

  @Test
  public void capacityReturnsLotWithHighestCapacity() {
    ArrayList<ParkingLot> lots = new ArrayList();
    ParkingLot parkingLot = new ParkingLot(1);
    ParkingLot parkingLot2 = new ParkingLot(2);
    lots.add(parkingLot);
    lots.add(parkingLot2);
    ParkingLot availableLot = ParkBasedOn.CAPACITY.getLot(lots);
    assertEquals(availableLot,parkingLot2);
  }

  @Test
  public void VacantSpaceReturnsLotWithMostVacantSpace() throws CannotParkException {
    ArrayList<ParkingLot> lots = new ArrayList();
    ParkingLot parkingLot = new ParkingLot(2);
    ParkingLot parkingLot2 = new ParkingLot(2);
    lots.add(parkingLot);
    lots.add(parkingLot2);
    parkingLot.park(new TestCar());

    ParkingLot availableLot = ParkBasedOn.VACANT_SPACE.getLot(lots);
    assertEquals(availableLot,parkingLot2);
  }
}