package com.qa.automation.base;

import com.qa.automation.utils.TestListener;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(TestListener.class)
public class BaseTest {

    @BeforeEach
    public void setUp() {
        DriverManager.initializeDriver();
    }

    @AfterEach
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
