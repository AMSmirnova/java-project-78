package hexlet.code.schemas;

import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.Predicate;

public final class MapSchema extends BaseSchema {

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
        super.addCondition("sizeof", sizeOf);
        return this;
    }

    public void shape(Map<String, BaseSchema> schemas) {
        schemas.forEach((key, value) -> {
            Predicate<Object> conditionForValues = x -> {
                ObjectMapper mapper = new ObjectMapper();
                Map<?, ?> map = mapper.convertValue(x, Map.class);
                return value.isValid(map.get(key));
            };
            super.addCondition("condition for" + key, conditionForValues);
        });
    }
}
