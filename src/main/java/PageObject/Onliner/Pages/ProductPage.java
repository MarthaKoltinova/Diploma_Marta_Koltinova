package PageObject.Onliner.Pages;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {
    private By addToCard = By.cssSelector(".button-style.button-style_base-alter.button-style_primary.product-aside__button.product-aside__button_narrow.product-aside__button_cart.button-style_expletive");
    private By inCart = By.cssSelector(".button-style.button-style_base-alter.button-style_primary.product-aside__button.product-aside__button_narrow.product-aside__button_cart.button-style_primary");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage addItemToCard() {
        logger.debug("add to card item");
        driver.findElement(addToCard).click();
        return this;
    }

    public String getText() {
        return driver.findElement(inCart).getText();
    }
}
