package Diploma;

import BaseObjects.BaseTest;
import PageObject.BaseGroupChecks;
import PageObject.BasePage;
import PageObject.BasePageChecks;
import PageObject.Onliner.Enums.Category;
import PageObject.Onliner.Enums.Group;
import PageObject.Onliner.Enums.Menu;
import PageObject.Onliner.Enums.SubCategory;
import PageObject.Onliner.Pages.*;
import org.checkerframework.checker.units.qual.C;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Diploma extends BaseTest {

    @BeforeMethod
    public void preconditions() {

    }

    @Test(priority = 1)
    public void verifySizeOfDescriptionField() {
        logger.info("Test verifySizeOfDescriptionField  started");
        get(HomePage.class)
                .open(property.getProperty("url"))
                .clickOnEntrance();
        get(EntrancePage.class)
                .enterEmail("martitakoltinova@gmail.com")
                .enterPassword("martaparta1")
                .signIn();
        get(BasePage.class)
                .clickOnProfile()
                .clickMyAnnouncement()
                .chooseTypeOfAnnouncements();
        get(CatalogAnnouncementsPage.class)
                .clickAnnouncementButton();
        get(PutAnnouncementsPageChecks.class)
                .verifySizeOfDescriptionField("Остался 1 символ", "Осталось 0 символов");
        logger.info("Test verifySizeOfDescriptionField finished");
    }

    @Test(priority = 2, enabled = false)
    public void uploadFile() throws InterruptedException {
        logger.info("Test uploadFile  started");
        get(PutAnnouncementsPage.class)
                .sendFileName();
        get(PutAnnouncementsPageChecks.class)
                .verifyImageUploaded();
        logger.info("Test uploadFile finished");
    }

    @Test(priority = 3)
    public void addItemToCart() {
        logger.info("Test addItemToCart  started");
        get(HomePage.class)
                .clickOnMenu(Menu.CATALOG);
        get(CatalogPage.class)
                .clickOnTabCategory(Category.ELECTRONICS)
                .clickOnTabSubCategory(SubCategory.VIDEO_GAMES)
                .clickOnItem(Group.GAMING_CONSOLES);
        get(BaseGroupChecks.class)
                .verifyThatTitleIs("Игровые приставки");
        get(GamingConsolesPage.class)
                .clickOnItem();
        get(ProductPage.class)
                .addItemToCard();
        get(InformPage.class)
                .clickCart();
        logger.info("Test addItemToCart finished");
    }

    @Test(priority = 4)
    public void deleteItemFromCart() {
        logger.info("Test deleteItemFromCart  started");
        get(CartPage.class)
                .deleteItem();
        logger.info("Test deleteItemFromCart finished");
    }

    @Test(priority = 5)
    public void putIncorrectData() {
        logger.info("Test putIncorrectData  started");
        get(HomePage.class)
                .open(property.getProperty("url"));
        get(BasePage.class)
                .clickOnProfile()
                .clickOnSignOut();
        get(HomePage.class)
                .clickOnEntrance();
        get(LoginPage.class)
                .goToRegistration();
        get(LoginPageChecks.class)
                .verifyThatTitleIs("Регистрация");
        get(LoginPage.class)
                .enterEmail("12345");
        get(LoginPageChecks.class)
                .verifyThatEmailHintIs("Некорректный e-mail");
        get(LoginPage.class)
                .enterPassword(1234);
        logger.info("Test putIncorrectData finished");
    }

    @Test(priority = 6)
    public void putInsufficientCountOfData() {
        logger.info("Test putInsufficientCountOfData  started");
        get(LoginPage.class)
                .enterPassword(1234);
        get(LoginPageChecks.class)
                .verifyThatPasswordHintsIs("Минимум 8 символов");
        logger.info("Test putInsufficientCountOfData finished");
    }
}

