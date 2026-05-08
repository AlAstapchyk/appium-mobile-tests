package com.qa.automation.pages.mobile;

import com.qa.automation.pages.BasePage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginMobilePage extends BasePage {

    private final By usernameInput = AppiumBy.accessibilityId("Username input field");
    private final By passwordInput = AppiumBy.accessibilityId("Password input field");
    private final By loginButton = AppiumBy.accessibilityId("Login button");

    public CheckoutMobilePage login(String username, String password) {
        logger.info("Logging in with username: {}", username);
        
        WebElement userField = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
        userField.clear();
        userField.sendKeys(username);

        WebElement passField = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        passField.clear();
        passField.sendKeys(password);

        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        submitButton.click();
        
        logger.info("Login submitted");
        return new CheckoutMobilePage();
    }
}
