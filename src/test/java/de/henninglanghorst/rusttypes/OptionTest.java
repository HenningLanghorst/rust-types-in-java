package de.henninglanghorst.rusttypes;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OptionTest {

    @Test
    void some() {
        Option.Some<String> some = new Option.Some<>("value");
        assertEquals("value", some.value());
    }

    @Test
    void none() {
        Option.None<String> none = new Option.None<>();
        assertThrows(NoSuchElementException.class, none::value);
    }
}
