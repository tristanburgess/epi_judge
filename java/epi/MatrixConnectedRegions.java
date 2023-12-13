package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;
import test_framework.TimedExecutor;
import java.util.ArrayList;
import java.util.List;

public class MatrixConnectedRegions {
  public static void flipColor(int x, int y, List<List<Boolean>> image) {
    // TODO - you fill in here.
    return;
  }

  @EpiTest(testDataFile = "../test_data/epi/painting.tsv")
  public static List<List<Integer>> flipColorWrapper(TimedExecutor executor,
      int x, int y,
      List<List<Integer>> image)
      throws Exception {
    List<List<Boolean>> B = new ArrayList<>();
    for (int i = 0; i < image.size(); i++) {
      B.add(new ArrayList<>());
      for (int j = 0; j < image.get(i).size(); j++) {
        B.get(i).add(image.get(i).get(j) == 1);
      }
    }

    executor.run(() -> flipColor(x, y, B));

    image = new ArrayList<>();
    for (int i = 0; i < B.size(); i++) {
      image.add(new ArrayList<>());
      for (int j = 0; j < B.get(i).size(); j++) {
        image.get(i).add(B.get(i).get(j) ? 1 : 0);
      }
    }

    return image;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "MatrixConnectedRegions.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
