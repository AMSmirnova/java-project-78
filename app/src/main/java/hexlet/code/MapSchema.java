package hexlet.code;

import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MapSchema extends BaseSchema {

    @Override
    public boolean isValid(Object obj) {
        if (!(obj instanceof Map<?, ?>) && obj != null) {
            return false;
        } else {
            return super.isValid(obj);
        }
    }

    @Override
    public MapSchema required() {
        super.required();
        return this;
    }

    public MapSchema sizeof(int amount) {
        Predicate<Object> sizeOf = x -> {
            ObjectMapper mapper = new ObjectMapper();
            Map<?, ?> map = mapper.convertValue(x, Map.class);
            return map.size() == amount;
        };
        super.put("sizeof", sizeOf);
        return this;
    }
}
