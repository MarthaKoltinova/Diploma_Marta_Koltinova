package BaseObjects;

import Properties.PropertyReader;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import static BaseObjects.DriverCreation.createDriver;
import static BaseObjects.DriverCreation.getDriver;

public class BaseTest {
    protected WebDriver driver;
    protected ITestContext context;
    protected Properties property;
    protected Logger logger = Logger.getLogger(BaseTest.class);

    @BeforeTest
    public void precondition(ITestContext context) {
        this.context = context;
        property = new PropertyReader(context.getSuite().getParameter("property")).getProperties();
        createDriver(property.getProperty("browser") == null ? "chrome" : property.getProperty("browser"));
        driver = getDriver();
    }

    protected <T> T get(Class<T> page) {
        return get(page, this.driver);
    }

    protected <T> T get(Class<T> page, WebDriver driver) {
        T instance = null;
        try {
            instance = page.getDeclaredConstructor(WebDriver.class).newInstance(driver);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return instance;
    }

    @AfterTest
    public void postcondition() {
        this.driver.quit();
    }
}
