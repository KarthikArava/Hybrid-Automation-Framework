package pages;

import io.cucumber.datatable.DataTable;
import org.apache.log4j.Logger;
import org.example.driver.DriverManager;
import org.example.utils.LoggerUtil;
import org.example.utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.Map;

public class SignupPage {

    private static final Logger log = LoggerUtil.getLogger(SignupPage.class);
    WebDriver driver;
    JavascriptExecutor js;

    @FindBy(xpath="//b[text()='Account Created!']")
    WebElement accCreatedText;

    @FindBy(xpath="//input[@value='Mr']")
    WebElement title;

    @FindBy(xpath="//input[@type='password']")
    WebElement password;

    @FindBy(xpath="//select[@id='days']")
    WebElement day;

    @FindBy(xpath="//select[@id='months']")
    WebElement month;

    @FindBy(xpath="//select[@id='years']")
    WebElement year;

    @FindBy(xpath="//input[@data-qa='first_name']")
    WebElement firstName;

    @FindBy(xpath="//input[@data-qa='last_name']")
    WebElement lastName;

    @FindBy(xpath="//input[@data-qa='address']")
    WebElement address;

    @FindBy(xpath="//input[@data-qa='state']")
    WebElement state;

    @FindBy(xpath="//input[@data-qa='city']")
    WebElement city;

    @FindBy(xpath="//input[@data-qa='zipcode']")
    WebElement zipcode;

    @FindBy(xpath="//input[@data-qa='mobile_number']")
    WebElement number;

    @FindBy(xpath="//button[@data-qa='create-account']")
    WebElement createAccount;

    @FindBy(xpath="//a[@data-qa='continue-button']")
    WebElement continueButton;


    public SignupPage() {
        driver = DriverManager.getDriver();
        PageFactory.initElements(driver,this);
        js = (JavascriptExecutor) driver;
    }

    public void validateSignupUrl(String urlPart) {
        log.info("Validating signup URL");
        WaitUtil.waitUntilUrlContains(driver,urlPart);
        Assert.assertTrue(driver.getCurrentUrl().contains(urlPart));
    }

    public void accInfo(DataTable table) {
        log.info("Entering account information");
        Map<String, String> data = table.asMap(String.class, String.class);
        title.click();
        password.sendKeys(data.get("password"));
        day.sendKeys(data.get("day"));
        month.sendKeys(data.get("month"));
        year.sendKeys(data.get("year"));
    }

    public void scrollPage() {
        js.executeScript("window.scrollBy(0,500)");
    }

    public void addInfo(DataTable table) {
        log.info("Entering additional information");
        Map<String, String> data = table.asMap(String.class, String.class);
        firstName.sendKeys(data.get("first name"));
        lastName.sendKeys(data.get("last name"));
        address.sendKeys(data.get("address"));
        js.executeScript("window.scrollBy(0,500)");
        state.sendKeys(data.get("state"));
        city.sendKeys(data.get("city"));
        zipcode.sendKeys(data.get("zipcode"));
        number.sendKeys(data.get("mobile number"));
    }

    public void createAcc() {
        By button = By.xpath("//button[@data-qa='create-account']");
        WaitUtil.waitUntilClickable(driver,button);
        log.info("Submitting the details");
        try {
            createAccount.click();
        } catch (Exception e) {
            js.executeScript("arguments[0].click();", createAccount);
        }
    }

    public void accCreateValidate(String text) {
        By msgLocator = By.xpath("//b[text()='Account Created!']");
        WaitUtil.waitUntilVisible(driver,msgLocator);
        Assert.assertEquals(accCreatedText.getText(),text);
    }

    public void continueButton() {
        By button = By.xpath("//a[@data-qa='continue-button']");
        WaitUtil.waitUntilClickable(driver,button);
        try {
            continueButton.click();
        } catch (Exception e) {
            js.executeScript("arguments[0].click();", continueButton);
        }
    }


}
