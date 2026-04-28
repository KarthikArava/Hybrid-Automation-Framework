package tests;

import client.ApiClient;
import io.qameta.allure.Description;
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

    @Test(priority = 3)
    @Story("Create user")
    @Description("VEEVA-8")
    public void VEEVA_8_createUser(){
        log.info("Start of create user API");
        Response response = ApiClient.post("/api/createAccount", UserRequestBuilder.createUser());

        ApiValidator.validateStatusCode(response);
        ApiValidator.validateResponseCode(response,201);
        ApiValidator.validateResponseMessage(response,"User created!");
        log.info("End of create user API\n");
    }

    @Test(priority = 4, dependsOnMethods = "createUser")
    @Story("Update user")
    @Description("VEEVA-9")
    public void VEEVA_9_updateUser(){
        log.info("Start of update user API");
        Response response = ApiClient.put("/api/updateAccount", UserRequestBuilder.updateUser());

        ApiValidator.validateStatusCode(response);
        ApiValidator.validateResponseCode(response);
        ApiValidator.validateResponseMessage(response,"User updated!");
        log.info("End of update user API\n");
    }

    @Test(priority = 5, dependsOnMethods = "createUser")
    @Story("Delete user")
    @Description("VEEVA-10")
    public void VEEVA_10_deleteUser(){
        log.info("Start of delete user API");
        Response response = ApiClient.delete("/api/deleteAccount",UserRequestBuilder.deleteUser());

        ApiValidator.validateStatusCode(response);
        ApiValidator.validateResponseCode(response);
        ApiValidator.validateResponseMessage(response,"Account deleted!");
        log.info("End of delete user API\n");
    }

}