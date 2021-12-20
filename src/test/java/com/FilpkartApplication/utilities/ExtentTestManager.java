package com.FilpkartApplication.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import java.util.HashMap;
import java.util.Map;

public class ExtentTestManager {

    public static ExtentTest parent;

    public static ExtentReports extent=ExtentManager.getInstance();
    static Map<Integer, ExtentTest> extentTestMap= new HashMap<Integer, ExtentTest>();

    public static synchronized ExtentTest getTest()
    {
        return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
    }

    public static synchronized void endTest()
    {
        extent.flush();
    }
    public  static  synchronized  ExtentTest startTest(String testName)
    {
        ExtentTestManager.parent=ExtentTestManager.extent.createTest(ExtentManager.reportFileName);
        extentTestMap.put((int) (long) (Thread.currentThread().getId()), parent);
        return parent;
    }
}
