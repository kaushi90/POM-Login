package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class homePage {
    WebDriver driver=null;

    @FindBys(@FindBy(xpath=(".//a[@href='#bookings']")))
    private WebElement bookingIcon;

    @FindBys(@FindBy(xpath=("/html/body/nav/div/div[2]/ul[2]/ul/li[1]/a")))
    private WebElement singoutOne;

    @FindBys(@FindBy(xpath=("/html/body/nav/div/div[2]/ul[2]/ul/li[1]/ul/li[2]/a")))
    private WebElement singoutTwo;



    public boolean verifyLogin()
    {
        Boolean result=false;
        result= bookingIcon.isDisplayed();
        return result;

    }

    public void clickLogOutOne()
    {
        singoutOne.click();
    }

    public void clickSignOutTwo()
    {
        singoutTwo.click();
    }

}
