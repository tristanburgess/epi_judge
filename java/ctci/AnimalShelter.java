package ctci;

import test_framework.EpiTest;
import test_framework.EpiUserType;
import test_framework.GenericTest;
import test_framework.TestFailure;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

// Whiteboard: https://1drv.ms/u/s!AvHgsMnKfyusiIE3tO01PeLyNGDy1A

public class AnimalShelter {
  public static abstract class Animal {
    protected String name;
    private long sequence;

    public Animal(String name) {
      this.name = name;
    }

    public void setSequence(long sequence) {
      this.sequence = sequence;
    }

    public long getOrder() {
      return sequence;
    }

    public boolean isOlderThan(Animal a) {
      return this.sequence < a.getOrder();
    }
  }

  public static class Dog extends Animal {
    public Dog(String name) {
      super(name);
    }
  }

  public static class Cat extends Animal {
    public Cat(String name) {
      super(name);
    }
  }

  public static class Queue {
    private long sequence = Long.MIN_VALUE;
    LinkedList<Dog> dogs = new LinkedList<Dog>();
    LinkedList<Cat> cats = new LinkedList<Cat>();

    public void enqueue(Animal a) {
      a.setSequence(sequence);
      sequence++;

      if (a instanceof Dog) {
        dogs.addLast((Dog) a);
      } else if (a instanceof Cat) {
        cats.addLast((Cat) a);
      } else {
        throw new IllegalArgumentException();
      }
    }

    public Animal dequeueAny() {
      if (dogs.isEmpty()) {
        return dequeueCat();
      } else if (cats.isEmpty()) {
        return dequeueDog();
      } else if (dogs.peek().isOlderThan(cats.peek())) {
        return dequeueDog();
      } else {
        return dequeueCat();
      }
    }

    public Dog dequeueDog() {
      return dogs.poll();
    }

    public Cat dequeueCat() {
      return cats.poll();
    }
  }

  @EpiUserType(ctorParams = { String.class, String.class, String.class })
  public static class QueueOp {
    public String op;
    public String name;
    public String type;

    public QueueOp(String op, String name, String type) {
      this.op = op;
      this.name = name;
      this.type = type;
    }
  }

  @EpiTest(testDataFile = "../test_data/ctci/animal_shelter.tsv")
  public static void animalShelterTest(List<QueueOp> ops) throws TestFailure {
    try {
      Queue q = new Queue();
      Animal result;
      for (QueueOp op : ops) {
        switch (op.op) {
          case "push":
            if (op.type == "dog") {
              q.enqueue(new Dog(op.name));
            } else if (op.type == "cat") {
              q.enqueue(new Cat(op.name));
            }
            break;
          case "pop":
            result = q.dequeueAny();
            if (op.type == "dog" && (!(result instanceof Dog) || result.name != op.name)) {
              throw new TestFailure("Pop: expected dog " + String.valueOf(op.name) + ", got " + String.valueOf(result));
            } else if (op.type == "cat" && (!(result instanceof Cat) || result.name != op.name)) {
              throw new TestFailure("Pop: expected cat " + String.valueOf(op.name) + ", got " + String.valueOf(result));
            }
            break;
          case "AnimalShelter":
            break;
          default:
            throw new RuntimeException("Unsupported queue operation: " + op.op);
        }
      }
    } catch (NoSuchElementException e) {
      throw new TestFailure("Unexpected NoSuchElement exception");
    }
  }

  public static void main(String[] args) {
    System.exit(GenericTest.runFromAnnotations(args, "AnimalShelter.java", new Object() {
    }.getClass().getEnclosingClass()).ordinal());
  }
}
