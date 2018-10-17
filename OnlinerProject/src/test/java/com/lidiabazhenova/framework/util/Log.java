package com.lidiabazhenova.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for Logger
 */
public class Log {

    private static final Logger LOGGER = LoggerFactory.getLogger(Log.class);

    /**
     * Method to set message to info when test is started
     *
     * @param testClassName
     */
    public static void startLog(String testClassName) {
        LOGGER.info("Test is Starting...");
    }

    /**
     * * Method to set message to info when test is ended
     *
     * @param testClassName
     */
    public static void endLog(String testClassName) {
        LOGGER.info("Test is Ending...");
    }
}