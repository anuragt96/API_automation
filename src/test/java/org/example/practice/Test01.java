package org.example.practice;

import org.testng.annotations.Test;

public class Test01 {

    @Test
    public void serverStartedOk(){
        System.out.println("I will start the server");
    }

    @Test(dependsOnMethods = "serverStartedOk")
    public void afterServerStart(){
        System.out.println("After server start");
    }


}
