package com.amazon.functions;

import com.amazon.pageObjects.HomePage;
import com.amazon.testScripts.BaseTest;
import com.amazon.utilities.AutomationUtil;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import java.io.IOException;

public class HomePageFunctions {

    WebDriver driver;
    HomePage homepage;
    BaseTest baseTest;
    AutomationUtil automationUtil;

    public HomePageFunctions(WebDriver driver) {
        this.driver = driver;
        homepage = new HomePage(driver);
        baseTest = new BaseTest();
        automationUtil = new AutomationUtil();
    }

    /**
     * @param selectItem provide item you want to select from dropdown
     * @throws InterruptedException
     */
    public void selectItemFromDropdown(String selectItem) throws InterruptedException {
        homepage.itemSearch.click();
        Thread.sleep(3000);
        automationUtil.selectValueFromDropdown(homepage.drp_itemDropdown, selectItem);
    }

    public void selectHardCoverBook(String bookName) throws InterruptedException, IOException {

        homepage.amazonSearchBox.sendKeys(bookName);
        homepage.amazonSearchBox.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        homepage.searchedBook.click();
        homepage.hardCoverBook.click();
        baseTest.captureScreenshots(driver, "selectHardCoverBook");
    }

    public String getHardCoverPrice() {

        String bookPrice = homepage.hardcoverBookPrice.getText();
        return bookPrice;
    }

    public void addIntoCart() throws IOException {

        homepage.btn_addToCart.click();
        baseTest.captureScreenshots(driver, "AddItemIntoShoppingCart");

    }


}
