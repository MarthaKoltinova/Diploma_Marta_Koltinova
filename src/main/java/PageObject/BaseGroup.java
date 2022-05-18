package PageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseGroup extends BasePage {
    protected WebDriver driver;
    protected Logger logger = Logger.getLogger(BasePage.class);
    protected WebDriverWait wait;
    private By results = By.xpath("//div[contains(@class, g)]//a[@class='js-product-title-link']");
    private By title = By.tagName("h1");
    private By item = By.xpath("//*[@class='js-product-title-link']");

    public BaseGroup(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }


    public BaseGroup clickOnItem() {
        logger.debug("Click on item");
        driver.findElement(item).click();
        return this;
    }

    public String getTitle() {
        logger.debug("get title");
        wait.until(ExpectedConditions.visibilityOfElementLocated(title));
        return driver.findElement(title).getText();
    }
}
