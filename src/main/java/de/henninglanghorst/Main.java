package de.henninglanghorst;

import de.henninglanghorst.rusttypes.Option;

public class Main {
    public static void main(String[] args) {
        var some = new Option.Some<>(10);
        handle(some);
    }

    private static void handle(Option<Integer> option) {
        switch (option) {
            case Option.Some(Integer value) -> System.out.println(value);
            case Option.None<Integer> ignored -> System.out.println("No value");
        }
    }
}