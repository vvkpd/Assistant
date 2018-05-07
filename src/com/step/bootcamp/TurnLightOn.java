package com.step.bootcamp;

public class TurnLightOn implements Action {
  private final Light light;

  public TurnLightOn(Light light) {

    this.light = light;
  }


  @Override
  public void execute() {
    light.turnOn();
  }

  @Override
  public Action undo() {
    return new TurnLightOff(light);
  }
}
