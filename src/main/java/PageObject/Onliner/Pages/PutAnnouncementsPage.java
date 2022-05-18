package PageObject.Onliner.Pages;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;
import java.util.Random;

public class PutAnnouncementsPage extends BasePage {
    public By descriptionField = By.cssSelector(".input-style.input-style_primary.input-style_big.baralog-form__input.baralog-form__input_width_xxxl.baralog-form__input_height_xs");
    public By restSymbolsText = By.className("baralog-form__label-description");
    public By chooseFile = By.xpath("//label[@class='drop-style__link']//input[@type='file']");
    public By image = By.cssSelector(".drop-style__upload-item.drop-style__upload-item_primary.drop-style__upload-item_repeat");
    protected WebDriverWait wait;

    public PutAnnouncementsPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
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

    public PutAnnouncementsPage sendFileName() {
        try {
            logger.info("send file name started");
            JavascriptExecutor j = (JavascriptExecutor) driver;
            logger.info(" JavascriptExecutor created");
            j.executeScript("document.getElementsByClassName(\"drop-style__link-real\")[0].classList.remove(\"drop-style__link-real\");");
            driver.findElement(chooseFile).sendKeys("C:\\Users\\marta\\IdeaProjects\\Diploma_Marta_Koltinova\\src\\main\\java\\Images\\profile.png");
            logger.info("done");
        } catch (Exception e) {
            logger.info(e);
        }
        return this;
    }
}

