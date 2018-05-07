package com.step.bootcamp;

public class HomeTheatrePlayMusic implements Action {
  private final HomeTheater homeTheater;

  public HomeTheatrePlayMusic(HomeTheater homeTheater) {
    this.homeTheater = homeTheater;
  }

  @Override
  public void execute() {
    homeTheater.play();
  }

  @Override
  public Action undo() {

    return null;
  }
}
