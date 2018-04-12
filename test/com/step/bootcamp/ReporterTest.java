package com.step.bootcamp;

import org.junit.Test;

import static org.mockito.Mockito.mock;

public class ReporterTest {

  @Test
  public void shouldReturnReportOfAllAttendants() {
    Reporter reporter = Reporter.html();
    Attendant mockAttendant1 = mock(Attendant.class);
    Attendant mockAttendant2 = mock(Attendant.class);
    Attendant mockAttendant3 = mock(Attendant.class);
    String report = reporter.add(mockAttendant1)
        .add(mockAttendant2)
        .add(mockAttendant3)
        .getReport();
    System.out.println(report);
  }
}