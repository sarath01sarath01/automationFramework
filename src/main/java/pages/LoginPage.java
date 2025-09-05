package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import initialization.ConfigManager;
import utilities.LoggerUtil;

public class LoginPage extends BasePage {

    @FindBy(id="user-name")
    private WebElement username;

    @FindBy(id="password")
    private WebElement password;

    @FindBy(id="login-button")
    private WebElement loginButton;

    public LoginPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public void navigateToLoginPage() {
        driver.get(ConfigManager.getProperty("base_url"));
        LoggerUtil.logInfo("Navidated to website base url:: " + ConfigManager.getProperty("base_url"));
    }

    public void login() throws InterruptedException {
        sendKeys(username, ConfigManager.getProperty("valid.username"), "UserName");
        sendKeys(password, ConfigManager.getProperty("valid.password"), "Password");
        click(loginButton, "Login Button");
    }

    public String getCurrentUrl() {
        LoggerUtil.logInfo("Current URL:: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

}
