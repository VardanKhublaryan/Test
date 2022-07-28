package com.company.swaglabs.utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;

public class MyLog4j {
    static Logger logger = Logger.getLogger(MyListener.class);
    static String log4jConfigFile = System.getProperty("user.dir")
            + File.separator + "src/main/resources/log4j.properties";

    public static void info(String info) {
        PropertyConfigurator.configure(log4jConfigFile);
        logger.info(info);
    }

    public static void error(String error) {
        PropertyConfigurator.configure(log4jConfigFile);
        logger.error(error);
    }

    public static void trace(String msg) {
        PropertyConfigurator.configure(log4jConfigFile);
        logger.trace(msg);
    }

    public static void debug(String msg) {
        PropertyConfigurator.configure(log4jConfigFile);
        logger.debug(msg);
    }

    public static void fatal(String msg) {
        PropertyConfigurator.configure(log4jConfigFile);
        logger.fatal(msg);
    }
}
