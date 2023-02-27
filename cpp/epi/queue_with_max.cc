#include <algorithm>
#include <list>
#include <stdexcept>
#include "generic_test.h"
#include "serialization_traits.h"
#include "test_failure.h"
using std::list;
using std::length_error;
using std::max_element;

class QueueWithMaxNaive {
 public:
  void Enqueue(int x) {
    elems_.emplace_back(x);
  }

  int Dequeue() {
    if (elems_.empty()) {
      throw length_error("empty queue");
    }
    const int x = elems_.front();
    elems_.pop_front();
    return x;
  }

  int Max() const {
    if (elems_.empty()) {
      throw length_error("empty queue");
    }
    return *max_element(elems_.begin(), elems_.end());
  }

 private:
  list<int> elems_;

};

struct QueueOp {
  enum { kConstruct, kDequeue, kEnqueue, kMax } op;
  int argument;

  QueueOp(const std::string& op_string, int arg) : argument(arg) {
    if (op_string == "QueueWithMax") {
      op = kConstruct;
    } else if (op_string == "dequeue") {
      op = kDequeue;
    } else if (op_string == "enqueue") {
      op = kEnqueue;
    } else if (op_string == "max") {
      op = kMax;
    } else {
      throw std::runtime_error("Unsupported queue operation: " + op_string);
    }
  }
};

template <>
struct SerializationTraits<QueueOp> : UserSerTraits<QueueOp, std::string, int> {
};

void QueueTester(const std::vector<QueueOp>& ops) {
  try {
    QueueWithMaxNaive q;
    for (auto& x : ops) {
      switch (x.op) {
        case QueueOp::kConstruct:
          break;
        case QueueOp::kDequeue: {
          int result = q.Dequeue();
          if (result != x.argument) {
            throw TestFailure("Dequeue: expected " +
                              std::to_string(x.argument) + ", got " +
                              std::to_string(result));
          }
        } break;
        case QueueOp::kEnqueue:
          q.Enqueue(x.argument);
          break;
        case QueueOp::kMax: {
          int s = q.Max();
          if (s != x.argument) {
            throw TestFailure("Max: expected " + std::to_string(x.argument) +
                              ", got " + std::to_string(s));
          }
        } break;
      }
    }
  } catch (const length_error&) {
    throw TestFailure("Unexpected length_error exception");
  }
}

int main(int argc, char* argv[]) {
  std::vector<std::string> args{argv + 1, argv + argc};
  std::string func_name = "QueueWithMaxNaive";
  std::vector<std::string> param_names{"ops"};

  return GenericTestMain(args, "queue_with_max.cc", "../test_data/epi/queue_with_max.tsv",
                         &QueueTester, DefaultComparator{}, func_name, param_names);
}
