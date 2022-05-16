package PageObject.Onliner.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class OrderPageChecks extends OrdersPage{

    public OrderPageChecks(WebDriver driver) {
        super(driver);
    }

    public OrderPageChecks verifyStatusOfResultsIs(String expected) {
        getStatusOfResults().forEach(actual -> {
            logger.info("Check that " + expected + " contains in " + actual);
            Assert.assertTrue(actual.contains(expected), "Check that " + expected + " contains in " + actual);
        });
        return this;
    }

    public Integer checkThatCountOfElementsMoreThan(By element,int count) {
        logger.debug("Find elements count " + element);
        Assert.assertTrue(driver.findElements(element).size() > count);
        return driver.findElements(element).size();
    }

    public OrderPageChecks verifyStatusBelowPriceIs(String expected) {
        getStatusOfResults().forEach(actual -> {
            Assert.assertTrue(actual.contains(expected), "Check that " + expected + " contains in " + actual);
        });
        return this;
    }
}
