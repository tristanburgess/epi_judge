package epi;

import test_framework.EpiTest;
import test_framework.EpiTestComparator;
import test_framework.EpiTestExpectedType;
import test_framework.EpiUserType;
import test_framework.GenericTest;
import java.util.Collections;
import java.util.List;
import java.util.function.BiPredicate;

public class RemoveDuplicates {
  @EpiUserType(ctorParams = { String.class, String.class })
  // @include
  public static class Name implements Comparable<Name> {
    String firstName;
    String lastName;

    public Name(String first, String last) {
      firstName = first;
      lastName = last;
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == null || !(obj instanceof Name)) {
        return false;
      }
      if (this == obj) {
        return true;
      }
      Name name = (Name) obj;
      return firstName.equals(name.firstName) && lastName.equals(name.lastName);
    }

    @Override
    public String toString() {
      return firstName;
    }

    @Override
    public int compareTo(Name name) {
      int cmpFirst = firstName.compareTo(name.firstName);
      if (cmpFirst != 0) {
        return cmpFirst;
      }
      return lastName.compareTo(name.lastName);
    }
  }

  public static void eliminateDuplicate(List<Name> names) {
    // TODO - you fill in here.
    return;
  }

  @EpiTest(testDataFile = "../test_data/epi/remove_duplicates.tsv")
  public static List<Name> eliminateDuplicateWrapper(List<Name> names) {
    eliminateDuplicate(names);
    return names;
  }

  @EpiTestComparator
  public static BiPredicate<List<String>, List<Name>> comp = (expected, result) -> {
    if (result == null) {
      return false;
    }
    Collections.sort(expected);
    Collections.sort(result);
    if (expected.size() != result.size()) {
      return false;
    }
    for (int i = 0; i < result.size(); i++) {
      if (!expected.get(i).equals(result.get(i).firstName)) {
        return false;
      }
    }
    return true;
  };

  @EpiTestExpectedType
  public static List<String> expectedType;

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "RemoveDuplicates.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
