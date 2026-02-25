package ru.hse.java2026;

import java.util.Arrays;
import java.util.Objects;

public class Sum {
    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            throw new IllegalArgumentException("Аргументы командной строки не заданы. Передайте числа для суммирования.");
        }

        int totalSum = Arrays.stream(args)
                .filter(Objects::nonNull)
                .flatMap(arg -> Arrays.stream(arg.split("\\p{javaWhitespace}+")))
                .filter(part -> !part.isEmpty())
                .mapToInt(part -> {
                    try {
                        return Integer.parseInt(part);
                    } catch (NumberFormatException e) {
                        System.err.println("Пропущено некорректное значение: " + part);
                        return 0;
                    }
                })
                .sum();

        System.out.println(totalSum);
    }
}