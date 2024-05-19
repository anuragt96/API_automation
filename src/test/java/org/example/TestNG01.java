package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNG01 {

    @Test
    public void HardAssertionTest(){
        System.out.println("Before");
        int id = 3;
        Assert.assertEquals(id,4);
        System.out.println("After");
    }

    @Test
    public void SoftAssertion(){
        System.out.println("Before");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(2,4);
        System.out.println("after");
    }
}
