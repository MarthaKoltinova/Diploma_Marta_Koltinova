package PageObject.Onliner.Pages;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class PutAnnouncementsPage extends BasePage {
    public By descriptionField = By.cssSelector(".input-style.input-style_primary.input-style_big.baralog-form__input.baralog-form__input_width_xxxl.baralog-form__input_height_xs");
    public By restSymbolsText = By.className("baralog-form__label-description");
    private final String fileName = "profile.png";
    private final String filePath = "C:\\Users\\marta\\IdeaProjects\\Diploma_Marta_Koltinova\\Images\\";
    public By chooseFile = By.xpath("//*[@class='drop-style__content']//*[@class='drop-style__link-faux']");
    public By image = By.cssSelector(".drop-style__upload-item.drop-style__upload-item_primary.drop-style__upload-item_repeat");

    public PutAnnouncementsPage(WebDriver driver) {
        super(driver);
    }

    public String generateRandomString(Integer length) {
        logger.debug("generateRandomString");
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {

            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }

        String randomString = sb.toString();
        logger.debug("verify size of description: " + randomString);
        return randomString;
    }

    public PutAnnouncementsPage sendFileName() throws InterruptedException {
        driver.findElement(chooseFile).click();
        Thread.sleep(1200);
        driver.findElement(chooseFile).sendKeys(filePath + fileName);
        return this;
    }
}

