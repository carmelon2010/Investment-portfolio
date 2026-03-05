package com.example.portfolio;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class LogFileNamer {
    public static String fileName;

    private static final DateTimeFormatter TS =
            DateTimeFormatter.ofPattern("yyyy-MM-dd_HHmmss");

    private LogFileNamer() {}

    public static String initFileName(String prefix) {
        String safePrefix = (prefix == null || prefix.isBlank()) ? "log" : prefix.trim();
        fileName = safePrefix + "_" + LocalDateTime.now().format(TS) + ".log";
        return fileName;
    }
}