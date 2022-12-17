package com.amazon.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.openqa.selenium.support.How.XPATH;


public class LoginPage {

    WebDriver ldriver;

    public LoginPage(WebDriver rdriver){
        ldriver=rdriver;
        PageFactory.initElements(rdriver,this);
    }

    @FindBy(how= XPATH, using="//*[contains(text(),'Your Account')]")
    public WebElement btn_yourAccount;

    @FindBy(how= XPATH, using="//*[@data-nav-role='signin']")
    public WebElement btn_signIn;

    @FindBy(how= XPATH, using="//*[@type='email']")
    public WebElement tf_phoneNumber;

    @FindBy(how= XPATH, using="//input[@id='continue']")
    public WebElement btn_continue;

    @FindBy(how= XPATH, using="//input[@type='password']")
    public WebElement tf_password;

    @FindBy(how= XPATH, using="//input[@id='signInSubmit']")
    public WebElement btn_submit;




}
