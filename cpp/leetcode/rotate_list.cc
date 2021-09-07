#include "generic_test.h"
#include "list_node.h"

// Whiteboard: https://1drv.ms/u/s!AvHgsMnKfyusiIEuRGgchMhP1a42GA

shared_ptr<ListNode<int>> RotateList(shared_ptr<ListNode<int>> L, int k) {
  if (L == NULL || L->next == NULL) {
    return L;
  }

  int len = 1;
  shared_ptr<ListNode<int>> join = L;
  while (join->next != NULL) {
    join = join->next;
    len++;
  }

  int r = k % len;
  if (r == 0) {
    return L;
  }

  join->next = L;

  shared_ptr<ListNode<int>> cut = L;
  for (int i = 0; i < len - r - 1; i++) {
    cut = cut->next;
  }
  shared_ptr<ListNode<int>> new_head = cut->next;
  cut->next = NULL;
  return new_head;
}

int main(int argc, char* argv[]) {
  std::vector<std::string> args{argv + 1, argv + argc};
  std::vector<std::string> param_names{"L", "k"};
  return GenericTestMain(args, "rotate_list.cc",
                         "../test_data/leetcode/rotate_list.tsv", &RotateList,
                         DefaultComparator{}, param_names);
}
