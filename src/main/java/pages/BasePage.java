package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import initialization.ConfigManager;
import initialization.DriverManager;
import utilities.LoggerUtil;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver,
                Duration.ofSeconds(Long.parseLong(ConfigManager.getProperty("explicitwait"))));
        PageFactory.initElements(driver, this);
    }

    protected void click(WebElement element, String elementName) {
        try{
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            LoggerUtil.logInfo("Clicked element:: " + elementName);
        } catch (Exception e) {
            LoggerUtil.logError("Error while clicking element:: " + elementName + " :: " + e.getMessage());
            throw e;
        }
    }

    protected void sendKeys(WebElement element, String text, String elementName) {
        try{
            wait.until(ExpectedConditions.visibilityOf(element));
            element.clear();
            element.sendKeys(text);
            LoggerUtil.logInfo("Entered text:: " + text + " in element:: " + elementName);
        } catch (Exception e) {
            LoggerUtil.logError("Error while entering text:: " + text + " in element:: " + elementName + " :: " + e.getMessage());
            throw e;
        }
    }

    protected String getText(WebElement element, String elementName) {
        try{
            wait.until(ExpectedConditions.visibilityOf(element));
            LoggerUtil.logInfo("Retrieved text:: " + element.getText() + " from element:: " + elementName);
            return element.getText();
        } catch (Exception e) {
            LoggerUtil.logError("Error while retrieving text from element:: " + elementName + " :: " + e.getMessage());
            throw e;
        }
    }

    protected boolean isElementDisplayed(WebElement element, String elementName) {
        try{
            wait.until(ExpectedConditions.visibilityOf(element));
            LoggerUtil.logInfo("Element:: " + elementName + " is displayed");
            return element.isDisplayed();
        } catch (Exception e) {
            LoggerUtil.logError("Error while checking if element:: " + elementName + " is displayed :: " + e.getMessage());
            throw e;
        }
    }

}
