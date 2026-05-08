package com.qa.automation.pages.mobile;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.automation.pages.BasePage;

import io.appium.java_client.AppiumBy;

public class CheckoutMobilePage extends BasePage {

    private final By fullNameInput = AppiumBy.accessibilityId("Full Name* input field");
    private final By addressInput = AppiumBy.accessibilityId("Address Line 1* input field");
    private final By cityInput = AppiumBy.accessibilityId("City* input field");
    private final By zipInput = AppiumBy.accessibilityId("Zip Code* input field");
    private final By countryInput = AppiumBy.accessibilityId("Country* input field");
    private final By toPaymentButton = AppiumBy.accessibilityId("To Payment button");

    public CheckoutMobilePage fillShippingInfo(String name, String address, String city, String zip, String country) {
        logger.info("Filling out shipping information for {}", name);

        wait.until(ExpectedConditions.visibilityOfElementLocated(fullNameInput)).sendKeys(name);
        driver.findElement(addressInput).sendKeys(address);
        driver.findElement(cityInput).sendKeys(city);
        driver.findElement(zipInput).sendKeys(zip);
        driver.findElement(countryInput).sendKeys(country);

        logger.info("Shipping info filled, proceeding to payment");
        driver.findElement(toPaymentButton).click();
        return this;
    }
}
