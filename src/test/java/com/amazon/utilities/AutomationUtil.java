package com.amazon.utilities;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AutomationUtil {

    /**
     * Generate random string
     * in java predefined class called 'RandomStringUtils' in here there is method called 'randomAlphabetic' used to generate random characters
     *
     * @param characterCount character count you want
     * @return random string
     */
    public String randomString(int characterCount) {
        String generatedString = RandomStringUtils.randomAlphabetic(characterCount);
        return generatedString;
    }

    /**
     * Generate random number
     *
     * @param numberCount number count you want
     * @return generatedNumber
     */
    public String randomNumber(int numberCount) {
        String generatedNumber = RandomStringUtils.randomNumeric(numberCount);
        return generatedNumber;
    }

    /**
     * select value from dropdown
     *
     * @param element     dropdown element
     * @param displayText text you want to select from dropdown
     */
    public void selectValueFromDropdown(WebElement element, String displayText) {
        Select drpList = new Select(element);
        drpList.selectByVisibleText(displayText);
    }

    /**
     * To get only numeric part from the text : ex: s$34.5 -> 34.5
     *
     * @param value value with numbers,texts,characters
     * @return numeric part only
     */
    public String getNumericValue(String value) {
        return getNumeric(value);
    }

    public String getNumeric(String input) {
        String minus = "";
        input = input.replaceAll("[^0-9.\\-]", "").trim();
        if (input.contains("-")) {
            minus = "-";
        }
        final String regExp = "[0-9]+([,.][0-9]{1,2})?";

        final Pattern pattern = Pattern.compile(regExp);

        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return minus + matcher.group();
        }
        return null;
    }
}
