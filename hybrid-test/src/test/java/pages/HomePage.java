package pages;

import org.apache.log4j.Logger;
import org.example.config.Config;
import org.example.driver.DriverManager;
import org.example.utils.AdHandlerUtil;
import org.example.utils.LoggerUtil;
import org.example.utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {

    WebDriver driver;
    private static final Logger log = LoggerUtil.getLogger(HomePage.class);

    @FindBy(xpath = "//a[@href='/login']")
    WebElement login;

    @FindBy(xpath="//a[@href='/delete_account']")
    WebElement deleteAccButton;

    @FindBy(xpath="//b[text()='Account Deleted!']")
    WebElement deleteAccMsg;

    @FindBy(xpath="//a[@data-qa='continue-button']")
    WebElement deleteContinueButton;

    @FindBy(xpath="//*[@id='header']/div/div/div/div[2]/div/ul/li[10]/a/b")
    WebElement nameOnHomePage;

    public HomePage(){
        driver = DriverManager.getDriver();
        PageFactory.initElements(driver,this);
    }

    public void get() {
        log.info("Opening base URL");
        driver.get(Config.get("baseUrl"));
    }

    public void login() {
        log.info("Navigating to login page");
        login.click();
    }

    public void validateUsername(String username) {
        log.info("Validating username");
        WaitUtil.waitUntilVisible(driver,By.xpath("//*[@id='header']/div/div/div/div[2]/div/ul/li[10]/a/b"));
        Assert.assertEquals(nameOnHomePage.getText(),username);
    }

    public void deleteAccount() {
        log.info("Deleting account in UI");
        AdHandlerUtil.handleGoogleVignette(driver);
        WaitUtil.waitUntilClickable(driver,By.xpath("//a[@href='/delete_account']"));
        deleteAccButton.click();
        AdHandlerUtil.handleGoogleVignette(driver);
    }

    public void deleteAccValidation(String msg) {
        WaitUtil.waitUntilVisible(driver,By.xpath("//b[text()='Account Deleted!']"));
        Assert.assertEquals(deleteAccMsg.getText(),msg);
        WaitUtil.waitUntilClickable(driver,By.xpath("//a[@data-qa='continue-button']"));
        deleteContinueButton.click();
    }
}
