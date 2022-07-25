package com.company.swaglabs.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class MyListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Start: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Success of test cases and its details are : " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Failure of test cases and its details are : " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Skip of test cases and its details are : " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Failure of test cases and its details are : " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {
    }
}

