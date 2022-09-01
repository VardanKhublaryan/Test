package com.company.swaglabs.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
    public static final String browserName =getPropValues("browser_name");

    public static final String chrome = getPropValues("chrome_browser");
    public static final String edge = getPropValues("edge_browser");
    public static final String firefox = getPropValues("firefox_browser");

    private static Properties getPropValues() throws IOException {
        InputStream inputStream = null;
        Properties props = new Properties();

        try {
            String propFileName = "config.properties";
            inputStream = Configuration.class.getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                props.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            assert inputStream != null;
            inputStream.close();
        }
        return props;
    }


    public static String getPropValues(String key) {
        if (System.getProperty(key) == null || System.getProperty(key).isEmpty()) {
            try {
                return getPropValues().getProperty(key);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return System.getProperty(key);
    }
}
