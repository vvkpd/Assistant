package com.step.bootcamp;

public class HomeTheater {
  private int volume = 0;

  public boolean on() {
    return true;
  }

  public boolean off() {
    return true;
  }

  public boolean play() {
    return true;
  }

  public boolean volumeUp() {
    volume++;
    return true;
  }

  public boolean volumeDown() {
    volume--;
    return true;
  }

  public boolean fullVolume() {
    volume = 5;
    return true;
  }
}
