package PageObject.Onliner.Pages;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    public By deleteButton = By.xpath("//*[contains(@class,'cart-form__button_remove')]");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage deleteItem() {
        logger.debug("delete item");
        actions.moveToElement(driver.findElement(deleteButton)).click().perform();
        return this;
    }
}
