package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ScreenshotUtil {

    public static void tirarScreenshot(WebDriver driver, String nomeArquivo) {
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.createDirectories(Paths.get("target/screenshots"));
            Files.copy(
                    screenshot.toPath(),
                    Paths.get("target/screenshots/" + nomeArquivo + ".png")
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
