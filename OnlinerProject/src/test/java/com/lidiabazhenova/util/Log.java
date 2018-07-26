package com.lidiabazhenova.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log {

    private static final Logger LOGGER = LoggerFactory.getLogger(Log.class);

    public static void startLog(String testClassName) {
        LOGGER.info("Test is Starting...");
    }

    public static void endLog(String testClassName) {
        LOGGER.info("Test is Ending...");
    }

    public static void info(String message) {
        LOGGER.info(message);
    }

    public static void warn(String message) {
        LOGGER.warn(message);
    }

    public static void error(String message) {
        LOGGER.error(message);
    }

    public static void debug(String message) {
        LOGGER.debug(message);
    }
}