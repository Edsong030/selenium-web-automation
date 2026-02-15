package utils;

import config.BaseTest;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

public class TestListener implements AfterTestExecutionCallback {

    @Override
    public void afterTestExecution(ExtensionContext context) {

        if (context.getExecutionException().isPresent()) {

            byte[] screenshot = ((TakesScreenshot) BaseTest.getDriver())
                    .getScreenshotAs(OutputType.BYTES);

            Allure.addAttachment(
                    "Erro Screenshot",
                    new ByteArrayInputStream(screenshot)
            );
        }
    }
}
