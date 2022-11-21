package com.ken42;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class validate {
    public static boolean char40(WebDriver driver, String xpath, String errorXpath) throws Exception {
        try {
            String Char41char = "sddadsadadsadadadadadadadaddadasdadadadaddsdadsddadsadda";

            Utils.callSendkeys(driver, xpath, Char41char, Char41char);
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
            String Char41char = "sddadsadadsadadadadadadadaddadasdadadadaddsdadsddadsaddasddadsadadsadadadadadadadaddadasdadadadaddsdadsddadsadda";

            Utils.callSendkeys(driver, xpath, Char41char, Char41char);
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
            String Char41char = "(*#$&))";

            Utils.callSendkeys(driver, xpath, Char41char, Char41char);
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
            String Char41char = "478623623696489349269234";

            Utils.callSendkeys(driver, xpath, Char41char, Char41char);
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