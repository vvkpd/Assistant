package com.step.bootcamp;

public class Assistant implements Listener{
  @Override
  public void full() {
    System.out.println("Full");
  }

  @Override
  public void spaceAvailable() {
    System.out.println("Space Available");
  }
}
