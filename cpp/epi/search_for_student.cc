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
};

template <>
struct SerializationTraits<Student>
    : UserSerTraits<Student, string, float> {
  
  static std::vector<std::string> GetMetricNames(const std::string& arg_name) {
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

int FindStudent(const vector<Student>& students, const Student& key) {
  return 0;
}

int main(int argc, char* argv[]) {
  std::vector<std::string> args{argv + 1, argv + argc};
  std::string func_name = "FindStudent";
  std::vector<std::string> param_names{"students", "key"};

  return GenericTestMain(args, "search_for_student.cc", "../test_data/epi/search_for_student.tsv",
                         &FindStudent, DefaultComparator{}, func_name, param_names);
}
