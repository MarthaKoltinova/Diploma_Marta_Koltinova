package PageObject.Onliner.Pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PutAnnouncementsPageChecks extends PutAnnouncementsPage {

    public PutAnnouncementsPageChecks(WebDriver driver) {
        super(driver);
    }

    public PutAnnouncementsPage verifySizeOfDescriptionField(String value, String value2) {
        logger.debug("verify size of description");
        driver.findElement(descriptionField).click();
        String generatedValue = generateRandomString(999);
        driver.findElement(descriptionField).sendKeys(generatedValue);
        Assert.assertEquals(driver.findElement(restSymbolsText).getText(), value);
        driver.findElement(descriptionField).sendKeys(generatedValue + "1");
        Assert.assertEquals(driver.findElement(restSymbolsText).getText(), value2);
        return this;
    }

    public PutAnnouncementsPage verifyImageUploaded() {
        logger.debug("verify Image Uploaded");
        Assert.assertTrue(driver.findElement(image).isDisplayed());
        return this;
    }
}

