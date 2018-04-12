package com.step.bootcamp;

import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class HTMLVisitorTest {
  @Test
  public void shouldReturnHTMLReport() {
    HTMLVisitor htmlReporter = new HTMLVisitor();
    htmlReporter.visitAttendant("Viraj", 1);
    htmlReporter.visitParkingLot(123, 2);
    assertEquals("<h2>Viraj  :- 1</h2><table><thead><th>Lot ID</th>" +
            "<th>Capacity</th></thead><tbody><tr><td>123</td><td>2</td></tr></tbody></table>"
        ,htmlReporter.report());
  }

  @Test
  public void shouldWriteToFile() throws IOException {
    FileWriter fileWriter = mock(FileWriter.class);
    HTMLVisitor htmlReporter = new HTMLVisitor();
    htmlReporter.visitAttendant("Viraj", 1);
    htmlReporter.visitParkingLot(123, 2);
    htmlReporter.write(fileWriter);
    verify(fileWriter).write("<h2>Viraj  :- 1</h2><table><thead><th>Lot ID</th>" +
        "<th>Capacity</th></thead><tbody><tr><td>123</td><td>2</td></tr></tbody></table>");
  }
}