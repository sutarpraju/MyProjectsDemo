package com.FilpkartApplication.PageObjects;

import com.FilpkartApplication.Base.baseFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainSearchPageObjects extends baseFunctions
{

     public MainSearchPageObjects()
     {
          PageFactory.initElements(driver, this);
     }
     @FindBy(xpath = "//*[@class=\"_2QfC02\"]/button[@class=\"_2KpZ6l _2doB4z\"]")
     public WebElement closePopup;

     @FindBy(xpath = "//*[@class=\"_3OO5Xc\"]/input[@title=\"Search for products, brands and more\"]")
     public WebElement searchTextBox;

     @FindBy(xpath = "//button[@class=\"L0Z3Pu\"]")
     public WebElement searchButton;



}
