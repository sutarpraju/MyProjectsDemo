package com.FilpkartApplication.PageObjects;

import com.FilpkartApplication.Base.baseFunctions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class samsungMobilePageObjects extends baseFunctions {

    public  samsungMobilePageObjects()
    {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@class=\\\"_1YAKP4\\\"]/select[@class=\\\"_2YxCDZ\\\"]")
    public WebElement minPriceRangeDropDown;

    @FindBy(xpath = "//*[@class=\"_3uDYxP\"]//*[@class=\"_2YxCDZ\"]")
    public WebElement maxPriceRangeDropDown;

    @FindBy(xpath = "//div[@class=\"_213eRC _2ssEMF\"]//div[contains(text(),\"RAM\")]")
    public WebElement ramLabel;

    @FindBy(xpath = "//div[contains(text(),\"2 GB\")]/preceding-sibling::div")
    public WebElement twoGBCheckbox;

    @FindBy(xpath = "//div[contains(text(),\"2 GB\")]")
    public WebElement twoGBLabel;

    @FindBy(xpath = "//div[contains(text(),\"Processor Brand\")]")
    public WebElement processorBrandLabel;

    @FindBy(xpath = "//div[contains(text(),\"Snapdragon\")]/preceding-sibling::div")
    public WebElement snapdragonCheckbox;

    @FindBy(xpath = "//div[contains(text(),\"Snapdragon\")]")
    public WebElement snapdragonLabel;
}
