package com.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    static Properties prop;

    public static Properties getProperties() {
        if (prop == null) {
            prop = new Properties();
            try (FileInputStream fis = new FileInputStream("./config.properties")) {
                prop.load(fis);
            } catch (IOException e) {
                System.out.println("error");
            }
        }
        return prop;
    }

    public static String getProperty(String key) {
        getProperties();
        return prop.getProperty(key);
    }
}