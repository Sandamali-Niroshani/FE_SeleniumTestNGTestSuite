package com.amazon.testScripts;

import com.amazon.utilities.ReadConfig;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

public class BaseTest {

    ReadConfig readConfig = new ReadConfig();


    public String baseUrl = readConfig.getApplicationURL();
    public String phoneNumber = readConfig.getPhoneNumber();
    public String password = readConfig.getPassword();
    public static WebDriver driver;
    public static Logger logger;

    //will take parameters from xml file
    @Parameters("browser")
    @BeforeClass
    public void setup(String br){

        logger = Logger.getLogger("Amazon");
        PropertyConfigurator.configure("log4j.properties");
//        BasicConfigurator.configure();

        if(br.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers//chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if(br.equals("firefox")){

            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//Drivers//geckodriver.exe");
            driver = new FirefoxDriver();
        }

        driver.get(baseUrl) ;
        driver.manage().window().maximize();
    }

    @AfterClass
    public void close(){
        driver.quit();
    }

    public void captureScreenshots(WebDriver driver,String name) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") +"/Screenshots/"+name+".png");
        FileUtils.copyFile(source,target);
        System.out.println("Screenshot taken");
    }

}
