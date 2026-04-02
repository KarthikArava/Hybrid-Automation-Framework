package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.apache.log4j.Logger;
import org.example.driver.DriverFactory;
import org.example.driver.DriverManager;
import org.example.utils.LoggerUtil;
import org.example.utils.ScreenshotUtil;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;

public class Hooks {

    private static final Logger log = LoggerUtil.getLogger(Hooks.class);

    @Before
    public void setup(Scenario scenario) {

        log.info("STARTING TEST: " + scenario.getName());

        DriverManager.setDriver(DriverFactory.initDriver());

        Allure.label("epic", "UI Tests");
        String featureName = scenario.getId().split(";")[0];
        Allure.label("feature", featureName);
        Allure.label("story", scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {

        WebDriver driver = DriverManager.getDriver();

        if(scenario.isFailed()) {
            byte[] screenshot = ScreenshotUtil.captureScreenshot(driver);
            scenario.attach(screenshot, "image/png", scenario.getName());
            Allure.addAttachment("Failure Screenshot : "+scenario.getName(), new ByteArrayInputStream(screenshot));
        }

        if(driver!=null) {
            driver.quit();
            DriverManager.unload();
        }

        log.info("ENDING TEST: " + scenario.getName()+"\n");
    }
}