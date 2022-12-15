package org.loggers;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public interface AbstractLogger {

    void log(@NotNull String message) throws IOException;
}
