package initialization;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigManager {

    private static Properties properties;
    private static final String CONFIG_FILE = "src\\main\\resources\\config.properties";

    static {
        properties = new Properties();
        try {
            FileInputStream inputStream = new FileInputStream(CONFIG_FILE);
            properties.load(inputStream);
            inputStream.close();
        } catch (Exception e) {
            throw new RuntimeException("Error loading config file: " + e.getMessage());
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

}
