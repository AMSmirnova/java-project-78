package hexlet.code.schemas;

import hexlet.code.Predicate;

import java.util.Objects;

public final class StringSchema extends BaseSchema {
    private BaseSchema baseSchema;
    public StringSchema() {
        Predicate<Object> isString = x -> (x instanceof String || x == null);
        super.addCondition("isString", isString);
    }

    public StringSchema required() {
        Predicate<Object> isRequired = Objects::nonNull;
        this.addCondition("required", isRequired);
        Predicate<Object> isEmptyString = x -> !Objects.equals(x, "");
        this.addCondition("isEmptyString", isEmptyString);
        return this;
    }

    public StringSchema minLength(int length) {
        Predicate<Object> minLength = x -> (x == null || x.toString().length() >= length);
        super.addCondition("minlength", minLength);
        return this;
    }

    public StringSchema contains(String data) {
        Predicate<Object> isContains = x -> (x == null || x.toString().contains(data));
        super.addCondition("contains", isContains);
        return this;
    }
}
