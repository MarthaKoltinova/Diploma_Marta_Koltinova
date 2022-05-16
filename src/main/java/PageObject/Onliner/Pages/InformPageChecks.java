package PageObject.Onliner.Pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class InformPageChecks extends InformPage {

    public InformPageChecks(WebDriver driver) {
        super(driver);
    }

    public InformPageChecks verifyThatTextOfGoToCartIs(String value) {
        Assert.assertEquals(getGoToCartText(), value);
        return this;
    }
}
