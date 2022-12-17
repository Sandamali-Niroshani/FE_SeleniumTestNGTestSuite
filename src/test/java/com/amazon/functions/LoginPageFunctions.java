package com.amazon.functions;

import com.amazon.pageObjects.LoginPage;

import com.amazon.testScripts.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;


public class LoginPageFunctions {

    WebDriver driver;
    LoginPage loginpage;
    BaseTest baseTest;

    public LoginPageFunctions(WebDriver driver) {
        this.driver = driver;
        loginpage = new LoginPage(driver);
        baseTest = new BaseTest();
    }




    public void login(String phoneNumber,String password) throws IOException {

        loginpage.btn_signIn.click();
        loginpage.tf_phoneNumber.sendKeys(phoneNumber);
        loginpage.btn_continue.click();
        loginpage.tf_password.sendKeys(password);
        loginpage.btn_submit.click();
        if(driver.getTitle().equals("Amazon.sg: Shop Online for Electronics, Computers, Books, Toys, DVDs, Baby, Grocery, & more")){
            Assert.assertTrue(true);
        }
        else
        {
            baseTest.captureScreenshots(driver,"LoginToAmazon");
            Assert.assertTrue(false);
        }

    }

}
