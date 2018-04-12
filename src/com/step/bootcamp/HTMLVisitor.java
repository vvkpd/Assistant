package com.step.bootcamp;

import java.io.FileWriter;
import java.io.IOException;

public class HTMLVisitor implements Visitor {
  private String report;

  public HTMLVisitor() {
    report = "";
  }

  @Override
  public void visitAttendant(String name, int noOfLots) {
    report += String.format("<h2>%s  :- %d</h2>", name, noOfLots)+
        "<table><thead>" +
        "<th>Lot ID</th><th>Capacity</th>" +
        "</thead><tbody>";
  }

  @Override
  public void visitParkingLot(int id, int capacity) {
    report += String.format("<tr><td>%d</td><td>%d</td></tr>",id,capacity);
  }

  public String report() {
    return report + "</tbody></table>";
  }

  public void write(FileWriter writer) throws IOException {
    writer.write(report());
  }
}
