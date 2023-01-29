package com.amazon.testScripts;

import com.amazon.functions.LoginPageFunctions;
import com.amazon.utilities.TestDataReader;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;


public class TC01_LoginToAmazon extends BaseTest {

    String pageTitle;

    @BeforeMethod
    @Parameters("dataPath")
    public void dataReader(String dataPath) {
        TestDataReader.getTestDataFile(dataPath);// Load the test data file
        pageTitle = TestDataReader.getTestData("pageTitle");
    }

    @Test
    public void logIntoAmazon() throws IOException {
        LoginPageFunctions loginPageFunctions = new LoginPageFunctions(driver);

        logger.info("Redirect to the amazon web site");
        /**
         To execute this login part please provide your amazon account details (phone number and password) in config.properties file
         */
//        loginPageFunctions.login(phoneNumber, password);
//        logger.info("Login into system");

        loginPageFunctions.verifyTitleOfThePage(pageTitle);

    }
}
