package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;

public class Base {

    HomePage homepage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Given("user is on the home page")
    public void userIsOnTheHomePage(){
        homepage.get();
    }

    @When("user clicks on signup login")
    public void userClicksOnSignupLogin() {
        homepage.clickSignup();
    }

    @Then("user should navigate to login page")
    public void userShouldNavigatesToLoginPage() {
        loginPage.validateLoginUrl("login");
    }

}
