package com.ken42;

import org.apache.commons.lang3.Validate;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.annotations.Test;

import net.bytebuddy.asm.Advice.Exit;

public class spjain {
    public static Logger log = Logger.getLogger("App_portal");
    static int time = 2000;
    public static WebDriver driver;

    public static void login(String url, WebDriver driver, String[] csvCell, Logger log) throws Exception {
        try {

            String email = csvCell[2];
            String password = csvCell[3];

            driver.navigate().refresh();
            Thread.sleep(3000);
         //   ((JavascriptExecutor) driver).executeScript("window.open()");
            ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tab.get(0));
            Thread.sleep(3000);
            Utils.callSendkeys(driver, ActionXpath.EnterEmail, email, "Enter r mail address ");
            Utils.clickXpath(driver, ActionXpath.Verify, time, "verify");
            Utils.bigSleepBetweenClicks(2);
            Utils.getAndSentOTP(driver, email, password);
            Utils.clickXpath(driver, ActionXpath.Verifylogin, time, "Verify Login ");
            String apply = csvCell[13];
            log.info("Applied course:" + apply);
            log.info("TC-1: Login was succesful");

        } catch (Exception e) {
            Utils.printException(e);
            String apply = csvCell[13];
            log.info("Applied course:" + apply);
            log.warning("TC-1: Login failed");
            throw (e);
        }
    }

    public static void ApplyforCourse(String url, WebDriver driver, String[] csvCell, Logger log) throws Exception {
        try {
            String Programe = csvCell[13];

            Utils.callSendkeys(driver, ActionXpath.searchthecourse, Programe, "Enter program");
            WebElement textbox = driver.findElement(By.xpath("//input[@placeholder='Search...']"));
            textbox.sendKeys(Keys.ENTER);
            Utils.smallSleepBetweenClicks(3);
            Utils.clickXpath(driver, ActionXpath.ApplyNow, time, "Click on apply");
            Utils.clickXpath(driver, ActionXpath.ClickNext, time, "click on Next");
            Utils.clickXpath(driver, ActionXpath.Selectmentor, time, "Slect the mentor");
            Utils.clickXpath(driver, ActionXpath.selectYes, time, "Slect  yes ");
            Utils.scrollUpOrDown(driver, time);
            Utils.scrollUpOrDown(driver, time);

            if (csvCell[13].equals("Global MBA") || csvCell[13].equals("Masters of Global Business Management VS-1")
                    || csvCell[13].equals("Doctor of Business Administration")) {
                System.out.println("No campus selection for Global MBA");
            } else {
                Utils.clickXpath(driver, ActionXpath.campus, time, "Select the campus");
                String campus = csvCell[14];
                Utils.selectFromDropDown(ActionXpath.selectxpath, campus, driver);
                Utils.scrollUpOrDown(driver, time);
            }

            if (csvCell[13].equals("Bachelor of Business Communication")) {
                System.out.println("No Specialization for BBC");
            } else {
                String Specilization = csvCell[15];
                Utils.clickXpath(driver, ActionXpath.Specilization, time, "Specilization");
                Utils.selectFromDropDown(ActionXpath.selectxpath, Specilization, driver);
            }

            Utils.clickXpath(driver, ActionXpath.ClickNext, time, "click on Next");
            Utils.smallSleepBetweenClicks(1);
            log.info("TC-1: Course deatil screen PASSED");
        } catch (

        Exception e) {
            Utils.printException(e);
            log.info("TC-1: Course details screen FAILED");
            throw (e);
        }
    }

    public static void BasicDetails(String url, WebDriver driver, String[] csvCell, Logger log) throws Exception {
        try {
            JavascriptExecutor js3 = (JavascriptExecutor) driver;
            String validation = csvCell[6];

            String dob = csvCell[35];
            String nationality = csvCell[17];
            String passport = csvCell[18];
            String country = csvCell[19];
            String state = csvCell[20];
            String city = csvCell[21];
            String street = csvCell[22];
            String PostalCode = csvCell[23];

            Utils.callSendkeys(driver, ActionXpath.dob, dob, "Set date of birth");
            Utils.scrollUpOrDown(driver, time);
            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.Nationaliydrop, time, "open nationality dropdown");
            Utils.selectFromDropDown(ActionXpath.selectxpath, nationality, driver);

            if (validation.equals("TRUE")) {
                Utils.cleartext(driver, ActionXpath.passport);
                validate.testForCharLength(driver, ActionXpath.passport, ActionXpath.passporterror, log, 13);
                Utils.cleartext(driver, ActionXpath.passport);
                validate.specialcharacter(driver, ActionXpath.passport, ActionXpath.passporterror, log);
                Utils.cleartext(driver, ActionXpath.passport);

            }
            Utils.cleartext(driver, ActionXpath.passport);
            Utils.callSendkeys(driver, ActionXpath.passport, passport, "Enter your Passport");

            Utils.scrollUpOrDown(driver, time);
            Utils.scrollUpOrDown(driver, time);
            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.Gender, time, "Select the Gender ");
            Utils.clickXpath(driver, ActionXpath.Mstatus, time, "Select your material status");
            Utils.scrollUpOrDown(driver, time);
            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.selectcountry, time, "Enter your selectcountry");
            // Alternate way of selecting from dropdown
            // String ctryxpath =
            // "//*[@id=\"menu-addresses[0][mailingCountry]\"]//*[text()='United States']";
            // Utils.clickXpath(driver, ctryxpath, time, "click on selected country");
            Utils.selectFromDropDown(ActionXpath.selectxpath, country, driver);
            Utils.clickXpath(driver, ActionXpath.selectstate, time, "Select the satet");
            Utils.selectFromDropDown(ActionXpath.selectxpath, state, driver);
            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.selectDist, time, "Select the Dist");
            Utils.selectFromDropDown(ActionXpath.selectxpath, city, driver);
            Utils.scrollUpOrDown(driver, time);

            if (validation.equals("TRUE")) {
                validate.testForCharLength(driver, ActionXpath.street, ActionXpath.addresserror, log, 201);
                Utils.cleartext(driver, ActionXpath.street);
                validate.specialcharacter(driver, ActionXpath.street, ActionXpath.addresserror, log);
                Utils.cleartext(driver, ActionXpath.street);
                validate.testForMandatoryField(driver, ActionXpath.street, ActionXpath.addresserror, log);
            }
            Utils.cleartext(driver, ActionXpath.street);
            Utils.callSendkeys(driver, ActionXpath.street, street, "enter your permanent addrrss");

            if (validation.equals("TRUE")) {
                validate.testForCharLength(driver, ActionXpath.PostalCode, ActionXpath.pincodeerror, log, 11);
                Utils.cleartext(driver, ActionXpath.PostalCode);
                validate.specialcharacter(driver, ActionXpath.PostalCode, ActionXpath.pincodeerror, log);
                Utils.cleartext(driver, ActionXpath.PostalCode);
                validate.testForMandatoryField(driver, ActionXpath.PostalCode, ActionXpath.pincodeerror, log);
            }
            Utils.cleartext(driver, ActionXpath.PostalCode);
            Utils.callSendkeys(driver, ActionXpath.PostalCode, PostalCode, "Select your Postal Code");

            Utils.scrollUpOrDown(driver, time);
            Utils.scrollUpOrDown(driver, time);
            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.currentaddress, time, "Click the address");
            Utils.clickXpath(driver, ActionXpath.selectcurrentaddress, time, "Click the address");
            Utils.clickXpath(driver, ActionXpath.ClickNext, time, "click on Next");
            Utils.smallSleepBetweenClicks(1);
            log.info("TC-1: Populating Basic Details PASSED");
        } catch (Exception e) {
            Utils.printException(e);
            log.warning("TC-1: Populating Basic Details FAILED");
            throw (e);
        }
    }

    public static void FamilyInfo(String url, WebDriver driver, String[] csvCell, Logger log) throws Exception {
        try {
            String firstName = csvCell[24];
            String lastName = csvCell[25];
            String Phone = csvCell[26];
            String Email = csvCell[27];
            String Age = csvCell[28];
            String occupation = csvCell[29];
            String annualIncome = csvCell[30];
            String validation = csvCell[6];
            Utils.clickXpath(driver, ActionXpath.selectrelationship, time, "Select the Relationship status option");
            Utils.clickXpath(driver, ActionXpath.relationType, time, "Select the relationhip Type");

            if (validation.equals("TRUE")) {
                validate.testForCharLength(driver, ActionXpath.firstName, ActionXpath.fnameerror, log, 41);
                Utils.cleartext(driver, ActionXpath.firstName);
                validate.specialcharacter(driver, ActionXpath.firstName, ActionXpath.fnameerror, log);
                validate.testForMandatoryField(driver, ActionXpath.firstName, ActionXpath.fnameerror, log);
            }
            Utils.callSendkeys(driver, ActionXpath.firstName, firstName, "Enter Fist name");
            Utils.scrollUpOrDown(driver, time);

            if (validation.equals("TRUE")) {
                validate.testForCharLength(driver, ActionXpath.lastName, ActionXpath.lnameerror, log, 41);
                Utils.cleartext(driver, ActionXpath.lastName);
                validate.specialcharacter(driver, ActionXpath.lastName, ActionXpath.lnameerror, log);
                validate.testForMandatoryField(driver, ActionXpath.lastName, ActionXpath.lnameerror, log);
            }
            Utils.callSendkeys(driver, ActionXpath.lastName, lastName, "Enter Last NAme");
            Utils.callSendkeys(driver, ActionXpath.Phone, Phone, "enter the Phone");
            Utils.scrollUpOrDown(driver, time);

            if (validation.equals("TRUE")) {
                validate.email(driver, ActionXpath.Email, ActionXpath.emailerror, log);
            }
            Email = Utils.genrateRandomEmailid();
            Utils.cleartext(driver, ActionXpath.Email);
            Utils.callSendkeys(driver, ActionXpath.Email, Email, "Enter the Email");

            if (validation.equals("TRUE")) {
                validate.specialcharacter(driver, ActionXpath.Age, ActionXpath.ageerror, log);
                Utils.cleartext(driver, ActionXpath.Age);
                validate.testForNumberLength(driver, ActionXpath.Age, ActionXpath.ageerror, log, 4);
                validate.testForMandatoryField(driver, ActionXpath.Age, ActionXpath.ageerror, log);
            }
            Utils.cleartext(driver, ActionXpath.Age);
            Utils.callSendkeys(driver, ActionXpath.Age, Age, "Populate Age");
            Utils.scrollUpOrDown(driver, time);

            if (validation.equals("TRUE")) {
                validate.testForCharLength(driver, ActionXpath.occupation, ActionXpath.occupationerror, log, 81);
                Utils.cleartext(driver, ActionXpath.occupation);
                validate.specialcharacter(driver, ActionXpath.occupation, ActionXpath.occupationerror, log);
                Utils.cleartext(driver, ActionXpath.occupation);
                validate.testAlphaOnly(driver, ActionXpath.occupation, ActionXpath.occupationerror, log);
                validate.testForMandatoryField(driver, ActionXpath.occupation, ActionXpath.occupationerror, log);
            }
            Utils.callSendkeys(driver, ActionXpath.occupation, occupation, "Enter Occupation");

            if (validation.equals("TRUE")) {
                validate.testForNumberLength(driver, ActionXpath.annualIncome, ActionXpath.incomeerror, log, 19);
                Utils.cleartext(driver, ActionXpath.annualIncome);
                validate.specialcharacter(driver, ActionXpath.annualIncome, ActionXpath.incomeerror, log);
                Utils.cleartext(driver, ActionXpath.annualIncome);
            }
            Utils.callSendkeys(driver, ActionXpath.annualIncome, annualIncome, "Selct the Annual income");

            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.SelectQualification, time, "Select the Qualification");
            Utils.clickXpath(driver, ActionXpath.Qualification, time, "Select the appropriate Qualification");
            Utils.clickXpath(driver, ActionXpath.CurrencyTypeSelect, time, "Select currency");
            Utils.clickXpath(driver, ActionXpath.currencyType, time, "Select the appropriate currency");
            Utils.clickXpath(driver, ActionXpath.ClickNext, time, "click on Next");
            Utils.smallSleepBetweenClicks(1);
            log.info("TC-1: Populating Family info PASSED");
        } catch (Exception e) {
            Utils.printException(e);
            log.warning("TC-1: Populating Family info FAILED");
            throw (e);
        }
    }

    public static void EmploymentInfo(String url, WebDriver driver, String csvCell[], Logger log) throws Exception {
        try {
            Utils.bigSleepBetweenClicks(1);
            String Company = csvCell[31];
            String industry = csvCell[32];
            String Country = csvCell[33];
            String state = csvCell[34];
            String city = csvCell[35];
            String Designation = csvCell[36];
            String Role = csvCell[37];
            String dateofJoin = csvCell[38];
            String experince = csvCell[39];
            String Annual = csvCell[40];
            String CurrencyType = csvCell[41];
            String validation = csvCell[6];
            Utils.clickXpath(driver, ActionXpath.clickyes, time, "clickyes");
            Utils.clickXpath(driver, ActionXpath.SelectjobType, time, "Select the Job type");
            Utils.clickXpath(driver, ActionXpath.jobType, time, "Select the Appropriate job ");
            if (validation.equals("TRUE")) {
                validate.testForCharLength(driver, ActionXpath.company, ActionXpath.companyerror, log, 101);
                Utils.cleartext(driver, ActionXpath.company);
                validate.specialcharacter(driver, ActionXpath.company, ActionXpath.companyerror, log);
                validate.testForMandatoryField(driver, ActionXpath.company, ActionXpath.companyerror, log);
            }
            Utils.cleartext(driver, ActionXpath.company);
            Utils.callSendkeys(driver, ActionXpath.company, Company, "enter the company name");

            Utils.scrollUpOrDown(driver, time);
            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.IndustryType, time, "IndustryType ");
            Utils.selectFromDropDown(ActionXpath.selectxpath, industry, driver);
            Utils.clickXpath(driver, ActionXpath.Country, time, "Click on the Country");
            Utils.selectFromDropDown(ActionXpath.selectxpath, Country, driver);
            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.state, time, "Selext the State");
            Utils.selectFromDropDown(ActionXpath.selectxpath, state, driver);
            Utils.clickXpath(driver, ActionXpath.city, time, "Select the City");
            Utils.selectFromDropDown(ActionXpath.selectxpath, city, driver);
            Utils.scrollUpOrDown(driver, time);

            if (validation.equals("TRUE")) {
                validate.testForCharLength(driver, ActionXpath.designation, ActionXpath.designationerror, log, 81);
                Utils.cleartext(driver, ActionXpath.designation);
                validate.specialcharacter(driver, ActionXpath.designation, ActionXpath.designationerror, log);
                Utils.cleartext(driver, ActionXpath.designation);
                validate.testForMandatoryField(driver, ActionXpath.designation, ActionXpath.designationerror, log);
            }
            Utils.cleartext(driver, ActionXpath.designation);
            Utils.callSendkeys(driver, ActionXpath.designation, Designation, "enter the Designation ");

            Utils.scrollUpOrDown(driver, time);
            if (validation.equals("TRUE")) {
                validate.testForCharLength(driver, ActionXpath.role, ActionXpath.roleserror, log, 81);
                Utils.cleartext(driver, ActionXpath.role);
                validate.specialcharacter(driver, ActionXpath.role, ActionXpath.roleserror, log);
                Utils.cleartext(driver, ActionXpath.role);
                validate.testAlphaOnly(driver, ActionXpath.role, ActionXpath.roleserror, log);
                Utils.cleartext(driver, ActionXpath.role);
                validate.testForMandatoryField(driver, ActionXpath.role, ActionXpath.roleserror, log);
            }
            Utils.cleartext(driver, ActionXpath.role);
            Utils.callSendkeys(driver, ActionXpath.role, Role, "enter the Role ");

            Utils.callSendkeys(driver, ActionXpath.DateJoin, dateofJoin, "enter the date of joining");
            Utils.clickXpath(driver, ActionXpath.CurrentCompany, time, "CurrentCompany");
            Utils.clickXpath(driver, ActionXpath.selectCurrentCompany, time, "selectCurrentCompany");
            Utils.scrollUpOrDown(driver, time);

            if (validation.equals("TRUE")) {
                validate.testForNumberLength(driver, ActionXpath.Experience, ActionXpath.monthserror, log, 4);
                Utils.cleartext(driver, ActionXpath.Experience);
                validate.specialcharacter(driver, ActionXpath.Experience, ActionXpath.monthserror, log);
                Utils.cleartext(driver, ActionXpath.Experience);
                validate.testForMandatoryField(driver, ActionXpath.Experience, ActionXpath.monthserror, log);
                Utils.cleartext(driver, ActionXpath.Experience);
            }
            Utils.callSendkeys(driver, ActionXpath.Experience, experince, "enter the Experience");

            if (validation.equals("TRUE")) {
                validate.testForNumberLength(driver, ActionXpath.AnnualSalary, ActionXpath.annualerror, log, 19);
                Utils.cleartext(driver, ActionXpath.AnnualSalary);
                validate.specialcharacter(driver, ActionXpath.AnnualSalary, ActionXpath.annualerror, log);
                Utils.cleartext(driver, ActionXpath.AnnualSalary);
                validate.testForMandatoryField(driver, ActionXpath.AnnualSalary, ActionXpath.annualerror, log);
            }
            Utils.cleartext(driver, ActionXpath.AnnualSalary);
            Utils.callSendkeys(driver, ActionXpath.AnnualSalary, Annual, "Enter the annual Salary");

            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.currencytype, time, "currencytype");
            Utils.selectFromDropDown(ActionXpath.selectxpath, CurrencyType, driver);

            Utils.clickXpath(driver, ActionXpath.ClickNext, time, "click on Next");
            Utils.smallSleepBetweenClicks(1);
            log.info("TC-1: Populting Empoyment detail PASSED");
        } catch (Exception e) {
            Utils.printException(e);
            log.info("TC-1: Populting Empoyment detail FAILED");
            throw (e);
        }
    }

    public static void EducationINFO(String url, WebDriver driver, String[] csvCell, Logger log) throws Exception {
        try {
            if (csvCell[13].equals("Bachelor of Business Communication")) {
                System.out.println("No ug and pg");
                // 12
                String hscboard = csvCell[62];
                String hscpercentage = csvCell[63];
                String hscyear = csvCell[64];
                String hscschool = csvCell[65];
                String hsccountry = csvCell[66];
                String hscstate = csvCell[67];
                String hsccity = csvCell[68];
                String ugcollege = csvCell[52];

                // Utils.scrollUpOrDown(driver, time);

                Utils.clickXpath(driver, ActionXpath.hscedtype_1, time, "hscedtype");
                Utils.clickXpath(driver, ActionXpath.hscselectedtype_1, time, "hscselectedtype");
                Utils.clickXpath(driver, ActionXpath.hscboard, time, "hscboard");
                Utils.selectFromDropDown(ActionXpath.selectxpath, hscboard, driver);
                Utils.scrollUpOrDown(driver, time);
                if (csvCell[13].equals("Masters of Global Business Management VS-1")) {
                    Utils.clickXpath(driver, ActionXpath.hscgradeType, time, "hscgrade type");
                    Utils.clickXpath(driver, ActionXpath.hscgradeselect, time, "hscgradeselect");
                } else {
                    Utils.clickXpath(driver, ActionXpath.gradeType_1, time, "grade type");
                    Utils.clickXpath(driver, ActionXpath.hscgradeselect, time, "hscgradeselect");
                }

                Utils.cleartext(driver, ActionXpath.hscpercentage_1);
                Utils.callSendkeys(driver, ActionXpath.hscpercentage_1, hscpercentage, "hscpercentage");

                Utils.selectFromDropDown(ActionXpath.selectxpath, ugcollege, driver);
                Utils.callSendkeys(driver, ActionXpath.hscyear_1, hscyear, "hscyear");
                Utils.scrollUpOrDown(driver, time);

                Utils.cleartext(driver, ActionXpath.hscschool_1);
                Utils.callSendkeys(driver, ActionXpath.hscschool_1, hscschool, "hscschool");

                Utils.clickXpath(driver, ActionXpath.hsccountry_1, time, "hsccountry");
                Utils.selectFromDropDown(ActionXpath.selectxpath, hsccountry, driver);
                Utils.scrollUpOrDown(driver, time);
                Utils.clickXpath(driver, ActionXpath.hscstate_1, time, "hscstate");
                Utils.selectFromDropDown(ActionXpath.selectxpath, hscstate, driver);

                Utils.scrollUpOrDown(driver, time);
                Utils.clickXpath(driver, ActionXpath.hsccity_1, time, "hsccity");
                Utils.selectFromDropDown(ActionXpath.selectxpath, hsccity, driver);
                Utils.scrollUpOrDown(driver, time);
                Utils.scrollUpOrDown(driver, time);

                // 10
                String sslcboard = csvCell[69];
                String sslcpercentage = csvCell[70];
                String sslcyear = csvCell[71];
                String sslcschool = csvCell[72];
                String sslccountry = csvCell[73];
                String sslcstate = csvCell[74];
                String sslccity = csvCell[75];
                Utils.clickXpath(driver, ActionXpath.sslcedtype_1, time, "sslcedtype");
                Utils.clickXpath(driver, ActionXpath.sslcselectedtype_1, time, "sslcselectedtype");
                Utils.clickXpath(driver, ActionXpath.sslcboard, time, "sslcboard");
                Utils.selectFromDropDown(ActionXpath.selectxpath, sslcboard, driver);
                Utils.scrollUpOrDown(driver, time);
                Utils.scrollUpOrDown(driver, time);
                if (csvCell[13].equals("Masters of Global Business Management VS-1")) {
                    Utils.clickXpath(driver, ActionXpath.sslcgradeType, time, "sslcgrade");
                    Utils.clickXpath(driver, ActionXpath.sslcselectgrade, time, "sslcselectgrade");
                } else {
                    Utils.clickXpath(driver, ActionXpath.sslcgrade_1, time, "sslcgrade");
                    Utils.clickXpath(driver, ActionXpath.sslcselectgrade, time, "sslcselectgrade");
                }
                Utils.callSendkeys(driver, ActionXpath.sslcpercentage_1, sslcpercentage, "sslcpercentage");
                Utils.scrollUpOrDown(driver, time);
                Utils.callSendkeys(driver, ActionXpath.sslcyear_1, sslcyear, "sslcyear");
                Utils.callSendkeys(driver, ActionXpath.sslcschool_1, sslcschool, "sslcschool");
                Utils.scrollUpOrDown(driver, time);
                Utils.clickXpath(driver, ActionXpath.sslccountry_1, time, "sslccountry");
                Utils.selectFromDropDown(ActionXpath.selectxpath, sslccountry, driver);
                Utils.clickXpath(driver, ActionXpath.sslcstate_1, time, "sslcstate");
                Utils.selectFromDropDown(ActionXpath.selectxpath, sslcstate, driver);
                Utils.scrollUpOrDown(driver, time);
                Utils.scrollUpOrDown(driver, time);
                Utils.clickXpath(driver, ActionXpath.sslccity_1, time, "sslccity");
                Utils.selectFromDropDown(ActionXpath.selectxpath, sslccity, driver);
                Utils.clickXpath(driver, ActionXpath.ClickNext, time, "click on Next");
                Utils.smallSleepBetweenClicks(1);
                log.info("TC-1: Populating Education details PASSED");

            } else {
                Utils.bigSleepBetweenClicks(1);
                String pgyear = csvCell[42];
                String pguniversity = csvCell[43];
                String pgcollege = csvCell[44];
                String pgpercentage = csvCell[45];
                String pgdegree = csvCell[46];
                String pgcountry = csvCell[47];
                String pgstate = csvCell[48];
                String pgcity = csvCell[49];
                String validation = csvCell[6];

                // pg
                Utils.callSendkeys(driver, ActionXpath.pgyear, pgyear, "pgyear");
                if (validation.equals("TRUE")) {
                    validate.testForCharLength(driver, ActionXpath.pguniversity, ActionXpath.pguniversityerror, log,
                            81);
                    Utils.cleartext(driver, ActionXpath.pguniversity);
                    validate.testAlphaOnly(driver, ActionXpath.pguniversity, ActionXpath.pguniversityerror, log);
                    Utils.cleartext(driver, ActionXpath.pguniversity);

                }
                Utils.cleartext(driver, ActionXpath.pguniversity);
                Utils.callSendkeys(driver, ActionXpath.pguniversity, pguniversity, "pguniversity");
                Utils.selectFromDropDown(ActionXpath.selectxpath, pguniversity, driver);

                Utils.scrollUpOrDown(driver, time);
                if (validation.equals("TRUE")) {
                    validate.testForCharLength(driver, ActionXpath.pgcollege, ActionXpath.pgcollegeerror, log, 81);
                    Utils.cleartext(driver, ActionXpath.pgcollege);
                    validate.testAlphaOnly(driver, ActionXpath.pgcollege, ActionXpath.pgcollegeerror, log);
                    Utils.cleartext(driver, ActionXpath.pgcollege);
                }
                Utils.cleartext(driver, ActionXpath.pgcollege);
                Utils.callSendkeys(driver, ActionXpath.pgcollege, pgcollege, "pgcollege");

                Utils.clickXpath(driver, ActionXpath.pgedttype, time, "pgedttype");
                Utils.clickXpath(driver, ActionXpath.pgselectedttype, time, "pgselectedttype");
                Utils.scrollUpOrDown(driver, time);
                Utils.clickXpath(driver, ActionXpath.pgdegree, time, "pgdegree");
                Utils.selectFromDropDown(ActionXpath.pgdegreeselect, pgdegree, driver);
                if (csvCell[13].equals("Masters of Global Business Management VS-1")) {
                    System.out.println("No evaluation for Masters of Global Business Management VS-1");
                } else {
                    Utils.clickXpath(driver, ActionXpath.pgevaluation, time, "pgevaluation");
                    Utils.clickXpath(driver, ActionXpath.pgevaluationselect, time, "pgevaluationselect");
                }
                if (validation.equals("TRUE")) {
                    validate.specialcharacter(driver, ActionXpath.pgpercentage, ActionXpath.pgpercentageerror,
                            log);
                    Utils.cleartext(driver, ActionXpath.pgpercentage);
                    // validate.testForNumberLength(driver, ActionXpath.pgpercentage,
                    // ActionXpath.pgpercentageerror, log,
                    // 6);
                }
                Utils.cleartext(driver, ActionXpath.pgpercentage);
                Utils.callSendkeys(driver, ActionXpath.pgpercentage, pgpercentage, "pgpercentage");
                Utils.selectFromDropDown(ActionXpath.selectxpath, pgpercentage, driver);
                Utils.scrollUpOrDown(driver, time);

                Utils.clickXpath(driver, ActionXpath.pgcountry, time, "pgcountry");
                Utils.selectFromDropDown(ActionXpath.pgcountryselect, pgcountry, driver);
                Utils.scrollUpOrDown(driver, time);
                Utils.clickXpath(driver, ActionXpath.pgstate, time, "pgstate");
                Utils.selectFromDropDown(ActionXpath.pgstateselect, pgstate, driver);
                Utils.clickXpath(driver, ActionXpath.pgcity, time, "pgcity");
                Utils.selectFromDropDown(ActionXpath.pgcityselect, pgcity, driver);
                Utils.scrollUpOrDown(driver, time);
                // ug

                String ugyear = csvCell[50];
                String uguniversity = csvCell[51];
                String ugcollege = csvCell[52];
                String ugpercentage = csvCell[53];
                String ugdegree = csvCell[54];
                String ugcountry = csvCell[55];
                String ugstate = csvCell[56];
                String ugcity = csvCell[57];
                String ugmark1 = csvCell[58];
                String ugmaxmark1 = csvCell[59];
                String ugmark2 = csvCell[60];
                String ugmaxmark2 = csvCell[61];

                Utils.callSendkeys(driver, ActionXpath.ugyear, ugyear, "ugyear");

                if (validation.equals("TRUE")) {
                    validate.testForCharLength(driver, ActionXpath.uguniversity, ActionXpath.uguniversityerror, log,
                            81);
                    Utils.cleartext(driver, ActionXpath.uguniversity);
                    validate.testAlphaOnly(driver, ActionXpath.uguniversity, ActionXpath.uguniversityerror, log);
                    validate.testForMandatoryField(driver, ActionXpath.uguniversity, ActionXpath.uguniversityerror,
                            log);
                }
                Utils.cleartext(driver, ActionXpath.uguniversity);
                Utils.callSendkeys(driver, ActionXpath.uguniversity, uguniversity, "uguniversity");
                Utils.selectFromDropDown(ActionXpath.selectxpath, uguniversity, driver);

                Utils.scrollUpOrDown(driver, time);

                if (validation.equals("TRUE")) {
                    validate.testForCharLength(driver, ActionXpath.ugcollege, ActionXpath.ugcollegeerror, log, 81);
                    Utils.cleartext(driver, ActionXpath.ugcollege);
                    validate.testAlphaOnly(driver, ActionXpath.ugcollege, ActionXpath.ugcollegeerror, log);
                    validate.testForMandatoryField(driver, ActionXpath.ugcollege, ActionXpath.ugcollegeerror, log);
                }
                Utils.cleartext(driver, ActionXpath.ugcollege);
                Utils.callSendkeys(driver, ActionXpath.ugcollege, ugcollege, "ugcollege");
                Utils.selectFromDropDown(ActionXpath.selectxpath, ugcollege, driver);
                Utils.clickXpath(driver, ActionXpath.ugedtype, time, "ugedtype");
                Utils.clickXpath(driver, ActionXpath.ugselectedtype, time, "ugselectedtype");
                Utils.clickXpath(driver, ActionXpath.ugdegree, time, "ugdegree");
                Utils.selectFromDropDown(ActionXpath.selectxpath, ugdegree, driver);
                Utils.scrollUpOrDown(driver, time);
                if (csvCell[13].equals("Masters of Global Business Management VS-1")) {
                    System.out.println("No evaluation for Masters of Global Business Management VS-1");
                } else {
                    Utils.clickXpath(driver, ActionXpath.ugevaluation, time, "ugevaluation");
                    Utils.clickXpath(driver, ActionXpath.ugevaluationselect, time, "ugevaluationselect");
                }
                if (validation.equals("TRUE")) {
                    validate.specialcharacter(driver, ActionXpath.ugpercentage, ActionXpath.ugpercentageerror, log);
                    Utils.cleartext(driver, ActionXpath.ugpercentage);
                    // validate.testForNumberLength(driver, ActionXpath.ugpercentage,
                    // ActionXpath.ugpercentageerror, log,
                    // 6);
                    validate.testForMandatoryField(driver, ActionXpath.ugpercentage, ActionXpath.ugpercentageerror,
                            log);
                }
                Utils.cleartext(driver, ActionXpath.ugpercentage);
                Utils.callSendkeys(driver, ActionXpath.ugpercentage, ugpercentage, "ugpercentage");
                Utils.selectFromDropDown(ActionXpath.selectxpath, ugpercentage, driver);
                Utils.scrollUpOrDown(driver, time);

                Utils.clickXpath(driver, ActionXpath.ugcountry, time, "ugcountry");
                Utils.selectFromDropDown(ActionXpath.selectxpath, ugcountry, driver);
                Utils.clickXpath(driver, ActionXpath.ugstate, time, "ugstate");
                Utils.selectFromDropDown(ActionXpath.selectxpath, ugstate, driver);
                Utils.scrollUpOrDown(driver, time);
                Utils.clickXpath(driver, ActionXpath.ugcity, time, "ugcity");
                Utils.selectFromDropDown(ActionXpath.selectxpath, ugcity, driver);
                Utils.scrollUpOrDown(driver, time);
                Utils.clickXpath(driver, ActionXpath.ugtype, time, "ugtype");
                Utils.clickXpath(driver, ActionXpath.ugselecttype, time, "ugselecttype");
                Utils.clickXpath(driver, ActionXpath.ugyear1, time, "ugyear1");
                Utils.clickXpath(driver, ActionXpath.ugselectyear1, time, "ugselectyear1");
                Utils.callSendkeys(driver, ActionXpath.ugmark1, ugmark1, "ugmark1");
                Utils.scrollUpOrDown(driver, time);
                Utils.callSendkeys(driver, ActionXpath.ugmaxmark1, ugmaxmark1, "ugmaxmark1");
                Utils.scrollUpOrDown(driver, time);
                Utils.clickXpath(driver, ActionXpath.ugyear2, time, "ugyear2");
                Utils.clickXpath(driver, ActionXpath.ugselectyear2, time, "ugselectyear2");
                Utils.callSendkeys(driver, ActionXpath.ugmark2, ugmark2, "ugmark2");
                Utils.scrollUpOrDown(driver, time);
                Utils.callSendkeys(driver, ActionXpath.ugmaxmark2, ugmaxmark2, "ugmaxmark2");
                Utils.scrollUpOrDown(driver, time);

                // 12
                String hscboard = csvCell[62];
                String hscpercentage = csvCell[63];
                String hscyear = csvCell[64];
                String hscschool = csvCell[65];
                String hsccountry = csvCell[66];
                String hscstate = csvCell[67];
                String hsccity = csvCell[68];
                Utils.scrollUpOrDown(driver, time);
                Utils.scrollUpOrDown(driver, time);

                Utils.clickXpath(driver, ActionXpath.hscedtype, time, "hscedtype");
                Utils.clickXpath(driver, ActionXpath.hscselectedtype, time, "hscselectedtype");
                Utils.clickXpath(driver, ActionXpath.hscboard, time, "hscboard");
                Utils.selectFromDropDown(ActionXpath.selectxpath, hscboard, driver);
                Utils.scrollUpOrDown(driver, time);
                if (csvCell[13].equals("Masters of Global Business Management VS-1")) {
                    Utils.clickXpath(driver, ActionXpath.hscgradeType, time, "hscgrade type");
                    Utils.clickXpath(driver, ActionXpath.hscgradeselect, time, "hscgradeselect");
                } else {
                    Utils.clickXpath(driver, ActionXpath.gradeType, time, "grade type");
                    Utils.clickXpath(driver, ActionXpath.hscgradeselect, time, "hscgradeselect");
                }
                if (validation.equals("TRUE")) {
                    // validate.testForNumberLength(driver, ActionXpath.hscpercentage,
                    // ActionXpath.hscpercentageerror, log,
                    // 6);
                    Utils.cleartext(driver, ActionXpath.hscpercentage);
                    validate.specialcharacter(driver, ActionXpath.hscpercentage, ActionXpath.hscpercentageerror, log);
                    validate.testForMandatoryField(driver, ActionXpath.hscpercentage, ActionXpath.hscpercentageerror,
                            log);
                }
                Utils.cleartext(driver, ActionXpath.hscpercentage);
                Utils.callSendkeys(driver, ActionXpath.hscpercentage, hscpercentage, "hscpercentage");

                Utils.selectFromDropDown(ActionXpath.selectxpath, ugcollege, driver);
                Utils.callSendkeys(driver, ActionXpath.hscyear, hscyear, "hscyear");
                Utils.scrollUpOrDown(driver, time);

                if (validation.equals("TRUE")) {
                    validate.testForCharLength(driver, ActionXpath.hscschool, ActionXpath.hscschoolerror, log, 81);
                    Utils.cleartext(driver, ActionXpath.hscschool);
                    validate.specialcharacter(driver, ActionXpath.hscschool, ActionXpath.hscschoolerror, log);
                    validate.testForMandatoryField(driver, ActionXpath.hscschool, ActionXpath.hscschoolerror, log);
                }
                Utils.cleartext(driver, ActionXpath.hscschool);
                Utils.callSendkeys(driver, ActionXpath.hscschool, hscschool, "hscschool");

                Utils.clickXpath(driver, ActionXpath.hsccountry, time, "hsccountry");
                Utils.selectFromDropDown(ActionXpath.selectxpath, hsccountry, driver);
                Utils.scrollUpOrDown(driver, time);
                Utils.clickXpath(driver, ActionXpath.hscstate, time, "hscstate");
                Utils.selectFromDropDown(ActionXpath.selectxpath, hscstate, driver);

                Utils.scrollUpOrDown(driver, time);
                Utils.clickXpath(driver, ActionXpath.hsccity, time, "hsccity");
                Utils.selectFromDropDown(ActionXpath.selectxpath, hsccity, driver);
                Utils.scrollUpOrDown(driver, time);
                Utils.scrollUpOrDown(driver, time);

                // 10
                String sslcboard = csvCell[69];
                String sslcpercentage = csvCell[70];
                String sslcyear = csvCell[71];
                String sslcschool = csvCell[72];
                String sslccountry = csvCell[73];
                String sslcstate = csvCell[74];
                String sslccity = csvCell[75];
                Utils.clickXpath(driver, ActionXpath.sslcedtype, time, "sslcedtype");
                Utils.clickXpath(driver, ActionXpath.sslcselectedtype, time, "sslcselectedtype");
                Utils.clickXpath(driver, ActionXpath.sslcboard, time, "sslcboard");
                Utils.selectFromDropDown(ActionXpath.selectxpath, sslcboard, driver);
                Utils.scrollUpOrDown(driver, time);
                Utils.scrollUpOrDown(driver, time);
                if (csvCell[13].equals("Masters of Global Business Management VS-1")) {
                    Utils.clickXpath(driver, ActionXpath.sslcgradeType, time, "sslcgrade");
                    Utils.clickXpath(driver, ActionXpath.sslcselectgrade, time, "sslcselectgrade");
                } else {
                    Utils.clickXpath(driver, ActionXpath.sslcgrade, time, "sslcgrade");
                    Utils.clickXpath(driver, ActionXpath.sslcselectgrade, time, "sslcselectgrade");
                }
                Utils.callSendkeys(driver, ActionXpath.sslcpercentage, sslcpercentage, "sslcpercentage");
                Utils.scrollUpOrDown(driver, time);
                Utils.callSendkeys(driver, ActionXpath.sslcyear, sslcyear, "sslcyear");
                Utils.callSendkeys(driver, ActionXpath.sslcschool, sslcschool, "sslcschool");
                Utils.scrollUpOrDown(driver, time);
                Utils.clickXpath(driver, ActionXpath.sslccountry, time, "sslccountry");
                Utils.selectFromDropDown(ActionXpath.selectxpath, sslccountry, driver);
                Utils.clickXpath(driver, ActionXpath.sslcstate, time, "sslcstate");
                Utils.selectFromDropDown(ActionXpath.selectxpath, sslcstate, driver);
                Utils.scrollUpOrDown(driver, time);
                Utils.scrollUpOrDown(driver, time);
                Utils.clickXpath(driver, ActionXpath.sslccity, time, "sslccity");
                Utils.selectFromDropDown(ActionXpath.selectxpath, sslccity, driver);
                Utils.clickXpath(driver, ActionXpath.ClickNext, time, "click on Next");
                Utils.smallSleepBetweenClicks(1);
                log.info("TC-1: Populating Education details PASSED");
            }
        } catch (Exception e) {
            Utils.printException(e);
            log.warning("TC-1: Populating Education details FAILED");
            throw (e);
        }
    }

    public static void other(String url, WebDriver driver, String[] csvCell, Logger log) throws Exception {
        try {
            String validation = csvCell[6];
            String SportAchievement = csvCell[76];
            String ProfessionalAchievement = csvCell[77];
            String CurricularActivities = csvCell[78];
            String AcademicAchievements = csvCell[79];
            String Statement = csvCell[80];
            String planmasterdegree = csvCell[81];
            String language = csvCell[82];

            if (validation.equals("TRUE")) {
                validate.testForCharLength(driver, ActionXpath.SportAchievement, ActionXpath.sportsaccivemeterror, log,
                        201);
                Utils.cleartext(driver, ActionXpath.SportAchievement);
            }
            Utils.callSendkeys(driver, ActionXpath.SportAchievement, SportAchievement, "SportAchievement");

            if (validation.equals("TRUE")) {
                validate.testForCharLength(driver, ActionXpath.ProfessionalAchievement, ActionXpath.professsionalerror,
                        log, 201);
                Utils.cleartext(driver, ActionXpath.ProfessionalAchievement);

            }
            Utils.callSendkeys(driver, ActionXpath.ProfessionalAchievement, ProfessionalAchievement,
                    "ProfessionalAchievement");

            if (validation.equals("TRUE")) {
                validate.testForCharLength(driver, ActionXpath.CurricularActivities, ActionXpath.Extracurricularerror,
                        log, 201);
                Utils.cleartext(driver, ActionXpath.CurricularActivities);

            }
            Utils.scrollUpOrDown(driver, time);
            Utils.callSendkeys(driver, ActionXpath.CurricularActivities, CurricularActivities, "CurricularActivities");

            if (validation.equals("TRUE")) {
                validate.testForCharLength(driver, ActionXpath.AcademicAchievements, ActionXpath.Exceptionalerror, log,
                        201);
                Utils.cleartext(driver, ActionXpath.AcademicAchievements);

            }
            Utils.callSendkeys(driver, ActionXpath.AcademicAchievements, AcademicAchievements, "AcademicAchievements");
            Utils.scrollUpOrDown(driver, time);
            Utils.scrollUpOrDown(driver, time);

            Utils.clickXpath(driver, ActionXpath.fundeducation, time, "fundeducation");
            Utils.clickXpath(driver, ActionXpath.fundselecteducation, time, "fundselecteducation");
            Utils.clickXpath(driver, ActionXpath.physicallychallenged, time, "physicallychallenged");
            Utils.scrollUpOrDown(driver, time);

            Utils.callSendkeys(driver, ActionXpath.Statement, Statement, "Statement of purpose");

            Utils.callSendkeys(driver, ActionXpath.planmasterdegree, planmasterdegree, "planmasterdegree");
            Utils.clickXpath(driver, ActionXpath.sponsoredbycompany, time, "sponsoredbycompany");
            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.Language, time, "Language");
            Utils.selectFromDropDown(ActionXpath.selectxpath, language, driver);
            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.Proficiency, time, "Proficiency");
            Utils.clickXpath(driver, ActionXpath.SelectProficiency, time, "SelectProficiency");
            Utils.scrollUpOrDown(driver, time);
            Utils.scrollUpOrDown(driver, time);
            Utils.scrollUpOrDown(driver, time);
            Utils.scrollUpOrDown(driver, time);
            Utils.scrollUpOrDown(driver, time);

            Utils.clickXpath(driver, ActionXpath.EducationConsultant, time, "EducationConsultant");
            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.hearspjain, time, "hearspjain");
            Utils.clickXpath(driver, ActionXpath.selecthearspjain, time, "selecthearspjain");
            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.refrence, time, "refrence");
            Utils.clickXpath(driver, ActionXpath.ClickNext, time, "click on Next");
            log.info("TC-1: Populating Others section PASSED");
        } catch (Exception e) {
            Utils.printException(e);
            log.warning("TC-1: Populating Others section FAILED");
            throw (e);
        }
    }

    public static void summaryanddeclaration(String url, WebDriver driver, String[] csvCell, Logger log)
            throws Exception {
        try {

            Utils.clickXpath(driver, ActionXpath.clicksubmit, time, "click on clicksubmit");
            Utils.bigSleepBetweenClicks(1);
            Utils.clickXpath(driver, ActionXpath.backtohome, time, "click on backtohome");
            Utils.bigSleepBetweenClicks(1);

        } catch (Exception e) {
            Utils.printException(e);
            throw (e);
        }
    }

    @Test(priority = 1)
    public static void Admissionfillform(String url, WebDriver driver, String[] csvCell, Logger log) throws Exception {

        try {
            System.out.println("TC-1: Fill form with validation test started Executation ");
            String Sfurl = csvCell[9];

            spjain.SalesforceBackendDELETE(driver, log, csvCell, Sfurl);
            driver.get(url);
            login(url, driver, csvCell, log);
            ApplyforCourse(url, driver, csvCell, log);
            BasicDetails(url, driver, csvCell, log);
            FamilyInfo(url, driver, csvCell, log);
            EmploymentInfo(url, driver, csvCell, log);
            EducationINFO(url, driver, csvCell, log);
            other(url, driver, csvCell, log);
            summaryanddeclaration(url, driver, csvCell, log);
            log.info("TC-1: Fill form with validation test Completed and Passed ");

        } catch (Exception e) {
            log.warning("TC-1: Fill form with validation test Failed");
            Utils.printException(e);
            throw (e);

        }
    }

    @Test(priority = 2)
    public static void fess_spjain(String Sfurl, String url, WebDriver driver, String[] csvCell, Logger log)
            throws Exception {

        try {
            System.out.println("TC-2:  Fess part with validation test started Executation ");
            fess.sf_login(url, driver, csvCell, log);
            // login(url, driver, csvCell, log);

            fess.Sf_Fees_part(Sfurl, url, driver, csvCell, log);
            log.info("TC-2: Fess part with validation test Completed and Passed ");

        } catch (Exception e) {
            log.warning("TC-2: Fess part with validation test Failed");
            Utils.printException(e);
            throw (e);

        }
    }

    @Test(priority = 3)
    public static void SalesforceBackendVerify(String Sfurl, WebDriver driver, String[] csvCell, Logger log) {
        try {
            System.out.println("TC-3: Salesforce backend Verification along with delete  Test Executation ");
            ((JavascriptExecutor) driver).executeScript("window.open()");
            ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tab.get(1));
            driver.get(Sfurl);
            String SfEmail = csvCell[10];
            String SfPassword = csvCell[8];
            Utils.callSendkeys(driver, ActionXpath.SalesforceEmail, SfEmail, "enter salesforce email");
            Utils.callSendkeys(driver, ActionXpath.SalesforcePassword, SfPassword, "Enter your password");
            Utils.clickXpath(driver, ActionXpath.loginSalesforce, time, "click on login salesforce");
            Utils.bigSleepBetweenClicks(1);
            Utils.clickXpath(driver, ActionXpath.applauncher, time, "click on applauncher");
            Utils.smallSleepBetweenClicks(2);
            Utils.callSendkeys(driver, ActionXpath.search, "Contacts", "click on contacts ");
            Utils.clickXpath(driver, ActionXpath.clickcontacts, time, "click on clickcontacts");
            Utils.callSendkeys(driver, ActionXpath.listsearch, "test Student", "Search for student name");
            Utils.clickXpath(driver, ActionXpath.clickstudent, time, "click on clickstudent");
            Utils.clickXpath(driver, ActionXpath.ClickApplicationtab, time, "click on ttha applcation ");
            Utils.clickXpath(driver, ActionXpath.clickappname, time, "click on thr application view");
            Utils.clickXpath(driver, ActionXpath.clickappview, time, "click on thr application view");

            Utils.clickXpath(driver, ActionXpath.ClickEdit, time, "Click on edit");
            Utils.smallSleepBetweenClicks(2);
            String passport = Utils.getTEXT(driver, ActionXpath.passportcheck);
            System.out.println("Passport Number is :" + passport);

            if (csvCell[8].equals(passport)) {
                System.out.println("Passport Number is same");
            } else {
                System.out.println("Passport Number is diffrent");
            }

            String Nationality = Utils.getTEXT(driver, ActionXpath.Nationalitycheck);
            System.out.println(Nationality);

            if (csvCell[7].equals(Nationality)) {
                System.out.println("Nationality is same");
            } else {
                System.out.println("Nationality is diffrent");
            }

            String email = Utils.getTEXT(driver, ActionXpath.emailcheck);
            System.out.println(email);

            if (csvCell[14].equals(email)) {
                System.out.println("email is same");
            } else {
                System.out.println("email is diffrent");
            }

            String dob = Utils.getTEXT(driver, ActionXpath.dobcheck);
            System.out.println(dob);

            if (csvCell[6].equals(dob)) {
                System.out.println("dob is same");
            } else {
                System.out.println("dob is diffrent");
            }

            String city = Utils.getTEXT(driver, ActionXpath.citycheck);
            System.out.println(city);

            if (csvCell[22].equals(city)) {
                System.out.println("city is same");
            } else {
                System.out.println("city is diffrent");
            }

            String fname = Utils.getTEXT(driver, ActionXpath.fnamecheck);
            System.out.println(fname);

            if (csvCell[11].equals(fname)) {
                System.out.println("fname is same");
            } else {
                System.out.println("fname is diffrent");
            }

            String age = Utils.getTEXT(driver, ActionXpath.agecheck);
            System.out.println(age);

            if (csvCell[15].equals(age)) {
                System.out.println("age is same");
            } else {
                System.out.println("age is diffrent");
            }

            String income = Utils.getTEXT(driver, ActionXpath.incomecheck);
            System.out.println(income);

            if (csvCell[17].equals(income)) {
                System.out.println("income is same");
            } else {
                System.out.println("income is diffrent");
            }

            String pgpercentage = Utils.getTEXT(driver, ActionXpath.pgpercentagecheck);
            System.out.println(pgpercentage);

            if (csvCell[32].equals(pgpercentage)) {
                System.out.println("pgpercentage is same");
            } else {
                System.out.println("pgpercentage is diffrent");
            }

            String hscpercentage = Utils.getTEXT(driver, ActionXpath.hscpercentagecheck);
            System.out.println(hscpercentage);

            if (csvCell[50].equals(hscpercentage)) {
                System.out.println("hscpercentage is same");
            } else {
                System.out.println("hscpercentage is diffrent");
            }

            String sslcpercentage = Utils.getTEXT(driver, ActionXpath.sslcpercentagecheck);
            System.out.println(sslcpercentage);

            if (csvCell[57].equals(sslcpercentage)) {
                System.out.println("sslcpercentage is same");
            } else {
                System.out.println("sslcpercentage is diffrent");
            }

            String extraactivities = Utils.getTEXT(driver, ActionXpath.extraactivitiescheck);
            System.out.println(extraactivities);

            if (csvCell[65].equals(extraactivities)) {
                System.out.println("extraactivities is same");
            } else {
                System.out.println("extraactivities is diffrent");
            }
            log.info("  TC-23:  the Salesforce backend Verification along with delete test case PASSED \n");

        } catch (Exception e) {
            log.warning("TC-3: the Salesforce backend Verification along with delete test case FAILED \n");
        }
    }

    // @Test(priority = 5)

    // public static void SalesforceBackendDELETE(WebDriver driver, Logger log,
    // String[] csvCell, String Tname)
    // throws Exception {
    // try {
    // System.out.println("TC-4: Salesforce backend Verification along with delete
    // Test Executation ");

    // // ((JavascriptExecutor) driver).executeScript("window.open()");
    // ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
    // if (!Tname.equals("T1")) {
    // // driver.switchTo().window(tab.get(1));
    // }
    // String Sfurl = csvCell[9];
    // driver.get(Sfurl);
    // String studentemail = csvCell[2];
    // String SfEmail = csvCell[10];
    // String SfPassword = csvCell[11];
    // String studentname = csvCell[12];
    // String count = null;
    // String row = null;
    // Boolean appPresent = false;
    // Boolean viewPresent = false;
    // System.out.println(SfEmail);

    // Utils.callSendkeys(driver, ActionXpath.SalesforceEmail, SfEmail, "enter
    // salesforce email");
    // Utils.callSendkeys(driver, ActionXpath.SalesforcePassword, SfPassword, "Enter
    // your password");
    // Utils.clickXpath(driver, ActionXpath.loginSalesforce, time, "click on login
    // salesforce");
    // Utils.bigSleepBetweenClicks(1);
    // Utils.clickXpath(driver, ActionXpath.applauncher, time, "click on
    // applauncher");
    // Utils.callSendkeys(driver, ActionXpath.search, "Contacts", "click on contacts
    // ");
    // Utils.clickXpath(driver, ActionXpath.contacts, time, "click on
    // clickcontacts");
    // Utils.cleartext(driver, ActionXpath.listsearch);
    // Utils.callSendkeys(driver, ActionXpath.listsearch, studentemail, "Search for
    // student name");
    // Utils.bigSleepBetweenClicks(1);
    // Actions qq = new Actions(driver);
    // // qq.moveByOffset(40, 40).click().perform();
    // WebDriverWait wait21 = new WebDriverWait(driver, 20);
    // WebElement elem21 = wait21.until(ExpectedConditions.elementToBeClickable(
    // By.xpath("(//*[text()='" + studentname + "'])[1]")));
    // ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem21);
    // Utils.bigSleepBetweenClicks(1);

    // Utils.clickXpath(driver, ActionXpath.ClickApplication1, time, "click on
    // ClickApplication1");

    // WebDriverWait wait2 = new WebDriverWait(driver, 20);
    // WebElement elem2 = wait21.until(ExpectedConditions.elementToBeClickable(
    // By.xpath("(//*[text()='" + studentname + "'])[1]")));
    // ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem2);

    // // Utils.clickXpath(driver, ActionXpath.view, time, "click on view");

    // Utils.clickXpath(driver, ActionXpath.apptab, time, "click on apptab");

    // Utils.smallSleepBetweenClicks(1);
    // Utils.clickXpath(driver, ActionXpath.delete, time, "Delete theapplciation ");
    // Utils.clickXpath(driver, ActionXpath.Delete2, time, "Delete theapplciation
    // ");

    // } catch (Exception e) {
    // // TODO: handle exception
    // }

    // }

    @Test(priority = 4)

    public static void SalesforceBackendDELETE(WebDriver driver, Logger log, String[] csvCell, String Tname)
            throws Exception {
        try {
            System.out.println("TC-4: Salesforce backend Verification along with delete  Test Executation ");

            // ((JavascriptExecutor) driver).executeScript("window.open()");
            ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
            if (!Tname.equals("T1")) {
                // driver.switchTo().window(tab.get(1));
            }
            String Sfurl = csvCell[9];
            driver.get(Sfurl);
            String studentemail = csvCell[2];
            String SfEmail = csvCell[10];
            String SfPassword = csvCell[11];
            String studentname = csvCell[12];
            String count = null;
            String row = null;
            Boolean appPresent = false;
            Boolean viewPresent = false;
            System.out.println(SfEmail);

            Utils.callSendkeys(driver, ActionXpath.SalesforceEmail, SfEmail, "enter salesforce email");
            Utils.callSendkeys(driver, ActionXpath.SalesforcePassword, SfPassword, "Enter your password");
            Utils.clickXpath(driver, ActionXpath.loginSalesforce, time, "click on login salesforce");
            Utils.bigSleepBetweenClicks(1);
            Utils.clickXpath(driver, ActionXpath.applauncher, time, "click on applauncher");
            Utils.callSendkeys(driver, ActionXpath.search, "Contacts", "click on contacts ");
            Utils.clickXpath(driver, ActionXpath.contacts, time, "click on clickcontacts");
            // Utils.cleartext(driver, ActionXpath.listsearch);
            Thread.sleep(2000);
            Utils.callSendkeys(driver, ActionXpath.listsearch, studentemail, "Search for student name");
            Utils.bigSleepBetweenClicks(1);
            Actions qq = new Actions(driver);
            // qq.moveByOffset(40, 40).click().perform();
            WebDriverWait wait21 = new WebDriverWait(driver, 20);
            WebElement elem21 = wait21.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("(//*[text()='" + studentname + "'])[1]")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem21);
            Utils.bigSleepBetweenClicks(1);
            // String Applicationtab = "//a[text()='Applications']";
            // String Applicationtab =
            // "//*[@id=\"tab-1\"]/slot/flexipage-component2[2]/slot/lst-related-list-container/div/div[9]/lst-related-list-single-container/laf-progressive-container/slot/lst-related-list-single-app-builder-mapper/article/lst-related-list-view-manager/lst-common-list-internal/lst-list-view-manager-header/div/div[1]/div[1]/div/div/h2/a/span[1]']";
            // appPresent = driver.findElements(By.xpath(Applicationtab)).size() > 0;
            // appPresent = driver.findElements(By.xpath(Applicationtab)).size() > 0;
            // WebElement l = driver.findElement(By.xpath(Applicationtab));
            // Javascript executor
            // ((JavascriptExecutor)
            // driver).executeScript("arguments[0].scrollIntoView(true);", l);
            Utils.clickXpath(driver, ActionXpath.ClickApplication1, time, "click on the appliation tab");

            Utils.smallSleepBetweenClicks(1);
            String view = "(//span[text()='View All'])[1]";
            viewPresent = driver.findElements(By.xpath(view)).size() > 0;
            Utils.bigSleepBetweenClicks(1);

            System.out.println("Application tab is not there");

            if (viewPresent) {
                WebDriverWait wait = new WebDriverWait(driver, 20);
                WebElement elem = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("(//span[text()='View All'])[1]")));
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);
                Thread.sleep(2000);
                count = Utils.getTEXT(driver, ActionXpath.deletecount);
                Pattern pt = Pattern.compile("-?\\d+");
                java.util.regex.Matcher m = pt.matcher(count);
                while (m.find()) {
                    row = m.group();
                }
                int count1 = Integer.parseInt(row);

                System.out.println(count1);

                for (int i = 0; i < count1; i++) {
                    Boolean acad2022Present = driver.findElements(By.xpath(ActionXpath.acadYear2022)).size() > 0;
                    Boolean acad2023Present = driver.findElements(By.xpath(ActionXpath.acadYear2023)).size() > 0;
                    Boolean acad2024Present = driver.findElements(By.xpath(ActionXpath.acadYear2024)).size() > 0;
                    if (acad2022Present) {
                        WebElement el = driver.findElement(By.xpath(ActionXpath.acadYear2022));
                        System.out.println("2022 is there click it     " + el);
                        el.click();
                        Utils.smallSleepBetweenClicks(1);
                        Utils.clickXpath(driver, ActionXpath.delete, time, "Delete theapplciation 2022");
                        Utils.clickXpath(driver, ActionXpath.Delete2, time, "Delete theapplciation 2022");
                        Utils.smallSleepBetweenClicks(2);
                        continue;
                    } else if (acad2023Present) {
                        WebElement el2 = driver.findElement(By.xpath(ActionXpath.acadYear2023));
                        System.out.println("2023 is there click it" + el2);
                        el2.click();
                        Utils.clickXpath(driver, ActionXpath.delete, time, "Delete theapplciation 2023");
                        Utils.clickXpath(driver, ActionXpath.Delete2, time, "Delete theapplciatnet 2023");
                        Utils.smallSleepBetweenClicks(2);
                        continue;
                    } else if (acad2024Present) {
                        WebElement el2 = driver.findElement(By.xpath(ActionXpath.acadYear2024));
                        System.out.println("2024 is there click it" + el2);
                        el2.click();
                        Utils.clickXpath(driver, ActionXpath.delete, time, "Delete theapplciation 2023");
                        Utils.clickXpath(driver, ActionXpath.Delete2, time, "Delete theapplciatnet 2023");
                        Utils.smallSleepBetweenClicks(2);
                        continue;
                    }
                }
            } else {
                System.out.println("There is nothing to Delete");
            }

            // driver.switchTo().window(tab.get(0));

            log.info("  TC-4:  the Salesforce backend  delete test case PASSED \n");

        }

        catch (Exception e) {
            log.warning("TC-4: the Salesforce backend  delete test case FAILED \n");
            Utils.printException(e);
            throw (e);
        }

    }
}
