package com.step.bootcamp;

import java.util.HashMap;

public class HomeAssistant {
  private final HashMap<String, Action> actions;

  public HomeAssistant() {
    this.actions = new HashMap<>();
  }

  public HomeAssistant add(Light light){
    actions.put("turn on", ()->light.turnOn());
    actions.put("turn off", ()->light.turnOff());
    return this;
  }

  public HomeAssistant add(CircularLight light){
    actions.put("circular light on", ()->light.switchOn());
    actions.put("circular light off", ()->light.switchOff());
    return this;
  }

  public HomeAssistant add(HomeTheater homeTheater){
    actions.put("music on", ()->homeTheater.on());
    actions.put("music off", ()->homeTheater.off());
    actions.put("play music", ()->homeTheater.play());
    return this;
  }

  public void listen(String instruction){
    instruction = instruction.toLowerCase().trim();
    Action action = actions.get(instruction);
    new StringBuilder()
    action.execute();
  }
}
