package requestBuilders;

import org.apache.log4j.Logger;
import org.example.utils.LoggerUtil;

import java.util.HashMap;
import java.util.Map;

public class ProductRequestBuilder {

    private static final Logger log = LoggerUtil.getLogger(ProductRequestBuilder.class);

    public static Map<String,String> searchProduct(String product){

        Map<String,String> body = new HashMap<>();
        log.info("Building search product payload");

        body.put("search_product", product);

        log.info("Request body : "+body.toString());

        return body;
    }
}