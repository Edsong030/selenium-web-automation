import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverFactory {

    private static final String REMOTE_URL = "http://your-remote-url:4444/wd/hub";

    public static WebDriver createDriver(String executionMode) {
        WebDriver driver;

        if (executionMode.equalsIgnoreCase("remote")) {
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            try {
                driver = new RemoteWebDriver(new URL(REMOTE_URL), capabilities);
            } catch (MalformedURLException e) {
                throw new RuntimeException("Invalid RemoteWebDriver URL", e);
            }
        } else { // local execution
            // Set path to your local webdriver binary, for example:
            System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
            driver = new ChromeDriver();
        }

        return driver;
    }
}