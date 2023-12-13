
package test_framework.serialization_traits;

import test_framework.minimal_json.Json;
import test_framework.minimal_json.JsonValue;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ListTraits extends SerializationTraits {
  private SerializationTraits innerTypeTraits;

  public ListTraits(SerializationTraits innerTypeTraits) {
    this.innerTypeTraits = innerTypeTraits;
  }

  @Override
  public String name() {
    return String.format("array(%s)", innerTypeTraits.name());
  }

  @Override
  public List<Object> parse(String str) {
    return jsonParse(Json.parse(str));
  }

  @Override
  public List<Object> jsonParse(JsonValue jsonObject) {
    if (!jsonObject.isArray()) {
      throw new RuntimeException("List parser: expected JSON array");
    }
    return StreamSupport.stream(jsonObject.asArray().spliterator(), false)
        .map(innerTypeTraits::jsonParse)
        .collect(Collectors.toList());
  }

  @Override
  public List<String> getMetricNames(String argName) {
    return Collections.singletonList(String.format("size(%s)", argName));
  }

  @Override
  public List<Integer> getMetrics(Object x) {
    if (x instanceof List) {
      @SuppressWarnings("unchecked")
      int size = ((List<Integer>) x).size();
      return Collections.singletonList(size);
    } else {
      throw new RuntimeException("Expected List");
    }
  }

  // TODO Custom parser that throws TestFailure with mismatch info

  public SerializationTraits getInnerTraits() {
    return innerTypeTraits;
  }
}
