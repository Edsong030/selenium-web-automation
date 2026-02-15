package config;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.ConfigReader;

import java.io.ByteArrayInputStream;
import java.net.URL;

public class BaseTest {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public WebDriver getDriver() {
        return driver.get();
    }

    @BeforeEach
    public void setup() {
        try {

            String browser = System.getProperty("browser",
                    ConfigReader.get("browser"));

            String remote = ConfigReader.get("remote");
            boolean isRemote = "true".equalsIgnoreCase(remote);

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");

            if (isRemote) {
                driver.set(new RemoteWebDriver(
                        new URL("http://selenium-hub:4444/wd/hub"),
                        options
                ));
            } else {
                driver.set(new org.openqa.selenium.chrome.ChromeDriver(options));
            }

            getDriver().manage().window().maximize();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao iniciar driver", e);
        }
    }


    @AfterEach
    public void tearDown() {
        if (getDriver() != null) {

            byte[] screenshot = ((TakesScreenshot) getDriver())
                    .getScreenshotAs(OutputType.BYTES);

            Allure.addAttachment(
                    "Screenshot",
                    new ByteArrayInputStream(screenshot)
            );

            getDriver().quit();
            driver.remove();
        }
    }
}
