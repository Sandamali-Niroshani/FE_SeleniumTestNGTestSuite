package com.amazon.functions;

import com.amazon.pageObjects.LoginPage;

import com.amazon.testScripts.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

import static com.amazon.testScripts.BaseTest.logger;


public class LoginPageFunctions {

    WebDriver driver;
    LoginPage loginpage;
    BaseTest baseTest;

    public LoginPageFunctions(WebDriver driver) {
        this.driver = driver;
        loginpage = new LoginPage(driver);
        baseTest = new BaseTest();
    }


    /**
     * @param phoneNumber provide phone number or email as user name
     * @param password    provide password
     * @throws IOException
     */
    public void login(String phoneNumber, String password) throws IOException {

        loginpage.btn_signIn.click();
        loginpage.tf_phoneNumber.sendKeys(phoneNumber);
        loginpage.btn_continue.click();
        loginpage.tf_password.sendKeys(password);
        loginpage.btn_submit.click();
    }

    public void verifyTitleOfThePage(String pageTitle) throws IOException {
        if (driver.getTitle().equals(pageTitle)) {
            Assert.assertTrue(true);
        } else {
            baseTest.captureScreenshots(driver, "LoginToAmazon");
            Assert.assertTrue(false, "Page title was incorrect");

        }
        logger.info("Verified page title successfully");
    }

    /**
     * @param expectedAccountName expected display name in amazon
     */
    public void verifyUserLogIntoCorrectAccount(String expectedAccountName) {
        Assert.assertEquals(loginpage.accountDisplayName.getText(), expectedAccountName, "User logged into the incorrect account");
        logger.info("Log into the correct account");
    }


}




