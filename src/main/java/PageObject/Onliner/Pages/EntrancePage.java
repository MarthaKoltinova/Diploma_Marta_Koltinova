package PageObject.Onliner.Pages;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EntrancePage extends BasePage {
    private By email = By.cssSelector(".auth-input.auth-input_primary.auth-input_base.auth-form__input.auth-form__input_width_full");
    private By password = By.xpath("//input[@type='password']");
    private By button = By.cssSelector(".auth-button.auth-button_primary.auth-button_middle.auth-form__button.auth-form__button_width_full");

    public EntrancePage(WebDriver driver) {
        super(driver);
    }

    public EntrancePage enterEmail(String value) {
        logger.debug("enter email");
        click(email);
        driver.findElement(email).sendKeys(value);
        return this;
    }

    public EntrancePage enterPassword(String value) {
        logger.debug("enter password");
        click(password);
        driver.findElement(password).sendKeys(value.toString());
        return this;
    }

    public EntrancePage signIn() {
        logger.debug("sign in");
        driver.findElement(button).click();
        return this;
    }
}
