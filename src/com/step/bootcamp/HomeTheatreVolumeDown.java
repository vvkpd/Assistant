package com.step.bootcamp;

public class HomeTheatreVolumeDown implements Action {
  private final HomeTheater homeTheater;

  public HomeTheatreVolumeDown(HomeTheater homeTheater) {
    this.homeTheater = homeTheater;
  }

  @Override
  public void execute() {
    homeTheater.volumeDown();
  }

  @Override
  public Action undo() {

    return new HomeTheatreVolumeUp(homeTheater);
  }
}
