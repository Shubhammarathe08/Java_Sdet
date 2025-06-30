package org.example.selenium;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Test;

/*
    default void onTestStart(ITestResult result)  // works on methods

    default void onTestSuccess(ITestResult result) //pass each time
    default void onTestFailure(ITestResult result) //fail each time
    default void onTestSkipped(ITestResult result) //skip each time

    default void onTestFailedButWithinSuccessPercentage(ITestResult result) // failed with certain pass % each time
    default void onTestFailedWithTimeout(ITestResult result) //failed due to - time over each time
    default void onStart(ITestContext context) //on start - execution of all test cases - Test > class
    default void onFinish(ITestContext context) //on finish - all test all cases execution - Test > class
* */
public class MyListner implements ITestListener {
    // either >> implement - ITestListener | public class ITestListener implements ITestListener + over ride
    // or extends adapter - TestListenerAdapter | public class MyListener extends TestListenerAdapter + over ride
    // Adapter class - empty implementation of methods of interface

    public void onTestStart(ITestResult result) {
        System.out.println("onTestStart: " + result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess: " + result.getName());
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("onTestFailure: " + result.getName());
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("onTestSkipped: " + result.getName());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("onTestFailedButWithinSuccessPercentage: " + result.getName());
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println("onTestFailedWithTimeout: " + result.getName());
        this.onTestFailure(result);
    }

    public void onStart(ITestContext context) {
        System.out.println("onStart: " + context.getName());
    }

    public void onFinish(ITestContext context) {
        System.out.println("onFinish: " + context.getName());
    }
}
