package de.henninglanghorst.rusttypes;

import java.util.NoSuchElementException;

/**
 * An option is either a value or nothing.
 *
 * @param <T> the type of the value
 */
public sealed interface Option<T> {

    /**
     * Case of {@link Option} where there is a value.
     *
     * @param value
     * @param <V>
     */
    record Some<V>(V value) implements Option<V> {
    }

    /**
     * Case of {@link Option} where there is no value.
     *
     * @param <N>
     */
    record None<N>() implements Option<N> {
    }

    default T value() {
        throw new NoSuchElementException("No value");
    }
}
