package org.loggers;

import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;


public class FileLogger implements AbstractLogger {
    private final Logger logger;
    private final String tag;

    public FileLogger(@NotNull Logger logger, @NotNull String tag) {
        this.logger = logger;
        this.tag = tag;
    }

    @Override
    public void log(@NotNull String message)  {
        logger.info("{} {}", LogsCounter.amount++, TagCreator.creatingTagForFileLogging(message, tag));
    }
}


