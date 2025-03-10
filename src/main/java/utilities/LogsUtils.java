package utilities;

import org.apache.logging.log4j.LogManager;

public class LogsUtils {

 public static String fileLogsPath = "test-outputs/logs/";

    public static void info(String msg)
    {
        LogManager.getLogger(Thread.currentThread().getStackTrace()[2].toString()).info(msg);
    }


    public static void error(String msg)
    {
        LogManager.getLogger(Thread.currentThread().getStackTrace()[2].toString()).error(msg);
    }


    public static void trace(String msg)
    {
      LogManager.getLogger(Thread.currentThread().getStackTrace()[2].toString()).trace(msg);
    }

}
