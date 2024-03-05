package core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtils {
    private static Properties properties;
    private static final String configFilePath = "src/test/java/resources/config.properties";

    //one method for all
    public static void readConfigUtils() {
        File ConfigFile = new File(configFilePath);
        try {
            FileInputStream configFileReader = new FileInputStream(ConfigFile);
            properties = new Properties();
            try {
                properties.load(configFileReader);
                configFileReader.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("config.properties not found at config file path" + configFilePath);
        }
    }
    public static String getValue(String property) {
        readConfigUtils();
        String value = properties.getProperty(property);
        if (value != null)
            return value;
        else
            throw new RuntimeException("Locator not specified in the config.properties file.");
    }

}