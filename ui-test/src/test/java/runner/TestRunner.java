package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(

        features = "src/test/resources/features",
        glue = {"stepDefinitions", "hooks"},
        plugin = {
                "pretty",
                "html:reports/cucumber-report.html",
                "json:reports/cucumber-report.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },
//        tags = "@UI",
        monochrome = true,
        publish = false

)

public class TestRunner extends AbstractTestNGCucumberTests {
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}