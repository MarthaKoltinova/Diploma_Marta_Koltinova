package PageObject.Onliner.Pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPageChecks extends CartPage {

    public CartPageChecks(WebDriver driver) {
        super(driver);
    }

    public CartPageChecks verifyProductNameInCart(String value) {
        logger.debug("Verify title name");
        Assert.assertEquals(getProductName(), value);
        return this;
    }

}
