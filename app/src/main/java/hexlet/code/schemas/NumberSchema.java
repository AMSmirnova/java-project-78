package hexlet.code.schemas;

import hexlet.code.Predicate;

public final class NumberSchema extends BaseSchema {

    public NumberSchema() {
        Predicate<Object> isNumber = x -> (x instanceof Integer || x == null);
        super.addCondition("isNumber", isNumber);
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
