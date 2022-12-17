package com.amazon.testScripts;

import com.amazon.functions.LoginPageFunctions;
import com.amazon.utilities.CacheDataWriterReader;
import com.amazon.utilities.TestDataReader;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.io.IOException;



public class TC02_SelectHardCoverBookInAmazon extends BaseTest {

    CacheDataWriterReader propFile = new CacheDataWriterReader();

    @BeforeMethod
    @Parameters("dataPath")
    public void dataReader(String dataPath) {
        TestDataReader.getTestDataFile(dataPath);// Load the test data file
        propFile.propertyFile("RegressionSuite"); // Properties file
//        String phoneNumber = TestDataReader.getTestData("phoneNumber");
//        String password = TestDataReader.getTestData("password");
    }

    @Test
    public void selectHardCoverBookInAmazon() throws InterruptedException, IOException {
        LoginPageFunctions loginPageFunctions = new LoginPageFunctions(driver);

       logger.info("Redirect to the amazon web site");
        Thread.sleep(20000);
        loginPageFunctions.login(TestDataReader.getTestData("phoneNumber"),TestDataReader.getTestData("password"));
        logger.info("Login into system");

        propFile.saveProperty("TC02_accountName", "Hello, Sandamali");

    }
}
