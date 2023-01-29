package com.amazon.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.openqa.selenium.support.How.XPATH;


public class ShoppingCartPage {

    WebDriver ldriver;

    public ShoppingCartPage(WebDriver rdriver){
        ldriver=rdriver;
        PageFactory.initElements(rdriver,this);
    }



    @FindBy(how= XPATH, using="//*[contains(@class,'sc-product-title sc-grid-item-product-title')]")
    public WebElement shoppingCartProductTitle;

    @FindBy(how= XPATH, using="//*[@id='sc-subtotal-amount-buybox']")
    public WebElement cartSubTotalAmount;

    @FindBy(how= XPATH, using="//*[@name='proceedToRetailCheckout']")
    public WebElement btn_proceedToCheckout;

    @FindBy(how= XPATH, using="//*[@id='nav-cart']")
    public WebElement shoppingCart;

    @FindBy(how= XPATH, using="//*[@id='activeCartViewForm']//*[@value='Delete']")
    public WebElement btn_deleteInShoppingCart;





}
