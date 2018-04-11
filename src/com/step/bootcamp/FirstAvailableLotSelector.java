package com.step.bootcamp;

import java.util.ArrayList;

public class FirstAvailableLotSelector implements LotSelector {
  @Override
  public ParkingLot select(ArrayList<ParkingLot> availableLots) {
    return availableLots.get(0);
  }
}
