package com.amazon.testScripts;

import com.amazon.functions.LoginPageFunctions;
import com.amazon.utilities.CacheDataWriterReader;
import com.amazon.utilities.TestDataReader;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;


public class TC03_OrderAddToCartAndProceed extends BaseTest {

    CacheDataWriterReader propFile = new CacheDataWriterReader();

    @BeforeMethod
    @Parameters("dataPath")
    public void dataReader(String dataPath) {
        TestDataReader.getTestDataFile(dataPath);// Load the test data file
        propFile.propertyFile("RegressionSuite"); // Properties file

    }

    @Test
    public void addToCartOrder() throws IOException {
        LoginPageFunctions loginPageFunctions = new LoginPageFunctions(driver);

       logger.info("Redirect to the amazon web site");

        loginPageFunctions.login(TestDataReader.getTestData("phoneNumber"),TestDataReader.getTestData("password"));
        logger.info("Login into system");

        String accountName =propFile.getPropertyValues("TC02_accountName");
        System.out.println("Account name:"+accountName);

    }
}
