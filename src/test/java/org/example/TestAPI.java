package org.example;

import io.restassured.RestAssured;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.testng.annotations.Test;

public class TestAPI
{
        @Test
        public void testAPIGETRequest() {

            RestAssured.given()
                    .baseUri("https://restful-booker.herokuapp.com")
                    .basePath("booking/970")
                    .when().get().then().log().all().statusCode(200);
        }
}