package PageObject.Onliner.Pages;

import PageObject.BasePage;
import PageObject.Onliner.Enums.Category;
import PageObject.Onliner.Enums.Group;
import PageObject.Onliner.Enums.SubCategory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CatalogPage extends BasePage {
    private By searchField = By.className("fast-search__input");
    public By iframe = By.className("modal-iframe");

    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    public CatalogPage clickOnTabCategory(Category category) {
        logger.debug("Click on category tab");
        driver.findElement(By.xpath(category.getCategory())).click();
        return this;
    }

    public CatalogPage clickOnTabSubCategory(SubCategory subCategory) {
        logger.debug("Click on sub category tab");
        driver.findElement(By.xpath(subCategory.getSubCategory())).click();
        return this;
    }

    public CatalogPage clickOnItem(Group group) {
        logger.debug("Click on item");
        driver.findElement(By.xpath(group.getGroup())).click();
        return this;
    }

    public CatalogPage searchInfo(String text) {
        logger.debug("searchInfo");
        driver.findElement(searchField).click();
        driver.findElement(searchField).sendKeys(text);
        return this;
    }
}

