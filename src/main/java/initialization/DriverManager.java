package initialization;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static WebDriver driver;
    private DriverManager() {};

    public static WebDriver getDriver() {
        if (driver == null) {
            String browserName = ConfigManager.getProperty("browser");
            driver = BrowserFactory.createBrowser(browserName);
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
    

}
