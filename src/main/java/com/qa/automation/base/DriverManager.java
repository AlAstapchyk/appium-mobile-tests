package com.qa.automation.base;

import java.net.MalformedURLException;
import java.net.URI;

import com.qa.automation.config.ConfigReader;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class DriverManager {

    private static final ThreadLocal<AndroidDriver> driver = new ThreadLocal<>();

    public static AndroidDriver getDriver() {
        return driver.get();
    }

    public static void initializeDriver() {
        if (driver.get() != null) {
            return;
        }

        try {
            driver.set(initMobileDriver());
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize AndroidDriver", e);
        }
    }

    private static AndroidDriver initMobileDriver() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName(ConfigReader.getProperty("mobile.platformName"))
                .setAutomationName(ConfigReader.getProperty("mobile.automationName"))
                .setDeviceName(ConfigReader.getProperty("mobile.deviceName"))
                .setApp(ConfigReader.getProperty("mobile.app"))
                .setAppPackage(ConfigReader.getProperty("mobile.appPackage"))
                .setAppActivity(ConfigReader.getProperty("mobile.appActivity"))
                .setNoReset(Boolean.parseBoolean(ConfigReader.getProperty("mobile.noReset")))
                .setFullReset(Boolean.parseBoolean(ConfigReader.getProperty("mobile.fullReset")));

        String appiumUrl = ConfigReader.getProperty("appium.server.url");
        return new AndroidDriver(URI.create(appiumUrl).toURL(), options);
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
