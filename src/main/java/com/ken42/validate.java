package com.ken42;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.logging.Logger;
import org.apache.commons.lang3.RandomStringUtils;

public class validate {

    public static void testForCharLength(WebDriver driver, String xpath, String errorXpath, Logger log, int length)
            throws Exception {
        String randomText = "abcdefghijklmnopqrstuvwxyz";
        int maxAllowedLength = length - 1;
        String testCharLength = RandomStringUtils.random(length, randomText);
        Utils.callSendkeys(driver, xpath, testCharLength, "Sending a string of length " + length);
        String testCharLengthErrorMessage = Utils.getTEXT(driver, errorXpath);
        System.out.println("%%%%%%%%%%%" + testCharLengthErrorMessage);
        String expectedErrorMessage = "This field cannot be more than " + maxAllowedLength + " characters";
        System.out.println("@@@@@@@@@@@" + expectedErrorMessage);
        if (testCharLengthErrorMessage.equals(expectedErrorMessage)) {
            log.info("Char Length validation test PASSED for length " + maxAllowedLength + xpath);
        } else {
            log.warning("Char Length validation test FAILED for length " + maxAllowedLength + xpath);
        }
    }

    public static void testForNumberLength(WebDriver driver, String xpath, String errorXpath, Logger log, int length)
            throws Exception {
        String randomText = "123456789";
        int maxAllowedLength = length - 1;
        String testCharLength = RandomStringUtils.random(length, randomText);
        Utils.callSendkeys(driver, xpath, testCharLength, "Sending a string of length " + length);
        String testCharLengthErrorMessage = Utils.getTEXT(driver, errorXpath);
        System.out.println("%%%%%%%%%%%" + testCharLengthErrorMessage);
        String expectedErrorMessage = "This field cannot be more than ";
        System.out.println("@@@@@@@@@@@" + expectedErrorMessage);
        if (testCharLengthErrorMessage.contains(expectedErrorMessage)) {
            log.info("Number Length validation test PASSED for length " + maxAllowedLength + xpath);
        } else {
            log.warning("Number Length validation test FAILED for length " + maxAllowedLength + xpath);
        }
    }

    public static void specialcharacter(WebDriver driver, String xpath, String errorXpath, Logger log)
            throws Exception {
        try {
            String SpecailChar = "(*#$))";

            Utils.callSendkeys(driver, xpath, SpecailChar, SpecailChar);
            String specialCharErrorMessage = Utils.getTEXT(driver, errorXpath);
            System.out.println("%%%%%%%%%%%" + specialCharErrorMessage);
            if (specialCharErrorMessage.contains("Please")) {
                log.info("Special character validation PASSED" + xpath);
            } else {
                log.warning("Special character validation FAILED" + xpath);
            }
            Utils.cleartext(driver, xpath);
        } catch (Exception e) {
            Utils.printException(e);
            throw (e);
        }
    }

    public static void testAlphaOnly(WebDriver driver, String xpath, String errorXpath, Logger log) throws Exception {
        try {
            String number = "478623623";
            Utils.callSendkeys(driver, xpath, number, number);
            String testAplhaErrorMessage = Utils.getTEXT(driver, errorXpath);
            System.out.println("%%%%%%%%%%%" + testAplhaErrorMessage);
            if (testAplhaErrorMessage.contains("Please Input")) {
                log.info("Validation for Alpha only feild PASSED" + xpath);
            } else {
                log.warning("Validation for Alpha only feild FAILED" + xpath);
            }
            Utils.cleartext(driver, xpath);
        } catch (Exception e) {
            Utils.printException(e);
            throw (e);
        }

    }

    public static void email(WebDriver driver, String xpath, String errorXpath, Logger log) throws Exception {
        String[] Email = { "a@gg.", "aa.c", "aa@c", "@cc.in" };
        for (int i = 0; i < Email.length; i++) {
            try {
                Utils.callSendkeys(driver, xpath, Email[i], "Sending an invalid Email ID");
                String emailErrorMessage = Utils.getTEXT(driver, errorXpath);
                System.out.println("%%%%%%%%" + emailErrorMessage);
                if (emailErrorMessage.equals("Please Input a valid Email")) {
                    log.info("Email validation PASSED for string" + Email[i] + xpath);
                } else {
                    log.warning("Email validation FAILED" + Email[i] + xpath);
                }
                Utils.cleartext(driver, xpath);
            } catch (Exception e) {
                Utils.printException(e);
                throw e;
            }
        }
    }

    public static void testForMandatoryField(WebDriver driver, String xpath, String errorXpath, Logger log)
            throws Exception {
        Utils.cleartext(driver, xpath);
        String madatoryErrorMessage = Utils.getTEXT(driver, errorXpath);
        if (madatoryErrorMessage.contains("This field is required")) {
            log.info("This feild is manadtory test PASSED" + xpath);
        } else {
            log.info("This feild is manadtory test FAILED" + xpath);
        }
    }

    //// .......................................ltcpt
    //// code...........................................////

    public static boolean validate20CharLength(WebDriver driver, String xpath, String errorXpath) throws Exception {
        try {
            String Char41char = "sasadasasasasasasasa";
            Utils.callSendkeys(driver, xpath, Char41char, "char");
            // WebElement alphafirstname =
            // driver.findElement(By.xpath("//span[@style='color: rgb(185, 37, 0);']"));
            WebElement errorMessage = driver.findElement(By.xpath(errorXpath));
            String checkwithlength = errorMessage.getText();

            WebElement number = driver.findElement(By.xpath("//span[@style='color: rgb(185, 37, 0);']"));
            String checklastNamewithcharactersize = number.getText();
            System.out.println(checklastNamewithcharactersize);

            if (!checklastNamewithcharactersize.equals(null)) {

                System.out.println("Tc:- data validation check with length size failed it's null ");

            }

            if (checkwithlength.contains("cannot")) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            Utils.printException(e);
            throw (e);
        }

    }

    public static boolean validateNumber(WebDriver driver, String xpath, String errorXpath) throws Exception {
        try {
            String Number = "202284989379393793783783";
            Utils.callSendkeys(driver, xpath, Number, "number");
            // WebElement alphafirstname =
            // driver.findElement(By.xpath("//span[@style='color: rgb(185, 37, 0);']"));
            WebElement errorMessage = driver.findElement(By.xpath(errorXpath));

            WebElement alphalastName = driver.findElement(By.xpath("//span[@style='color: rgb(185, 37, 0);']"));
            String checklastNamewithnumber = alphalastName.getText();
            System.out.println(checklastNamewithnumber);

            if (!checklastNamewithnumber.equals(null)) {

                System.out.println("Tc:- data validation check with number failed it's null  ");

            }

            String checkfirstnamewithnumber = errorMessage.getText();
            if (checkfirstnamewithnumber.contains("cannot")) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            Utils.printException(e);
            throw (e);
        }

    }

    public static boolean validateSpecialChar(WebDriver driver, String xpath, String errorXpath) throws Exception {
        try {
            String CharSpecial = "@%$^%*&!()%&&%&$$$";
            Utils.callSendkeys(driver, xpath, CharSpecial, "char special");
            // WebElement alphafirstname =
            // driver.findElement(By.xpath("//span[@style='color: rgb(185, 37, 0);']"));
            WebElement errorMessage = driver.findElement(By.xpath(errorXpath));
            String checkwithspecialcharacter = errorMessage.getText();

            WebElement SpecialCharacteronly = driver.findElement(By.xpath("//span[@style='color: rgb(185, 37, 0);']"));
            String checklastNamewithSpecialCharacteronly = SpecialCharacteronly.getText();
            System.out.println(checklastNamewithSpecialCharacteronly);

            if (!checklastNamewithSpecialCharacteronly.equals(null)) {

                System.out.println("Tc:- data validation check with specialCharacter failed it's null ");

            }

            if (checkwithspecialcharacter.contains("cannot")) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            Utils.printException(e);
            throw (e);
        }

    }

    public static boolean validate80CharLength(WebDriver driver, String xpath, String errorXpath) throws Exception {
        try {
            String Char80char = "sddadsadadsadadadadadadadaddadasdadadadaddsdadsddadsaddasddadsadadsadadadadadadadaddadasdadadadaddsdadsddadsadda";
            Utils.callSendkeys(driver, xpath, Char80char, "char 80");
            // WebElement alphafirstname =
            // driver.findElement(By.xpath("//span[@style='color: rgb(185, 37, 0);']"));
            WebElement errorMessage = driver.findElement(By.xpath(errorXpath));
            String checkfirstnamewithnumber = errorMessage.getText();
            if (checkfirstnamewithnumber.contains("cannot")) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            Utils.printException(e);
            throw (e);
        }

    }
}
