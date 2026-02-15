package config;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import utils.AllureUtil;

public class TestListener implements TestWatcher {

    private final BaseTest baseTest;

    public TestListener(BaseTest baseTest) {
        this.baseTest = baseTest;
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        AllureUtil.anexarScreenshot(baseTest.driver, context.getDisplayName());
    }
}
