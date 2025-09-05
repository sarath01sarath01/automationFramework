package tests;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import initialization.DriverManager;
import pages.LoginPage;
import pages.LoginPageWithDynamicLocators;
import utilities.LoggerUtil;

public class LoginTest {
    
    private static final int TIMEOUT_SECONDS = 10;
    private WebDriverWait wait;
    private LoginPageWithDynamicLocators loginPage;

    @BeforeMethod
    public void setUp() {
        LoggerUtil.logInfo("Starting test setup for LoginTest");
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().manage().deleteAllCookies();
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT_SECONDS));
        wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(TIMEOUT_SECONDS));
        // loginPage = new LoginPage();
        loginPage = new LoginPageWithDynamicLocators();
        LoggerUtil.logInfo("Test setup completed successfully");
    }

    @AfterTest
    public void tearDown() {
        LoggerUtil.logInfo("Starting test cleanup");
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
            LoggerUtil.logInfo("Browser closed successfully");
        }
    }

    @Test(priority = 1)
    public void testSuccessfulLogin() {
        LoggerUtil.logInfo("Starting test: testSuccessfulLogin");
        
        try {
            LoggerUtil.logInfo("Navigating to login page");
            loginPage.navigateToLoginPage();
            
            LoggerUtil.logInfo("Attempting login with valid credentials");
            loginPage.login();
            
            String currentUrl = loginPage.getCurrentUrl();
            LoggerUtil.logInfo("Current URL after login: " + currentUrl);
            
            Assert.assertTrue(currentUrl.contains("inventory"), 
                "Login failed - Expected URL to contain 'inventory' but got: " + currentUrl);
            
            LoggerUtil.logInfo("Test passed: Successfully logged in with valid credentials");
        } catch (Exception e) {
            LoggerUtil.logError("Test failed: testSuccessfulLogin - " + e.getMessage());
        }
    }

    // @Test(priority = 2)
    // public void testLoginWithValidUsernameInvalidPassword() {
    //     LoggerUtil.logInfo("Starting test: testLoginWithValidUsernameInvalidPassword");
        
    //     try {
    //         LoggerUtil.logInfo("Navigating to login page");
    //         loginPage.navigateToLoginPage();
            
    //         LoggerUtil.logInfo("Attempting login with valid username and invalid password");
    //         loginPage.login("standard_user", "wrong_password");
            
    //         String currentUrl = loginPage.getCurrentUrl();
    //         LoggerUtil.logInfo("Current URL after failed login attempt: " + currentUrl);
            
    //         Assert.assertFalse(currentUrl.contains("inventory"), 
    //             "Login should have failed but URL contains 'inventory': " + currentUrl);
            
    //         LoggerUtil.logInfo("Test passed: Login correctly failed with invalid password");
    //     } catch (Exception e) {
    //         LoggerUtil.logError("Test failed: testLoginWithValidUsernameInvalidPassword - " + e.getMessage());
    //     }
    // }

    // @Test(priority = 3)
    // public void testLoginWithInvalidUsernameValidPassword() {
    //     LoggerUtil.logInfo("Starting test: testLoginWithInvalidUsernameValidPassword");
        
    //     try {
    //         LoggerUtil.logInfo("Navigating to login page");
    //         loginPage.navigateToLoginPage();
            
    //         LoggerUtil.logInfo("Attempting login with invalid username and valid password");
    //         loginPage.login("wrong_user", "secret_sauce");
            
    //         String currentUrl = loginPage.getCurrentUrl();
    //         LoggerUtil.logInfo("Current URL after failed login attempt: " + currentUrl);
            
    //         Assert.assertFalse(currentUrl.contains("inventory"), 
    //             "Login should have failed but URL contains 'inventory': " + currentUrl);
            
    //         LoggerUtil.logInfo("Test passed: Login correctly failed with invalid username");
    //     } catch (Exception e) {
    //         LoggerUtil.logError("Test failed: testLoginWithInvalidUsernameValidPassword - " + e.getMessage());
    //     }
    // }

    // @Test(priority = 4)
    // public void testLoginWithInvalidCredentials() {
    //     LoggerUtil.logInfo("Starting test: testLoginWithInvalidCredentials");
        
    //     try {
    //         LoggerUtil.logInfo("Navigating to login page");
    //         loginPage.navigateToLoginPage();
            
    //         LoggerUtil.logInfo("Attempting login with invalid username and invalid password");
    //         loginPage.login("wrong_username", "wrong_password");
            
    //         String currentUrl = loginPage.getCurrentUrl();
    //         LoggerUtil.logInfo("Current URL after failed login attempt: " + currentUrl);
            
    //         Assert.assertFalse(currentUrl.contains("inventory"), 
    //             "Login should have failed but URL contains 'inventory': " + currentUrl);
            
    //         LoggerUtil.logInfo("Test passed: Login correctly failed with invalid credentials");
    //     } catch (Exception e) {
    //         LoggerUtil.logError("Test failed: testLoginWithInvalidCredentials - " + e.getMessage());
    //     }
    // }
}
