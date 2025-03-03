package com.aplikasihadir.hooks;

import com.aplikasihadir.DriverSingleton;
import com.aplikasihadir.drivers.utils.BrowserType;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;

public class Hook {

    private static WebDriver driver;

    @BeforeAll
    public static void setup() throws InterruptedException {
        driver = DriverSingleton.getDriver(System.getProperty("browser", BrowserType.CHROME));
    }

    @AfterAll
    public static void teardown() throws InterruptedException {
        driver.quit();
    }
}
