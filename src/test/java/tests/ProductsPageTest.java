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

    ProductsPage productsPage;

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
        productsPage = new ProductsPage();
    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        LoggerUtil.logInfo("Closing products page tests.........");
        DriverManager.getDriver().quit();
    }

    @Test(priority = 1)
    public void verifyFirstItemAddedToCart() throws InterruptedException {

        productsPage.addFirstItemToCart();
        Assert.assertTrue(productsPage.isFirstItemAddedToCart(), "First Item not added to cart");
        productsPage.removeFirstItemFromCart();
    }

    @Test(priority = 2)
    public void verifyFirstItemRemovedFromCart() throws InterruptedException {
        ProductsPage productsPage = new ProductsPage();
        productsPage.addFirstItemToCart();
        productsPage.removeFirstItemFromCart();
        Assert.assertTrue(productsPage.isFirstItemRemovedFromCart(), "First Item not removed from cart");
    }

    @Test(priority = 3)
    public void verifyAllItemsAddedToCart() throws InterruptedException {
        productsPage.addAllItemsToCart();
        Assert.assertEquals(productsPage.getItemsCountOnCart(), 6, "All items not added to cart");
    }


}
