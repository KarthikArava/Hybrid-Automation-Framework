package stepDefinitions;

import client.ApiClient;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.example.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.HomePage;
import pages.LoginPage;
import requestBuilder.UserRequestBuilder;
import validator.ApiValidator;

public class Hybrid {

    private static final Logger log = LoggerFactory.getLogger(Hybrid.class);
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    Response createResponse,getResponse;

    @When("the user account created through API request")
    public void theUserAccountCreatedThroughAPIRequest() {
        createResponse = ApiClient.post("/api/createAccount", UserRequestBuilder.createUser());
    }

    @Then("the response should validate")
    public void theResponseShouldValidate() {
        ApiValidator.validateStatusCode(createResponse);
        ApiValidator.validateResponseCode(createResponse,201);
    }

    @Given("the user is on homepage")
    public void theUserIsOnHomepage() {
        homePage.get();
    }

    @When("navigated to login page")
    public void navigatedToLoginPage() {
        homePage.login();
    }

    @And("entered the user credentials that created by API request and click submit")
    public void enteredTheUserCredentialsThatCreatedByAPIRequestAndClickSubmit() {
        loginPage.validatePage();
        loginPage.enterCredentials(Config.get("hybridEmail"),Config.get("password"));
    }

    @Then("the user should login successfully and see the username on the homepage")
    public void theUserShouldLoginSuccessfullyAndSeeTheUsernameOnTheHomepage() {
        homePage.validateUsername(Config.get("username"));
    }

    @When("the user clicks delete account on homepage")
    public void theUserClicksDeleteAccountOnHomepage() {
        homePage.deleteAccount();
    }

    @Then("validate the deletion message in UI {string}")
    public void validateTheDeletionMessageInUI(String msg) {
        homePage.deleteAccValidation(msg);
    }

    @When("the user get the same account through API request")
    public void theUserGetTheSameAccountThroughAPIRequest() {
        getResponse = ApiClient.get("/api/getUserDetailByEmail",UserRequestBuilder.getUser());
    }

    @And("should see the {string} message")
    public void shouldSeeTheAccountNotFoundMessage(String msg) {
        ApiValidator.validateStatusCode(getResponse);
        ApiValidator.validateResponseCode(getResponse,404);
        ApiValidator.validateResponseMessage(getResponse,msg);
    }
}
