package hexlet.code;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class BaseSchema {
    Map<String, Predicate<Object>> conditions;

    public BaseSchema() {
        this.conditions = new HashMap<>();
    }

    public boolean isValid(Object object) {
        return conditions.values().stream().allMatch(n -> n.test(object));
    }

    public BaseSchema required() {
        Predicate<Object> isRequired = Objects::nonNull;
        this.addCondition("base required", isRequired);
        return this;
    }

    public void addCondition(String name, Predicate<Object> condition) {
        conditions.put(name, condition);
    }
}
