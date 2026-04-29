package tests;

import client.ApiClient;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.example.utils.LoggerUtil;
import org.testng.annotations.Test;
import requestBuilders.UserRequestBuilder;
import validator.ApiValidator;

@Epic("API Tests")
@Feature("User API")
public class UserApiTest {

    private static final Logger log = LoggerUtil.getLogger(UserApiTest.class);

    @Test(priority = 3, description = "VEEVA-8")
    @Story("Create user")
    public void createUser(){
        log.info("Start of create user API");
        Response response = ApiClient.post("/api/createAccount", UserRequestBuilder.createUser());

        ApiValidator.validateStatusCode(response);
        ApiValidator.validateResponseCode(response,201);
        ApiValidator.validateResponseMessage(response,"User created!");
        log.info("End of create user API\n");
    }

    @Test(priority = 4, dependsOnMethods = "createUser", description = "VEEVA-9")
    @Story("Update user")
    public void updateUser(){
        log.info("Start of update user API");
        Response response = ApiClient.put("/api/updateAccount", UserRequestBuilder.updateUser());

        ApiValidator.validateStatusCode(response);
        ApiValidator.validateResponseCode(response);
        ApiValidator.validateResponseMessage(response,"User updated!");
        log.info("End of update user API\n");
    }

    @Test(priority = 5, dependsOnMethods = "createUser", description = "VEEVA-10")
    @Story("Delete user")
    public void deleteUser(){
        log.info("Start of delete user API");
        Response response = ApiClient.delete("/api/deleteAccount",UserRequestBuilder.deleteUser());

        ApiValidator.validateStatusCode(response);
        ApiValidator.validateResponseCode(response);
        ApiValidator.validateResponseMessage(response,"Account deleted!");
        log.info("End of delete user API\n");
    }

}