package hexlet.code;

public class NumberSchema extends BaseSchema {
    private BaseSchema baseSchema;
    public NumberSchema() {
        baseSchema = new BaseSchema();
    }

    public boolean isValid(Object obj) {
        if (!(obj instanceof Integer) && obj != null) {
            return false;
        } else {
            return baseSchema.isValid(obj);
        }
    }

    @Override
    public NumberSchema required() {
        System.out.println("required");
        baseSchema.required();
        return this;
    }

    public NumberSchema positive() {
        Predicate<Object> isPositive = x -> (int) x > 0;
        baseSchema.put("positive", isPositive);
        return this;
    }

    public NumberSchema range(int min, int max) {
        Predicate<Object> isInRange = x -> ((int) x >= min && (int) x <= max);
        baseSchema.put("range", isInRange);
        return this;
    }
}
