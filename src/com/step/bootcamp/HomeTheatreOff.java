package com.step.bootcamp;

public class HomeTheatreOff implements Action {
  private final HomeTheater homeTheater;

  public HomeTheatreOff(HomeTheater homeTheater) {
    this.homeTheater = homeTheater;
  }

  @Override
  public void execute() {
    homeTheater.off();
  }

  @Override
  public Action undo() {

    return new HomeTheatreOn(homeTheater);
  }
}
