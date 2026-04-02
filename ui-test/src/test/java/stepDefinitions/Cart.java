package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CartPage;
import pages.ProductPage;

public class Cart {

    ProductPage productPage = new ProductPage();
    CartPage cartPage = new CartPage();
    String firstProd, cartProd;

    @When("user navigates to products page")
    public void userNavigatesToProductsPage() {
        productPage.productPage();
    }

    @And("user adds the first product to the cart")
    public void userAddsTheFirstProductToTheCart() {
        productPage.selectProduct();
        firstProd = productPage.firstProdName();
        productPage.addToCart();
    }

    @And("user clicks view cart")
    public void userClicksViewCart() {
        cartPage.viewCart();
    }

    @Then("product should be visible in the cart")
    public void productShouldBeVisibleInTheCart() {
        cartProd = cartPage.cartProdName();
        Assert.assertEquals(cartProd,cartProd);
    }

    @When("user removes the product from cart")
    public void userRemovesTheProductFromCart() {
        cartPage.removeCartProd();
    }

    @Then("cart should display {string}")
    public void cartShouldBeEmpty(String message) {
        cartPage.emptyCartValidate(message);
    }
}
