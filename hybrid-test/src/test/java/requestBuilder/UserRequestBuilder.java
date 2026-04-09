package requestBuilder;

import org.apache.log4j.Logger;
import org.example.config.Config;
import org.example.utils.LoggerUtil;

import java.util.HashMap;
import java.util.Map;

public class UserRequestBuilder {

    private static final Logger log = LoggerUtil.getLogger(UserRequestBuilder.class);

    public static Map<String,String> createUser() {

        Map<String,String> body = new HashMap<>();
        log.info("Building create user request payload");

        body.put("name", Config.get("username"));
        body.put("email",Config.get("hybridEmail"));
        body.put("password",Config.get("password"));
        body.put("title","Mr");
        body.put("birth_date","18");
        body.put("birth_month","February");
        body.put("birth_year","2005");
        body.put("firstname","Karthik");
        body.put("lastname","Arava");
        body.put("company","TestCompany");
        body.put("address1","Bantumilli");
        body.put("address2","Satuluru");
        body.put("country","India");
        body.put("zipcode","521324");
        body.put("state","Andhra Pradesh");
        body.put("city","Bhimavaram");
        body.put("mobile_number","9876543210");

        log.info("Request body : "+body.toString());

        return body;
    }

    public static Map<String,String> getUser() {

        Map<String,String> params = new HashMap<>();
        log.info("Building get user request payload");

        params.put("email",Config.get("hybridEmail"));

        log.info("Request parameters : "+params.toString());

        return params;
    }
}