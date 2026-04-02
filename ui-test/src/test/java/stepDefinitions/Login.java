package stepDefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.config.Config;
import pages.HomePage;
import pages.LoginPage;

public class Login {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @And("user see login {string}")
    public void userSeeLogin(String text) {
        loginPage.loginTextValidation(text);
    }

    @And("user clicks login button")
    public void userClicksLoginButton() {
        loginPage.loginButton();
    }

    @Then("user should see error message {string}")
    public void userShouldSeeErrorMessage(String message) {
        loginPage.invalidLoginValidate(message);
    }

    @When("user enters valid credentials")
    public void userEntersValidCredentials() {
        String email = Config.get("validEmail");
        String password = Config.get("password");
        loginPage.enterCredentials(email,password);
    }

    @Then("user should see valid username on home page")
    public void userShouldSeeValidUsernameOnHomePage() {
        String username = Config.get("validUsername");
        homePage.accNameValidate(username);
    }

    @When("user enters invalid credentials")
    public void userEntersInvalidCredentials() {
        String email = Config.get("invalidEmail");
        String password = Config.get("password");
        loginPage.enterCredentials(email,password);
    }
}
