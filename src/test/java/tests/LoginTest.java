package tests;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
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

    @AfterTest
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

    @Test
    public void loginIntoApplicationWithCorrectUsernameWrongPassword() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.navigateToLoginPage();
        loginPage.login("standard_user", "wrong_password");
        Thread.sleep(1000);
        Assert.assertFalse(loginPage.getCurrentUrl().contains("inventory"), "Page changed");
    }

    @Test
    public void loginIntoApplicationWithWrongUsernameCorrectPassword() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.navigateToLoginPage();
        loginPage.login("wrong_user", "secret_sauce");
        Thread.sleep(1000);
        Assert.assertFalse(loginPage.getCurrentUrl().contains("inventory"), "Page changed");
    }

    @Test
    public void loginIntoApplicationWithWrongUsernameWrongPassword() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.navigateToLoginPage();
        loginPage.login("wrong_username", "wrong_password");
        Thread.sleep(1000);
        Assert.assertFalse(loginPage.getCurrentUrl().contains("inventory"), "Page changed");
    }
}
