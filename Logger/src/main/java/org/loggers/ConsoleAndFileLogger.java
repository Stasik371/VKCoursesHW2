package org.loggers;

import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;


public class ConsoleAndFileLogger implements AbstractLogger {
    private final Logger consoleLogger;
    private final Logger fileLogger;
    private final String tag;

    public ConsoleAndFileLogger(@NotNull Logger consoleLogger, @NotNull Logger fileLogger, @NotNull String tag) {
        this.consoleLogger = consoleLogger;
        this.fileLogger = fileLogger;
        this.tag = tag;
    }

    @Override
    public void log(@NotNull String message) {
        consoleLogger.info("{} {}", LogsCounter.amount++, message);
        fileLogger.info("{} {}", LogsCounter.amount++, TagCreator.creatingTagForFileLogging(message, tag));
    }
}
