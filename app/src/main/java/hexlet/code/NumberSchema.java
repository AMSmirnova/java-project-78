package hexlet.code;

public class NumberSchema extends BaseSchema {

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
        Predicate<Object> isPositive = x -> (int) x > 0;
        super.put("positive", isPositive);
        return this;
    }

    public NumberSchema range(int min, int max) {
        Predicate<Object> isInRange = x -> ((int) x >= min && (int) x <= max);
        super.put("range", isInRange);
        return this;
    }
}
