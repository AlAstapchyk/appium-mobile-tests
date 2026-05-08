package com.qa.automation.pages.mobile;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.automation.pages.BasePage;

public class ProductMobilePage extends BasePage {

    private final By addToCartButton = AppiumBy.accessibilityId("Add To Cart button");

    private final By cartBadge = AppiumBy.accessibilityId("cart badge");

    public ProductMobilePage clickAddToCart() {
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButton));
        button.click();
        return this;
    }

    public CartMobilePage navigateToCart() {
        WebElement cart = wait.until(ExpectedConditions.visibilityOfElementLocated(cartBadge));
        cart.click();
        return new CartMobilePage();
    }
}
