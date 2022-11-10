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

import com.mongodb.util.Util;

public class Application {
    public static Logger log = Logger.getLogger("App_portal");
    static int time = 2000;
    @Test(priority = 1)
	public static void testApp(String url,WebDriver driver,String[] csvCell) throws Exception {

        try {
            String Email =csvCell[2];

            Thread.sleep(3000);
            System.out.println("TC-1: Starting Application Login  test case execution ");
            Utils.callSendkeys(driver, ActionXpath.EnterEmail, Email, "Enter r mail address ");
            Utils.clickXpath(driver, ActionXpath.Verify, time, "verify");
            Utils.bigSleepBetweenClicks(1);
            Utils.getAndSentOTP(driver);
            Utils.clickXpath(driver, ActionXpath.Verifylogin, time, "Verift the Login ");
            log.info("  TC-1: Application login test case PASSED \n");

        } catch (Exception e) {
            log.warning("TC-1: Application login test case FAILED \n");
        }
    }
    
    @Test(priority = 2)
    public static void ApplyforCourse(String url,WebDriver driver){
        try{
            System.out.println("TC:2: Starting Apply for Course programe Test Executation ");
            Utils.clickXpath(driver, ActionXpath.Apply, time, "Click on the Apply now Button");
            Utils.smallSleepBetweenClicks(1);
            Utils.clickXpath(driver, ActionXpath.ClickDropDepartment, time, "Select the all department Dropdown");
            Utils.clickXpath(driver, ActionXpath.selectPost, time, "Select the appropiraite Department ");
            Utils.smallSleepBetweenClicks(1);
            Utils.clickXpath(driver, ActionXpath.ClickPorogrameDrop, time, "Select the Progarme Drop down");
            Utils.clickXpath(driver, ActionXpath.selectPrograme, time, "Select the appropriate Programe");
            Utils.clickXpath(driver, ActionXpath.ApplyNow, time, "Click on apply");
            Utils.clickXpath(driver, ActionXpath.ClickNext, time, "click on Next");
            Utils.clickXpath(driver, ActionXpath.Selectmentor, time, "Slect the mentor");
            Utils.clickXpath(driver, ActionXpath.selectYes, time, "Slect  yes ");
            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.Campus, time, "Select the campus");
            Utils.clickXpath(driver, ActionXpath.SelectCampus, time, "Select the campus");
            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.Specilization, time, "Select the campus");
            Utils.clickXpath(driver, ActionXpath.selectSpecilization, time, "Select the Specilization");
            Utils.clickXpath(driver, ActionXpath.ClickNext, time, "click on Next");
            log.info("  TC-2: Apply for Course programe test case PASSED \n");
        } catch (Exception e) {
			log.warning("TC-2: Apply for Course programe test case FAILED \n");
		}
    }
    
    @Test(priority = 3)
    public static void BasicDetails(String url,WebDriver driver,String[] csvCell ){
        try{
            JavascriptExecutor js3 = (JavascriptExecutor) driver;

            String dob =csvCell[6];
			String nationality=csvCell[7];
			String passport=csvCell[8];
			String street=csvCell[9];
			String PostalCode=csvCell[10];

            System.out.println("TC:3: Starting BasicDetails Test Executation ");
            Utils.callSendkeys(driver,ActionXpath.dob, dob, "Set tu date of birth");
            Utils.scrollUpOrDown(driver, time);
            Utils.callSendkeys(driver, ActionXpath.nationality,nationality, "Enter Your Nationality");
            Utils.callSendkeys(driver, ActionXpath.passport,passport, "Enter your Passport");
            Utils.scrollUpOrDown(driver, time);
            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.Gender, time, "Select the Gender ");
            Utils.clickXpath(driver, ActionXpath.Mstatus, time, "Select your material status");
            Utils.scrollUpOrDown(driver, time);
            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.selectcountry,time, "Enter your selectcountry");
            java.util.List<WebElement> country = driver
                    .findElements(By.xpath("//ul[contains(@class,'MuiList-root MuiList-padding MuiMenu-list css-r8u8y9')]//li//div//div"));
            for (int i = 0; i < country.size(); i++) {
                if (country.get(i).getText().startsWith("India")) {
                    country.get(i).click();
                    break;
                }
            }
            System.out.println("India printed");
            // Utils.clickXpath(driver,ActionXpath.country, time, "Select your Country");
            Utils.clickXpath(driver, ActionXpath.selectstate, time, "Select the satet");
             List<WebElement> gram = driver
            .findElements(By.xpath("//ul[contains(@class,'MuiList-root MuiList-padding MuiMenu-list css-r8u8y9')]//li//div//div"));
            for (int i = 0; i < gram.size(); i++) {
            if(gram.get(i).getText().startsWith("Karnataka"))
            {
             gram.get(i).click();
             break;
            }
            }
            System.out.println("India2 printed");
            Utils.scrollUpOrDown(driver, time);
            // Utils.clickXpath(driver, ActionXpath.State, time, "Selct the State");
            Utils.clickXpath(driver, ActionXpath.selectDist, time, "Select the Dist");
            java.util.List<WebElement> gram2 = driver
            .findElements(By.xpath("//ul[contains(@class,'MuiList-root MuiList-padding MuiMenu-list css-r8u8y9')]//li//div//div"));
            for (int i = 0; i < gram.size(); i++) {
            if(gram2.get(i).getText().startsWith("Bangalore Rural"))
            {
                gram2.get(i).click();
                break;
            }
            }
            // Utils.clickXpath(driver, ActionXpath.District, time, "Select the Dist");
            Utils.scrollUpOrDown(driver, time);
            Utils.callSendkeys(driver, ActionXpath.street, street, "enter your permanent addrrss");
            Utils.callSendkeys(driver, ActionXpath.PostalCode, PostalCode, "Select your Postal Code");
            Utils.scrollUpOrDown(driver, time);
            Utils.scrollUpOrDown(driver, time);
            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.currentaddress, time, "Click the address");
            Utils.clickXpath(driver, ActionXpath.selectcurrentaddress, time, "Click the address");
            Utils.clickXpath(driver, ActionXpath.ClickNext, time, "click on Next");
            log.info("  TC-3: Fill the BasicDetails test case PASSED \n");

        } catch (Exception e) {
			log.warning("TC-3: Fill the BasicDetails test case FAILED \n");
		}
    } 
    
    @Test(priority = 4)
    public static void FamilyInfo(String url,WebDriver driver,String[] csvCell){
        try{
            String firstName=csvCell[11];
            String lastName=csvCell[12];
            String Phone=csvCell[13];
            String Email=csvCell[14];
            String Age=csvCell[15];
            String occupation=csvCell[16];
            String annualIncome=csvCell[17];


            System.out.println("TC:3: Starting FamilyInfo Test Executation ");
            Utils.clickXpath(driver, ActionXpath.selectrelationship, time, "Select the Relationship status option");
            Utils.clickXpath(driver, ActionXpath.relationType, time, "Select the relationhip Type");
            Utils.callSendkeys(driver, ActionXpath.firstName, firstName, "Enter Fist name");
            Utils.scrollUpOrDown(driver, time);
            Utils.callSendkeys(driver, ActionXpath.lastName, lastName, "Enter Last NAme");
            Utils.callSendkeys(driver, ActionXpath.Phone, Phone, "enter the Phone");
            Utils.scrollUpOrDown(driver, time);
            Utils.callSendkeys(driver, ActionXpath.Email, Email, "Enter the Emial");
            Utils.callSendkeys(driver, ActionXpath.Age, Age, "Selct age");
            Utils.scrollUpOrDown(driver, time);
            Utils.callSendkeys(driver, ActionXpath.occupation, occupation, "Select the manager");
            Utils.callSendkeys(driver, ActionXpath.annualIncome, annualIncome, "Selct the Annual income");
            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.SelectQualification, time, "Select the Qualification");
            Utils.clickXpath(driver, ActionXpath.Qualification, time, "Select the appropriate Qualification");
            Utils.clickXpath(driver, ActionXpath.CurrencyTypeSelect, time, "Select currency");
            Utils.clickXpath(driver, ActionXpath.currencyType, time, "Select the appropriate currency");
            Utils.clickXpath(driver, ActionXpath.ClickNext, time, "click on Next");
            log.info("  TC-4: Fill the FamilyInfo test case PASSED \n");

        }catch (Exception e) {
            log.warning("TC-4: Fill the FamilyInfo test case FAILED \n");
        }
    }
    @Test(priority = 5)
    public static void EmploymentInfo(String url,WebDriver driver,String[] csvCell){
        try{
            Utils.bigSleepBetweenClicks(1);
            String Company=csvCell[18];
            String industry=csvCell[19];
            String location=csvCell[20];
            String Designation=csvCell[21];
            String Role=csvCell[22];
            String dateofJoin=csvCell[23];
            String experince=csvCell[24];
            String Annual=csvCell[25];
            System.out.println("TC:5: Starting EmploymentInfo Test Executation ");
            Utils.clickXpath(driver, ActionXpath.clickyes, time, "clickyes");
            Utils.clickXpath(driver, ActionXpath.SelectjobType, time, "Select the Job type");
            Utils.clickXpath(driver, ActionXpath.jobType, time, "Select the Appropriate job ");
            Utils.callSendkeys(driver, ActionXpath.company, Company, "enter the company name");
            Utils.scrollUpOrDown(driver, time);
            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.IndustryType, time, "IndustryType ");
            java.util.List<WebElement> gram2 = driver
            .findElements(By.xpath("//ul[contains(@class,'MuiList-root MuiList-padding MuiMenu-list css-r8u8y9')]//li//div//div"));
            for (int i = 0; i < gram2.size(); i++) {
            if(gram2.get(i).getText().startsWith("Agriculture & Forestry/Wildlife - Other (Agriculture & Forestry/Wildlife)"))
            {
                gram2.get(i).click();
                break;
            }
            }
            Utils.callSendkeys(driver, ActionXpath.location, location, "Entet the location");
            Utils.callSendkeys(driver, ActionXpath.designation, Designation, "enter the Designation ");
            Utils.scrollUpOrDown(driver, time);
            Utils.scrollUpOrDown(driver, time);
            Utils.callSendkeys(driver, ActionXpath.role, Role, "enter the Role ");
            Utils.callSendkeys(driver, ActionXpath.DateJoin, dateofJoin, "enter the date of joining");
            Utils.clickXpath(driver, ActionXpath.CurrentCompany, time, "CurrentCompany");
            Utils.clickXpath(driver, ActionXpath.selectCurrentCompany, time, "selectCurrentCompany");
            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.currencytype, time, "currencytype");
            Utils.clickXpath(driver, ActionXpath.selectcurrencytype, time, "selectcurrencytype");
            Utils.scrollUpOrDown(driver, time);
            Utils.callSendkeys(driver, ActionXpath.Experience, experince, "enter the Experience");
            Utils.callSendkeys(driver, ActionXpath.AnnualSalary, Annual, "Enter the annual Salary");
            Utils.clickXpath(driver, ActionXpath.ClickNext, time, "click on Next");
            log.info("  TC-5: Fill the EmploymentInfo test case PASSED \n");
       
        }catch (Exception e) {
            log.warning("TC-5: Fill the EmploymentInfo test case FAILED \n");
        }
    }
    @Test(priority = 6)
    public static void EducationINFO(String url,WebDriver driver, String[] csvCell){
        try{
            System.out.println("TC:6: Starting Education Test Executation ");
           Utils.bigSleepBetweenClicks(1);
           String pgyear=csvCell[26];
           String pguniversity=csvCell[27];
           String pgcollege=csvCell[28];
           String pgpercentage=csvCell[29];
           String ugyear=csvCell[30];
           String uguniversity=csvCell[31];
           String ugcollege=csvCell[32];
           String ugpercentage=csvCell[33];
           String ugmark1=csvCell[34];
           String ugmaxmark1=csvCell[35];
           String ugmark2=csvCell[36];
           String ugmaxmark2=csvCell[37];
           String hscpercentage=csvCell[38];
           String hscyear=csvCell[39];
           String hscschool=csvCell[40];
           String sslcpercentage=csvCell[41];
           String sslcyear=csvCell[42];
           String sslcschool=csvCell[43];
           
            //pg
            Utils.callSendkeys(driver, ActionXpath.pgyear, pgyear, "pgyear");
            Utils.callSendkeys(driver, ActionXpath.pguniversity, pguniversity, "pguniversity");
            Utils.scrollUpOrDown(driver, time);
            Utils.callSendkeys(driver, ActionXpath.pgcollege, pgcollege, "pgcollege");
            Utils.callSendkeys(driver, ActionXpath.pgpercentage, pgpercentage, "pgpercentage");
            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.pgedttype, time, "pgedttype");
            Utils.clickXpath(driver, ActionXpath.pgselectedttype, time, "pgselectedttype");
            Utils.clickXpath(driver, ActionXpath.pgdegree, time, "pgdegree");
            // Utils.clickXpath(driver, ActionXpath.pgselectdegree, time, "pgselectdegree");
            java.util.List<WebElement> gram = driver
            .findElements(By.xpath("//ul[contains(@class,'MuiList-root MuiList-padding MuiMenu-list css-r8u8y9')]//li//div//div"));
            for (int i = 0; i < gram.size(); i++) {
            if(gram.get(i).getText().startsWith("Bachelor of Fine Arts (BFA)"))
            {
             gram.get(i).click();
             break;
            }
            }
            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.pgcountry, time, "pgcountry");
            // Utils.clickXpath(driver, ActionXpath.pgselectcountry, time, "pgselectcountry");
            gram = driver
            .findElements(By.xpath("//ul[contains(@class,'MuiList-root MuiList-padding MuiMenu-list css-r8u8y9')]//li//div//div"));
            for (int i = 0; i < gram.size(); i++) {
            if(gram.get(i).getText().startsWith("India"))
            {
             gram.get(i).click();
             break;
            }
            }
            Utils.clickXpath(driver, ActionXpath.pgstate, time, "pgstate");
            // Utils.clickXpath(driver, ActionXpath.pgselectstate, time, "pgselectstate");
             gram = driver
            .findElements(By.xpath("//ul[contains(@class,'MuiList-root MuiList-padding MuiMenu-list css-r8u8y9')]//li//div//div"));
            for (int i = 0; i < gram.size(); i++) {
            if(gram.get(i).getText().startsWith("Karnataka"))
            {
             gram.get(i).click();
             break;
            }
            }
            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.pgcity, time, "pgcity");
            // Utils.clickXpath(driver, ActionXpath.pgselectcity, time, "pgselectcity");
            gram = driver
            .findElements(By.xpath("//ul[contains(@class,'MuiList-root MuiList-padding MuiMenu-list css-r8u8y9')]//li//div//div"));
            for (int i = 0; i < gram.size(); i++) {
            if(gram.get(i).getText().startsWith("Bangalore Rural"))
            {
             gram.get(i).click();
             break;
            }
            }
            Utils.scrollUpOrDown(driver, time);
            //ug
            Utils.callSendkeys(driver, ActionXpath.ugyear, ugyear, "ugyear");
            Utils.callSendkeys(driver, ActionXpath.uguniversity, uguniversity, "uguniversity");
            Utils.scrollUpOrDown(driver, time);
            Utils.callSendkeys(driver, ActionXpath.ugcollege, ugcollege, "ugcollege");
            Utils.callSendkeys(driver, ActionXpath.ugpercentage,ugpercentage, "ugpercentage");
            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.ugedtype, time, "ugedtype");
            Utils.clickXpath(driver, ActionXpath.ugselectedtype, time, "ugselectedtype");
            Utils.clickXpath(driver, ActionXpath.ugdegree, time, "ugdegree");
            // Utils.clickXpath(driver, ActionXpath.ugselectdegree, time, "ugselectdegree");
            gram = driver
            .findElements(By.xpath("//ul[contains(@class,'MuiList-root MuiList-padding MuiMenu-list css-r8u8y9')]//li//div//div"));
            for (int i = 0; i < gram.size(); i++) {
            if(gram.get(i).getText().startsWith("Bachelor of Management Science (BMS)"))
            {
             gram.get(i).click();
             break;
            }
            }
            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.ugcountry, time, "ugcountry");
            // Utils.clickXpath(driver, ActionXpath.ugselectcountry, time, "ugselectcountry");
             gram = driver
            .findElements(By.xpath("//ul[contains(@class,'MuiList-root MuiList-padding MuiMenu-list css-r8u8y9')]//li//div//div"));
            for (int i = 0; i < gram.size(); i++) {
            if(gram.get(i).getText().startsWith("India"))
            {
             gram.get(i).click();
             break;
            }
            }
            Utils.clickXpath(driver, ActionXpath.ugstate, time, "ugstate");
            // Utils.clickXpath(driver, ActionXpath.ugselectstate, time, "ugselectstate");
            gram = driver
            .findElements(By.xpath("//ul[contains(@class,'MuiList-root MuiList-padding MuiMenu-list css-r8u8y9')]//li//div//div"));
            for (int i = 0; i < gram.size(); i++) {
            if(gram.get(i).getText().startsWith("Karnataka"))
            {
             gram.get(i).click();
             break;
            }
            }
            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.ugcity, time, "ugcity");
            // Utils.clickXpath(driver, ActionXpath.ugselectcity, time, "ugselectcity");
            gram = driver
            .findElements(By.xpath("//ul[contains(@class,'MuiList-root MuiList-padding MuiMenu-list css-r8u8y9')]//li//div//div"));
            for (int i = 0; i < gram.size(); i++) {
            if(gram.get(i).getText().startsWith("Bangalore Rural"))
            {
             gram.get(i).click();
             break;
            }
            }
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
            
            //12
            Utils.clickXpath(driver, ActionXpath.hscedtype, time, "hscedtype");
            Utils.clickXpath(driver, ActionXpath.hscselectedtype, time, "hscselectedtype");
            Utils.clickXpath(driver, ActionXpath.hscboard, time, "hscboard");
            // Utils.clickXpath(driver, ActionXpath.hscselectboard, time, "hscselectboard");
            gram = driver
            .findElements(By.xpath("//ul[contains(@class,'MuiList-root MuiList-padding MuiMenu-list css-r8u8y9')]//li//div//div"));
            for (int i = 0; i < gram.size(); i++) {
            if(gram.get(i).getText().startsWith("KARNATAKA SECONDARY EDUCATION, EXAMINATION BOARD"))
            {
             gram.get(i).click();
             break;
            }
            }
            Utils.scrollUpOrDown(driver, time);
            Utils.callSendkeys(driver, ActionXpath.hscpercentage, hscpercentage, "hscpercentage");
            Utils.callSendkeys(driver, ActionXpath.hscyear, hscyear, "hscyear");
            Utils.scrollUpOrDown(driver, time);
            Utils.callSendkeys(driver, ActionXpath.hscschool, hscschool, "hscschool");
            Utils.clickXpath(driver, ActionXpath.hsccountry, time, "hsccountry");
            // Utils.clickXpath(driver, ActionXpath.hscselectcountry, time, "hscselectcountry");
            gram = driver
            .findElements(By.xpath("//ul[contains(@class,'MuiList-root MuiList-padding MuiMenu-list css-r8u8y9')]//li//div//div"));
            for (int i = 0; i < gram.size(); i++) {
            if(gram.get(i).getText().startsWith("India"))
            {
             gram.get(i).click();
             break;
            }
            }
            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.hscstate, time, "hscstate");
            // Utils.clickXpath(driver, ActionXpath.hscselectstate, time, "hscselectstate");
            gram = driver
            .findElements(By.xpath("//ul[contains(@class,'MuiList-root MuiList-padding MuiMenu-list css-r8u8y9')]//li//div//div"));
            for (int i = 0; i < gram.size(); i++) {
            if(gram.get(i).getText().startsWith("Karnataka"))
            {
             gram.get(i).click();
             break;
            }
            }
            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.hsccity, time, "hsccity");
            // Utils.clickXpath(driver, ActionXpath.hscselectcity, time, "ugselectcity");
            gram = driver
            .findElements(By.xpath("//ul[contains(@class,'MuiList-root MuiList-padding MuiMenu-list css-r8u8y9')]//li//div//div"));
            for (int i = 0; i < gram.size(); i++) {
            if(gram.get(i).getText().startsWith("Bangalore Rural"))
            {
             gram.get(i).click();
             break;
            }
            }
            Utils.scrollUpOrDown(driver, time);
            Utils.scrollUpOrDown(driver, time);

            //10
            Utils.clickXpath(driver, ActionXpath.sslcedtype, time, "sslcedtype");
            Utils.clickXpath(driver, ActionXpath.sslcselectedtype, time, "sslcselectedtype");
            Utils.clickXpath(driver, ActionXpath.sslcboard, time, "sslcboard");
            // Utils.clickXpath(driver, ActionXpath.sslcselectboard, time, "sslcselectboard");
            gram = driver
            .findElements(By.xpath("//ul[contains(@class,'MuiList-root MuiList-padding MuiMenu-list css-r8u8y9')]//li//div//div"));
            for (int i = 0; i < gram.size(); i++) {
            if(gram.get(i).getText().startsWith("KARNATAKA SECONDARY EDUCATION, EXAMINATION BOARD"))
            {
             gram.get(i).click();
             break;
            }
            }
            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.sslcgrade, time, "sslcgrade");
            Utils.clickXpath(driver, ActionXpath.sslcselectgrade, time, "sslcselectgrade");
            Utils.callSendkeys(driver, ActionXpath.sslcpercentage, sslcpercentage, "sslcpercentage");
            Utils.scrollUpOrDown(driver, time);
            Utils.callSendkeys(driver, ActionXpath.sslcyear, sslcyear, "sslcyear");
            Utils.callSendkeys(driver, ActionXpath.sslcschool, sslcschool, "sslcschool");
            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.sslccountry, time, "sslccountry");
            // Utils.clickXpath(driver, ActionXpath.sslcselectcountry, time, "sslcselectcountry");
            gram = driver
            .findElements(By.xpath("//ul[contains(@class,'MuiList-root MuiList-padding MuiMenu-list css-r8u8y9')]//li//div//div"));
            for (int i = 0; i < gram.size(); i++) {
            if(gram.get(i).getText().startsWith("India"))
            {
             gram.get(i).click();
             break;
            }
            }
            Utils.clickXpath(driver, ActionXpath.sslcstate, time, "sslcstate");
            // Utils.clickXpath(driver, ActionXpath.sslcselectstate, time, "sslcselectstate");
            gram = driver
            .findElements(By.xpath("//ul[contains(@class,'MuiList-root MuiList-padding MuiMenu-list css-r8u8y9')]//li//div//div"));
            for (int i = 0; i < gram.size(); i++) {
            if(gram.get(i).getText().startsWith("Karnataka"))
            {
             gram.get(i).click();
             break;
            }
            }
            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.sslccity, time, "sslccity");
            // Utils.clickXpath(driver, ActionXpath.sslcselectcity, time, "sslcselectcity");
            gram = driver
            .findElements(By.xpath("//ul[contains(@class,'MuiList-root MuiList-padding MuiMenu-list css-r8u8y9')]//li//div//div"));
            for (int i = 0; i < gram.size(); i++) {
            if(gram.get(i).getText().startsWith("Bangalore Rural"))
            {
             gram.get(i).click();
             break;
            }
            }
            Utils.clickXpath(driver, ActionXpath.ClickNext, time, "click on Next"); 
           
            log.info("  TC-6: Fill the Education test case PASSED \n");

        
        }catch (Exception e) {
            log.warning("TC-6: Fill the Education test case FAILED \n");
        }
    }
    @Test(priority = 7)
    public static void other(String url,WebDriver driver, String[] csvCell){
        try{
            System.out.println("TC:7: Others Test Executation ");
            
           String SportAchievement=csvCell[44];
           String ProfessionalAchievement=csvCell[45];
           String CurricularActivities=csvCell[46];
           String AcademicAchievements=csvCell[47];
           String Statement=csvCell[48];
           String planmasterdegree=csvCell[49];

            Utils.callSendkeys(driver, ActionXpath.SportAchievement, SportAchievement, "SportAchievement");
            Utils.callSendkeys(driver, ActionXpath.ProfessionalAchievement, ProfessionalAchievement, "ProfessionalAchievement");
            Utils.scrollUpOrDown(driver, time);
            Utils.callSendkeys(driver, ActionXpath.CurricularActivities, CurricularActivities, "CurricularActivities");
            Utils.callSendkeys(driver, ActionXpath.AcademicAchievements, AcademicAchievements, "AcademicAchievements");
            Utils.scrollUpOrDown(driver, time);
            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.fundeducation, time, "fundeducation");
            Utils.clickXpath(driver, ActionXpath.fundselecteducation, time, "fundselecteducation");
            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.physicallychallenged, time, "physicallychallenged");
            // Utils.callSendkeys(driver, ActionXpath.sharedetails, "NA", "sharedetails");
            Utils.callSendkeys(driver, ActionXpath.Statement, Statement, "Statement");
            Utils.callSendkeys(driver, ActionXpath.planmasterdegree, planmasterdegree, "planmasterdegree");
            Utils.clickXpath(driver, ActionXpath.sponsoredbycompany, time, "sponsoredbycompany"); 
            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.Language, time, "Language"); 
            // Utils.clickXpath(driver, ActionXpath.SelectLanguage, time, "SelectLanguage");
            java.util.List<WebElement> gram = driver
            .findElements(By.xpath("//ul[contains(@class,'MuiList-root MuiList-padding MuiMenu-list css-r8u8y9')]//li//div//div"));
            for (int i = 0; i < gram.size(); i++) {
            if(gram.get(i).getText().startsWith("Kannada"))
            {
             gram.get(i).click();
             break;
            }
            }
           Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.Proficiency, time, "Proficiency");
            Utils.clickXpath(driver, ActionXpath.SelectProficiency, time, "SelectProficiency");
            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.evaluation, time, "evaluation");
            Utils.clickXpath(driver, ActionXpath.Selectevaluation, time, "Selectevaluation");
            Utils.clickXpath(driver, ActionXpath.qualificationenglish, time, "qualificationenglish"); 
            Utils.clickXpath(driver, ActionXpath.selectlatestqualificationenglish, time, "selectlatestqualificationenglish");
            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.latestqualificationenglish, time, "latestqualificationenglish");
            Utils.clickXpath(driver, ActionXpath.selectlatestqualificationenglish, time, "selectlatestqualificationenglish");
            Utils.clickXpath(driver, ActionXpath.EducationConsultant, time, "EducationConsultant");
            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.hearspjain, time, "hearspjain");
            Utils.clickXpath(driver, ActionXpath.selecthearspjain, time, "selecthearspjain"); 
            Utils.clickXpath(driver, ActionXpath.refrence, time, "refrence");
            Utils.clickXpath(driver, ActionXpath.ClickNext, time, "click on Next");
            log.info("  TC-7: Fill the Others test case PASSED \n");
        }catch (Exception e) {
            log.warning("TC-7: Fill the others test case FAILED \n");
        }
    }
    @Test(priority = 8)
    public static void summaryanddeclaration(String url,WebDriver driver, String[] csvCell){
        try{
            System.out.println("TC:8: summaryanddeclaration Test Executation ");

            Utils.clickXpath(driver, ActionXpath.clicksubmit, time, "click on clicksubmit");
            Utils.bigSleepBetweenClicks(1);
            Utils.clickXpath(driver, ActionXpath.backtohome, time, "click on backtohome");
            Utils.bigSleepBetweenClicks(1);

            log.info("  TC-8: Fill the summaryanddeclaration test case PASSED \n");
        }catch (Exception e) {
             log.warning("TC-8: Fill the summaryanddeclaration test case FAILED \n");
        }
        }
        @Test(priority = 9)
        public static void SalesforceBackendVerify(String Sfurl,WebDriver driver,String[] csvCell) {
            try{
                System.out.println("TC:9: Salesforce backend Verification along with delete  Test Executation ");
                ((JavascriptExecutor) driver).executeScript("window.open()");
		         ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
		        driver.switchTo().window(tab.get(1));
                 driver.get(Sfurl);
                String SfEmail=csvCell[50];
                String SfPassword=csvCell[51];
                Utils.callSendkeys(driver, ActionXpath.SalesforceEmail, SfEmail, "enter salesforce email");
                Utils.callSendkeys(driver, ActionXpath.SalesforcePassword, SfPassword,"Enter your password");
                Utils.clickXpath(driver, ActionXpath.loginSalesforce, time, "click on login salesforce");
                Utils.clickXpath(driver, ActionXpath.ClickApplication, time, "clcik the application Tab");
                Utils.callSendkeys(driver, ActionXpath.SearchForAppliacant, "Test Student", "Enter the applicatnt name");
                Utils.clickXpath(driver, ActionXpath.clickTheApplicanetName, time, "clcik on the application name");
                Utils.clickXpath(driver, ActionXpath.clickApplicatioID, time, "Click on the applicant ID");
                Utils.clickXpath(driver, ActionXpath.clickApplicationView, time, "click on thr application view");
                Utils.scrollUpOrDown(driver, time);
                Utils.scrollUpOrDown(driver, time);
                Utils.clickXpath(driver, ActionXpath.clickDelete, time, "Delete the applicant ");
                Utils.clickXpath(driver, ActionXpath.ClickProfileForLogout, time, "clcik the profile  for logout the salesforce");
                Utils.clickXpath(driver, ActionXpath.ClickLOgout, time, "click logout ");

                log.info("  TC-8:  the Salesforce backend Verification along with delete test case PASSED \n");

            }catch (Exception e) {
                log.warning("TC-8: the Salesforce backend Verification along with delete test case FAILED \n");
           }
        }
}

