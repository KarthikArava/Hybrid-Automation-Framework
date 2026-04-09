package pages;

import org.apache.log4j.Logger;
import org.example.driver.DriverManager;
import org.example.utils.LoggerUtil;
import org.example.utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

    WebDriver driver;
    private static final Logger log = LoggerUtil.getLogger(LoginPage.class);

    @FindBy(xpath="//h2[text()='Login to your account']")
    WebElement loginText;

    @FindBy(xpath="//input[@data-qa='login-email']")
    WebElement Email;

    @FindBy(xpath="//input[@data-qa='login-password']")
    WebElement password;

    @FindBy(xpath="//button[@data-qa='login-button']")
    WebElement loginButton;

    public LoginPage(){
        driver = DriverManager.getDriver();
        PageFactory.initElements(driver,this);
    }

    public void enterCredentials(String email, String pass) {
        log.info("Entering login credentials");
        Email.sendKeys(email);
        password.sendKeys(pass);
        log.info("Clicking login button");
        WaitUtil.waitUntilClickable(driver, By.xpath("//button[@data-qa='login-button']"));
        loginButton.click();
    }

    public void validatePage() {
        log.info("Validating login page");
        WaitUtil.waitUntilUrlContains(driver,"login");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
        Assert.assertEquals(loginText.getText(),"Login to your account");
    }
}
