package org.example.CRUD.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PUTDemoHashmap {

    @Test
    public  void putDemo() {

        ValidatableResponse validatableResponse;
        RequestSpecification requestSpecification;

        //we can convert the payload into the hashmap because managing everything in string
        // variable is difficult in automation

        //JSON Object

        Map<String, Object> jsonBody = new HashMap<>();
        jsonBody.put("firstname", "James");
        jsonBody.put("lastname", "Brown");
        jsonBody.put("totalprice", 111);
        jsonBody.put("depositpaid", true);

        Map<String,Object> bookingdatesMap = new HashMap<>();
        bookingdatesMap.put("checkin", "2018-01-01");
        bookingdatesMap.put("checkout", "2019-01-01");
        jsonBody.put("bookingdates",bookingdatesMap);
        jsonBody.put("additionalneeds","Breakfast");
        System.out.println(jsonBody);


        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("booking/2382");
//        requestSpecification.headers("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=");
//        requestSpecification.cookie("token", token_from_previous_request);
        requestSpecification.auth().preemptive().basic("admin","password123");
        requestSpecification.contentType(ContentType.JSON);

        //adding body as response
        requestSpecification.body(jsonBody).log().all();

        //calling PUT method
        Response response = requestSpecification.when().put();

        System.out.println(response.asString());

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        validatableResponse.body("firstname", Matchers.equalTo("James"));

    }
}
