package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import initialization.DriverManager;
import pages.ProductsPage;
import utilities.LoggerUtil;

public class ProductsPageTest {

    @BeforeTest
    public void setup() {
        WebDriver driver = DriverManager.getDriver();
        driver.get("https://www.saucedemo.com/v1/inventory.html");
    }

    @BeforeMethod
    public void initialSetup() {
        LoggerUtil.logInfo("Setting up for products page test.........");
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().manage().deleteAllCookies();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        LoggerUtil.logInfo("Closing products page tests.........");
        Thread.sleep(5000);
        DriverManager.getDriver().quit();
    }

    @Test
    public void loginIntoApplication() throws InterruptedException {
        ProductsPage productsPage = new ProductsPage();
        productsPage.addFirstItemToCart();
        Assert.assertTrue(productsPage.verifyOneItemAddedToCart(), "Item not added to cart");
    }

}
