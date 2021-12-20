package com.FilpkartApplication.Methods;

import com.FilpkartApplication.PageObjects.MainSearchPageObjects;
import com.FilpkartApplication.Base.baseFunctions;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.event.KeyEvent;

public class MainPageMethods extends baseFunctions
{
    MainSearchPageObjects pobj=new MainSearchPageObjects();

    public void closeLoginPopup()
    {
        try {
            if (pobj.closePopup.isDisplayed())
            {
                test.log(Status.PASS,"Login PopUp is Displayed Successfully");
                pobj.closePopup.click();
                test.log(Status.PASS,"Login PopUp has been closed Successfully");
                System.out.println("PopUp closed");
            }else {
                test.log(Status.FAIL,"Login PopUp is not closed");
                System.out.println("PopUp Not Found");
            }
        }catch (Exception e) {
            test.log(Status.FAIL,"Login PopUp is not displayed");
            System.out.println(e.getMessage());
        }
    }

    public void searchString(String searchItems)
    {
        try
        {
            if (pobj.searchTextBox.isDisplayed())
            {
                test.log(Status.PASS,"Search Text Box is Displayed Successfully");
                System.out.println("Search Text Box Displayed");
                pobj.searchTextBox.sendKeys(searchItems);
                test.log(Status.PASS,searchItems+" "+"is entered in search text box Successfully");
                System.out.println("Search value entered in text box");
                pobj.searchButton.click();
                test.log(Status.PASS,"Clicked on Search Button Successfully");
            }else {
                test.log(Status.FAIL,"Search Text Box is Not Displayed");
                System.out.println("Search Text Box is not Displayed");
            }
        }catch (Exception e) {
            test.log(Status.FAIL,"Failed to verify Search Text Box");
            System.out.println(e.getMessage());
        }
    }
}
