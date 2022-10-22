package org.loggers;

import org.jetbrains.annotations.NotNull;

public class TagCreator {
    public @NotNull String tagCreator(@NotNull String message, @NotNull String tag) {
        return "<" + tag + ">" + message + "</" + tag + ">";
    }
}
