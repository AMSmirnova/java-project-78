package hexlet.code;

import java.util.Objects;

public class StringSchema extends BaseSchema {
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
        super.put("required", isEmptyString);
        super.required();
        return this;
    }
    public StringSchema minLength(int length) {
        Predicate<Object> minLength = x -> x.toString().length() >= length;
        super.put("minlength", minLength);
        return this;
    }

    public StringSchema contains(String data) {
        Predicate<Object> isContains = x -> x.toString().contains(data);
        super.put("contains", isContains);
        return this;
    }
}
