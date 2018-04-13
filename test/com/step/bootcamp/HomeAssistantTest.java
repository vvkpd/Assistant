package com.step.bootcamp;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class HomeAssistantTest {
  @Test
  public void shouldTurnOnLight() {
    Light mockLight = mock(Light.class);
    HomeAssistant homeAssistant = new HomeAssistant().add(mockLight);
    homeAssistant.listen("turn on");
    verify(mockLight).turnOn();
  }

  @Test
  public void shouldTurnOffLight() {
    Light mockLight = mock(Light.class);
    HomeAssistant homeAssistant = new HomeAssistant().add(mockLight);
    homeAssistant.listen("turn off");
    verify(mockLight).turnOff();
  }

  @Test
  public void shouldTurnOffCircularLight() {
    CircularLight mockLight = mock(CircularLight.class);
    HomeAssistant homeAssistant = new HomeAssistant().add(mockLight);
    homeAssistant.listen("circular light off");
    verify(mockLight).switchOff();
  }
  @Test
  public void shouldTurnOnCircularLight() {
    CircularLight mockLight = mock(CircularLight.class);
    HomeAssistant homeAssistant = new HomeAssistant().add(mockLight);
    homeAssistant.listen("circular light on");
    verify(mockLight).switchOn();
  }

  @Test
  public void shouldTurnOnHomeTheater() {
    HomeTheater mockTheater = mock(HomeTheater.class);
    HomeAssistant homeAssistant = new HomeAssistant().add(mockTheater);
    homeAssistant.listen("music on");
    verify(mockTheater).on();
  }

  @Test
  public void shouldTurnOffHomeTheater() {
    HomeTheater mockTheater = mock(HomeTheater.class);
    HomeAssistant homeAssistant = new HomeAssistant().add(mockTheater);
    homeAssistant.listen("music off");
    verify(mockTheater).off();
  }

  @Test
  public void shouldPlayMusic() {
    HomeTheater mockTheater = mock(HomeTheater.class);
    HomeAssistant homeAssistant = new HomeAssistant().add(mockTheater);
    homeAssistant.listen("Play Music");
    verify(mockTheater).play();
  }
}