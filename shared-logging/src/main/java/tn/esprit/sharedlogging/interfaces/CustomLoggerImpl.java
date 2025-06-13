package tn.esprit.sharedlogging.interfaces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.MessageFormatter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CustomLoggerImpl implements CustomLogger {
    private final Logger logger;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private final String className;

    // ANSI escape codes
    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String CYAN = "\u001B[36m";
    private static final String PURPLE = "\u001B[35m";

    public CustomLoggerImpl(Class<?> clazz) {
        this.logger = LoggerFactory.getLogger(clazz);
        this.className = clazz.getSimpleName();
    }

    private String formatMessage(String level, String module, String message) {
        String timestamp = LocalDateTime.now().format(formatter);
        String coloredLevel;
        String moduleDisplay = (module != null && !module.isEmpty())
                ? "[" + PURPLE + module + RESET + "]"
                : "";

        switch (level) {
            case "ERROR" -> coloredLevel = RED + level + RESET;
            case "WARN" -> coloredLevel = YELLOW + level + RESET;
            case "DEBUG" -> coloredLevel = CYAN + level + RESET;
            case "INFO" -> coloredLevel = BLUE + level + RESET;
            default -> coloredLevel = level;
        }

        return String.format("[%s] [%s] [%s] %s %s",
                timestamp,
                coloredLevel,
                CYAN + className + RESET,
                moduleDisplay,
                message);
    }

    // Info methods
    @Override
    public void info(String message) {
        if (logger.isInfoEnabled()) {
            logger.info(formatMessage("INFO", "", message));
        }
    }

    @Override
    public void info(String format, Object... args) {
        if (logger.isInfoEnabled()) {
            logger.info(formatMessage("INFO", "", formatMessage(format, args)));
        }
    }

    @Override
    public void info(String module, String format, Object... args) {
        if (logger.isInfoEnabled()) {
            logger.info(formatMessage("INFO", module, formatMessage(format, args)));
        }
    }

    // Debug methods
    @Override
    public void debug(String message) {
        if (logger.isDebugEnabled()) {
            logger.debug(formatMessage("DEBUG", "", message));
        }
    }

    @Override
    public void debug(String format, Object... args) {
        if (logger.isDebugEnabled()) {
            logger.debug(formatMessage("DEBUG", "", formatMessage(format, args)));
        }
    }

    @Override
    public void debug(String module, String format, Object... args) {
        if (logger.isDebugEnabled()) {
            logger.debug(formatMessage("DEBUG", module, formatMessage(format, args)));
        }
    }

    // Warn methods
    @Override
    public void warn(String message) {
        if (logger.isWarnEnabled()) {
            logger.warn(formatMessage("WARN", "", message));
        }
    }

    @Override
    public void warn(String format, Object... args) {
        if (logger.isWarnEnabled()) {
            logger.warn(formatMessage("WARN", "", formatMessage(format, args)));
        }
    }

    @Override
    public void warn(String module, String format, Object... args) {
        if (logger.isWarnEnabled()) {
            logger.warn(formatMessage("WARN", module, formatMessage(format, args)));
        }
    }

    // Error methods
    @Override
    public void error(String message, Throwable throwable) {
        if (logger.isErrorEnabled()) {
            logger.error(formatMessage("ERROR", "", message), throwable);
        }
    }

    @Override
    public void error(String format, Throwable throwable, Object... args) {
        if (logger.isErrorEnabled()) {
            logger.error(formatMessage("ERROR", "", formatMessage(format, args)), throwable);
        }
    }

    @Override
    public void error(String module, String format, Throwable throwable, Object... args) {
        if (logger.isErrorEnabled()) {
            logger.error(formatMessage("ERROR", module, formatMessage(format, args)), throwable);
        }
    }

    // Helper method to format messages with arguments
    private String formatMessage(String format, Object... args) {
        return MessageFormatter.arrayFormat(format, args).getMessage();
    }
}