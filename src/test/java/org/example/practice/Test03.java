package org.example.practice;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class Test03 {

    @Test(groups = "sanity")
    public void test1(){
        System.out.println("test 1");
    }


    @Test(groups = "sanity")
    public void test2(){
        System.out.println("test 2");
    }


    @Test(groups = "sanity")
    public void test3(){
        System.out.println("test 3");
    }



}
