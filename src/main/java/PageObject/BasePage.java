package PageObject;

import PageObject.Onliner.Enums.Menu;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Logger logger = Logger.getLogger(BasePage.class);
    private By entrance = By.cssSelector(".auth-bar__item.auth-bar__item--text");
    private By cart = By.cssSelector(".auth-bar__item.auth-bar__item--cart");
    private By profile = By.cssSelector(".b-top-profile__preview.js-toggle-bar");
    private By announcement = By.cssSelector(".b-top-profile__link.b-top-profile__link_alter.js-open-submenu");
    public By catalogAnnouncements = By.linkText("Объявления в каталоге");
    public By signOut = By.cssSelector(".b-top-profile__link.b-top-profile__link_secondary");


    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(25));
    }

    public BasePage click(By element) {
        logger.debug("Click on " + element);
        driver.findElement(element).click();
        return this;
    }

    public BasePage clickOnMenu(Menu menu) {
        logger.debug("Click on menu tab");
        driver.findElement(By.partialLinkText(menu.getMenu())).click();
        return this;
    }

    public BasePage clickOnEntrance() {
        logger.debug("Click on tab entrance ");
        driver.findElement(entrance).click();
        return this;
    }

    public BasePage goToCart() {
        logger.debug("go to cart");
        driver.findElement(cart).click();
        return this;
    }

    public BasePage clickOnProfile()  {
        logger.debug("Click on profile");
        wait.until(ExpectedConditions.visibilityOfElementLocated(profile));
        driver.findElement(profile).click();
        return this;
    }

    public BasePage clickOnSignOut()  {
        logger.debug("Click on SignOut");
        driver.findElement(signOut).click();
        return this;
    }

    public BasePage clickMyAnnouncement() {
        logger.debug("Click on announcement");
        driver.findElement(announcement).click();
        return this;
    }

    public BasePage chooseTypeOfAnnouncements() {
        logger.debug("Click on type of announcements");
        driver.findElement(catalogAnnouncements).click();
        return this;
    }

    protected Boolean isElementExist(By element) {
        List<WebElement> elementList = driver.findElements(element);
        return elementList.size() > 0;

    }


}