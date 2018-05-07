package com.step.bootcamp;

public class CircularLightOff implements Action {
  private final CircularLight circularLight;

  public CircularLightOff(CircularLight circularLight) {
    this.circularLight = circularLight;
  }

  @Override
  public void execute() {
    circularLight.switchOff();
  }

  @Override
  public Action undo() {

    return new CircularLightOn(circularLight);
  }
}
