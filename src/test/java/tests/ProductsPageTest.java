package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
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

    @AfterTest
    public void tearDown() throws InterruptedException {
        LoggerUtil.logInfo("Closing products page tests.........");
        DriverManager.getDriver().quit();
    }

    @Test
    public void firstItemAddToCart() throws InterruptedException {
        ProductsPage productsPage = new ProductsPage();
        productsPage.addFirstItemToCart();
        Assert.assertTrue(productsPage.verifyOneItemAddedToCart(), "Item not added to cart");
    }

    @Test
    public void firstItemRemoveFromCart() throws InterruptedException {
        ProductsPage productsPage = new ProductsPage();
        productsPage.addFirstItemToCart();
        Thread.sleep(1000);
        productsPage.removeFirstItemFromCart();
        Assert.assertTrue(productsPage.verifyFirstItemRemovedFromCart(), "Item not removed from cart");
    }

}
