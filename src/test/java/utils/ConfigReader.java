// Improved ConfigReader.java with better validation and error handling

package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private Properties properties;

    public ConfigReader(String filePath) {
        properties = new Properties();
        loadProperties(filePath);
    }

    private void loadProperties(String filePath) {
        try (FileInputStream input = new FileInputStream(filePath)) {
            properties.load(input);
        } catch (IOException e) {
            System.err.println("Error loading properties file: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Additional cleanup if necessary
        }
    }

    public String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            System.err.println("Property with key '" + key + "' not found.");
            // You could also throw an exception or return a default value
        }
        return value;
    }

    // Add more methods for validation and error handling if needed
}