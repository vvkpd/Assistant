package com.step.bootcamp;

import org.junit.Test;

import static org.junit.Assert.*;

public class LightTest {

  @Test
  public void shouldTurnTheLightOff() {
    Light light = new Light();
    assertTrue(light.turnOff());
  }

  @Test
  public void shouldTurnTheLightOn() {
    Light light = new Light();
    assertTrue(light.turnOn());
  }
}
