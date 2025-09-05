package pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.LoggerUtil;

import org.openqa.selenium.WebElement;
import java.util.List;

public class ProductsPage extends BasePage {

    @FindBy(xpath="(//button[contains(text(), 'ADD TO CART')])[1]")
    private WebElement firstItemAddToCartButton;

    @FindBy(xpath="//div[@id='shopping_cart_container']//span")
    private WebElement cartHighlighter;

    @FindBy(xpath="(//button[contains(text(), 'Remove')])[1]")
    private WebElement firstItemRemoveFromCartButton;

    @FindBy(xpath = "(//div[@class='pricebar'])//button")
    private List<WebElement> priceBarButtons;

    

    public ProductsPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public void addFirstItemToCart() {
        click(firstItemAddToCartButton, "First Item Add to Cart Button");
    }

    public void removeFirstItemFromCart() {
        click(firstItemRemoveFromCartButton, "First Item Remove from Cart Button");
    }

    public boolean verifyOneItemAddedToCart() {
        LoggerUtil.logInfo(cartHighlighter.getCssValue("background-color"));
        if(getText(cartHighlighter, "Cart highlighter icon").equals("1") && cartHighlighter.getCssValue("background-color").equalsIgnoreCase("rgb(255, 37, 58)")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verifyFirstItemRemovedFromCart() {
        if(priceBarButtons.get(0).getText().equalsIgnoreCase("add to cart"))
            return true;
        return false;
    }
}
