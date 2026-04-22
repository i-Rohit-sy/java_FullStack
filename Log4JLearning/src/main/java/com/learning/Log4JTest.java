package com.learning;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class Log4JTest {
    private static final Logger logger = (Logger) LogManager.getLogger(Log4JTest.class);

    public static void process(){
        logger.trace("FROM THE TRACE");
        logger.debug("HELLO FROM DEBUG");
        logger.info("INFO FROM LOGGER");
        logger.warn("WARNING FROM LOGGER");
        logger.error("ERROR FROM LOGGER");
        logger.fatal("FATAL MESSAGE FROM LOGGER");
    }
}
