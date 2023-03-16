package epi;
import test_framework.EpiTest;
import test_framework.EpiUserType;
import test_framework.GenericTest;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SearchForStudent {

  @EpiUserType(ctorParams = {String.class, Float.class})
  public static class Student {
    public String name;
    public Float gpa;

    public Student(String name, Float gpa) {
      this.name = name;
      this.gpa = gpa;
    }

    @Override
    public String toString() {
      return "[" + "name: " + name + ", gpa: " + gpa + "]";
    }
  }

  @EpiTest(testDataFile = "../test_data/epi/search_for_student.tsv")
  public static int findStudent(List<Student> A, Student key) {
    int res = Collections.binarySearch(A, key, new Comparator<Student>() {
      @Override
      public int compare(Student a, Student b) {
        if (b.gpa.compareTo(a.gpa) != 0) {
          return b.gpa.compareTo(a.gpa);
        }

        return a.name.compareTo(b.name);
      }
    });

    if (res < 0) {
      return -1;
    }
    return res;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SearchForStudent.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
