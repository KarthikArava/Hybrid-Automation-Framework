package org.example.driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(WebDriver webdriver) {
        driver.set(webdriver);
    }

    public static void unload() {
        driver.get().quit();
        driver.remove();
    }
}
