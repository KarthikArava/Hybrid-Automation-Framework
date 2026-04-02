package org.example.utils;

import org.openqa.selenium.WebDriver;

public class AdHandlerUtil {

    public static void handleGoogleVignette(WebDriver driver){

        if(driver.getCurrentUrl().contains("google_vignette")){
            driver.navigate().back();
        }

    }
}
