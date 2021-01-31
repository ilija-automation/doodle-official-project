package com.doodle.common.core;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class MTFProperties {

    public static Properties dynamic = new Properties();
    public static Properties timeouts = new Properties();

    public static void init() {

        File propertiesDir = new File(System.getProperty("user.dir"), "src/test/properties");

        initFromFile(dynamic, propertiesDir + "/dynamic.properties");
        initFromFile(timeouts, propertiesDir + "/timeouts.properties");
    }

    public static void initFromFile(Properties props, String filepath) {
        try {
            FileInputStream stream = new FileInputStream(filepath);
            props.load(stream);
            stream.close();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String getBrowser() {
        return dynamic.getProperty("browser").toLowerCase();
    }

    public static String getServer() {
        return dynamic.getProperty("server").toLowerCase();
    }

}
