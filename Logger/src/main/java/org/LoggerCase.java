package org;

import org.jetbrains.annotations.NotNull;


public enum LoggerCase {
    BOTH("both"){},
    FILE("file"),
    CONSOLE("console"){

    },
    NOT_FOUND("Not found");

    @NotNull
    private final String value;

    LoggerCase(@NotNull final String value) {
        this.value = value;
    }

    @NotNull
    public static LoggerCase fromValue(@NotNull String value) {
        for (final LoggerCase loggerCases : values()) {
            if (loggerCases.value.equalsIgnoreCase(value)) {
                return loggerCases;
            }
        }
        return NOT_FOUND;
    }

}