package com.amazon.testScripts;

import com.amazon.functions.HomePageFunctions;
import com.amazon.functions.LoginPageFunctions;
import com.amazon.functions.ShoppingCartPageFunctions;
import com.amazon.utilities.AutomationUtil;
import com.amazon.utilities.CacheDataWriterReader;
import com.amazon.utilities.TestDataReader;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;


public class TC02_HardCoverBookAddIntoCart extends BaseTest {

    CacheDataWriterReader propFile = new CacheDataWriterReader();
    String pageTitle;
    String itemType;
    String bookName;

    @BeforeMethod
    @Parameters("dataPath")
    public void dataReader(String dataPath) {
        TestDataReader.getTestDataFile(dataPath);// Load the test data file
        propFile.propertyFile("RegressionSuite"); // Properties file
        pageTitle = TestDataReader.getTestData("pageTitle");
        itemType = TestDataReader.getTestData("itemType");
        bookName = TestDataReader.getTestData("bookName");
    }

    @Test
    public void verifyHardCoverBookAddIntoCart() throws InterruptedException, IOException {
        LoginPageFunctions loginPageFunctions = new LoginPageFunctions(driver);
        HomePageFunctions hmPageFunctions = new HomePageFunctions(driver);
        ShoppingCartPageFunctions shoppingCartPageFunctions = new ShoppingCartPageFunctions(driver);
        AutomationUtil automationUtil = new AutomationUtil();

        logger.info("Redirect to the amazon web site");
        Thread.sleep(2000);

        /**
         To execute this login part please provide your amazon account details (phone number and password) in TC_02.properties file
         */
//        loginPageFunctions.login(TestDataReader.getTestData("phoneNumber"), TestDataReader.getTestData("password"));
//        logger.info("Login into system");
//        propFile.saveProperty("TC02_accountName", "Hello, Sandamali");

/** -------------------------------- Verify page title ------------------------   */
        loginPageFunctions.verifyTitleOfThePage(pageTitle);


/** -------------------------------- Select hard cover book ------------------------   */
        hmPageFunctions.selectItemFromDropdown(itemType);
        hmPageFunctions.selectHardCoverBook(bookName);
        String hardcoverBookPrice = hmPageFunctions.getHardCoverPrice();

        propFile.saveProperty("TC02_hardcoverBookDisplayPrice", hardcoverBookPrice);

        logger.info("Select hard cover book :" + bookName);
        logger.info("Select hard cover book price :" + hardcoverBookPrice);


/** -------------------------------- Add into shopping cart and verify shopping cart details ------------------------   */
        hmPageFunctions.addIntoCart();
        logger.info("Selected book add into cart");

        shoppingCartPageFunctions.clickOnShoppingCart();

        String hardcoverBookPriceInSearchPage = propFile.getPropertyValues("TC02_hardcoverBookDisplayPrice");
        double hardcoverBookDisplayPriceInSearchPage = Double.parseDouble(automationUtil.getNumericValue(hardcoverBookPriceInSearchPage));
        shoppingCartPageFunctions.verifyShoppingCartSubTotalAndProductDetails(bookName, hardcoverBookDisplayPriceInSearchPage);
        logger.info("Verified shopping cart details");

        shoppingCartPageFunctions.removeItemFromCart();

    }
}
