package tn.esprit.sharedlogging.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUtil {
    private static Logger getLogger(Class<?> clazz) {
        return LoggerFactory.getLogger(clazz);
    }

    // Information logging
    public static void logInfo(Class<?> clazz, String message) {
        getLogger(clazz).info(message);
    }

    // Debug logging
    public static void logDebug(Class<?> clazz, String message) {
        getLogger(clazz).debug(message);
    }

    // Warning logging
    public static void logWarn(Class<?> clazz, String message) {
        getLogger(clazz).warn(message);
    }

    // Error logging (without exception)
    public static void logError(Class<?> clazz, String message) {
        getLogger(clazz).error(message);
    }

    // Error logging with exception
    public static void logError(Class<?> clazz, String message, Throwable throwable) {
        getLogger(clazz).error(message, throwable);
    }

    // Trace logging
    public static void logTrace(Class<?> clazz, String message) {
        getLogger(clazz).trace(message);
    }
}