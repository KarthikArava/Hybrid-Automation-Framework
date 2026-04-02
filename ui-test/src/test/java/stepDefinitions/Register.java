package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.config.Config;
import pages.HomePage;
import pages.LoginPage;
import pages.SignupPage;

public class Register {

    SignupPage signupPage = new SignupPage();
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @And("user see signup {string}")
    public void userSeeSignup(String text) {
        loginPage.newUserTextValidation(text);
    }

    @When("user enters name and email")
    public void userEntersNameAndEmail() {
        String name = Config.get("registerName");
        String email = Config.get("registerEmail");
        loginPage.signUp(name,email);
    }

    @And("user clicks signup button")
    public void userClicksSignupButton() {
        loginPage.signupButton();
    }

    @Then("user should navigate to signup page")
    public void userShouldNavigateToSignupPage() {
        signupPage.validateSignupUrl("signup");
    }

    @When("user enters account information")
    public void userEntersAccountInformation(DataTable data) {
        signupPage.accInfo(data);
    }

    @And("user scrolls the page")
    public void userScrollsThePage() {
        signupPage.scrollPage();
    }

    @And("user enters address information")
    public void userEntersAddressInformation(DataTable data) {
        signupPage.addInfo(data);
    }

    @And("user clicks create account button")
    public void userClicksCreateAccountButton() {
        signupPage.createAcc();
    }

    @Then("user should see {string}")
    public void userShouldSeeAccountCreated(String text) {
        signupPage.accCreateValidate(text);
    }

    @When("user clicks continue button")
    public void userClicksContinueButton() {
        signupPage.continueButton();
    }

    @Then("user should see registered username on home page")
    public void userShouldSeeRegisteredUsernameOnHomePage() {
        String username = Config.get("registerName");
        homePage.accNameValidate(username);
    }

    @And("user click delete account")
    public void userClickDeleteAccount() {
        homePage.deleteAcc();
    }

    @When("user see delete account message {string}")
    public void userSeeDeleteAccountMessage(String msg) {
        homePage.deleteAccValidation(msg);
    }

    @Then("click continue")
    public void clickContinue() {
        homePage.deleteAccContinue();
    }
}
