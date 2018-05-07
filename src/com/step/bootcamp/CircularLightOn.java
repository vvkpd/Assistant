package com.step.bootcamp;

public class CircularLightOn implements Action {
  private final CircularLight circularLight;

  public CircularLightOn(CircularLight circularLight) {
    this.circularLight = circularLight;
  }

  @Override
  public void execute() {
    circularLight.switchOn();
  }

  @Override
  public Action undo() {

    return new CircularLightOff(circularLight);
  }
}
