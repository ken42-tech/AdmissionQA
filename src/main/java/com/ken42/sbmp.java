package com.ken42;

import org.apache.commons.lang3.Validate;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import org.testng.annotations.Test;

public class sbmp {
    public static Logger log = Logger.getLogger("App_portal");
    static int time = 2000;
    public static WebDriver driver;

    public static void login(String url, WebDriver driver, String[] csvCell, Logger log) throws Exception {
        try {
            String email = csvCell[2];
            String password = csvCell[3];

            Thread.sleep(3000);
            Utils.callSendkeys(driver, ActionXpath.EnterEmail, email, "Enter r mail address ");
            Utils.clickXpath(driver, ActionXpath.Verify, time, "verify");
            Utils.bigSleepBetweenClicks(2);
            Utils.getAndSentOTP(driver, email, password);
            Utils.clickXpath(driver, ActionXpath.Verifylogin, time, "Verify Login ");
            log.info("TC-1: Login was succesful");

        } catch (Exception e) {
            Utils.printException(e);
            log.warning("TC-1: Login failed");
            throw (e);
        }
    }

    public static void sbmpApplyforCourse(String url, WebDriver driver, String[] csvCell, Logger log) throws Exception {
        try {
            String Programe = csvCell[13];
            Utils.smallSleepBetweenClicks(3);
            Utils.callSendkeys(driver, ActionXpath.searchthecourse, Programe, "Enter program");
            WebElement textbox = driver.findElement(By.xpath("//input[@placeholder='Search...']"));
            textbox.sendKeys(Keys.ENTER);
            Utils.smallSleepBetweenClicks(3);
            Utils.clickXpath(driver, ActionXpath.ApplyNow, time, "Click on apply");
            Utils.clickXpath(driver, ActionXpath.ClickNext, time, "click on Next");

            Utils.smallSleepBetweenClicks(1);
            log.info("TC-1:sbmp  Course deatil screen PASSED");
        } catch (Exception e) {
            Utils.printException(e);
            log.info("TC-1: sbmp Course details screen FAILED");
            throw (e);
        }
    }

    public static void sbmpBasicDetails(String url, WebDriver driver, String[] csvCell, Logger log) throws Exception {
        try {
            JavascriptExecutor js3 = (JavascriptExecutor) driver;
            String validation = csvCell[6];
            String middlename = csvCell[91];

            String aadharnumber = csvCell[93];

            Utils.smallSleepBetweenClicks(1);
            Utils.callSendkeys(driver, ActionXpath.childMiddleName, middlename, "enter childMiddleName");
            Utils.scrollUpOrDown(driver, time);
            Utils.scrollUpOrDown(driver, time);
            Utils.callSendkeys(driver, ActionXpath.childaadharNumber, aadharnumber, "enter childaadharNumber");
            Utils.scrollUpOrDown(driver, time);

            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.clickonTransport, time, " clickonTransport");
            Utils.clickXpath(driver, ActionXpath.selecttransport, time, " selecttransport");
            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.clickonTrip, time, " clickonTrip");
            Utils.clickXpath(driver, ActionXpath.selecttrip, time, " selecttrip");

            Utils.scrollUpOrDown(driver, time);
            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.ClickNext, time, "click on Next");

            Utils.smallSleepBetweenClicks(1);
            log.info("TC-1: Populating Basic Details PASSED");
        } catch (Exception e) {
            Utils.printException(e);
            log.warning("TC-1: Populating Basic Details FAILED");
            throw (e);
        }
    }

    public static void sbmpFamilyInfo(String url, WebDriver driver, String[] csvCell, Logger log) throws Exception {
        try {
            String parentfirstName = csvCell[94];
            String parentmiddleName = csvCell[95];
            String parentlastName = csvCell[96];
            String parentphone = csvCell[97];
            String email = csvCell[98];
            String aadharnumber = csvCell[93];

            String annualIncome = csvCell[99];
            String validation = csvCell[27];
            Utils.smallSleepBetweenClicks(1);
            Utils.clickXpath(driver, ActionXpath.parentclickonrelationship, time, "parentclickonrelationship");

            Utils.clickXpath(driver, ActionXpath.parentsselectrelationship, time, "parentsselectrelationship");
            Utils.smallSleepBetweenClicks(1);
            if (validation.equals("TRUE")) {
                validate.testForCharLength(driver, ActionXpath.parentfirstName, ActionXpath.fnameerror, log, 41);
                Utils.cleartext(driver, ActionXpath.parentfirstName);
                validate.specialcharacter(driver, ActionXpath.parentfirstName, ActionXpath.fnameerror, log);
                validate.testForMandatoryField(driver, ActionXpath.parentfirstName, ActionXpath.fnameerror, log);
            }
            Utils.callSendkeys(driver, ActionXpath.parentfirstName, parentfirstName, "Enter Fist name");
            Utils.scrollUpOrDown(driver, time);

            Utils.callSendkeys(driver, ActionXpath.Parentmiddlename, parentmiddleName, "Enter Parentmiddlename");
            Utils.scrollUpOrDown(driver, time);

            if (validation.equals("TRUE")) {
                validate.testForCharLength(driver, ActionXpath.parentlastName, ActionXpath.lnameerror, log, 41);
                Utils.cleartext(driver, ActionXpath.parentlastName);
                validate.specialcharacter(driver, ActionXpath.parentlastName, ActionXpath.lnameerror, log);
                validate.testForMandatoryField(driver, ActionXpath.parentlastName, ActionXpath.lnameerror, log);
            }
            Utils.callSendkeys(driver, ActionXpath.parentlastName, parentlastName, "Enter Last NAme");
            Utils.scrollUpOrDown(driver, time);
            Utils.callSendkeys(driver, ActionXpath.familyphone, parentphone, "enter the parentphone");

            if (validation.equals("TRUE")) {
                validate.email(driver, ActionXpath.familyemail, ActionXpath.emailerror, log);
            }
            email = Utils.genrateRandomEmailid();
            Utils.cleartext(driver, ActionXpath.familyemail);
            Utils.callSendkeys(driver, ActionXpath.familyemail, email, "Enter the Email");

            Utils.callSendkeys(driver, ActionXpath.familyaadhara, aadharnumber, "familyaadhara");
            Utils.scrollUpOrDown(driver, time);

            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.clickonQualification, time, "clickonQualification");
            Utils.clickXpath(driver, ActionXpath.Selecteducation, time, "Selecteducation");

            Utils.clickXpath(driver, ActionXpath.clickonoccuption, time, "clickonoccuption");
            Utils.clickXpath(driver, ActionXpath.Selectoccuption, time, "Selectoccuption");
            Utils.scrollUpOrDown(driver, time);
            if (validation.equals("TRUE")) {
                validate.testForNumberLength(driver, ActionXpath.familyannualincome, ActionXpath.incomeerror, log, 16);
                Utils.cleartext(driver, ActionXpath.familyannualincome);
                validate.specialcharacter(driver, ActionXpath.familyannualincome, ActionXpath.incomeerror, log);
                Utils.cleartext(driver, ActionXpath.familyannualincome);
            }
            Utils.callSendkeys(driver, ActionXpath.familyannualincome, annualIncome, "Selct the Annual income");

            Utils.clickXpath(driver, ActionXpath.ClickNext, time, "click on Next");
            Utils.smallSleepBetweenClicks(1);
            log.info("TC-1:Sbmp Populating Family info PASSED");
        } catch (Exception e) {
            Utils.printException(e);
            log.warning("TC-1: Sbmp Populating Family info FAILED");
            throw (e);
        }
    }

    public static void sbmp_permanentaddress_Info(String url, WebDriver driver, String[] csvCell, Logger log)
            throws Exception {
        try {
            String coursecountry = csvCell[100];
            String coursestate = csvCell[101];
            String coursecity = csvCell[102];
            String perpincode = csvCell[103];

            Utils.clickXpath(driver, ActionXpath.clickoncoursecountry, time, " clickoncoursecountry");
            Utils.selectFromDropDown(ActionXpath.selectxpath, coursecountry, driver);

            Utils.clickXpath(driver, ActionXpath.clickoncoursestate, time, " clickoncoursestate");
            Utils.selectFromDropDown(ActionXpath.selectxpath, coursestate, driver);

            Utils.clickXpath(driver, ActionXpath.clickoncoursecity, time, " clickoncoursecity");
            Utils.selectFromDropDown(ActionXpath.selectxpath, coursecity, driver);

            Utils.scrollUpOrDown(driver, time);

            Utils.callSendkeys(driver, ActionXpath.coursepincode, perpincode, "Enter coursepincode");

            Utils.scrollUpOrDown(driver, time);

            Utils.clickXpath(driver, ActionXpath.clickoncourseaddress, time, " clickoncourseaddress");
            Utils.clickXpath(driver, ActionXpath.selectcourseaddress, time, "selectcourseaddress");

            Utils.clickXpath(driver, ActionXpath.ClickNext, time, "click on Next");
            Thread.sleep(4000);
            Utils.clickXpath(driver, ActionXpath.ClickNext, time, "click on Next");
            Utils.smallSleepBetweenClicks(1);
            log.info("TC-1:Sbmp Populating address info PASSED");
        } catch (Exception e) {
            Utils.printException(e);
            log.warning("TC-1: Sbmp Populating address info FAILED");
            throw (e);
        }
    }

    public static void sbmp_document_upload(String url, WebDriver driver, String[] csvCell, Logger log)
            throws Exception {
        try {

            driver.findElement(By.xpath("(//input[@type='file'])[1]"))
                    .sendKeys("C:\\Users\\Public\\Documents\\passport.png");

            Thread.sleep(3000);
            driver.findElement(By.xpath("(//input[@type='file'])[2]"))
                    .sendKeys("C:\\Users\\Public\\Documents\\std12.jpg");

            Thread.sleep(4000);
            Utils.clickXpath(driver, ActionXpath.ClickNext, time, "click on Next");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,2000)");
            Thread.sleep(4000);
            Utils.clickXpath(driver, ActionXpath.ClickNext, time, "click on Next");
            Thread.sleep(4000);
            Utils.clickXpath(driver, ActionXpath.clickonsubmit, time, "clickonsubmit");
            log.info("TC-1: Populating Others section PASSED");
        } catch (Exception e) {
            Utils.printException(e);
            log.warning("TC-1: Populating Others section FAILED");
            throw (e);
        }
    }

    @Test(priority = 1)
    public static void SbmpAdmissionfillform(String url, WebDriver driver, String[] csvCell, Logger log)
            throws Exception {

        try {
            System.out.println("TC-1: Fill form with validation test started Executation ");
            String Sfurl = csvCell[9];

            // Thread.sleep(15000);
            login(url, driver, csvCell, log);

            sbmpApplyforCourse(Sfurl, driver, csvCell, log);
            sbmpBasicDetails(url, driver, csvCell, log);
            sbmpFamilyInfo(Sfurl, driver, csvCell, log);
            sbmp_permanentaddress_Info(Sfurl, driver, csvCell, log);
            sbmp_document_upload(Sfurl, driver, csvCell, log);

            log.info("TC-1: Sbmp Fill form with validation test Completed and Passed ");

        } catch (Exception e) {
            log.warning("TC-1: Sbmp Fill form with validation test Failed");
            Utils.printException(e);
            throw (e);

        }
    }

}