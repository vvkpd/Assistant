package com.step.bootcamp;

import java.util.ArrayList;

public interface LotSelector {
  ParkingLot select(ArrayList<ParkingLot> availableLots);
}
