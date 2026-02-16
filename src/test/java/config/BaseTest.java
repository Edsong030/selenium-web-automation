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

            String remote = ConfigReader.get("remote");
            String headless = ConfigReader.get("headless");

            ChromeOptions options = new ChromeOptions();

            if ("true".equalsIgnoreCase(headless)) {
                options.addArguments("--headless=new");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--window-size=1920,1080");
            } else {
                options.addArguments("--start-maximized");
            }

            // Execução remota (Docker / Grid / CI)
            if ("true".equalsIgnoreCase(remote)) {

                String gridUrl = ConfigReader.get("grid.url");

                driver.set(new RemoteWebDriver(
                        new URL(gridUrl),
                        options
                ));

            } else {
                // Execução local
                driver.set(new ChromeDriver(options));
            }

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
