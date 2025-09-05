package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import initialization.DriverManager;
import pages.CartPage;
import pages.ProductsPage;
import utilities.LoggerUtil;

public class CartTest {

    ProductsPage productsPage;
    CartPage cartPage;

    @BeforeTest
    public void setup() {
        LoggerUtil.logInfo("Cart tests started");
        WebDriver driver = DriverManager.getDriver();
        driver.get("https://www.saucedemo.com/v1/inventory.html");
        productsPage = new ProductsPage();
        productsPage.addAllItemsToCart();
        driver.get("https://www.saucedemo.com/v1/cart.html");
        cartPage = new CartPage();
    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        LoggerUtil.logInfo("Closing cart page tests.........");
        DriverManager.getDriver().quit();
    }

    @Test
    public void testItemsSizeAndHighlighterNumber() {
        Assert.assertEquals(cartPage.getCartItemsSize(), cartPage.getCartItemsSizeOnCartHighlighter(), "Counts are not matching");
    }
    
}
