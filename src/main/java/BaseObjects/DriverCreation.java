package BaseObjects;

import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.Locale;

import static io.github.bonigarcia.wdm.WebDriverManager.getInstance;

public class DriverCreation {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void createDriver(String drivers) {
        if (driver.get() == null) {
            WebDriver webDriver = getInstance(DriverManagerType.valueOf(drivers.toUpperCase(Locale.ROOT))).create();
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            webDriver.manage().window().maximize();
            driver.set(webDriver);
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }
}
