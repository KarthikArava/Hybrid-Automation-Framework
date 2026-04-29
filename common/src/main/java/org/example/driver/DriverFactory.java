package org.example.driver;

import org.apache.log4j.Logger;
import org.example.utils.LoggerUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.Map;

import static org.example.config.Config.prop;

public class DriverFactory {

    private static final Logger log = LoggerUtil.getLogger(DriverFactory.class);
    public static WebDriver initDriver() {

        String browser = prop.getProperty("browser");
        String env = System.getProperty("env", "local");
        boolean isHeadless = env.equalsIgnoreCase("ci");
        WebDriver driver = null;

        log.info("Initializing browser: " + browser + " | Environment: " + env);

        if(browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();

            Map<String, Object> prefs = new HashMap<>();

            prefs.put("autofill.profile_enabled", false);
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            prefs.put("profile.default_content_setting_values.notifications", 2);
            prefs.put("profile.managed_default_content_settings.ads", 2);
            prefs.put("profile.default_content_setting_values.geolocation", 2);

            options.setExperimentalOption("prefs", prefs);

            options.addArguments("--disable-notifications");
            options.addArguments("--disable-infobars");
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--disable-blink-features=AutomationControlled");
            options.addArguments("--disable-features=IsolateOrigins,site-per-process");

            if (isHeadless) {
                options.addArguments("--headless=new");
                options.addArguments("--disable-gpu");
                options.addArguments("--window-size=1920,1080");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
            }

            driver = new ChromeDriver(options);
            log.info("Chrome browser launched successfully");
        }
        else if(browser.equalsIgnoreCase("Edge")) {
            EdgeOptions options = new EdgeOptions();

            Map<String, Object> prefs = new HashMap<>();

            prefs.put("autofill.profile_enabled", false);
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            prefs.put("profile.default_content_setting_values.notifications", 2);
            prefs.put("profile.managed_default_content_settings.ads", 2);
            prefs.put("profile.default_content_setting_values.geolocation", 2);

            options.setExperimentalOption("prefs", prefs);

            options.addArguments("--disable-notifications");
            options.addArguments("--disable-infobars");
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--disable-blink-features=AutomationControlled");
            options.addArguments("--disable-features=IsolateOrigins,site-per-process");

            if (isHeadless) {
                options.addArguments("--headless=new");
                options.addArguments("--disable-gpu");
                options.addArguments("--window-size=1920,1080");
            }

            driver = new EdgeDriver(options);
            log.info("Edge browser launched successfully");
        }
        else if(browser.equalsIgnoreCase("firefox")) {

            FirefoxOptions options = new FirefoxOptions();

            options.addArguments("-private");

            options.addPreference("dom.webnotifications.enabled", false);
            options.addPreference("dom.push.enabled", false);

            options.addPreference("privacy.trackingprotection.enabled", true);
            options.addPreference("browser.contentblocking.category", "strict");

            if (isHeadless) {
                options.addArguments("-headless");
                options.addArguments("--width=1920");
                options.addArguments("--height=1080");
                options.setBinary("/usr/local/bin/firefox");
                options.addArguments("--no-sandbox");
            }

            driver = new FirefoxDriver(options);
            log.info("Firefox driver launched successfully");
        }
        else {
            log.error("No such browser : "+browser);
            throw new RuntimeException("No Such Browser : " + browser);
        }

        if (!isHeadless) {
            driver.manage().window().maximize();
        }

        return driver;
    }

}