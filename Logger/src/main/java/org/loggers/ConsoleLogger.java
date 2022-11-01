package org.loggers;

import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

public class ConsoleLogger implements AbstractLogger {

    private Logger logger;

    public ConsoleLogger(@NotNull Logger logger) {
        this.logger = logger;
    }

    @Override
    public void log(@NotNull String message) {
        logger.info("{} {}", LogsCounter.amount++, message);
    }
}
