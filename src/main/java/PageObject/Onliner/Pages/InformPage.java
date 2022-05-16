package PageObject.Onliner.Pages;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InformPage extends BasePage {
    private By goToCart = By.cssSelector(".button-style.button-style_another.button-style_base-alter.product-recommended__button");

    public InformPage(WebDriver driver) {
        super(driver);
    }

    public String getGoToCartText() {
        return driver.findElement(goToCart).getText();
    }

    public InformPage clickCart() {
        logger.debug("Click continue shopping");
        driver.findElement(goToCart).click();
        return this;
    }
}
