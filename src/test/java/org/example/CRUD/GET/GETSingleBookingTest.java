package org.example.CRUD.GET;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.requestSpecification;

public class GETSingleBookingTest {

    @Test
    public void testSingle(){

        RestAssured.given().
                baseUri("https://restful-booker.herokuapp.com/booking")
                .basePath("/970").when().get().then().log().all().statusCode(200);
    }

    public static class NonBDDStyle {

        @Test
        public void NonBDDStyleTest(){

            //in BDD framework duplicacy of the test cases are increased that's why some QAs use nonBDD file
            RequestSpecification requestSpecification = RestAssured.given();
            requestSpecification.baseUri("https://restful-booker.herokuapp.com/booking");
            requestSpecification.basePath("/970").when().get();
            requestSpecification.then().statusCode(200);
        }
        @Test
        public void NonBDDStyleTest2(){

            //in BDD framework duplicacy of the test cases are increased that's why some QAs use nonBDD file
            requestSpecification.when().post();
            requestSpecification.then().statusCode(200);
        }
    }
}
