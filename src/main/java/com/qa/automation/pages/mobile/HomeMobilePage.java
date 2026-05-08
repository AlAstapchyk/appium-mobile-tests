package com.qa.automation.pages.mobile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.automation.pages.BasePage;

import io.appium.java_client.AppiumBy;

public class HomeMobilePage extends BasePage {

    private final By firstProduct = AppiumBy.accessibilityId("store item");
    private final By cartBadge = AppiumBy.accessibilityId("cart badge");

    public ProductMobilePage clickFirstProduct() {
        WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(firstProduct));
        product.click();
        return new ProductMobilePage();
    }

    public ProductMobilePage scrollAndClickProduct(String productName) {
        scrollToElementText(productName);
        WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='store item' and .//*[contains(@text, '" + productName + "')]]")));
        product.click();
        return new ProductMobilePage();
    }

    public CartMobilePage navigateToCart() {
        WebElement cart = wait.until(ExpectedConditions.visibilityOfElementLocated(cartBadge));
        cart.click();
        return new CartMobilePage();
    }

    public boolean isCartBadgeDisplayed() {
        return !driver.findElements(cartBadge).isEmpty();
    }
}
