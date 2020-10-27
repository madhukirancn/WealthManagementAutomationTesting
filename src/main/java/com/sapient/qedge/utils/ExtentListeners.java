package com.sapient.qedge.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentListeners implements ITestListener {
    private final ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();
    private final ThreadLocal<ExtentTest> childTest = new ThreadLocal<ExtentTest>();
    public ExtentReports extents = new ExtentReports();
    public ExtentTest extentTest;
    String htmlPath = System.getProperty("user.dir") + "\\reports\\MainReport.html";
    public ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter(htmlPath);

    public void onStart(ITestContext context) {
        extentHtmlReporter.config().setDocumentTitle("Wealth Management Testing Report");
        extentHtmlReporter.config().setReportName("WM Automation testing");
        extents.attachReporter(extentHtmlReporter);
        extentTest = extents.createTest(context.getName());
        parentTest.set(extentTest);
    }

    public ExtentTest createChild(ITestResult result) {
        ExtentTest child = parentTest.get().createNode(result.getName());
        return child;
    }

    public void onTestStart(ITestResult result) {
        childTest.set(createChild(result));
        childTest.get().info("Starting test:" + result.getName());
        childTest.get().info(result.getMethod().getDescription());
    }

    public void onTestSuccess(ITestResult result) {
        childTest.get().pass("Test Passed");
    }

    public void onTestFailure(ITestResult result) {
        childTest.get().fail("Test Failed:\n" + result.getThrowable().getMessage());
    }


    public void onFinish(ITestContext context) {
        extents.flush();
    }


}
