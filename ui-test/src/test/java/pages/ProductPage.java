package pages;

import org.apache.log4j.Logger;
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

public class ProductPage {

    private static final Logger log = LoggerUtil.getLogger(ProductPage.class);
    WebDriver driver;
    JavascriptExecutor js;

    @FindBy(xpath="//a[@href='/products']")
    WebElement productPage;

    @FindBy(xpath="//a[@href='/product_details/1']")
    WebElement firstProd;

    @FindBy(xpath="//div[@class='product-details']/div/div/h2")
    WebElement firstProdName;

    @FindBy(xpath="//button[@type='button']")
    WebElement addToCart;

    public ProductPage() {
        driver = DriverManager.getDriver();
        PageFactory.initElements(driver,this);
        js = (JavascriptExecutor) driver;
    }

    public void productPage() {
        By button = By.xpath("//a[@href='/products']");
        WaitUtil.waitUntilClickable(driver,button);
        log.info("Navigating to products page");
        productPage.click();
        AdHandlerUtil.handleGoogleVignette(driver);
    }

    public void selectProduct() {
        By prod = By.xpath("//a[@href='/product_details/1']");
        WebElement element = driver.findElement(prod);
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", element);
        WaitUtil.waitUntilClickable(driver,prod);
        log.info("Selecting the product");
        firstProd.click();
    }

    public String firstProdName() {
        return firstProdName.getText();
    }

    public void addToCart() {
        log.info("Adding the product to cart");
        addToCart.click();
    }

}
