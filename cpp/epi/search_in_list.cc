#include <memory>

#include "../generic_types/list_node.h"
#include "generic_test.h"
using std::shared_ptr;

// Whiteboard: https://1drv.ms/u/s!AvHgsMnKfyusiIE8afx1m6KfCEAR0g

shared_ptr<ListNode<int>> SearchList(shared_ptr<ListNode<int>> L, int key) {
  shared_ptr<ListNode<int>> cur = L;
  while (cur != nullptr) {
    if (cur->data == key) {
      return cur;
    }
    cur = cur->next;
  }
  return nullptr;
}

int SearchListWrapper(shared_ptr<ListNode<int>> L, int key) {
  auto result = SearchList(L, key);
  return result ? result->data : -1;
}

int main(int argc, char* argv[]) {
  std::vector<std::string> args{argv + 1, argv + argc};
  std::vector<std::string> param_names{"L", "key"};
  return GenericTestMain(args, "search_in_list.cc",
                         "../test_data/epi/search_in_list.tsv",
                         &SearchListWrapper, DefaultComparator{}, param_names);
}
