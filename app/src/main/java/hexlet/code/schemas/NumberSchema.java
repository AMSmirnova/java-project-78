package hexlet.code.schemas;

import hexlet.code.Predicate;

public final class NumberSchema extends BaseSchema {

    @Override
    public boolean isValid(Object obj) {
        if (!(obj instanceof Integer) && obj != null) {
            return false;
        } else {
            return super.isValid(obj);
        }
    }

    @Override
    public NumberSchema required() {
        super.required();
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
