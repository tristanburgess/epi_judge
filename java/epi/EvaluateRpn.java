package epi;

import java.util.Deque;
import java.util.LinkedList;

import test_framework.EpiTest;
import test_framework.GenericTest;

public class EvaluateRpn {

  @EpiTest(testDataFile = "../test_data/epi/evaluate_rpn.tsv")
  public static int evalTok(String expression) {
    Deque<Integer> s = new LinkedList<Integer>();

    for (String tok : expression.split(",")) {
      if (tok.length() > 1 || !"+-*/".contains(tok)) {
        s.push(Integer.parseInt(tok));
        continue;
      }

      final int y = s.pop();
      final int x = s.pop();

      switch (tok) {
        case "+": {
          s.push(x + y);
          break;
        }
        case "-": {
          s.push(x - y);
          break;
        }
        case "*": {
          s.push(x * y);
          break;
        }
        case "/": {
          s.push(x / y);
          break;
        }
        default: {
          throw new IllegalStateException("Invalid RPN at tok: " + tok);
        }
      }
    }

    return s.pop();
  }

  @EpiTest(testDataFile = "../test_data/epi/evaluate_rpn.tsv")
  public static int eval(String expression) {
    Deque<Integer> s = new LinkedList<Integer>();

    Integer operand = null;
    boolean neg = false;

    for (char c : expression.toCharArray()) {
      switch (c) {
        case ',': {
          if (operand != null) {
            s.push(operand);
            operand = null;
          }
          break;
        }
        case '+': {
          int r = s.pop();
          s.push(s.pop() + r);
          break;
        }
        case '*': {
          int r = s.pop();
          s.push(s.pop() * r);
          break;
        }
        case '/': {
          int r = s.pop();
          s.push(s.pop() / r);
          break;
        }
        case '-': {
          // All operators are binary, so must be working on building a negative
          // if the current stack size < 2.
          if (s.size() >= 2) {
            int r = s.pop(); 
            s.push(s.pop() - r);
          } else {
            neg = true;
          }
          break;
        }
        default: {
          if (operand == null) {
            operand = 0;
          }
          operand = operand * 10 + (c - '0');
          if (neg) {
            operand = -operand;
            neg = false;
          }
          break;
        }
      }
    }

    // We never built an intermediate result, so all we have to do is return
    // the sole built operand.
    if (s.isEmpty()) {
      return operand;
    }

    return s.pop();
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "EvaluateRpn.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
