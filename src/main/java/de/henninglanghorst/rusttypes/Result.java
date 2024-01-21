package de.henninglanghorst.rusttypes;

/*
 * Interface for representing the result of an operation.
 * This interface allows for returning either a successful result
 * or an error from methods.
 */
public sealed interface Result<T> {

    /**
     * A successful result.
     *
     * @param value The value of the result.
     * @param <V>   The type of the result.
     */
    record Ok<V>(V value) implements Result<V> {
    }

    /**
     * An error result.
     *
     * @param exception The exception that caused the error.
     * @param <N>       The type of the error which does not matter here.
     */
    record Err<N>(Exception exception) implements Result<N> {
    }

    /**
     * Returns the value of the result or throws the exception if the result is an error.
     *
     * @return The value of the result.
     */
    default T value() {
        return switch (this) {
            case Ok<T>(T value) -> value;
            case Err<T>(RuntimeException exception) -> throw exception;
            case Err<T>(Exception exception) -> throw new RuntimeException(exception);
        };
    }
}
