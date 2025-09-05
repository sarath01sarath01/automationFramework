package tests;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import initialization.DriverManager;
import pages.LoginPage;
import utilities.LoggerUtil;

public class LoginTest {

    @BeforeMethod
    public void initialSetup() {
        LoggerUtil.logInfo("Setting up for login page test.........");
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().manage().deleteAllCookies();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        LoggerUtil.logInfo("Closing login page tests.........");
        Thread.sleep(5000);
        DriverManager.getDriver().quit();
    }

    @Test
    public void loginIntoApplication() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.navigateToLoginPage();
        loginPage.login();
        Thread.sleep(1000);
        Assert.assertTrue(loginPage.getCurrentUrl().contains("inventory"), "Page not changed");
    }
}
