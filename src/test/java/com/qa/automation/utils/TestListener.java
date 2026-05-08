package com.qa.automation.utils;

import com.qa.automation.base.DriverManager;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestListener implements AfterTestExecutionCallback {

    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {
        boolean testFailed = context.getExecutionException().isPresent();
        if (testFailed) {
            WebDriver driver = DriverManager.getDriver();
            if (driver != null) {
                saveScreenshotPNG(driver);
            }
        }
    }

    @Attachment(value = "Page screenshot on failure", type = "image/png")
    public byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
