#include <memory>

#include "../generic_types/list_node.h"
#include "generic_test.h"
using std::shared_ptr;

shared_ptr<ListNode<int>> SearchList(shared_ptr<ListNode<int>> L, int key) {
  while (L != nullptr && L->data != key) {
    L = L->next;
  }

  return L;
}

int SearchListWrapper(shared_ptr<ListNode<int>> L, int key) {
  auto result = SearchList(L, key);
  return result ? result->data : -1;
}

int main(int argc, char* argv[]) {
  std::vector<std::string> args{argv + 1, argv + argc};
  std::string func_name = "SearchList";
  std::vector<std::string> param_names{"L", "key"};

  return GenericTestMain(args, "search_in_list.cc",
                         "../test_data/epi/search_in_list.tsv",
                         &SearchListWrapper, DefaultComparator{}, func_name, param_names);
}
