package org.loggers;

import org.jetbrains.annotations.NotNull;

public class TagCreator {
    public @NotNull
    static String creatingTagForFileLogging(@NotNull String message, @NotNull String tag) {
        return "<" + tag + ">" + message + "</" + tag + ">";
    }
}
