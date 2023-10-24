package hexlet.code.schemas;

import hexlet.code.Predicate;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public abstract class BaseSchema {
    private Map<String, Predicate<Object>> conditions;

    public BaseSchema() {
        this.conditions = new HashMap<>();
    }

    protected boolean isValid(Object object) {
        return conditions.values().stream().allMatch(n -> n.test(object));
    }

    protected BaseSchema required() {
        Predicate<Object> isRequired = Objects::nonNull;
        this.addCondition("base required", isRequired);
        return this;
    }

    protected final void addCondition(String name, Predicate<Object> condition) {
        conditions.put(name, condition);
    }
}
