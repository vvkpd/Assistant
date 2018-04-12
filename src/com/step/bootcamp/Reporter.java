package com.step.bootcamp;

import java.util.ArrayList;

public class Reporter {
  private final ArrayList<Visitable> attendants;
  private final Visitor visitor;

  private Reporter(Visitor visitor) {
    this.visitor = visitor;
    attendants = new ArrayList<>();
  }

  public static Reporter html() {
    return new Reporter(new HTMLVisitor());
  }

  public Reporter add(Visitable attendant) {
    attendants.add(attendant);
    return this;
  }

  public String getReport() {
    attendants.forEach(attendant->attendant.accept(visitor));
    return visitor.report();
  }
}
