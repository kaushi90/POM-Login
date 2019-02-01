package com.test.suite;

import com.pages.homePage;
import com.pages.loginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class loginTestScenarios {

    String baseURL ="https://www.phptravels.net/login";
    String email = "user@phptravels.com";
    String password ="demouser";
    private WebDriver driver;
    SoftAssert soft = new SoftAssert(); //use soft assets here
    WebDriverWait wait;
    loginPage loginPage=new loginPage();
    homePage homePage=new homePage();


    @BeforeTest (groups = {"Positive_Secnario"})
    public void startup(){
        System.setProperty("webdriver.gecko.driver","C:\\geckodriver-v0.16.0-win32\\geckodriver.exe");
        driver = new FirefoxDriver();
//      driver.manage().window().maximize();
        driver.get(baseURL);
        wait = new WebDriverWait(driver, 20);
        //wait.until(ExpectedConditions.titleContains("Login"));
        //loginPage.verifyLoginPage();
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='panel-heading go-text-right']")));

    }

    @Test (priority=1,groups = { "Positive_Secnario" })
    public void travelValidLoging()
    {
        soft.assertEquals(driver.getTitle(),"Login"); //test case 1 for check login page appearence
        loginPage.setUsername(email);
        loginPage.setPassword(password);
        loginPage.clickRemember();
        loginPage.clickLogin();
        soft.assertEquals(homePage.verifyLogin(),"True");
        soft.assertEquals(driver.getTitle(),"My Account"); //Test case 2 for verify the login
        soft.assertAll();
        homePage.clickLogOutOne();
        homePage.clickSignOutTwo();
    }
    @Test (priority=3,groups = { "Negative_Secnario" })
    public void blankLogingData()
    {
        wait.until(ExpectedConditions.titleContains("Login"));
        loginPage.setUsername(" ");
        loginPage.setPassword(" ");
        loginPage.clickRemember();
        loginPage.clickLogin();
        soft.assertEquals(loginPage.displayText(),"Invalid Email or Password");

    }
    @Test (priority=2,groups = { "Negative_Secnario" })
    public  void invalidLogingData()
    {
        loginPage.setUsername("kanishka");
        loginPage.setPassword("123@123");
        loginPage.clickRemember();
        loginPage.clickLogin();
        soft.assertEquals(loginPage.displayText(),"Invalid Email or Password");
        loginPage.clean();
    }

    @AfterTest (groups ={"Positive_Secnario","Negative_Secnario" })
    public void closeBrowser()
    {
        driver.quit(); //quit the firefox browser
    }
}
