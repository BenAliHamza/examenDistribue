package tn.esprit.sharedlogging.interfaces;

public interface CustomLogger {
    void info(String message);
    void info(String format, Object... args);
    void info(String module, String format, Object... args);

    void debug(String message);
    void debug(String format, Object... args);
    void debug(String module, String format, Object... args);

    void warn(String message);
    void warn(String format, Object... args);
    void warn(String module, String format, Object... args);

    void error(String message, Throwable throwable);
    void error(String format, Throwable throwable, Object... args);
    void error(String module, String format, Throwable throwable, Object... args);
}