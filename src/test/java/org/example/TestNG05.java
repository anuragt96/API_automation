package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG05 {

    //1 --> sanity
    //2 -> QA
    //3-> Regression

    @Test(groups = {"QA", "Sanity"})
    public void sanityRun()
    {
        System.out.println("QA");
        System.out.println("Sanity");
    }

    @Test(groups = {"QA", "Preprod"})
    public void QARun()
    {
        System.out.println("QA");
        System.out.println("PreProd");
    }

    @Test(groups = {"smoke", "PROD"})
    public void ProdRun()
    {
        System.out.println("smoke");
        System.out.println("PROD");
        Assert.assertTrue(false);
    }
}
