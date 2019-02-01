package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPage {
    WebDriver driver=null;
    @FindBys(@FindBy(xpath=(".//input[@name='username']")))
    private WebElement username;

    @FindBys(@FindBy(xpath=(".//input[@name='password']")))
    private WebElement password;

    @FindBys(@FindBy(xpath=(".//input[@id='remember-me']")))
    private WebElement remember;

    @FindBys(@FindBy(xpath=(".//button[@class='btn btn-action btn-lg btn-block loginbtn']")))
    private WebElement loginbtn;

    @FindBys(@FindBy(xpath=(".//div[@class='panel-heading go-text-right']")))
    private WebElement verifylogin;

    @FindBys(@FindBy(xpath=("/html/body/div[5]/div[1]/div[1]/form/div[1]/div[2]/div")))
    private WebElement validationMessage;

    public void setUsername(String user)
    {

        username.sendKeys(user);
    }

    public void setPassword(String pwd)
    {
        username.sendKeys(pwd);
    }

    public void clickRemember()
    {
        remember.click();
    }
    public void clickLogin()
    {
      loginbtn.click();
    }

    public Boolean verifyLoginPage()
    {
        Boolean loginIcon=false;
        loginIcon=verifylogin.isDisplayed();
        return loginIcon;
    }

    public String displayText()
    {
        String message;
        message=validationMessage.getText();
        return message;
    }

    public void clean()
    {
        username.clear();
        password.clear();
        remember.clear();
    }


}
