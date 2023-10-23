package hexlet.code;

import java.util.Objects;

public class StringSchema extends BaseSchema {
    private BaseSchema baseSchema;
    public StringSchema() {
        baseSchema = new BaseSchema();
    }
    @Override
    public boolean isValid(Object obj) {
        if (!(obj instanceof String) && obj != null) {
            return false;
        } else {
            return baseSchema.isValid(obj);
        }
    }

    @Override
    public StringSchema required() {
        Predicate<Object> isEmptyString = x -> !Objects.equals(x, "");
        baseSchema.put("required", isEmptyString);
        baseSchema.required();
        return this;
    }
    public StringSchema minLength(int length) {
        Predicate<Object> minLength = x -> x.toString().length() >= length;
        baseSchema.put("minlength", minLength);
        return this;
    }

    public StringSchema contains(String data) {
        Predicate<Object> isContains = x -> x.toString().contains(data);
        baseSchema.put("contains", isContains);
        return this;
    }
}
