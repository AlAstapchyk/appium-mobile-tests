package com.qa.automation.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    static {
        try {
            String path = "src/main/resources/config.properties";
            FileInputStream input = new FileInputStream(path);
            properties = new Properties();
            properties.load(input);
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.properties file.");
        }
    }

    public static String getProperty(String key) {
        // Allow overriding via system properties (e.g. from Maven command line)
        String sysProp = System.getProperty(key);
        if (sysProp != null) {
            return sysProp;
        }
        
        String prop = properties.getProperty(key);
        if (prop != null && prop.contains("${user.dir}")) {
            return prop.replace("${user.dir}", System.getProperty("user.dir"));
        }
        return prop;
    }
}
