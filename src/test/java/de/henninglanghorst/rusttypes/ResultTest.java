package de.henninglanghorst.rusttypes;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ResultTest {

    @Test
    void ok() {
        String value = "Hello";
        Result.Ok<String> result = new Result.Ok<>(value);
        assertThat(result.value()).isEqualTo(value);
    }

    @Test
    void error() {
        Exception exception = new RuntimeException("Error");
        Result.Err<String> result = new Result.Err<>(exception);
        assertThatThrownBy(result::value)
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Error");
    }
}
