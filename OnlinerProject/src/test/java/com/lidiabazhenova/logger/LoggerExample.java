package com.lidiabazhenova.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerExample {

    public static void main( String[] args )
    {
        Logger logger = LoggerFactory.getLogger(LoggerExample.class);

        logger.info("This is how you configure Log4J with SLF4J");
    }

}
