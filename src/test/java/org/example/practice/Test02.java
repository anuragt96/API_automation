package org.example.practice;

import org.testng.annotations.Test;

public class Test02 {

    @Test(groups = {"init"})
    public void serverStart(){
        System.out.println("1. server start");
    }

    @Test(groups = {"init"})
    public void initEnv(){
        System.out.println("2. initEnv");
    }

    @Test(dependsOnGroups = {"init.*"})
    public void method1(){
        System.out.println("test case 1");
    }


}
