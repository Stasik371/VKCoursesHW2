package org;

import com.google.inject.AbstractModule;
import org.loggers.*;
import org.jetbrains.annotations.NotNull;
import org.slf4j.LoggerFactory;

public final class InjectionModule extends AbstractModule {

    private final String[] args;

    public InjectionModule(@NotNull String[] args) {
        this.args = args;
    }

    @Override
    protected void configure() {
        LoggerCase loggerCase = LoggerCase.fromValue(args[0]);
        switch (loggerCase) {
            case CONSOLE:
                bind(AbstractLogger.class).toInstance(new ConsoleLogger
                        (LoggerFactory.getLogger(ConsoleLogger.class)));
                break;
            case FILE:
                bind(AbstractLogger.class).toInstance(new FileLogger
                        (LoggerFactory.getLogger(FileLogger.class), args[1]));
                break;
            case BOTH:
                bind(AbstractLogger.class).toInstance(new ConsoleAndFileLogger(
                        LoggerFactory.getLogger(ConsoleLogger.class),
                        LoggerFactory.getLogger(FileLogger.class), args[1]));
                break;
            case NOT_FOUND:
                throw new IllegalArgumentException("Incorrect parameters");
        }
    }
}
