package org.example;
import org.testng.annotations.Test;

public class TestNG04 {

    @Test(priority = 1)
    public void getReq(){
        System.out.println("RA GET req");
    }
    @Test(priority = 2)
    public void PostReq(){
        System.out.println("RA POST req");
    }
    @Test(priority = 3)
    public void patchReq(){
        System.out.println("RA PATCH req");
    }
    @Test(priority = 4)
    public void DelReq(){
        System.out.println("RA DELETE req");
    }
}
