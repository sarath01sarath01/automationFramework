package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtil {

    private static final Logger logger = LogManager.getLogger(LoggerUtil.class);

    public static Logger getLogger() {
        return logger;
    }

    public static void logInfo(String message) {
        logger.info(message);
    }

    public static void logWarn(String message) {
        logger.warn(message);
    }

    public static void logError(String message) {
        logger.error(message);
    }

    public static void logFatal(String message) {
        logger.fatal(message);
    }

    public static void logDebug(String message) {
        logger.debug(message);
    }
}
