package com.step.bootcamp;

import java.util.ArrayList;

public class VacantSpaceBasedSelector implements LotSelector {
  @Override
  public ParkingLot select(ArrayList<ParkingLot> availableLots) {
    return availableLots.stream().reduce((pl,lot)->{
      if(pl.compareAvailableSpace(lot) <= 0) return lot;
      return pl;
    }).get();
  }
}
