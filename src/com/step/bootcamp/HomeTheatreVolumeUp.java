package com.step.bootcamp;

public class HomeTheatreVolumeUp implements Action {
  private final HomeTheater homeTheater;

  public HomeTheatreVolumeUp(HomeTheater homeTheater) {
    this.homeTheater = homeTheater;
  }

  @Override
  public void execute() {
    homeTheater.volumeUp();
  }

  @Override
  public Action undo() {

    return new HomeTheatreVolumeDown(homeTheater);
  }
}
