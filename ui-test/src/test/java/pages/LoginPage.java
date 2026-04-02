package pages;

import org.apache.log4j.Logger;
import org.example.driver.DriverManager;
import org.example.utils.LoggerUtil;
import org.example.utils.WaitUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

    private static final Logger log = LoggerUtil.getLogger(LoginPage.class);
    WebDriver driver;
    JavascriptExecutor js;

    @FindBy(xpath="//h2[text()='Login to your account']")
    WebElement loginText;

    @FindBy(xpath="//input[@data-qa='login-email']")
    WebElement Email;

    @FindBy(xpath="//input[@data-qa='login-password']")
    WebElement password;

    @FindBy(xpath="//button[@data-qa='login-button']")
    WebElement loginButton;

    @FindBy(xpath="//p[text()='Your email or password is incorrect!']")
    WebElement invalidLoginMsg;

    @FindBy(xpath="//h2[text()='New User Signup!']")
    WebElement newUserSignupText;

    @FindBy(xpath="//input[@name='name']")
    WebElement name;

    @FindBy(xpath="//input[@data-qa='signup-email']")
    WebElement email;

    @FindBy(xpath="//button[@data-qa='signup-button']")
    WebElement signup;

    public LoginPage() {
        driver= DriverManager.getDriver();
        PageFactory.initElements(driver,this);
        js = (JavascriptExecutor) driver;
    }

    public void validateLoginUrl(String urlpart) {
        log.info("Validating login URL");
        WaitUtil.waitUntilUrlContains(driver,urlpart);
        Assert.assertTrue(driver.getCurrentUrl().contains(urlpart));
    }

    public void loginTextValidation(String text) {
        log.info("Validating Login text");
        Assert.assertEquals(loginText.getText(),text);
    }

    public void enterCredentials(String email, String pass) {
        log.info("Entering email : "+email+" and password : "+pass);
        Email.sendKeys(email);
        password.sendKeys(pass);
    }

    public void loginButton() {
        By button = By.xpath("//button[@data-qa='login-button']");
        WaitUtil.waitUntilClickable(driver, button);
        log.info("Clicking login button");
        try {
            loginButton.click();
        } catch (Exception e) {
            js.executeScript("arguments[0].click();", loginButton);
        }
    }

    public void invalidLoginValidate(String message) {
        By msgLocator = By.xpath("//p[text()='Your email or password is incorrect!']");
        WaitUtil.waitUntilVisible(driver,msgLocator);
        log.info("Validating invalid details");
        Assert.assertEquals(invalidLoginMsg.getText(),message);
    }

    public void newUserTextValidation(String text) {
        log.info("Validating SignUp text");
        Assert.assertEquals(newUserSignupText.getText(),text);
    }

    public void signUp(String Name, String Email) {
        log.info("Entering name : "+Name+" and email : "+Email);
        name.sendKeys(Name);
        email.sendKeys(Email);
    }

    public void signupButton() {
        By button = By.xpath("//button[@data-qa='signup-button']");
        WaitUtil.waitUntilClickable(driver,button);
        log.info("Clicking signup button and navigating to enter user details");
        try {
            signup.click();
        } catch (Exception e) {
            js.executeScript("arguments[0].click();", signup);
        }
    }

}
