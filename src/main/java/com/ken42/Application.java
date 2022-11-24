package com.ken42;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.testng.annotations.Test;

import com.beust.jcommander.JCommander.ProgramName;
import com.mongodb.util.Util;

public class Application {
    public static Logger log = Logger.getLogger("App_portal");
    static int time = 2000;
    public static WebDriver driver;

    public static void login(String url, WebDriver driver, String[] csvCell) throws Exception {
        try {
            String email = csvCell[2];
            String password = csvCell[3];

            Thread.sleep(3000);
            Utils.callSendkeys(driver, ActionXpath.EnterEmail, email, "Enter r mail address ");
            Utils.clickXpath(driver, ActionXpath.Verify, time, "verify");
            Utils.bigSleepBetweenClicks(1);
            Utils.getAndSentOTP(driver, email, password);
            Utils.clickXpath(driver, ActionXpath.Verifylogin, time, "Verift the Login ");

        } catch (Exception e) {
            Utils.printException(e);
            throw (e);
        }
    }

    public static void ApplyforCourse(String url, WebDriver driver, String[] csvCell) throws Exception {
        try {
            Utils.clickXpath(driver, ActionXpath.Apply, time, "Click on the Apply now Button");
            Utils.smallSleepBetweenClicks(1);
            Utils.clickXpath(driver, ActionXpath.ClickDropDepartment, time, "Select the all department Dropdown");
            Utils.clickXpath(driver, ActionXpath.selectPost, time, "Select the appropiraite Department ");
            Utils.smallSleepBetweenClicks(1);
            Utils.clickXpath(driver, ActionXpath.ClickPorogrameDrop, time, "Select the Progarme Drop down");
            String Programe = csvCell[76];
            Utils.selectFromDropDown(ActionXpath.selectxpath, Programe, driver);

            Utils.clickXpath(driver, ActionXpath.ApplyNow, time, "Click on apply");
            Utils.clickXpath(driver, ActionXpath.ClickNext, time, "click on Next");
            Utils.clickXpath(driver, ActionXpath.Selectmentor, time, "Slect the mentor");
            Utils.clickXpath(driver, ActionXpath.selectYes, time, "Slect  yes ");
            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.Campus, time, "Select the campus");
            String campus = csvCell[77];
            Utils.selectFromDropDown(ActionXpath.selectxpath, campus, driver);
            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.ClickNext, time, "click on Next");
        } catch (Exception e) {
            Utils.printException(e);
            throw (e);
        }
    }

    public static void BasicDetails(String url, WebDriver driver, String[] csvCell) throws Exception {
        try {
            JavascriptExecutor js3 = (JavascriptExecutor) driver;
            String validation = csvCell[78];

            String dob = csvCell[6];
            String nationality = csvCell[7];
            String passport = csvCell[8];
            String country = csvCell[9];
            String state = csvCell[10];
            String city = csvCell[11];
            String street = csvCell[12];
            String PostalCode = csvCell[13];

            Utils.callSendkeys(driver, ActionXpath.dob, dob, "Set tu date of birth");
            Utils.scrollUpOrDown(driver, time);
            Utils.scrollUpOrDown(driver, time);

            Utils.clickXpath(driver, ActionXpath.Nationaliydrop, time, "open nationality dropdown");
            Utils.selectFromDropDown(ActionXpath.selectxpath, nationality, driver);
            if (validation.equals("TRUE")) {
                Utils.cleartext(driver, ActionXpath.passport);
                validate.char40(driver, ActionXpath.passport, ActionXpath.errorpassport2);
                Utils.cleartext(driver, ActionXpath.passport);
                validate.char80(driver, ActionXpath.passport, ActionXpath.errorpassport2);
                Utils.cleartext(driver, ActionXpath.passport);
                validate.specialcharacter(driver, ActionXpath.passport, ActionXpath.errorpassport1);
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
            Utils.selectFromDropDown(ActionXpath.selectxpath, country, driver);
            System.out.println("India printed");
            // Utils.clickXpath(driver,ActionXpath.country, time, "Select your Country");
            Utils.clickXpath(driver, ActionXpath.selectstate, time, "Select the satet");
            Utils.selectFromDropDown(ActionXpath.selectxpath, state, driver);
            System.out.println("India2 printed");
            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.selectDist, time, "Select the Dist");
            Utils.selectFromDropDown(ActionXpath.selectxpath, city, driver);
            // Utils.clickXpath(driver, ActionXpath.District, time, "Select the Dist");
            Utils.scrollUpOrDown(driver, time);
            if (validation.equals("TRUE")) {
                validate.char80(driver, ActionXpath.street, ActionXpath.errorstreet1);
                Utils.cleartext(driver, ActionXpath.street);
                validate.specialcharacter(driver, ActionXpath.street, ActionXpath.errorstreet2);
            }
            Utils.cleartext(driver, ActionXpath.street);
            Utils.callSendkeys(driver, ActionXpath.street, street, "enter your permanent addrrss");
            if (validation.equals("TRUE")) {
                validate.char80(driver, ActionXpath.PostalCode, ActionXpath.errorzipcode2);
                Utils.cleartext(driver, ActionXpath.PostalCode);
                validate.specialcharacter(driver, ActionXpath.PostalCode, ActionXpath.errorzipcode1);
            }
            Utils.cleartext(driver, ActionXpath.PostalCode);
            Utils.callSendkeys(driver, ActionXpath.PostalCode, PostalCode, "Select your Postal Code");
            Utils.scrollUpOrDown(driver, time);
            Utils.scrollUpOrDown(driver, time);
            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.currentaddress, time, "Click the address");
            Utils.clickXpath(driver, ActionXpath.selectcurrentaddress, time, "Click the address");
            Utils.clickXpath(driver, ActionXpath.ClickNext, time, "click on Next");

        } catch (Exception e) {
            Utils.printException(e);
            throw (e);
        }
    }

    public static void FamilyInfo(String url, WebDriver driver, String[] csvCell) throws Exception {
        try {
            String firstName = csvCell[14];
            String lastName = csvCell[15];
            String Phone = csvCell[16];
            String Email = csvCell[17];
            String Age = csvCell[18];
            String occupation = csvCell[19];
            String annualIncome = csvCell[20];
            String validation = csvCell[78];
            Utils.clickXpath(driver, ActionXpath.selectrelationship, time, "Select the Relationship status option");
            Utils.clickXpath(driver, ActionXpath.relationType, time, "Select the relationhip Type");
            if (validation.equals("TRUE")) {
                validate.char80(driver, ActionXpath.firstName, ActionXpath.errorfname1);
                Utils.cleartext(driver, ActionXpath.firstName);
                validate.specialcharacter(driver, ActionXpath.firstName, ActionXpath.errorfname2);
            }
            Utils.cleartext(driver, ActionXpath.firstName);
            Utils.callSendkeys(driver, ActionXpath.firstName, firstName, "Enter Fist name");
            Utils.scrollUpOrDown(driver, time);
            if (validation.equals("TRUE")) {
                validate.char80(driver, ActionXpath.lastName, ActionXpath.errorlname1);
                Utils.cleartext(driver, ActionXpath.lastName);
                validate.specialcharacter(driver, ActionXpath.lastName, ActionXpath.errorlname2);
            }
            Utils.cleartext(driver, ActionXpath.lastName);
            Utils.callSendkeys(driver, ActionXpath.lastName, lastName, "Enter Last NAme");
            Utils.callSendkeys(driver, ActionXpath.Phone, Phone, "enter the Phone");
            Utils.scrollUpOrDown(driver, time);
            if (validation.equals("TRUE")) {
                validate.specialcharacter(driver, ActionXpath.Email, ActionXpath.erroremail1);
            }
            Utils.cleartext(driver, ActionXpath.Email);
            Utils.callSendkeys(driver, ActionXpath.Email, Email, "Enter the Emial");
            if (validation.equals("TRUE")) {
                validate.numbers(driver, ActionXpath.Age, ActionXpath.errorage1);
                Utils.cleartext(driver, ActionXpath.Age);
                validate.specialcharacter(driver, ActionXpath.Age, ActionXpath.errorage1);
                Utils.cleartext(driver, ActionXpath.Age);
                validate.char40(driver, ActionXpath.Age, ActionXpath.errorage1);
            }
            Utils.cleartext(driver, ActionXpath.Age);

            Utils.callSendkeys(driver, ActionXpath.Age, Age, "Selct age");
            Utils.scrollUpOrDown(driver, time);
            if (validation.equals("TRUE")) {
                validate.char40(driver, ActionXpath.occupation, ActionXpath.erroroccupation1);
                Utils.cleartext(driver, ActionXpath.occupation);
                validate.specialcharacter(driver, ActionXpath.occupation, ActionXpath.erroroccupation2);
                Utils.cleartext(driver, ActionXpath.occupation);
                validate.numbers(driver, ActionXpath.occupation, ActionXpath.erroroccupation1);
                Utils.cleartext(driver, ActionXpath.occupation);
            }
            Utils.callSendkeys(driver, ActionXpath.occupation, occupation, "Select the manager");
            if (validation.equals("TRUE")) {
                validate.char40(driver, ActionXpath.annualIncome, ActionXpath.errorincome2);
                Utils.cleartext(driver, ActionXpath.annualIncome);
                validate.specialcharacter(driver, ActionXpath.annualIncome, ActionXpath.errorincome1);
                Utils.cleartext(driver, ActionXpath.annualIncome);
                validate.numbers(driver, ActionXpath.annualIncome, ActionXpath.errorincome2);
            }
            Utils.cleartext(driver, ActionXpath.annualIncome);
            Utils.callSendkeys(driver, ActionXpath.annualIncome, annualIncome, "Selct the Annual income");
            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.SelectQualification, time, "Select the Qualification");
            Utils.clickXpath(driver, ActionXpath.Qualification, time, "Select the appropriate Qualification");
            Utils.clickXpath(driver, ActionXpath.CurrencyTypeSelect, time, "Select currency");
            Utils.clickXpath(driver, ActionXpath.currencyType, time, "Select the appropriate currency");
            Utils.clickXpath(driver, ActionXpath.ClickNext, time, "click on Next");

        } catch (Exception e) {
            Utils.printException(e);
            throw (e);
        }
    }

    public static void EmploymentInfo(String url, WebDriver driver, String csvCell[]) throws Exception {
        try {
            Utils.bigSleepBetweenClicks(1);
            String Company = csvCell[21];
            String industry = csvCell[22];
            String Country = csvCell[23];
            String state = csvCell[24];

            String city = csvCell[25];

            String Designation = csvCell[26];
            String Role = csvCell[27];
            String dateofJoin = csvCell[28];
            String experince = csvCell[29];
            String Annual = csvCell[30];
            String CurrencyType = csvCell[31];
            String validation = csvCell[78];
            Utils.clickXpath(driver, ActionXpath.clickyes, time, "clickyes");
            Utils.clickXpath(driver, ActionXpath.SelectjobType, time, "Select the Job type");
            Utils.clickXpath(driver, ActionXpath.jobType, time, "Select the Appropriate job ");
            if (validation.equals("TRUE")) {
                validate.char80(driver, ActionXpath.company, ActionXpath.errorcompany1);
                Utils.cleartext(driver, ActionXpath.company);
                validate.specialcharacter(driver, ActionXpath.company, ActionXpath.errorcompany2);
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
                validate.char80(driver, ActionXpath.designation, ActionXpath.errordestination1);
                Utils.cleartext(driver, ActionXpath.designation);
                validate.specialcharacter(driver, ActionXpath.designation, ActionXpath.errordestination2);
                Utils.cleartext(driver, ActionXpath.designation);
                validate.numbers(driver, ActionXpath.designation, ActionXpath.errordestination2);
            }
            Utils.cleartext(driver, ActionXpath.designation);
            Utils.callSendkeys(driver, ActionXpath.designation, Designation, "enter the Designation ");
            Utils.scrollUpOrDown(driver, time);
            Utils.scrollUpOrDown(driver, time);
            if (validation.equals("TRUE")) {
                validate.char80(driver, ActionXpath.role, ActionXpath.errorroles1);
                Utils.cleartext(driver, ActionXpath.role);
                validate.specialcharacter(driver, ActionXpath.role, ActionXpath.errorroles2);
                Utils.cleartext(driver, ActionXpath.role);
                validate.numbers(driver, ActionXpath.role, ActionXpath.errorroles2);
            }
            Utils.cleartext(driver, ActionXpath.role);
            Utils.callSendkeys(driver, ActionXpath.role, Role, "enter the Role ");
            Utils.callSendkeys(driver, ActionXpath.DateJoin, dateofJoin, "enter the date of joining");
            Utils.clickXpath(driver, ActionXpath.CurrentCompany, time, "CurrentCompany");
            Utils.clickXpath(driver, ActionXpath.selectCurrentCompany, time, "selectCurrentCompany");
            Utils.scrollUpOrDown(driver, time);
            if (validation.equals("TRUE")) {
                validate.char80(driver, ActionXpath.Experience, ActionXpath.errormonths1);
                Utils.cleartext(driver, ActionXpath.Experience);
                validate.specialcharacter(driver, ActionXpath.Experience, ActionXpath.errormonths2);
                Utils.cleartext(driver, ActionXpath.Experience);
                validate.numbers(driver, ActionXpath.Experience, ActionXpath.errormonths1);
                Utils.cleartext(driver, ActionXpath.Experience);
            }
            Utils.callSendkeys(driver, ActionXpath.Experience, experince, "enter the Experience");
            if (validation.equals("TRUE")) {
                validate.char80(driver, ActionXpath.AnnualSalary, ActionXpath.errrosalary1);
                Utils.cleartext(driver, ActionXpath.AnnualSalary);
                validate.specialcharacter(driver, ActionXpath.AnnualSalary, ActionXpath.errrosalary2);
                Utils.cleartext(driver, ActionXpath.AnnualSalary);
                validate.numbers(driver, ActionXpath.AnnualSalary, ActionXpath.errrosalary2);
            }
            Utils.cleartext(driver, ActionXpath.AnnualSalary);
            Utils.callSendkeys(driver, ActionXpath.AnnualSalary, Annual, "Enter the annual Salary");
            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.currencytype, time, "currencytype");
            // Utils.clickXpath(driver, ActionXpath.selectcurrencytype, time,
            // "selectcurrencytype");
            Utils.selectFromDropDown(ActionXpath.selectxpath, CurrencyType, driver);

            Utils.clickXpath(driver, ActionXpath.ClickNext, time, "click on Next");

        } catch (Exception e) {
            Utils.printException(e);
            throw (e);
        }
    }

    public static void EducationINFO(String url, WebDriver driver, String[] csvCell) throws Exception {
        try {
            Utils.bigSleepBetweenClicks(1);
            String pgyear = csvCell[32];
            String pguniversity = csvCell[33];
            String pgcollege = csvCell[34];
            String pgpercentage = csvCell[35];
            String pgdegree = csvCell[36];
            String pgcountry = csvCell[37];
            String pgstate = csvCell[38];
            String pgcity = csvCell[39];
            String validation = csvCell[78];

            // pg
            Utils.callSendkeys(driver, ActionXpath.pgyear, pgyear, "pgyear");
            if (validation.equals("TRUE")) {
                validate.char40(driver, ActionXpath.pguniversity, ActionXpath.error40charUniverisy);
                Utils.cleartext(driver, ActionXpath.pguniversity);
                validate.numbers(driver, ActionXpath.pguniversity, ActionXpath.errorUniversity);
            }
            Utils.cleartext(driver, ActionXpath.pguniversity);
            Utils.callSendkeys(driver, ActionXpath.pguniversity, pguniversity, "pguniversity");
            Utils.selectFromDropDown(ActionXpath.selectxpath, pguniversity, driver);
            Utils.scrollUpOrDown(driver, time);
            if (validation.equals("TRUE")) {
                validate.char40(driver, ActionXpath.pgcollege, ActionXpath.error40charCollege);
                Utils.cleartext(driver, ActionXpath.pgcollege);
                validate.numbers(driver, ActionXpath.pgcollege, ActionXpath.errorCollege);
            }
            Utils.cleartext(driver, ActionXpath.pgcollege);
            Utils.callSendkeys(driver, ActionXpath.pgcollege, pgcollege, "pgcollege");
            Utils.selectFromDropDown(ActionXpath.selectxpath, pgcollege, driver);
            if (validation.equals("TRUE")) {
                validate.specialcharacter(driver, ActionXpath.pgpercentage, ActionXpath.errorSpecailCharPercentage);
                Utils.cleartext(driver, ActionXpath.pgpercentage);
                validate.char80(driver, ActionXpath.pgpercentage, ActionXpath.error40charUniverisy);
            }
            Utils.cleartext(driver, ActionXpath.pgpercentage);
            Utils.callSendkeys(driver, ActionXpath.pgpercentage, pgpercentage, "pgpercentage");
            Utils.selectFromDropDown(ActionXpath.selectxpath, pgpercentage, driver);
            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.pgedttype, time, "pgedttype");
            Utils.clickXpath(driver, ActionXpath.pgselectedttype, time, "pgselectedttype");
            Utils.clickXpath(driver, ActionXpath.pgdegree, time, "pgdegree");
            // Utils.clickXpath(driver, ActionXpath.pgselectdegree, time, "pgselectdegree");
            Utils.selectFromDropDown(ActionXpath.pgdegreeselect, pgdegree, driver);
            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.pgcountry, time, "pgcountry");
            Utils.selectFromDropDown(ActionXpath.pgcountryselect, pgcountry, driver);
            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.pgstate, time, "pgstate");
            Utils.selectFromDropDown(ActionXpath.pgstateselect, pgstate, driver);
            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.pgcity, time, "pgcity");
            Utils.selectFromDropDown(ActionXpath.pgcityselect, pgcity, driver);
            Utils.scrollUpOrDown(driver, time);
            // ug

            String ugyear = csvCell[40];
            String uguniversity = csvCell[41];
            String ugcollege = csvCell[42];
            String ugpercentage = csvCell[43];
            String ugdegree = csvCell[44];
            String ugcountry = csvCell[45];
            String ugstate = csvCell[46];
            String ugcity = csvCell[47];
            String ugmark1 = csvCell[48];
            String ugmaxmark1 = csvCell[49];
            String ugmark2 = csvCell[50];
            String ugmaxmark2 = csvCell[51];

            Utils.callSendkeys(driver, ActionXpath.ugyear, ugyear, "ugyear");
            if (validation.equals("TRUE")) {
                validate.char40(driver, ActionXpath.uguniversity, ActionXpath.error40charUniverisy);
                Utils.cleartext(driver, ActionXpath.uguniversity);
                validate.numbers(driver, ActionXpath.uguniversity, ActionXpath.errorUniversity);
            }
            Utils.cleartext(driver, ActionXpath.uguniversity);
            Utils.callSendkeys(driver, ActionXpath.uguniversity, uguniversity, "uguniversity");
            List<WebElement> UgUniveristy = driver.findElements(By.xpath("//div[text()='" + uguniversity + "']"));
            for (int i = 0; i < UgUniveristy.size(); i++) {
                if (UgUniveristy.get(i).getText().contains(uguniversity)) {
                    UgUniveristy.get(i).click();
                    break;
                }
            }
            Utils.scrollUpOrDown(driver, time);
            if (validation.equals("TRUE")) {
                validate.char40(driver, ActionXpath.ugcollege, ActionXpath.error40charUniverisy);
                Utils.cleartext(driver, ActionXpath.ugcollege);
                validate.numbers(driver, ActionXpath.ugcollege, ActionXpath.errorCollege);
            }
            Utils.cleartext(driver, ActionXpath.ugcollege);
            Utils.callSendkeys(driver, ActionXpath.ugcollege, ugcollege, "ugcollege");
            List<WebElement> UGCollege = driver.findElements(By.xpath("//div[text()='" + ugcollege + "']"));
            for (int i = 0; i < UgUniveristy.size(); i++) {
                if (UGCollege.get(i).getText().contains(ugcollege)) {
                    UGCollege.get(i).click();
                    break;
                }
            }
            if (validation.equals("TRUE")) {
                validate.specialcharacter(driver, ActionXpath.ugpercentage, ActionXpath.errorUniversity);
                Utils.cleartext(driver, ActionXpath.ugpercentage);
                validate.char80(driver, ActionXpath.ugpercentage, ActionXpath.error80CharPercentage);
            }
            Utils.cleartext(driver, ActionXpath.ugpercentage);
            Utils.callSendkeys(driver, ActionXpath.ugpercentage, ugpercentage, "ugpercentage");
            List<WebElement> UGPercentage = driver.findElements(By.xpath("//div[text()='" + ugpercentage + "']"));
            for (int i = 0; i < UgUniveristy.size(); i++) {
                if (UGPercentage.get(i).getText().contains(ugpercentage)) {
                    UGPercentage.get(i).click();
                    break;
                }
            }
            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.ugedtype, time, "ugedtype");
            Utils.clickXpath(driver, ActionXpath.ugselectedtype, time, "ugselectedtype");
            Utils.clickXpath(driver, ActionXpath.ugdegree, time, "ugdegree");
            Utils.selectFromDropDown(ActionXpath.selectxpath, ugdegree, driver);
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
            String hscboard = csvCell[52];
            String hscpercentage = csvCell[53];
            String hscyear = csvCell[54];
            String hscschool = csvCell[55];
            String hsccountry = csvCell[56];
            String hscstate = csvCell[57];
            String hsccity = csvCell[58];
            Utils.clickXpath(driver, ActionXpath.hscedtype, time, "hscedtype");
            Utils.clickXpath(driver, ActionXpath.hscselectedtype, time, "hscselectedtype");
            Utils.clickXpath(driver, ActionXpath.hscboard, time, "hscboard");
            Utils.selectFromDropDown(ActionXpath.selectxpath, hscboard, driver);
            Utils.clickXpath(driver, ActionXpath.hscgrade, time, "hscgrade");
            Utils.clickXpath(driver, ActionXpath.hscgradeselect, time, "hscgradeselect");
            Utils.scrollUpOrDown(driver, time);
            if (validation.equals("TRUE")) {
                validate.char80(driver, ActionXpath.hscpercentage, ActionXpath.error80CharPercentage);
                Utils.cleartext(driver, ActionXpath.hscpercentage);
                validate.specialcharacter(driver, ActionXpath.hscpercentage, ActionXpath.errorSpecailCharPercentage);
            }
            Utils.cleartext(driver, ActionXpath.hscpercentage);
            Utils.callSendkeys(driver, ActionXpath.hscpercentage, hscpercentage, "hscpercentage");
            Utils.selectFromDropDown(ActionXpath.selectxpath, ugcollege, driver);
            Utils.callSendkeys(driver, ActionXpath.hscyear, hscyear, "hscyear");
            Utils.scrollUpOrDown(driver, time);
            if (validation.equals("TRUE")) {
                validate.char40(driver, ActionXpath.hscschool, ActionXpath.errorSchool);
                Utils.cleartext(driver, ActionXpath.hscschool);
                validate.specialcharacter(driver, ActionXpath.hscschool, ActionXpath.errorSpecailCharPercentage);
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
            String sslcboard = csvCell[59];
            String sslcpercentage = csvCell[60];
            String sslcyear = csvCell[61];
            String sslcschool = csvCell[62];
            String sslccountry = csvCell[63];
            String sslcstate = csvCell[64];
            String sslccity = csvCell[65];
            Utils.clickXpath(driver, ActionXpath.sslcedtype, time, "sslcedtype");
            Utils.clickXpath(driver, ActionXpath.sslcselectedtype, time, "sslcselectedtype");
            Utils.clickXpath(driver, ActionXpath.sslcboard, time, "sslcboard");
            Utils.selectFromDropDown(ActionXpath.selectxpath, sslcboard, driver);
            Utils.scrollUpOrDown(driver, time);
            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.sslcgrade, time, "sslcgrade");
            Utils.clickXpath(driver, ActionXpath.sslcselectgrade, time, "sslcselectgrade");
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

        } catch (Exception e) {
            Utils.printException(e);
            throw (e);
        }
    }

    public static void other(String url, WebDriver driver, String[] csvCell) throws Exception {
        try {

            String SportAchievement = csvCell[66];
            String ProfessionalAchievement = csvCell[67];
            String CurricularActivities = csvCell[68];
            String AcademicAchievements = csvCell[69];
            String Statement = csvCell[70];
            String planmasterdegree = csvCell[71];
            String language = csvCell[72];

            Utils.callSendkeys(driver, ActionXpath.SportAchievement, SportAchievement, "SportAchievement");
            Utils.callSendkeys(driver, ActionXpath.ProfessionalAchievement, ProfessionalAchievement,
                    "ProfessionalAchievement");
            Utils.scrollUpOrDown(driver, time);
            Utils.callSendkeys(driver, ActionXpath.CurricularActivities, CurricularActivities, "CurricularActivities");
            Utils.callSendkeys(driver, ActionXpath.AcademicAchievements, AcademicAchievements, "AcademicAchievements");
            Utils.scrollUpOrDown(driver, time);
            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.fundeducation, time, "fundeducation");
            Utils.clickXpath(driver, ActionXpath.fundselecteducation, time, "fundselecteducation");
            Utils.scrollUpOrDown(driver, time);
            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.physicallychallenged, time, "physicallychallenged");
            // Utils.callSendkeys(driver, ActionXpath.sharedetails, "NA", "sharedetails");
            Utils.callSendkeys(driver, ActionXpath.Statement, Statement, "Statement");
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
            // Utils.clickXpath(driver, ActionXpath.evaluation, time, "evaluation");
            // Utils.clickXpath(driver, ActionXpath.Selectevaluation, time,
            // "Selectevaluation");
            // Utils.clickXpath(driver, ActionXpath.qualificationenglish, time,
            // "qualificationenglish");
            // Utils.clickXpath(driver, ActionXpath.selectlatestqualificationenglish, time,
            // "selectlatestqualificationenglish");
            // Utils.scrollUpOrDown(driver, time);
            // Utils.clickXpath(driver, ActionXpath.latestqualificationenglish, time,
            // "latestqualificationenglish");
            // Utils.clickXpath(driver, ActionXpath.selectlatestqualificationenglish, time,
            // "selectlatestqualificationenglish");
            Utils.clickXpath(driver, ActionXpath.EducationConsultant, time, "EducationConsultant");
            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.hearspjain, time, "hearspjain");
            Utils.clickXpath(driver, ActionXpath.selecthearspjain, time, "selecthearspjain");
            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.refrence, time, "refrence");
            Utils.clickXpath(driver, ActionXpath.ClickNext, time, "click on Next");
        } catch (Exception e) {
            Utils.printException(e);
            throw (e);

        }
    }

    public static void summaryanddeclaration(String url, WebDriver driver, String[] csvCell) throws Exception {
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

            login(url, driver, csvCell);
            ApplyforCourse(url, driver, csvCell);
            BasicDetails(url, driver, csvCell);
            FamilyInfo(url, driver, csvCell);
            EmploymentInfo(url, driver, csvCell);
            EducationINFO(url, driver, csvCell);
            other(url, driver, csvCell);
            summaryanddeclaration(url, driver, csvCell);
            log.info("TC-1: Fill form with validation test Completed and Passed ");

        } catch (Exception e) {
            log.warning("TC-1: Fill form with validation test Failed");
            Utils.printException(e);
            throw (e);

        }
    }

    @Test(priority = 2)
    public static void SalesforceBackendVerify(String Sfurl, WebDriver driver, String[] csvCell, Logger log) {
        try {
            System.out.println("TC-2: Salesforce backend Verification along with delete  Test Executation ");
            ((JavascriptExecutor) driver).executeScript("window.open()");
            ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tab.get(1));
            driver.get(Sfurl);
            String SfEmail = csvCell[74];
            String SfPassword = csvCell[75];
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
            log.info("  TC-2:  the Salesforce backend Verification along with delete test case PASSED \n");

        } catch (Exception e) {
            log.warning("TC-2: the Salesforce backend Verification along with delete test case FAILED \n");
        }
    }
}