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


    /**
     * Returns the value of the option. If the option is empty, a {@link NoSuchElementException} is thrown.
     *
     * @return the value of the option
     * @throws NoSuchElementException if the option is empty
     */
    default T value() {
        return switch (this) {
            case Some<T>(T value) -> value;
            case None<T> ignored -> throw new NoSuchElementException("No value present");
        };
    }
}
