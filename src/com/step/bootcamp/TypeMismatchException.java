package com.step.bootcamp;

public class TypeMismatchException extends RuntimeException{
  public TypeMismatchException() {
    super("Cannot add two different type of measurements");
  }
}
