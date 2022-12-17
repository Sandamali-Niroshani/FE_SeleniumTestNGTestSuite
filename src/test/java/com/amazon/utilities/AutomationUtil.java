package com.amazon.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class AutomationUtil {

   /**
   Generate random string
    return random string
    in java predefined class called 'RandomStringUtils' in here there is method called 'randomAlphabetic' used to generate random characters
    */

   public String randomString(int characterCount){
      String generatedString = RandomStringUtils.randomAlphabetic(characterCount);
      return generatedString;
   }

    /**
     *  Generate random number
     * @param numberCount  number count you want
     * @return generatedNumber
     */
    public String randomNumber(int numberCount){
        String generatedNumber = RandomStringUtils.randomNumeric(numberCount);
        return generatedNumber;
    }
}
