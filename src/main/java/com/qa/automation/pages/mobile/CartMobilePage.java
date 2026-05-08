package com.qa.automation.pages.mobile;

import com.qa.automation.pages.BasePage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartMobilePage extends BasePage {

    private final By removeButton = AppiumBy.accessibilityId("remove item");
    // XPath is used here because 'text' is not supported by accessibilityId
    private final By noItemsTitle = By.xpath("//*[@text='No Items']");
    private final By proceedToCheckoutButton = AppiumBy.accessibilityId("Proceed To Checkout button");

    public LoginMobilePage clickProceedToCheckout() {
        logger.info("Clicking Proceed to Checkout");
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(proceedToCheckoutButton));
        button.click();
        return new LoginMobilePage();
    }

    public CartMobilePage clickRemoveItem() {
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(removeButton));
        button.click();
        return this;
    }

    public boolean isCartEmpty() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(noItemsTitle)).isDisplayed();
    }
}
