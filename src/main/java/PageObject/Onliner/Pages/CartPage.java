package PageObject.Onliner.Pages;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    public By deleteButton = By.className("cart-form__control");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage deleteItem() {
        logger.debug("delete item");
        driver.findElement(deleteButton).click();
        return this;
    }
}
