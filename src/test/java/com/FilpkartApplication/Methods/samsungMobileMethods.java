package com.FilpkartApplication.Methods;

import com.FilpkartApplication.Base.baseFunctions;
import com.FilpkartApplication.PageObjects.samsungMobilePageObjects;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class samsungMobileMethods extends baseFunctions
{
    samsungMobilePageObjects sobj=new samsungMobilePageObjects();
    WebDriverWait wait=new WebDriverWait(driver,40);;

    public void setPriceFilter(String MaxPriceFilter)
    {
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated
                    ((By.xpath("//*[@class=\"_3uDYxP\"]//*[@class=\"_2YxCDZ\"]"))));
            test.log(Status.PASS,"Price Filter is Displayed Successfully");
            Select select=new Select(sobj.maxPriceRangeDropDown);
            System.out.println("DropDown Displayed");
            select.selectByValue(MaxPriceFilter);
            test.log(Status.PASS,"Max price filter is selected as "+MaxPriceFilter+" "+"Successfully");
            System.out.println("Max value selected");
        }catch (Exception e)
        {
            test.log(Status.FAIL,"Price Filter is not Displayed");
            System.out.println(e.getMessage());
        }

    }

    public void selectRamFilter(){
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.
                    xpath("//div[@class=\"_213eRC _2ssEMF\"]//div[contains(text(),\"RAM\")]")));
            if (sobj.ramLabel.isDisplayed())
            {
                test.log(Status.PASS,"RAM Label is Displayed Successfully");
                if (sobj.twoGBLabel.isDisplayed()) {
                    test.log(Status.PASS,"2 GB RAM Label is Displayed Successfully");
                    System.out.println("2GB RAM Label Is displayed");
                    Thread.sleep(5000);
                    ((JavascriptExecutor) driver).executeScript("scroll(0,500)");
                    wait.until(ExpectedConditions.elementToBeClickable(sobj.twoGBCheckbox));
                    sobj.twoGBCheckbox.click();
                    test.log(Status.PASS,"2 GB RAM filter is Selected Successfully");
                    System.out.println("2GB RAM Label Is Selected");
                }else {
                    test.log(Status.FAIL,"2 GB RAM filter is not Selected");
                    System.out.println("2GB RAM Label Is Not Selected");
                }
            }else
            {
                test.log(Status.FAIL,"RAM Label is not Displayed");
                System.out.println("RAM Label Is not displayed");
            }
        }catch (Exception e)
        {
            test.log(Status.FAIL,"Failed to Verify RAM Filter");
            System.out.println(e.getMessage());
        }
    }

    public void selectProcessorFilter()
    {
        try
        {
            if (sobj.processorBrandLabel.isDisplayed())
            {
                test.log(Status.PASS,"Processor Brand Label Is Displayed Successfully");
                System.out.println("Processor Brand Label Is Displayed");
                Thread.sleep(1000);
                ((JavascriptExecutor)driver).executeScript("scroll(0,1000)");
                sobj.processorBrandLabel.click();
                wait.until(ExpectedConditions.elementToBeClickable(sobj.snapdragonCheckbox));
                sobj.snapdragonCheckbox.click();
                test.log(Status.PASS,"Processor Brand-Snapdragon Is Selected Successfully");
                System.out.println("Processor Brand Snapdragon Is Selected");
            }
        }catch (Exception e)
        {
            test.log(Status.FAIL,"Processor Brand Is Not Displayed");
            System.out.println(e.getMessage());
        }
    }
}
