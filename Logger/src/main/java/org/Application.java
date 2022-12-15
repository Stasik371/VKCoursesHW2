package org;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.loggers.AbstractLogger;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class Application {

    @Inject
    private AbstractLogger logger;


    public static void main(@NotNull String[] args) throws IOException {
        final Injector injector = Guice.createInjector(new org.InjectionModule(args));
        injector.getInstance(Application.class).waitForInput();
    }

    public void waitForInput() throws IOException {
        FileWriter logFile = new FileWriter("logs/logs.log");
        BufferedWriter out1 = new BufferedWriter(logFile);
        out1.write("");
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Waiting for new lines. Key in Ctrl+D to exit.");
            while (true) {
                String message = scanner.nextLine();
                logger.log(message);
            }

        } catch (IllegalStateException | NoSuchElementException | IOException e) {
            System.out.println("MainApplication error" + e.toString());
        }
    }

}
