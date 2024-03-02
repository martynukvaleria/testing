package core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtils {
    private Properties properties;
    private final String configFilePath = "src/test/java/resources/config.properties";

    public ConfigUtils() {
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

    public String getApplicationUrl() {
        String applicationUrl = properties.getProperty("url.base");
        if (applicationUrl != null)
            return applicationUrl;
        else
            throw new RuntimeException("Application url not specified in the config.properties file.");
    }

    public String getLocator(String property) {
        String locator = properties.getProperty(property);
        if (locator != null)
            return locator;
        else
            throw new RuntimeException("Locator not specified in the config.properties file.");
    }


    public String getName() {
        String username = properties.getProperty("name");
        if (username != null)
            return username;
        else
            throw new RuntimeException("username not specified in the config.properties file.");
    }

    public String getResult() {
        String result = properties.getProperty("private");
        if (result != null)
            return result;
        else
            throw new RuntimeException("result not specified in the config.properties file.");
    }
    public String getData(String property) {
        String data = properties.getProperty(property);
        if (data != null)
            return data;
        else
            throw new RuntimeException("result not specified in the config.properties file.");
    }

    public String getBrowser() {
        String browser = properties.getProperty("browser");
        if (browser != null)
            return browser;
        else
            throw new RuntimeException("browser not specified in the config.properties file.");
    }

}