package utilities.Logger;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class LoggingUtils {

    private static final Logger LOGGER = LogManager.getLogger(LoggingUtils.class);


    private LoggingUtils() {
        // Private constructor to prevent instantiation
    }

    public static void info(String message) {
        LOGGER.info(message);
    }

    public static void info(int message) {
        LOGGER.info(String.valueOf(message));
    }

    public static void info(ArrayList<String> message) {
        LOGGER.info(message.toString());
    }

    public static void info(List<String> message) {
        LOGGER.info(message.toString());
    }

    public static void error(String message) {
        LOGGER.error(message);
    }

    public static void error(Exception message) {
        LOGGER.error("Exception occurred", message);
    }

    public static void log(File file, String message) {
        LOGGER.info("RP_MESSAGE#FILE#{}#{}", file.getAbsolutePath(), message);
    }
}
