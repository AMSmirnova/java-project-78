package hexlet.code.schemas;

import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.Predicate;

public final class MapSchema extends BaseSchema {

    public MapSchema() {
        Predicate<Object> isMap = x -> (x instanceof Map || x == null);
        super.addCondition("isMap", isMap);
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
