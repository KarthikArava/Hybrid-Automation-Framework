package requestBuilders;

import org.apache.log4j.Logger;
import org.example.utils.LoggerUtil;

import java.util.HashMap;
import java.util.Map;

public class UserRequestBuilder {

    private static final Logger log = LoggerUtil.getLogger(UserRequestBuilder.class);

    public static Map<String,String> createUser() {

        Map<String,String> body = new HashMap<>();
        log.info("Building create user request payload");

        body.put("name","Karthik");
        body.put("email","karthikarava@test.com");
        body.put("password","karthik");
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

    public static Map<String,String> updateUser() {

        Map<String,String> body = new HashMap<>();
        log.info("Building update user request payload");

        body.put("name","Karthikeya");
        body.put("email","karthikarava@test.com");
        body.put("password","karthik");
        body.put("birth_date","18");
        body.put("birth_month","June");
        body.put("birth_year","2004");
        body.put("address2","Satuluru bangla");
        body.put("zipcode","521369");

        log.info("Request body : "+body.toString());

        return body;
    }

    public static Map<String,String> deleteUser() {

        Map<String,String> body = new HashMap<>();
        log.info("Building delete user request payload");

        body.put("email","karthikarava@test.com");
        body.put("password","karthik");

        log.info("Request body : "+body.toString());

        return body;
    }
}