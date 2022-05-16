package PageObject.Onliner.Pages;

import PageObject.BasePage;
import PageObject.Onliner.Enums.CheckboxItems;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class OrdersPage extends BasePage {
    protected WebDriverWait wait;
    private By statusResults = By.cssSelector(".service-offers__status.ng-scope.service-offers__status_error");
    public By countOfSearchResults = By.xpath("//*[@class='service-interaction__inner-container']");

    public OrdersPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }

    public OrdersPage clickOnCheckbox(CheckboxItems checkboxItems) {
        logger.debug("Click on checkbox");
        driver.findElement(By.xpath(checkboxItems.getCheckboxItems())).click();
        return this;
    }

    public List<String> getStatusOfResults() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(statusResults));
        List<String> data = driver.findElements(statusResults).stream().map(result -> result.getText()).collect(Collectors.toList());
        return data;
    }

    public By getStatusResults() {
        return statusResults;
    }
}
