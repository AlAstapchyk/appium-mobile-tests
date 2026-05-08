package com.qa.automation.pages;

import com.qa.automation.base.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class BasePage {
    protected AndroidDriver driver;
    protected WebDriverWait wait;
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    public BasePage() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    /**
     * Scrolls down to an element containing the specific text using Android UIAutomator.
     */
    protected void scrollToElementText(String text) {
        driver.findElement(io.appium.java_client.AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
                        + "new UiSelector().textContains(\"" + text + "\"));"));
    }
}
