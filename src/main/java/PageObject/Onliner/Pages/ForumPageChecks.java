package PageObject.Onliner.Pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ForumPageChecks extends ForumPage {

    protected ForumPageChecks(WebDriver driver) {
        super(driver);
    }

    public ForumPageChecks verifyThatTitleIs(String value) {
        logger.debug("Verify title name");
        Assert.assertEquals(getTitle(), value);
        return this;
    }

    public ForumPageChecks verifyThatTimeOfPublicationLessThan24Hour(String expected) {
        getTimeOfResults().forEach(actual -> {
            logger.info("Check that " + expected + " contains in " + actual);
            Assert.assertFalse(actual.contains(expected), "Check that " + expected + " contains in " + actual);
        });
        return this;
    }

}
