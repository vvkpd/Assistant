package com.step.bootcamp;

public class TurnLightOff implements Action  {
  private final Light light;

  public TurnLightOff(Light light) {
    this.light = light;
  }

  @Override
  public void execute() {
    light.turnOff();
  }

  @Override
  public Action undo() {
    return new TurnLightOn(light);
  }
}
