package tests;

import client.ApiClient;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.example.utils.LoggerUtil;
import org.testng.annotations.Test;
import requestBuilders.ProductRequestBuilder;
import validator.ApiValidator;

@Epic("API Tests")
@Feature("Product API")
public class ProductApiTest {

    private static final Logger log = LoggerUtil.getLogger(ProductApiTest.class);

    @Test(priority = 1, description = "VEEVA-11")
    @Story("Get all products")
    public void getAllProducts(){
        log.info("Start of get all products API");
        Response response = ApiClient.get("/api/productsList");

        ApiValidator.validateStatusCode(response);
        ApiValidator.validateResponseCode(response);
        ApiValidator.validateSchema(response);
        log.info("End of get all products API\n");
    }

    @Test(priority = 2, description = "VEEVA-12")
    @Story("Search products")
    public void searchProduct(){
        log.info("Start of search product API");
        Response response = ApiClient.post("/api/searchProduct", ProductRequestBuilder.searchProduct("jean"));

        ApiValidator.validateStatusCode(response);
        ApiValidator.validateResponseCode(response);
        ApiValidator.validateSchema(response);
        log.info("End of search product API\n");
    }

}
