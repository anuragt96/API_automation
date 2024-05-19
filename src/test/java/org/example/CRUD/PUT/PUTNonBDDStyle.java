package org.example.CRUD.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class PUTNonBDDStyle {

    ValidatableResponse validatableResponse;
    RequestSpecification requestSpecification;


    @Test
    public void putRequest(){

        String payload = "{\n" +
                "    \"firstname\" : \"James\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

//        String token_from_previous_request = "498f8371d7ebedf";

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("booking/2382");
//        requestSpecification.headers("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=");
//        requestSpecification.cookie("token", token_from_previous_request);
        requestSpecification.auth().preemptive().basic("admin","password123");
        requestSpecification.contentType(ContentType.JSON);

        //adding body as response
        requestSpecification.body(payload).log().all();

        //calling PUT method
        Response response = requestSpecification.when().put();

        System.out.println(response.asString());

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        validatableResponse.body("firstname", Matchers.equalTo("James"));
    }
}
