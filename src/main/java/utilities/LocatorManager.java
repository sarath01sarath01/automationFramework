package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LocatorManager {
    
    private static Map<String, String> locators = new HashMap<>();
    private static final String LOCATORS_FILE = "test-data/locators.json";
    
    static {
        loadLocators();
    }
    
    private static void loadLocators() {
        try (FileReader reader = new FileReader(LOCATORS_FILE)) {
            Gson gson = new Gson();
            locators = gson.fromJson(reader, new TypeToken<Map<String, String>>(){}.getType());
        } catch (IOException e) {
            throw new RuntimeException("Failed to load locators from " + LOCATORS_FILE, e);
        }
    }
    
    public static By getLocator(String elementName) {
        String locatorValue = locators.get(elementName);
        if (locatorValue == null) {
            throw new IllegalArgumentException("Locator not found for element: " + elementName);
        }
        
        String[] parts = locatorValue.split(":", 2);
        String strategy = parts[0];
        String value = parts[1];
        
        switch (strategy.toLowerCase()) {
            case "id":
                return By.id(value);
            case "name":
                return By.name(value);
            case "class":
                return By.className(value);
            case "css":
                return By.cssSelector(value);
            case "xpath":
                return By.xpath(value);
            case "tag":
                return By.tagName(value);
            case "linktext":
                return By.linkText(value);
            case "partiallinktext":
                return By.partialLinkText(value);
            default:
                throw new IllegalArgumentException("Unsupported locator strategy: " + strategy);
        }
    }
}