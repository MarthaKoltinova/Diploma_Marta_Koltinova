package PageObject.Onliner.Pages;

import PageObject.BasePage;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage open(String url) {
        logger.debug("Open page " + url);
        driver.get(url);
        return this;
    }
}
