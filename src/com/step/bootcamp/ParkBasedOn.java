package com.step.bootcamp;

import java.util.ArrayList;

public enum ParkBasedOn {
  CAPACITY{
    @Override
    public ParkingLot getLot(ArrayList<ParkingLot> availableLots) {
      return availableLots.stream().reduce((pl,lot)->{
        if(pl.compareTo(lot) <= 0) return lot;
        return pl;
      }).get();
    }
  },
  VACANT_SPACE{
    @Override
    public ParkingLot getLot(ArrayList<ParkingLot> availableLots) {
      return availableLots.stream().reduce((pl,lot)->{
        if(pl.compareAvailableSpace(lot) <= 0) return lot;
        return pl;
      }).get();
    }
  },
  AVAILABILITY;


  public ParkingLot getLot(ArrayList<ParkingLot> availableLots) {
    return availableLots.get(0);
  }
}
