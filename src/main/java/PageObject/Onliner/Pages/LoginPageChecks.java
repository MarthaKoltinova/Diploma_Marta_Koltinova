package PageObject.Onliner.Pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPageChecks extends LoginPage {
    public LoginPageChecks(WebDriver driver) {
        super(driver);
    }

    public LoginPageChecks verifyThatTitleIs(String value) {
        logger.debug("Verify title name");
        Assert.assertEquals(getTitle(), value);
        return this;
    }

    public LoginPageChecks verifyThatEmailHintIs(String value) {
        logger.debug("hint incorrect email");
        Assert.assertEquals(getEmailHint(), value);
        return this;
    }

    public LoginPageChecks verifyThatPasswordHintsIs(String value) {
        logger.debug("hint incorrect password");
        Assert.assertEquals(getPasswordHint(), value);
        return this;
    }
}
