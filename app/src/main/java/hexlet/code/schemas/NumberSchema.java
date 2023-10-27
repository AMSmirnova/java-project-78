package hexlet.code.schemas;

import java.util.function.Predicate;
import java.util.Objects;

public final class NumberSchema extends BaseSchema {

    public NumberSchema() {
        Predicate<Object> isNumber = x -> (x instanceof Integer || x == null);
        super.addCondition("isNumber", isNumber);
    }

    public NumberSchema required() {
        Predicate<Object> isRequired = Objects::nonNull;
        this.addCondition("required", isRequired);
        return this;
    }

    public NumberSchema positive() {
        Predicate<Object> isPositive = x -> (x == null) || ((int) x > 0);
        super.addCondition("positive", isPositive);
        return this;
    }

    public NumberSchema range(int min, int max) {
        Predicate<Object> isInRange = x -> (x == null) || ((int) x >= min && (int) x <= max);
        super.addCondition("range", isInRange);
        return this;
    }
}
