package org;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.loggers.AbstractLogger;
import org.jetbrains.annotations.NotNull;

import java.util.NoSuchElementException;
import java.util.Scanner;


public class Application {

    @Inject
    private AbstractLogger logger;


    public static void main(@NotNull String[] args) {
        final Injector injector = Guice.createInjector(new org.InjectionModule(args));
        injector.getInstance(Application.class).waitForInput();
    }

    public void waitForInput() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Waiting for new lines. Key in Ctrl+D to exit.");
            while (true) {
                String message = scanner.nextLine();
                logger.log(message);
            }
        } catch (IllegalStateException | NoSuchElementException e) {
            System.out.println("MainApplication error" + e.toString());
        }
    }

}
