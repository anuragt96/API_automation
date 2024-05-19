package org.example.IntegrationScenario;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class PostNPut {

    // post - create a token
    //post - get a token
    //pass the token to PUT

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    String token,ID;
    Integer Booking_id;


    @Test(priority = 1)
    public void createToken(){

        String payload = " {\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                " }";

        //Non BDD style
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/auth");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload);
        Response response = requestSpecification.when().post();
        validatableResponse = response.then();

        token = response.then().extract().path("token");
        System.out.println("Token --> " + token);

        validatableResponse.body("token", Matchers.notNullValue());
        validatableResponse.body("token.length()", Matchers.is(15));

    }

    @Test(priority = 2)
    public void CreateBooking(){

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

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("booking");
        requestSpecification.contentType(ContentType.JSON);

        //adding body as response
        requestSpecification.body(payload).log().all();

        //calling PUT method
        Response response = requestSpecification.when().post();

        System.out.println(response.asString());

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        validatableResponse.body("booking.firstname", Matchers.equalTo("James"));

        Booking_id = response.then().extract().path("bookingid");
        System.out.println(Booking_id);

    }

    @Test(priority = 3)
    public void UpdateBookingWithTokenID(){

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

//        requestSpecification = RestAssured.given();
        requestSpecification.basePath("/booking/" + Booking_id);
//        requestSpecification.headers("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=");
        requestSpecification.cookie("token", token);
//        requestSpecification.auth().preemptive().basic("admin","password123");
        requestSpecification.contentType(ContentType.JSON);

        //adding body as response
        requestSpecification.body(payload).log().all();

        //calling PUT method
        Response response = requestSpecification.put();

        System.out.println(response.asString());

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        validatableResponse.body("firstname", Matchers.equalTo("James"));

    }



}
