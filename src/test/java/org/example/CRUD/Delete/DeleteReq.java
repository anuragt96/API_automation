package org.example.CRUD.Delete;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class DeleteReq {

    ValidatableResponse validatableResponse;
    RequestSpecification requestSpecification;

    @Test
    public void DeleteRequest(){

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/1301");
        requestSpecification.auth().preemptive().basic("admin","password123");
        requestSpecification.contentType(ContentType.JSON);

        Response response1 = requestSpecification.when().delete();

        System.out.println(response1.asString());

        validatableResponse = response1.then().log().all();
        validatableResponse.statusCode(201);

    }
}
