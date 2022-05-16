package PageObject.Onliner.Pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductPageChecks extends ProductPage {
    public ProductPageChecks(WebDriver driver) {
        super(driver);
    }

    public ProductPageChecks verifyTextOfTheCartButton(String value) {
        logger.debug("Check that status of the button is changed");
        Assert.assertEquals(getText(), value);
        return this;
    }
}
