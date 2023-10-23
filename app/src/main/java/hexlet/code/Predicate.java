package hexlet.code;

@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}

