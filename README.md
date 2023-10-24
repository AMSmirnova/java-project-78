### Hexlet tests and linter status:
[![Actions Status](https://github.com/AMSmirnova/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/AMSmirnova/java-project-78/actions)
[![Java-CI](https://github.com/AMSmirnova/java-project-78/actions/workflows/main.yml/badge.svg)](https://github.com/AMSmirnova/java-project-78/actions/workflows/main.yml)
[![Maintainability](https://api.codeclimate.com/v1/badges/ebf4450b2d1e8003b439/maintainability)](https://codeclimate.com/github/AMSmirnova/java-project-78/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/ebf4450b2d1e8003b439/test_coverage)](https://codeclimate.com/github/AMSmirnova/java-project-78/test_coverage)

# Data Validator
## This library checks data against validation rules. To use a validator, create a validator object and set a data validation scheme.
* String validation provides:
  * .required() - not null value or not empty .
  * .minLength() - minimum length limit
  * .contains() - content limit
* Number validation provides:
  * .required() - not null value
  * .positive() - sign limit
  * .range() - allowable range
* Map validation provides:
  * .required() - not null elements
  * .sizeof() - size limit
  * .shape() - structure check

## Usage example
```java
import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;

Validator v = new Validator();

// String validation
StringSchema stringSchema = v.string();

stringSchema.isValid(""); // true
stringSchema.isValid(null); // true

stringSchema.required().minLength(5).contains("what");
stringSchema.isValid("what does the fox say"); // true
stringSchema.isValid("The fox says"); // false

// Number validation
NumberSchema numberSchema = v.number();

numberSchema.isValid(null); // true
numberSchema.positive().isValid(null); // true

schema.required().range(5, 10);

schema.isValid(-10); // false
schema.isValid(5); // true
schema.isValid(10); // true
schema.isValid(4); // false

// Map validation
Map<String, BaseSchema> schemas = new HashMap<>();

schemas.put("name", v.string().required());
schemas.put("age", v.number().positive());

schema.shape(schemas);

Map<String, Object> human1 = new HashMap<>();
human1.put("name", "Kolya");
human1.put("age", 100);
schema.isValid(human1); // true

Map<String, Object> human3 = new HashMap<>();
human3.put("name", "");
human3.put("age", null);
schema.isValid(human3); // false

