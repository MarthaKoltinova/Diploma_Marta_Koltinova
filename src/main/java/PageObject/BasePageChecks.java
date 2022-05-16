package PageObject;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public abstract class BasePageChecks extends BasePage {
    public BasePageChecks(WebDriver driver) {
        super(driver);
    }

    public BasePageChecks verifyThatTitleOfTabIs(String value) {
        logger.debug("Verify title name of tab");
        Assert.assertEquals(driver.getTitle(), value);
        return this;
    }
}
