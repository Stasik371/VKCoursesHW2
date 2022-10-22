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
        if(args[0].equals("console")){
            bind(org.loggers.AbstractLogger.class).toInstance(new org.loggers.ConsoleLogger
                    (LoggerFactory.getLogger(org.loggers.ConsoleLogger.class)));
        }
        else if(args[0].equals("file")){
            bind(org.loggers.AbstractLogger.class).toInstance(new org.loggers.FileLogger
                    (LoggerFactory.getLogger(FileLogger.class), args[1]));
        }
        else if(args[0].equals("both")){
            bind(org.loggers.AbstractLogger.class).toInstance(new ConsoleAndFileLogger(
                    LoggerFactory.getLogger(org.loggers.ConsoleLogger.class),
                    LoggerFactory.getLogger(org.loggers.FileLogger.class), args[1]));
        }
        else{
            throw new IllegalArgumentException("Incorrect parameters");
        }
    }
}
