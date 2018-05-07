package com.step.bootcamp;

public class HomeTheatreOn implements Action {
  private final HomeTheater homeTheater;

  public HomeTheatreOn(HomeTheater homeTheater) {
    this.homeTheater = homeTheater;
  }

  @Override
  public void execute() {
    homeTheater.on();
  }

  @Override
  public Action undo() {

    return new HomeTheatreOff(homeTheater);
  }
}
