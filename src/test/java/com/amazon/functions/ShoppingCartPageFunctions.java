package com.amazon.functions;

import com.amazon.pageObjects.ShoppingCartPage;
import com.amazon.testScripts.BaseTest;
import com.amazon.utilities.AutomationUtil;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

import static com.amazon.testScripts.BaseTest.logger;


public class ShoppingCartPageFunctions {

    WebDriver driver;
    ShoppingCartPage shoppingCartPage;
    BaseTest baseTest;
    AutomationUtil automationUtil;

    public ShoppingCartPageFunctions(WebDriver driver) {
        this.driver = driver;
        shoppingCartPage = new ShoppingCartPage(driver);
        baseTest = new BaseTest();
        automationUtil = new AutomationUtil();
    }

    public void clickOnShoppingCart() throws InterruptedException {
        shoppingCartPage.shoppingCart.click();
        Thread.sleep(3000);
        logger.info("Click on shopping cart");
    }


    /**
     * @param expectedBookName           name of the book you selected
     * @param expectedShoppingCartAmount expected total in shopping cart
     */
    public void verifyShoppingCartSubTotalAndProductDetails(String expectedBookName, double expectedShoppingCartAmount) throws IOException {

        if (shoppingCartPage.shoppingCartProductTitle.getText().contains(expectedBookName)) {
            Assert.assertTrue(true, "Correct book was displayed in shopping cart");
            logger.info("Selected book display in shopping cart");
        } else {
            baseTest.captureScreenshots(driver, "verifyHardCoverBookAddIntoCart");
            Assert.assertTrue(false, "Selected book was not displayed in shopping cart");
        }

        String shoppingCartAmount = automationUtil.getNumericValue(shoppingCartPage.cartSubTotalAmount.getText());
        logger.info("Shopping cart subtotal:" + Double.parseDouble(shoppingCartAmount));
        Assert.assertEquals(Double.parseDouble(shoppingCartAmount), expectedShoppingCartAmount);
        baseTest.captureScreenshots(driver, "verifyShoppingCartPrice");

    }

    public void proceedToCheckout() {
        shoppingCartPage.btn_proceedToCheckout.click();
    }

    public void removeItemFromCart() throws IOException {
        shoppingCartPage.btn_deleteInShoppingCart.click();
        baseTest.captureScreenshots(driver, "removeItemFromShoppingCart");
        logger.info("Remove selected item");
    }


}
