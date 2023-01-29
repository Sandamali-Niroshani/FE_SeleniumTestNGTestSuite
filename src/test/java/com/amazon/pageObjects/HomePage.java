package com.amazon.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.How.ID;
import static org.openqa.selenium.support.How.XPATH;

public class HomePage {

    @FindBy(how = ID, using = "nav-search-dropdown-card")
    public WebElement itemSearch;

    @FindBy(how = XPATH, using = "//*[@id='searchDropdownBox']")
    public WebElement drp_itemDropdown;

    @FindBy(how = ID, using = "twotabsearchtextbox")
    public WebElement amazonSearchBox;

    @FindBy(how = XPATH, using = "(//*[contains(text(),'The 4-Hour Work Week')])[1]")
    public WebElement searchedBook;

    @FindBy(how = XPATH, using = "//*[contains(@class,'swatchElement unselected')]//*[contains(text(),'Hardcover')]")
    public WebElement hardCoverBook;

    @FindBy(how = XPATH, using = "//*[@class='a-size-base a-color-price a-color-price']")
    public WebElement hardcoverBookPrice;

    @FindBy(how = XPATH, using = "//input[@id='add-to-cart-button']")
    public WebElement btn_addToCart;

    WebDriver ldriver;

    public HomePage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }


}
