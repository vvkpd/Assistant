package com.step.bootcamp;

public interface Visitor {
  void visitAttendant(String name, int noOfLots);
  void visitParkingLot(int id, int capacity);
}
