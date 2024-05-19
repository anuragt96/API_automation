package org.example.CRUD.Postreq;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.example.POJOClasses.Auth;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class BDDStylePost {

    @Test
    public void testBDDPost(){

        // verify that when we pass payload(username and pwd) then URl should give 200 OK status
        //URL - https://restful-booker.herokuapp.com
        // basepath - /auth
        //status code - 200
        //payload can be taken in as string,hashmap and in pojo class

        Auth auth = new Auth();
        auth.setUsername("admin");
        auth.setPassword("password123");

//        String payload = " {\n" +
//                "    \"username\" : \"admin\",\n" +
//                "    \"password\" : \"password123\"\n" +
//                " }";

        RestAssured.given().baseUri("https://restful-booker.herokuapp.com")
                .basePath("/auth")
                .contentType(ContentType.JSON)
                .body(auth)
                .when().post()
                .then().log().all().assertThat()
                .statusCode(200)
                .body("token", Matchers.notNullValue());


        //Non BDD style
        RequestSpecification requestSpecification = RestAssured.given();

        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/auth");
        requestSpecification.contentType(ContentType.JSON);

        Response response = requestSpecification.when().post();

        ValidatableResponse validatableResponse = response.then();
        //ValidatableResponse token = validatableResponse.body("token", Matchers.notNullValue());
        validatableResponse.body("token.length()", Matchers.is(15));



    }
}
