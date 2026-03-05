package com.example.portfolio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDateTime;

public final class Logger {
    private static Logger instance;

    private static String fileName;

    private static final String logDirectory = "Investment-portfolio\\com\\example\\portfolio\\logs";

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    private Logger() {
        fileName = "log" + LocalDateTime.now().toString().replace(":", "-") + ".log";
        try {
            File file = new File(logDirectory, fileName);
            System.out.println("Creating log file: " + file.getAbsolutePath());
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


    public static void log(LogLevel level, String message) {
        if (instance == null) {
            instance = new Logger();
        }
        try{
            
            File file = new File(logDirectory, instance.fileName);
            Writer output = new BufferedWriter(new FileWriter(file, true));

            String logEntry = String.format("%s [%s] %s: %s%n", LocalDateTime.now(), level, getCaller(), message);
            output.append(logEntry);
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static String getCaller() {
    return StackWalker.getInstance()
        .walk(s -> s.skip(1).findFirst()
        .map(f -> f.getClassName() + "." + f.getMethodName())
        .orElse("unknown"));
    }


}
