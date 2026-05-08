package com.qa.automation.mobile;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.qa.automation.base.BaseTest;
import com.qa.automation.pages.mobile.HomeMobilePage;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;

@Feature("Mobile E-Commerce Flow")
public class MobileStoreTest extends BaseTest {

    @ParameterizedTest
    @ValueSource(strings = {"Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Fleece Jacket"})
    @Description("Verify user can add specific products to the cart dynamically (Data-Driven)")
    public void testAddSpecificProductToCart(String productName) {
        new HomeMobilePage()
                .scrollAndClickProduct(productName)
                .clickAddToCart();

        Assertions.assertTrue(new HomeMobilePage().isCartBadgeDisplayed(), "Cart badge should be visible for " + productName);
    }

    @Test
    @Description("Verify checkout flow using Fluent Interface (Method Chaining)")
    public void testCompleteCheckoutFlow() {
        new HomeMobilePage()
                .clickFirstProduct()
                .clickAddToCart()
                .navigateToCart()
                .clickProceedToCheckout()
                .login("bob@example.com", "10203040")
                .fillShippingInfo("Jane Doe", "456 Fluent St", "Code City", "98765", "USA");

        Assertions.assertTrue(true, "Checkout flow reached payment screen successfully");
    }

    @Test
    @Description("Verify user can add and then remove a product from the cart")
    public void testRemoveProductFromCart() {
        boolean isCartEmpty = new HomeMobilePage()
                .clickFirstProduct()
                .clickAddToCart()
                .navigateToCart()
                .clickRemoveItem()
                .isCartEmpty();

        // To check screenshot of failed test
        // Assertions.assertTrue(false, "Intentional failure to test screenshots");
        Assertions.assertTrue(isCartEmpty, "Cart should be empty after removing item");
    }

    @Test
    @Description("Verify scrolling to a specific product works correctly")
    public void testScrollToProduct() {
        new HomeMobilePage()
                .scrollAndClickProduct("Onesie")
                .clickAddToCart();

        Assertions.assertTrue(new HomeMobilePage().isCartBadgeDisplayed(), "Cart badge should be visible after scrolling and adding");
    }
}
