package org.loggers;

import org.Application;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

import javax.swing.text.html.HTML;

public class FileLogger implements AbstractLogger {
    private final Logger logger;
    private final String tag;

    public FileLogger(@NotNull Logger logger, @NotNull String tag) {
        this.logger = logger;
        this.tag = tag;
    }

    @Override
    public void log(@NotNull String message) {
        logger.info("{} {}", LogsCounter.amount++, new TagCreator().tagCreator(message,tag));
    }
}


