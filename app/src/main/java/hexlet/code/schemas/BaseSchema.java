package hexlet.code.schemas;

import java.util.function.Predicate;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseSchema {
    private Map<String, Predicate<Object>> conditions;

    protected BaseSchema() {
        this.conditions = new HashMap<>();
    }

    public final boolean isValid(Object object) {
        return conditions.values().stream().allMatch(n -> n.test(object));
    }

    protected final void addCondition(String name, Predicate<Object> condition) {
        conditions.put(name, condition);
    }
}
