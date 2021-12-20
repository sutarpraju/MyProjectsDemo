package com.FilpkartApplication.TestCases;

import com.FilpkartApplication.Base.baseFunctions;
import com.FilpkartApplication.Methods.MainPageMethods;
import com.FilpkartApplication.Methods.samsungMobileMethods;
import com.FilpkartApplication.PageObjects.MainSearchPageObjects;
import com.FilpkartApplication.utilities.ExcelDataProvider;
import org.apache.poi.ss.formula.functions.T;
import org.testng.annotations.*;

import java.io.IOException;

public class TC_Verify_flipkartApplication extends baseFunctions
{
    MainPageMethods mainPageMethods;
    samsungMobileMethods mobileMethods;
    String ExcelName="Verify_flipkartMainPage";
    String sheetName="Search_Mobiles";
    String TestCaseName="TC_Verify_flipkartApplication";

    @BeforeSuite
    public void generateExtentReports()
    {
        extentReporting("C:\\Users\\prajakta_sutar\\IdeaProjects\\FilpkartApplication\\test-output\\"+" "+TestCaseName+".html");
    }
    @BeforeMethod
    public void setupTest()
    {
        setup();
        mainPageMethods= new MainPageMethods();
        mobileMethods= new samsungMobileMethods();
    }
    @Test(dataProvider = "TestdataProvider")
    public void Search_Mobiles(String searchItems,String MaxPriceFilter)
    {
        test = extent.createTest(TestCaseName);
        mainPageMethods.closeLoginPopup();
        captureScreenshot(driver,"LoginPopUp Closed");
        mainPageMethods.searchString(searchItems);
        captureScreenshot(driver,"Search Items");
        mobileMethods.setPriceFilter(MaxPriceFilter);
        captureScreenshot(driver,"Max Price Filter");
        mobileMethods.selectRamFilter();
        captureScreenshot(driver,"RAM Filter");
        mobileMethods.selectProcessorFilter();
        captureScreenshot(driver,"Processor Filter");
    }

    @AfterMethod
    public void tearDownTest()
    {
        tearDown();
    }

    @AfterSuite
    public void clearExtent(){
        flushExtent();
    }

    @DataProvider
    public Object[][] TestdataProvider() throws IOException {
        Object data[][]=ExcelDataProvider.requiredData(sheetName,System.getProperty("user.dir")+
                "/src/test/java/com/FilpkartApplication/TestData/"+ExcelName+".xlsx");
        return data;
    }
}

