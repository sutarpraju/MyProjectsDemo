package com.FilpkartApplication.utilities;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class ExtentManager {
    private static ExtentReports extent;
    public static String reportFileName;
    private static String fileSeperator=System.getProperty("file.separator");
    private static String reportfilePath=System.getProperty("user.dir")+fileSeperator+"TestReport";
    private static String reportFileLocation= "";

    public static String reportSuitName;

    public static ExtentReports getInstance()
    {
        if (extent== null)
            createInstane();
        return extent;
    }

    public static ExtentReports createInstane()
    {
        Properties pro= new Properties();
        File file=new File(System.getProperty("user.dir")+"\\config.properties");
        FileInputStream fileInput;
        try{
            fileInput=new FileInputStream(file);
            pro.load(fileInput);
        }catch (Exception e)
        {
            e.printStackTrace();
            e.getMessage();
        }

        String url=(pro.getProperty("url"));
        String filename=getReportPath(reportfilePath);

        ExtentSparkReporter htmlReporter= new ExtentSparkReporter(filename);

        DateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
        Date date=new Date();
        String systemDateandTime=dateFormat.format(date);

        htmlReporter.config().enableOfflineMode(true);
        htmlReporter.config().setOfflineMode(true);
        htmlReporter.config().setTheme(Theme.DARK);

        htmlReporter.config().setDocumentTitle(reportSuitName+systemDateandTime);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(reportSuitName);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
        htmlReporter.config().setTimelineEnabled(true);
        htmlReporter.config().setProtocol(Protocol.HTTPS);

        extent=new ExtentReports();
        extent.attachReporter(htmlReporter);

        extent.setAnalysisStrategy(AnalysisStrategy.SUITE);
        extent.setAnalysisStrategy(AnalysisStrategy.TEST);
        extent.setSystemInfo("OS", "Windows");
        extent.setSystemInfo("ENV", "Testing");
        extent.setSystemInfo("URL",url);

        return extent;
    }

    private static  String getReportPath(String path)
    {
        DateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
        Date date=new Date();
        String systemdateandtime=dateFormat.format(date);
        reportFileLocation=reportfilePath+fileSeperator+reportSuitName+".html";

        System.out.println(reportFileLocation);
        File testDirectory= new File(path);
        if (!testDirectory.exists())
        {
            if (testDirectory.mkdir())
            {
                System.out.println("Directory:" + path + "is created");
                return  reportFileLocation;
            }else
            {
                System.out.println("Failed to create directory"+path);
                return System.getProperty("user.dir");
            }
        }else
        {
            System.out.println("Directory Already Exists"+path);
        }
        return reportFileLocation;
    }

    public static  String getsuitName()
    {
        String suitname= reportSuitName;
        return suitname;
    }
}
