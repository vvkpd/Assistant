package com.step.bootcamp;

public interface Action {
  void execute();
  Action undo();
}
