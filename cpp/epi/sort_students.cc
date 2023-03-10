#include <algorithm>
#include <vector>
#include "fmt_print.h"
#include "generic_test.h"
#include "serialization_traits.h"
using std::string;
using std::vector;

struct Student {
  string name;
  float gpa;

  bool operator<(const Student& that) {
    return name < that.name;
  }
};

template <>
struct SerializationTraits<Student>
    : UserSerTraits<Student, string, float> {
  
  static std::vector<std::string> GetMetricNames(std::string& arg_name) {
    return {};
  }

  static std::vector<int> GetMetrics(const Student& student) {
    return {};
  }
};

bool operator==(const Student& lhs, const Student& rhs) {
  return (lhs.name == rhs.name) && (lhs.gpa == rhs.gpa);
}

std::ostream& operator<<(std::ostream& out, const Student& student) {
  return PrintTo(out, std::make_tuple(student.name, student.gpa));
}

vector<Student> SortStudentsByGPA(const vector<Student>& students) {
  vector<Student> out(students);
  sort(out.begin(), out.end(), [](const Student& a, const Student& b) {
    return a.gpa < b.gpa;
  });
  return out;
}

vector<Student> SortStudentsByName(const vector<Student>& students) {
  vector<Student> out(students);
  sort(out.begin(), out.end());
  return out;
}

int main(int argc, char* argv[]) {
  std::vector<std::string> args{argv + 1, argv + argc};
  std::string func_name = "SortStudentsByGPA";
  std::vector<std::string> param_names{"students"};

  return GenericTestMain(args, "sort_students.cc", "../test_data/epi/sort_students.tsv",
                         &SortStudentsByGPA, DefaultComparator{}, func_name, param_names);
}
