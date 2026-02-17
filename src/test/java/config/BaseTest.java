// Refactored BaseTest.java to use WebDriverFactory

import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected WebDriver driver;

    public void setUp() {
        driver = WebDriverFactory.createDriver(); // Use WebDriverFactory to configure the driver
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}