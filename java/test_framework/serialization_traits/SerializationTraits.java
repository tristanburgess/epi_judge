
package test_framework.serialization_traits;

import test_framework.TestFailure;
import test_framework.minimal_json.JsonValue;

import java.util.List;
import java.util.Objects;

public abstract class SerializationTraits {
  public abstract String name();

  public abstract Object parse(String str);

  public abstract Object jsonParse(JsonValue jsonObject);

  public abstract List<String> getMetricNames(String argName);

  public abstract List<Integer> getMetrics(Object x);

  public boolean isVoid() {
    return false;
  }

  boolean argumentsEqual(Object a, Object b) throws TestFailure {
    return Objects.equals(a, b);
  }
}
