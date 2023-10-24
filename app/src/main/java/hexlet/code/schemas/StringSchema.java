package hexlet.code.schemas;

import hexlet.code.Predicate;

import java.util.Objects;

public final class StringSchema extends BaseSchema {
    private BaseSchema baseSchema;
    @Override
    public boolean isValid(Object obj) {
        if (!(obj instanceof String) && obj != null) {
            return false;
        } else {
            return super.isValid(obj);
        }
    }

    @Override
    public StringSchema required() {
        Predicate<Object> isEmptyString = x -> !Objects.equals(x, "");
        super.addCondition("required", isEmptyString);
        super.required();
        return this;
    }
    public StringSchema minLength(int length) {
        Predicate<Object> minLength = x -> x.toString().length() >= length;
        super.addCondition("minlength", minLength);
        return this;
    }

    public StringSchema contains(String data) {
        Predicate<Object> isContains = x -> x.toString().contains(data);
        super.addCondition("contains", isContains);
        return this;
    }
}
