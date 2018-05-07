package com.step.bootcamp;

public class PartyMode implements Action {
  private final HomeTheater homeTheater;
  private final CircularLight circularLight;
  private final Light light;

  public PartyMode(HomeTheater homeTheater, CircularLight circularLight, Light light) {
    this.homeTheater = homeTheater;
    this.circularLight = circularLight;
    this.light = light;
  }

  @Override
  public void execute() {
    homeTheater.fullVolume();
    light.turnOn();
    circularLight.switchOn();
  }

  @Override
  public Action undo() {

    return null;
  }
}
