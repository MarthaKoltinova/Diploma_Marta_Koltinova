package PageObject.Onliner.Pages;

import PageObject.BasePage;
import PageObject.Onliner.Enums.Links;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class ForumPage extends BasePage {
    private By title = By.tagName("h1");
    private By publicationTime = By.xpath("//div[contains(@class, g)]//a[@class='link-getlast']");
    private By pageNumber = By.xpath("//*[@class='pages-fastnav']//li)[last()]");
    public By countOfThemes = By.xpath("//*[@class='m-title']//*[contains(text(),'найдено')]");
    protected WebDriverWait wait;

    public ForumPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }

    public ForumPage clickLink(Links links) {
        logger.debug("Click on link");
        driver.findElement(By.linkText(links.getLinks())).click();
        return this;
    }

    public String getTitle() {
        logger.debug("get title");
        wait.until(ExpectedConditions.visibilityOfElementLocated(title));
        return driver.findElement(title).getText();
    }

    public List<String> getTimeOfResults() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(publicationTime));
        List<String> data = driver.findElements(publicationTime).stream().map(result -> result.getText()).collect(Collectors.toList());
        return data;
    }

    public ForumPage clickLastPage() {
        logger.debug("Click on page");
        driver.findElement(pageNumber).click();
        return this;
    }

    public String getCount() {
        logger.debug("get count");
        String[] count= (String[]) driver.findElements(countOfThemes).toArray();
        return count[1];
    }
}
