package com.amazon.testScripts;

import com.amazon.functions.LoginPageFunctions;
import org.testng.annotations.Test;

import java.io.IOException;


public class TC01_LoginToAmazon extends BaseTest {

    @Test
    public void logIntoAmazon() throws IOException {
        LoginPageFunctions loginPageFunctions = new LoginPageFunctions(driver);

       logger.info("Redirect to the amazon web site");

        loginPageFunctions.login(phoneNumber,password);
        logger.info("Login into system");


    }
}
