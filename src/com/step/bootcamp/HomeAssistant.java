package com.step.bootcamp;

import java.util.ArrayList;
import java.util.HashMap;

public class HomeAssistant {
  private final HashMap<String, Action> commands;
  private ArrayList<Action> previousCommands;

  public HomeAssistant() {
    this.commands = new HashMap<>();
    this.previousCommands = new ArrayList<>();
  }

  public void listen(String instruction){
    instruction = instruction.toLowerCase().trim();
    Action action = commands.get(instruction);
    executePreviousCommand(instruction);
    if(action != null) {
      action.execute();
      previousCommands.add(0,action.undo());
    }
  }

  private void executePreviousCommand(String instruction) {
    if(instruction.equals("undo") && !previousCommands.isEmpty()) {
      previousCommands.get(0).execute();
      previousCommands.remove(0);
    }
  }

  public void addCommand(String command, Action action) {
    command = command.toLowerCase().trim();
    commands.put(command,action);
  }
}
