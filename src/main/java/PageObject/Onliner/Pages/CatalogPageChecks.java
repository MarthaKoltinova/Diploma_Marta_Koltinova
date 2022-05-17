package PageObject.Onliner.Pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CatalogPageChecks extends CatalogPage {
    public CatalogPageChecks(WebDriver driver) {
        super(driver);
    }
    public CatalogPageChecks verifyDialogWindow() {
        logger.debug("verifyDialogWindow");
        Assert.assertTrue(isElementExist(iframe));
        return this;
    }

}
