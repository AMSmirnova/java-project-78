package hexlet.code;

import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MapSchema extends BaseSchema{

    @Override
    public boolean isValid(Object obj) {
        if (!(obj instanceof Map<?,?>) && obj != null) {
            return false;
        } else { return super.isValid(obj);
        }
    }

    @Override
    public MapSchema required() {
        super.required();
        return this;
    }

    public MapSchema sizeOf(int amount) {
//        Predicate<Object> sizeOf = x -> x.size() == amount;
//        super.put("sizeOf", sizeOf);
        return this;
    }
}
