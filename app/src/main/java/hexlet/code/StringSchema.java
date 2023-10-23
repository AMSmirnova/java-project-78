package hexlet.code;

import java.util.Objects;

public class StringSchema {

    private boolean isRequired = false;
    private boolean isMinLength = false;
    private int minLength;
    private boolean isContains = false;
    private String data;
    public boolean isValid(Object obj) {
        String str;
        if (!(obj instanceof String)) {
            return false;
        } else {
            str = obj.toString();
        }
        return isValid(str);
    }
    public boolean isValid(String str) {

        if (isRequired && (Objects.equals(str, "") || Objects.equals(str, null))) {
            return false;
        }
        if (isMinLength && (str.length() < minLength)) {
            return false;
        }

        if (isContains && !str.contains(data)) {
            return false;
        }

        return true;
    }
    public StringSchema required() {
        isRequired = true;
        return this;
    }

    public StringSchema minLength(int length) {
        isMinLength = true;
        minLength = length;
        return this;
    }

    public StringSchema contains(String data) {
        isContains = true;
        this.data = data;
        return this;
    }
}
