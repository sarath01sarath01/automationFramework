package pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BasePage {

    @FindBy(xpath="(//button[contains(text(), 'ADD TO CART')])[1]")
    private WebElement firstItemAddToCartButton;

    @FindBy(xpath="//div[@id='shopping_cart_container']//span")
    private WebElement cartHighlighter;

    public ProductsPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public void addFirstItemToCart() {
        click(firstItemAddToCartButton, "First Item Add to Cart Button");
    }

    public boolean verifyOneItemAddedToCart() {
        if(getText(cartHighlighter, "Cart highlighter icon").equals("1") && cartHighlighter.getCssValue("background-color").equalsIgnoreCase("#ff253a")) {
            return true;
        } else {
            return false;
        }
    }
}
