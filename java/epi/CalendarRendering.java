package epi;

import test_framework.EpiTest;
import test_framework.EpiUserType;
import test_framework.GenericTest;
import java.util.List;

public class CalendarRendering {
  @EpiUserType(ctorParams = { int.class, int.class })
  public static class Event {
    public int start, finish;

    public Event(int start, int finish) {
      this.start = start;
      this.finish = finish;
    }
  }

  @EpiTest(testDataFile = "../test_data/epi/calendar_rendering.tsv")
  public static int findMaxSimultaneousEvents(List<Event> A) {
    // TODO - you fill in here.
    return 0;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "CalendarRendering.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
