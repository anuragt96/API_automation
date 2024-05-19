package org.example.practice;

import org.testng.IExecutionListener;

public class CustomListener implements IExecutionListener {

    @Override
    public void onExecutionStart() {
        long StartTime= System.currentTimeMillis();
        System.out.println("Started execution at : "+ StartTime+ "*********");

    }

    @Override
    public void onExecutionFinish() {
        long endTime = System.currentTimeMillis();
        System.out.println("Finished execution in : "+ endTime+ "*********");
    }
}
