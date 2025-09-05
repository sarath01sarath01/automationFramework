package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import initialization.ConfigManager;
import utilities.LocatorManager;
import utilities.LoggerUtil;

public class LoginPageWithDynamicLocators extends BasePage {

    public LoginPageWithDynamicLocators() {
        super();
        PageFactory.initElements(driver, this);
    }

    public void navigateToLoginPage() {
        driver.get(ConfigManager.getProperty("base_url"));
        LoggerUtil.logInfo("Navigated to website base url:: " + ConfigManager.getProperty("base_url"));
    }

    public void login() throws InterruptedException {
        WebElement username = driver.findElement(LocatorManager.getLocator("login.username"));
        WebElement password = driver.findElement(LocatorManager.getLocator("login.password"));
        WebElement loginButton = driver.findElement(LocatorManager.getLocator("login.button"));
        
        sendKeys(username, ConfigManager.getProperty("valid.username"), "UserName");
        sendKeys(password, ConfigManager.getProperty("valid.password"), "Password");
        click(loginButton, "Login Button");
    }

    public void login(String usernameString, String passwordString) throws InterruptedException {
        WebElement username = driver.findElement(LocatorManager.getLocator("login.username"));
        WebElement password = driver.findElement(LocatorManager.getLocator("login.password"));
        WebElement loginButton = driver.findElement(LocatorManager.getLocator("login.button"));
        
        sendKeys(username, usernameString, "UserName");
        sendKeys(password, passwordString, "Password");
        click(loginButton, "Login Button");
    }

    public String getCurrentUrl() {
        LoggerUtil.logInfo("Current URL:: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }
}