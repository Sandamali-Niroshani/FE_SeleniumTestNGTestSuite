package com.amazon.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

    //create object of prperties class
    Properties pro;

    public ReadConfig(){
        // './' mean home directory
        File src = new File("./Configuration/config.properties");

        //when you need to read the file you need to open file in read mode. for that need to use FileInputStream
        try{
            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            //load complete file
            pro.load(fis);
        } catch (Exception e) {
           System.out.println("Exception is "+ e.getMessage());
        }
    }

    //Add different method for each variables in config.properties
    public String getApplicationURL(){
        String url = pro.getProperty("baseUrl");
        return url;

    }

    public String getPhoneNumber(){
        String phoneNumber  = pro.getProperty("phoneNumber");
        return phoneNumber;

    }

    public String getPassword(){
        String password  = pro.getProperty("password");
        return password;

    }

}
