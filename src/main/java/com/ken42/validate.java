package com.ken42;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class validate {
    public static boolean char40(WebDriver driver, String xpath, String errorXpath) throws Exception {
        try {
            String Char40char = "sddadsadadsadadadadadadadaddadasdadadadaddsdadsddadsadda";

            Utils.callSendkeys(driver, xpath, Char40char, Char40char);
            WebElement errorMessage = driver.findElement(By.xpath(errorXpath));
            String checkfirstnamewithnumber = errorMessage.getText();

            if (checkfirstnamewithnumber.contains("valid")) {
                return true;
            } else if (checkfirstnamewithnumber.contains("correct value")) {
                return true;
            } else if (checkfirstnamewithnumber.contains("cannot")) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            Utils.printException(e);
            throw (e);
        }

    }

    public static boolean char80(WebDriver driver, String xpath, String errorXpath) throws Exception {
        try {
            String Char80char = "sddadsadadsadadadadadadadaddadasdadadadaddsdadsddadsaddasddadsadadsadadadadadadadaddadasdadadadaddsdadsddadsadda";

            Utils.callSendkeys(driver, xpath, Char80char, Char80char);
            WebElement errorMessage = driver.findElement(By.xpath(errorXpath));
            String checkfirstnamewithnumber = errorMessage.getText();

            if (checkfirstnamewithnumber.contains("valid")) {
                return true;
            } else if (checkfirstnamewithnumber.contains("correct value")) {
                return true;
            } else if (checkfirstnamewithnumber.contains("cannot")) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            Utils.printException(e);
            throw (e);
        }

    }

    public static boolean specialcharacter(WebDriver driver, String xpath, String errorXpath) throws Exception {
        try {
            String SpecailChar = "(*#$&))";

            Utils.callSendkeys(driver, xpath, SpecailChar, SpecailChar);
            WebElement errorMessage = driver.findElement(By.xpath(errorXpath));
            String checkfirstnamewithnumber = errorMessage.getText();

            if (checkfirstnamewithnumber.contains("valid")) {
                return true;
            } else if (checkfirstnamewithnumber.contains("correct value")) {
                return true;
            } else if (checkfirstnamewithnumber.contains("cannot")) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            Utils.printException(e);
            throw (e);
        }

    }

    public static boolean numbers(WebDriver driver, String xpath, String errorXpath) throws Exception {
        try {
            String number = "478623623696489349269234";

            Utils.callSendkeys(driver, xpath, number, number);
            WebElement errorMessage = driver.findElement(By.xpath(errorXpath));
            String checkfirstnamewithnumber = errorMessage.getText();

            if (checkfirstnamewithnumber.contains("valid")) {
                return true;
            } else if (checkfirstnamewithnumber.contains("correct value")) {
                return true;
            } else if (checkfirstnamewithnumber.contains("cannot")) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            Utils.printException(e);
            throw (e);
        }

    }

    public static boolean email(WebDriver driver, String xpath, String errorXpath) throws Exception {
        try {

            String invlaidEmail1 = "a@gg.c";
            String invlaidEmail2 = "aa.c";
            String invlaidEmail3 = "aa@c";
            String invlaidEmail4 = "@cc.in";

            Utils.callSendkeys(driver, xpath, invlaidEmail1, invlaidEmail2);
            WebElement errorMessage = driver.findElement(By.xpath(errorXpath));
            String checkEmail = errorMessage.getText();

            if (checkEmail.contains("valid")) {
                return true;
            } else if (checkEmail.contains("correct Email address")) {
                return true;
            } else if (checkEmail.contains("cannot")) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            Utils.printException(e);
            throw (e);
        }

    }

    public static boolean char200(WebDriver driver, String xpath, String errorXpath) throws Exception {
        try {
            String Char200char = "sddadsadadsadadadadadadadaddadasdadadadaddsdadsddadsaddasddadsadadsadadadadadadadaddadasdadadadaddsdadsddadsaddasddadsadadsadadadadadadadaddadasdadadadaddsdadsddadsaddasddadsadadsadadadadadadadaddadasdadadadaddsdadsddadsadda";

            Utils.callSendkeys(driver, xpath, Char200char, Char200char);
            WebElement errorMessage = driver.findElement(By.xpath(errorXpath));
            String checkfirstnamewithnumber = errorMessage.getText();

            if (checkfirstnamewithnumber.contains("valid")) {
                return true;
            } else if (checkfirstnamewithnumber.contains("correct value")) {
                return true;
            } else if (checkfirstnamewithnumber.contains("cannot")) {
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