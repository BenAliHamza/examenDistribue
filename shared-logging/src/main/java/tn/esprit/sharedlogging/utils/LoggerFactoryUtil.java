package tn.esprit.sharedlogging.utils;

import tn.esprit.sharedlogging.interfaces.CustomLogger;
import tn.esprit.sharedlogging.interfaces.CustomLoggerImpl;

public class LoggerFactoryUtil {
    public static CustomLogger getLogger(Class<?> clazz) {
        return new CustomLoggerImpl(clazz);
    }
}