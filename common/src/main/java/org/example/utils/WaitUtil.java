package org.example.utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtil {

    private static final Logger log = LoggerUtil.getLogger(WaitUtil.class);

    public static void waitUntilClickable(WebDriver driver, By locator) {
        log.info("Waiting until element clickable : "+locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(
                webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState")
                        .equals("complete"));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitUntilVisible(WebDriver driver, By locator) {
        log.info("Waiting until element visible : "+locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(
                webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState")
                        .equals("complete"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitUntilUrlContains(WebDriver driver, String urlPart) {
        log.info("Waiting until URL contains : "+urlPart);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlContains(urlPart));
    }

}
