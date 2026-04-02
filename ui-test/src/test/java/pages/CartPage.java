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

public class CartPage {

    private static final Logger log = LoggerUtil.getLogger(CartPage.class);
    WebDriver driver;

    @FindBy(xpath="//u[text()='View Cart']")
    WebElement viewCart;

    @FindBy(xpath="//a[@href='/product_details/1']")
    WebElement cartProductName;

    @FindBy(xpath="//a[@class='cart_quantity_delete']")
    WebElement removeProd;

    @FindBy(xpath="//b[text()='Cart is empty!']")
    WebElement cartEmptyText;

    public CartPage() {
        driver = DriverManager.getDriver();
        PageFactory.initElements(driver,this);
    }

    public void viewCart() {
        By button = By.xpath("//u[text()='View Cart']");
        WaitUtil.waitUntilVisible(driver,button);
        log.info("Navigating to cart page");
        viewCart.click();
    }

    public String cartProdName() {
        By prod = By.xpath("//a[@href='/product_details/1']");
        WaitUtil.waitUntilClickable(driver,prod);
        return cartProductName.getText();
    }

    public void removeCartProd () {
        log.info("Removing product from cart");
        removeProd.click();
    }

    public void emptyCartValidate(String message) {
        By msg = By.xpath("//b[text()='Cart is empty!']");
        WaitUtil.waitUntilVisible(driver,msg);
        log.info("Validating empty cart");
        Assert.assertEquals(cartEmptyText.getText(),message);
    }

}
