package pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v117.page.Page;
import org.openqa.selenium.By;

public class CartPage extends BasePage {

    @FindBy(xpath = "//div[@class='cart_item']")
    private List<WebElement> cartItems;

    @FindBy(xpath="//div[@id='shopping_cart_container']//span")
    private WebElement cartHighlighter;

    public CartPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public int getCartItemsSize() {
        return cartItems.size();
    }

    public int getCartItemsSizeOnCartHighlighter() {
        return Integer.parseInt(getText(cartHighlighter, "Cart highlighter icon"));
    }

    public void removeItemFromCart() {
        cartItems.get(0).findElement(By.xpath("//button[text()='REMOVE']")).click();
    }
    
}
