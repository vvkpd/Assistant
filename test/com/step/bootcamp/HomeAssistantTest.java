package com.step.bootcamp;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class HomeAssistantTest {

  private Light mockLight;
  private CircularLight mockedCircularLight;
  private HomeTheater mockTheater;
  private HomeAssistant homeAssistant;

  @Before
  public void setUp() throws Exception {
    mockLight = mock(Light.class);
    mockedCircularLight = mock(CircularLight.class);
    mockTheater = mock(HomeTheater.class);
    homeAssistant = new HomeAssistant();
  }

  @Test
  public void shouldTurnOnLight() {
    homeAssistant.addCommand("turn on",new TurnLightOn(mockLight));
    homeAssistant.listen("turn on");
    verify(mockLight).turnOn();
  }

  @Test
  public void shouldTurnOffLightOnUndo() {
    homeAssistant.addCommand("turn on",new TurnLightOn(mockLight));
    homeAssistant.listen("turn on");
    verify(mockLight).turnOn();
    homeAssistant.listen("undo");
    verify(mockLight).turnOff();
  }

  @Test
  public void shouldUndoAllPreviousActions() {
    homeAssistant.addCommand("turn on", new TurnLightOn(mockLight));
    homeAssistant.addCommand("circular light on", new CircularLightOn(mockedCircularLight));
    homeAssistant.addCommand("music on", new HomeTheatreOn(mockTheater));
    homeAssistant.listen("turn on");
    homeAssistant.listen("circular light on");
    homeAssistant.listen("music on");
    homeAssistant.listen("undo");
    verify(mockTheater).off();
    homeAssistant.listen("undo");
    verify(mockedCircularLight).switchOff();
    homeAssistant.listen("undo");
    verify(mockLight).turnOff();
  }

  @Test
  public void shouldTurnOffLight() {
    homeAssistant.addCommand("turn off",new TurnLightOff(mockLight));
    homeAssistant.listen("turn off");
    verify(mockLight).turnOff();
  }

  @Test
  public void shouldTurnOffCircularLight() {
    homeAssistant.addCommand("circular light off",new CircularLightOff(mockedCircularLight));
    homeAssistant.listen("circular light off");
    verify(mockedCircularLight).switchOff();
  }
  @Test
  public void shouldTurnOnCircularLight() {
    homeAssistant.addCommand("circular light on",new CircularLightOn(mockedCircularLight));
    homeAssistant.listen("circular light on");
    verify(mockedCircularLight).switchOn();
  }

  @Test
  public void shouldTurnOnHomeTheater() {
    homeAssistant.addCommand("music on", new HomeTheatreOn(mockTheater));
    homeAssistant.listen("music on");
    verify(mockTheater).on();
  }

  @Test
  public void shouldTurnOffHomeTheater() {
    homeAssistant.addCommand("music off",new HomeTheatreOff(mockTheater));
    homeAssistant.listen("music off");
    verify(mockTheater).off();
  }

  @Test
  public void shouldPlayMusic() {
    homeAssistant.addCommand("Play Music",new HomeTheatrePlayMusic(mockTheater));
    homeAssistant.listen("Play Music");
    verify(mockTheater).play();
  }

  @Test
  public void shouldIncreaseVolumeOfTheatre() {
    homeAssistant.addCommand("volume up",new HomeTheatreVolumeUp(mockTheater));
    homeAssistant.listen("volume up");
    verify(mockTheater).volumeUp();
  }

  @Test
  public void shouldDecreaseVolumeOfTheatre() {
    homeAssistant.addCommand("volume down",new HomeTheatreVolumeDown(mockTheater));
    homeAssistant.listen("volume down");
    verify(mockTheater).volumeDown();
  }

  @Test
  public void shouldOnPartyMode() {
    homeAssistant.addCommand("party",new PartyMode(mockTheater,mockedCircularLight,mockLight));
    homeAssistant.listen("party");
    verify(mockTheater).fullVolume();
    verify(mockedCircularLight).switchOn();
    verify(mockLight).turnOn();
  }

  @Test
  public void shouldNotThrowExceptionForFirstUndo() {
    homeAssistant.listen("undo");
  }
}