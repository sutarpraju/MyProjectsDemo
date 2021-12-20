package com.FilpkartApplication.Base;

import com.FilpkartApplication.utilities.ReadConfig;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class baseFunctions<test> {
    public static WebDriver driver;
    ReadConfig readConfig=new ReadConfig();
    public String BaseUrl=readConfig.getApplicationUrl();
    public String typeOfBrowser=readConfig.getBrowserName();
    public static ExtentReports extent;
    public static ExtentSparkReporter sparkReporter;
    public static ExtentTest test;

    public void setup()
    {
        if (typeOfBrowser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }else if (typeOfBrowser.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver= new ChromeDriver();
        }else if (typeOfBrowser.equalsIgnoreCase("IE"))
        {
            WebDriverManager.iedriver().setup();
            driver=new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(BaseUrl);
    }

    public void tearDown()
    {
        driver.quit();
    }

    public void extentReporting(String path)
    {
        extent = new ExtentReports();
        sparkReporter = new ExtentSparkReporter(path);
        extent.attachReporter(sparkReporter);
    }

    public void flushExtent()
    {
        extent.flush();
    }
    public void captureScreenshot(WebDriver driver, String FolderName)
    {
        try {
            TakesScreenshot ts=(TakesScreenshot) driver;
            File source=ts.getScreenshotAs(OutputType.FILE);
            File target=new File("C:\\Users\\prajakta_sutar\\IdeaProjects\\FilpkartApplication\\Screenshots\\"+FolderName+".png");
            FileUtils.copyFile(source,target);
            System.out.println("Screenshot Taken");
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
}
