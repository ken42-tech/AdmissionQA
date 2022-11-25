package com.ken42;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.logging.Logger;

public class validate {
    public static void char40(WebDriver driver, String xpath, String errorXpath, Logger log) throws Exception {
        try {
            String Char40char = "sddadsadadsadadadadadadadaddadasdadadadaddsdadsddadsadda";

            Utils.callSendkeys(driver, xpath, Char40char, Char40char);
            String checkfirstnamewithnumber = Utils.getTEXT(driver, errorXpath);
            System.out.println(checkfirstnamewithnumber);
            if (!checkfirstnamewithnumber.contains("This field cannot be more than 40 characters")) {
                log.warning("40 Characters validation test failed");
            } 
            Utils.cleartext(driver, xpath);
        } catch (Exception e) {
            Utils.printException(e);
            throw (e);
        }

    }

    public static void char80(WebDriver driver, String xpath, String errorXpath, Logger log) throws Exception {
        try {
            String Char80char = "sddadsadadsadadadadadadadaddadasdadadadaddsdadsddadsaddasddadsadadsadadadadadadadaddadasdadadadaddsdadsddadsadda";

            Utils.callSendkeys(driver, xpath, Char80char, Char80char);
            WebElement errorMessage = driver.findElement(By.xpath(errorXpath));
            String checkfirstnamewithnumber = errorMessage.getText();

            if (checkfirstnamewithnumber.contains("This field cannot be more than 40 characters")) {
                log.warning("Validation of 80 character failed");
            } 
            Utils.cleartext(driver, xpath);
        } catch (Exception e) {
            Utils.printException(e);
            throw (e);
        }

    }

    public static void specialcharacter(WebDriver driver, String xpath, String errorXpath, Logger log) throws Exception {
        try {
            String SpecailChar = "(*#$&))";

            Utils.callSendkeys(driver, xpath, SpecailChar, SpecailChar);
            String checkfirstnamewithnumber = Utils.getTEXT(driver, errorXpath);
            
            if (!checkfirstnamewithnumber.contains("Please Input a valid value")) {
                log.warning("Special character validation failed");
            }
            Utils.cleartext(driver, xpath);
        } catch (Exception e) {
            Utils.printException(e);
            throw (e);
        }

    }

    public static void numbers(WebDriver driver, String xpath, String errorXpath, Logger log) throws Exception {
        try {
            String number = "478623623696489349269234";
            Utils.callSendkeys(driver, xpath, number, number);
            String checkfirstnamewithnumber = Utils.getTEXT(driver, errorXpath);

            if (!checkfirstnamewithnumber.contains("Please Input a valid value")) {
                log.warning("Validation failed for Alpha only feild");
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
                Utils.cleartext(driver, xpath);
                System.out.println(i);
                String checkEmail = Utils.getTEXT(driver, errorXpath);
                if (!checkEmail.contains("Please Input a valid Email")) {
                    log.warning("TC-1: Email validation FAILED");
                } 
                Utils.cleartext(driver, xpath);
            }catch (Exception e){
                Utils.printException(e);
                throw e;
            }
        }
    }

    public static void char200(WebDriver driver, String xpath, String errorXpath, Logger log) throws Exception {
        try {
            String Char200char = "sddadsadadsadadadadadadadaddadasdadadadaddsdadsddadsaddasddadsadadsadadadadadadadaddadasdadadadaddsdadsddadsaddasddadsadadsadadadadadadadaddadasdadadadaddsdadsddadsaddasddadsadadsadadadadadadadaddadasdadadadaddsdadsddadsadda";

            Utils.callSendkeys(driver, xpath, Char200char, Char200char);
            String checkfirstnamewithnumber = Utils.getTEXT(driver, errorXpath);
            
            if (!checkfirstnamewithnumber.contains("This field cannot be more than 200 characters")) {
                log.warning("200 character validation test failed ");
            } 
            Utils.cleartext(driver, xpath);
        } catch (Exception e) {
            Utils.printException(e);
            throw (e);
        }

    }
}