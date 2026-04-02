package pages;

import org.apache.log4j.Logger;
import org.example.config.Config;
import org.example.driver.DriverManager;
import org.example.utils.LoggerUtil;
import org.example.utils.AdHandlerUtil;
import org.example.utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {

    private static final Logger log = LoggerUtil.getLogger(HomePage.class);
    WebDriver driver;
    JavascriptExecutor js;

    @FindBy(xpath="//a[@href='/login']")
    WebElement signup;

    @FindBy(xpath="//a[@href='/delete_account']")
    WebElement deleteAccButton;

    @FindBy(xpath="//b[text()='Account Deleted!']")
    WebElement deleteAccMsg;

    @FindBy(xpath="//a[@data-qa='continue-button']")
    WebElement deleteContinueButton;

    @FindBy(xpath="//*[@id='header']/div/div/div/div[2]/div/ul/li[10]/a/b")
    WebElement nameOnHomePage;

    public HomePage() {
        driver = DriverManager.getDriver();
        PageFactory.initElements(driver,this);
        js = (JavascriptExecutor) driver;
    }

    public void get() {
        log.info("Opening the base URL");
        driver.get(Config.get("baseUrl"));
    }

    public void clickSignup() {
        log.info("Navigating to signup/login page");
        signup.click();
    }

    public void accNameValidate(String username) {
        By msgLocator = By.xpath("//*[@id='header']/div/div/div/div[2]/div/ul/li[10]/a/b");
        WaitUtil.waitUntilVisible(driver,msgLocator);
        log.info("Validating the user account with username");
        Assert.assertEquals(nameOnHomePage.getText(),username);
    }

    public void deleteAcc() {
        AdHandlerUtil.handleGoogleVignette(driver);
        By button = By.xpath("//a[@href='/delete_account']");
        WaitUtil.waitUntilClickable(driver,button);
        log.info("Deleting the account created");
        try {
            deleteAccButton.click();
        } catch (Exception e) {
            js.executeScript("arguments[0].click();", deleteAccButton);
        }
        AdHandlerUtil.handleGoogleVignette(driver);

    }

    public void deleteAccValidation(String msg) {
        By msgLocator = By.xpath("//b[text()='Account Deleted!']");
        WaitUtil.waitUntilVisible(driver,msgLocator);
        log.info("Validating the account deleted");
        Assert.assertEquals(deleteAccMsg.getText(),msg);
    }

    public void deleteAccContinue() {
        By button = By.xpath("//a[@data-qa='continue-button']");
        WaitUtil.waitUntilClickable(driver,button);
        try {
            deleteContinueButton.click();
        } catch (Exception e) {
            js.executeScript("arguments[0].click();", deleteContinueButton);
        }
    }

}
