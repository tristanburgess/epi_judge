package epi;
import test_framework.EpiTest;
import test_framework.EpiUserType;
import test_framework.GenericTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortStudents {

  @EpiUserType(ctorParams = {String.class, Float.class})
  public static class Student implements Comparable<Student> {
    public String name;
    public Float gpa;

    public Student(String name, Float gpa) {
      this.name = name;
      this.gpa = gpa;
    }

    // used by e.g. Collections.sort() with no custom comparator
    public int compareTo(Student that) {
      return this.name.compareTo(that.name);
    }

    @Override
    public boolean equals(Object that) {
      if (that == null || !(that instanceof Student)) {
        return false;
      }

      Student thatS = (Student) that;

      return this.name.compareTo(thatS.name) == 0 && this.gpa.compareTo(thatS.gpa) == 0;
    }

    @Override
    public String toString() {
      return "[" + "name: " + name + ", gpa: " + gpa + "]";
    }
  }

  @EpiTest(testDataFile = "../test_data/epi/sort_students.tsv")
  public static List<Student> sortStudentsByName(List<Student> students) {
    List<Student> ans = new ArrayList<>(students);

    Collections.sort(ans, new Comparator<Student>() {
      @Override
      public int compare(Student a, Student b) {
          return a.gpa.compareTo(b.gpa);
      }
    });

    return ans;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SortStudents.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
