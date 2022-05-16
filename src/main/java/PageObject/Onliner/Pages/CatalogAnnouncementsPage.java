package PageObject.Onliner.Pages;
import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CatalogAnnouncementsPage extends BasePage{
    private By announcementButton = By.cssSelector(".button.button_green.button_base.catalog-masthead-controls__button");

    public CatalogAnnouncementsPage(WebDriver driver) {
        super(driver);
    }

    public CatalogAnnouncementsPage clickAnnouncementButton() {
        logger.debug("Click on announcement button");
        driver.findElement(announcementButton).click();
        return this;
    }
}
