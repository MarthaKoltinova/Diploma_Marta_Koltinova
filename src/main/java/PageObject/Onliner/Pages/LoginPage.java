package PageObject.Onliner.Pages;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private By title = By.cssSelector(".auth-form__title.auth-form__title_big.auth-form__title_condensed-default");
    public By registration = By.linkText("Зарегистрироваться на Onlíner");
    private By email = By.xpath("//input[@type='email']");
    private By password = By.xpath("//input[@type='password']");
    private By wrongEmail = By.xpath("//div[@class='auth-form__description auth-form__description_error auth-form__description_base auth-form__description_extended-other']");
    private By wrongPassword = By.xpath("//div[@class='auth-form__description auth-form__description_primary auth-form__description_tiny auth-form__description_condensed-other']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }

    public String getEmailHint() {
        return driver.findElement(wrongEmail).getText();
    }

    public String getPasswordHint() {
        return driver.findElement(wrongPassword).getText();
    }

    public LoginPage goToRegistration() {
        logger.debug("go to registration");
        click(registration);
        return this;
    }

    public LoginPage enterEmail(String value) {
        logger.debug("enter wrong email");
        click(email);
        driver.findElement(email).sendKeys(value);
        return this;
    }

    public LoginPage enterPassword(Integer value) {
        logger.debug("enter wrong password");
        click(password);
        driver.findElement(password).sendKeys(value.toString());
        return this;
    }
}
