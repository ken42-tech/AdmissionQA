package com.ken42;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
            Utils.clickXpath(driver, ActionXpath.ClickPorogrameDrop, time, "Selec the Progarme Drop down");
            Utils.clickXpath(driver, ActionXpath.selectPrograme, time, "Select the appropriate Programe");
            Utils.clickXpath(driver, ActionXpath.ApplyNow, time, "Click on apply");
            Utils.clickXpath(driver, ActionXpath.ClickNext, time, "click on Next");
            Utils.clickXpath(driver, ActionXpath.Selectmentor, time, "Slect the mentor");
            Utils.clickXpath(driver, ActionXpath.selectYes, time, "Slect  yes ");
            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.SelectCampus, time, "Select the campus");
            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.Specilization, time, "Select the Specilization");
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
            Utils.callSendkeys(driver, ActionXpath.nationality,nationality, "Enter Your Nationality");
            Utils.callSendkeys(driver, ActionXpath.passport,passport, "Enter your Passport");
            Utils.clickXpath(driver, ActionXpath.Gender, time, "Select the Gender ");
            Utils.clickXpath(driver, ActionXpath.Mstatus, time, "Select your material status");
            Utils.clickXpath(driver, ActionXpath.selectcountry,time, "Enter your selectcountry");
             java.util.List<WebElement> gram = driver
            .findElements(By.xpath("//ul[contains(@class,'MuiList-root MuiList-padding MuiMenu-list css-r8u8y9')]//li//div//div"));
            for (int i = 0; i < gram.size(); i++) {
            if(gram.get(i).getText().startsWith("India"))
            {
             gram.get(i).click();
            }
            }

            Utils.clickXpath(driver,ActionXpath.country, time, "Select your Country");
            Utils.clickXpath(driver, ActionXpath.selectstate, time, "Select the satet");
            java.util.List<WebElement> gram1 = driver
            .findElements(By.xpath("//ul[contains(@class,'MuiList-root MuiList-padding MuiMenu-list css-r8u8y9')]//li//div//div"));
            for (int i = 0; i < gram.size(); i++) {
            if(gram1.get(i).getText().startsWith("Karnataka"))
            {
             gram1.get(i).click();
            }
            }
            Utils.clickXpath(driver, ActionXpath.State, time, "Selct the State");
            Utils.clickXpath(driver, ActionXpath.selectDist, time, "Select the Dist");
            java.util.List<WebElement> gram2 = driver
            .findElements(By.xpath("//ul[contains(@class,'MuiList-root MuiList-padding MuiMenu-list css-r8u8y9')]//li//div//div"));
            for (int i = 0; i < gram.size(); i++) {
            if(gram2.get(i).getText().startsWith("Bangalore Rural"))
            {
                gram2.get(i).click();
            }
            }
            Utils.clickXpath(driver, ActionXpath.District, time, "Select the Dist");
            Utils.callSendkeys(driver, ActionXpath.street, street, "enter your permanent addrrss");
            Utils.callSendkeys(driver, ActionXpath.PostalCode, PostalCode, "Select your Postal Code");
            Utils.clickXpath(driver, ActionXpath.address, time, "Click the address");
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
            Utils.callSendkeys(driver, ActionXpath.lastName, lastName, "Enter Last NAme");
            Utils.callSendkeys(driver, ActionXpath.Phone, Phone, "enter the Phone");
            Utils.callSendkeys(driver, ActionXpath.Email, Email, "Enter the Emial");
            Utils.callSendkeys(driver, ActionXpath.Age, Age, "Selct age");
            Utils.callSendkeys(driver, ActionXpath.occupation, occupation, "Select the manager");
            Utils.callSendkeys(driver, ActionXpath.annualIncome, annualIncome, "Selct the Annual income");
            Utils.clickXpath(driver, ActionXpath.SelectQualification, time, "Select the Qualification");
            Utils.clickXpath(driver, ActionXpath.Qualification, time, "Select the appropriate Qualification");
            Utils.clickXpath(driver, ActionXpath.CurrencyTypeSelect, time, "Select currency");
            Utils.clickXpath(driver, ActionXpath.currencyType, time, "Select the appropriate currency");
            Utils.clickXpath(driver, ActionXpath.ClickNext, time, "click on Next");
            log.info("  TC-3: Fill the FamilyInfo test case PASSED \n");

}catch (Exception e) {
    log.warning("TC-3: Fill the FamilyInfo test case FAILED \n");
}
    }
    @Test(priority = 5)
    public static void EmploymentInfo(String url,WebDriver driver,String[] csvCell){
        try{
            String Company=csvCell[18];
            String industry=csvCell[19];
            String location=csvCell[20];
            String Designation=csvCell[21];
            String Role=csvCell[22];
            String dateofJoin=csvCell[23];
            String experince=csvCell[24];
            String Annual=csvCell[25];
            System.out.println("TC:5: Starting EmploymentInfo Test Executation ");
            Utils.clickXpath(driver, ActionXpath.SelectjobType, time, "Select the Job type");
            Utils.clickXpath(driver, ActionXpath.jobType, time, "Select the Appropriate job ");
            Utils.callSendkeys(driver, ActionXpath.company, Company, "enter the company name");
            Utils.callSendkeys(driver, ActionXpath.IndustryType, industry, "Enter the Industry");
            Utils.callSendkeys(driver, ActionXpath.designation, Designation, "enter the Designation ");
            Utils.callSendkeys(driver, ActionXpath.location, location, "Entet the location");
            Utils.callSendkeys(driver, ActionXpath.role, Role, "enter the Role ");
            Utils.callSendkeys(driver, ActionXpath.DateJoin, dateofJoin, "enter the date of joining");
            Utils.callSendkeys(driver, ActionXpath.Experience, experince, "enter the Experience");
            Utils.callSendkeys(driver, ActionXpath.AnnualSalary, Annual, "Enter the annual Salary");
            Utils.clickXpath(driver, ActionXpath.ClickNext, time, "click on Next");
            log.info("  TC-5: Fill the EmploymentInfo test case PASSED \n");
       
        }catch (Exception e) {
            log.warning("TC-5: Fill the EmploymentInfo test case FAILED \n");
        }
    }
    @Test(priority = 6)
    public static void Education(String url,WebDriver driver, String Email){
        try{
            System.out.println("TC:6: Starting Education Test Executation ");
            Utils.clickXpath(driver, ActionXpath.ClickNext, time, "click on Next");
            log.info("  TC-6: Fill the Education test case PASSED \n");
            //pg
            Utils.callSendkeys(driver, ActionXpath.pgyear, "15-05-2020", "pgyear");
            Utils.callSendkeys(driver, ActionXpath.pguniversity, "Bharathiyar", "pguniversity");
            Utils.callSendkeys(driver, ActionXpath.pgcollege, "Bangalore instute", "pgcollege");
            Utils.callSendkeys(driver, ActionXpath.pgpercentage, "70", "pgpercentage");
            Utils.clickXpath(driver, ActionXpath.pgedttype, time, "pgedttype");
            Utils.clickXpath(driver, ActionXpath.pgselectedttype, time, "pgselectedttype");
            Utils.clickXpath(driver, ActionXpath.pgdegree, time, "pgdegree");
            // Utils.clickXpath(driver, ActionXpath.pgselectdegree, time, "pgselectdegree");
            java.util.List<WebElement> gram = driver
            .findElements(By.xpath("//ul[contains(@class,'MuiList-root MuiList-padding MuiMenu-list css-r8u8y9')]//li//div//div"));
            for (int i = 0; i < gram.size(); i++) {
            if(gram.get(i).getText().startsWith("//*[text()='Bachelor of Fine Arts (BFA)']"))
            {
             gram.get(i).click();
            }
            }
            Utils.clickXpath(driver, ActionXpath.pgcountry, time, "pgcountry");
            // Utils.clickXpath(driver, ActionXpath.pgselectcountry, time, "pgselectcountry");
            gram = driver
            .findElements(By.xpath("//ul[contains(@class,'MuiList-root MuiList-padding MuiMenu-list css-r8u8y9')]//li//div//div"));
            for (int i = 0; i < gram.size(); i++) {
            if(gram.get(i).getText().startsWith("India"))
            {
             gram.get(i).click();
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
            }
            }
            Utils.clickXpath(driver, ActionXpath.pgcity, time, "pgcity");
            // Utils.clickXpath(driver, ActionXpath.pgselectcity, time, "pgselectcity");
            gram = driver
            .findElements(By.xpath("//ul[contains(@class,'MuiList-root MuiList-padding MuiMenu-list css-r8u8y9')]//li//div//div"));
            for (int i = 0; i < gram.size(); i++) {
            if(gram.get(i).getText().startsWith("Bangalore Rural"))
            {
             gram.get(i).click();
            }
            }
             
            //ug
            Utils.callSendkeys(driver, ActionXpath.ugyear, "15-05-2017", "ugyear");
            Utils.callSendkeys(driver, ActionXpath.uguniversity, "Bharathiyar", "uguniversity");
            Utils.callSendkeys(driver, ActionXpath.ugcollege, "Bangalore instute", "ugcollege");
            Utils.callSendkeys(driver, ActionXpath.ugpercentage, "70", "ugpercentage");
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
            }
            }
            Utils.clickXpath(driver, ActionXpath.ugcountry, time, "ugcountry");
            // Utils.clickXpath(driver, ActionXpath.ugselectcountry, time, "ugselectcountry");
             gram = driver
            .findElements(By.xpath("//ul[contains(@class,'MuiList-root MuiList-padding MuiMenu-list css-r8u8y9')]//li//div//div"));
            for (int i = 0; i < gram.size(); i++) {
            if(gram.get(i).getText().startsWith("India"))
            {
             gram.get(i).click();
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
            }
            }
            Utils.clickXpath(driver, ActionXpath.ugcity, time, "ugcity");
            // Utils.clickXpath(driver, ActionXpath.ugselectcity, time, "ugselectcity");
            gram = driver
            .findElements(By.xpath("//ul[contains(@class,'MuiList-root MuiList-padding MuiMenu-list css-r8u8y9')]//li//div//div"));
            for (int i = 0; i < gram.size(); i++) {
            if(gram.get(i).getText().startsWith("Bangalore Rural"))
            {
             gram.get(i).click();
            }
            }
            Utils.clickXpath(driver, ActionXpath.ugtype, time, "ugtype");
            Utils.clickXpath(driver, ActionXpath.ugselecttype, time, "ugselecttype");
            Utils.clickXpath(driver, ActionXpath.ugyear1, time, "ugyear1");
            Utils.clickXpath(driver, ActionXpath.ugselectyear1, time, "ugselectyear1");
            Utils.callSendkeys(driver, ActionXpath.ugmark1, "70", "ugmark1");
            Utils.callSendkeys(driver, ActionXpath.ugmaxmark1, "100", "ugmaxmark1");
            Utils.clickXpath(driver, ActionXpath.ugyear2, time, "ugyear2");
            Utils.clickXpath(driver, ActionXpath.ugselectyear2, time, "ugselectyear2");
            Utils.callSendkeys(driver, ActionXpath.ugmark2, "75", "ugmark2");
            Utils.callSendkeys(driver, ActionXpath.ugmaxmark2, "100", "ugmaxmark2");
            
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
            }
            }
            Utils.callSendkeys(driver, ActionXpath.hscpercentage, "78", "hscpercentage");
            Utils.callSendkeys(driver, ActionXpath.hscyear, "15-05-2017", "hscyear");
            Utils.callSendkeys(driver, ActionXpath.hscschool, "St pauls", "hscschool");
            Utils.clickXpath(driver, ActionXpath.hsccountry, time, "hsccountry");
            // Utils.clickXpath(driver, ActionXpath.hscselectcountry, time, "hscselectcountry");
            gram = driver
            .findElements(By.xpath("//ul[contains(@class,'MuiList-root MuiList-padding MuiMenu-list css-r8u8y9')]//li//div//div"));
            for (int i = 0; i < gram.size(); i++) {
            if(gram.get(i).getText().startsWith("India"))
            {
             gram.get(i).click();
            }
            }
            Utils.clickXpath(driver, ActionXpath.hscstate, time, "hscstate");
            // Utils.clickXpath(driver, ActionXpath.hscselectstate, time, "hscselectstate");
            gram = driver
            .findElements(By.xpath("//ul[contains(@class,'MuiList-root MuiList-padding MuiMenu-list css-r8u8y9')]//li//div//div"));
            for (int i = 0; i < gram.size(); i++) {
            if(gram.get(i).getText().startsWith("Karnataka"))
            {
             gram.get(i).click();
            }
            }
            Utils.clickXpath(driver, ActionXpath.hsccity, time, "hsccity");
            // Utils.clickXpath(driver, ActionXpath.hscselectcity, time, "ugselectcity");
            gram = driver
            .findElements(By.xpath("//ul[contains(@class,'MuiList-root MuiList-padding MuiMenu-list css-r8u8y9')]//li//div//div"));
            for (int i = 0; i < gram.size(); i++) {
            if(gram.get(i).getText().startsWith("Bangalore Rural"))
            {
             gram.get(i).click();
            }
            }
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
            }
            }
            Utils.clickXpath(driver, ActionXpath.sslcgrade, time, "sslcgrade");
            Utils.clickXpath(driver, ActionXpath.sslcselectgrade, time, "sslcselectgrade");
            Utils.callSendkeys(driver, ActionXpath.sslcpercentage, "15", "sslcpercentage");
            Utils.callSendkeys(driver, ActionXpath.sslcyear, "15-05-2015", "sslcyear");
            Utils.callSendkeys(driver, ActionXpath.sslcschool, "St pauls", "sslcschool");
            Utils.clickXpath(driver, ActionXpath.sslccountry, time, "sslccountry");
            // Utils.clickXpath(driver, ActionXpath.sslcselectcountry, time, "sslcselectcountry");
            gram = driver
            .findElements(By.xpath("//ul[contains(@class,'MuiList-root MuiList-padding MuiMenu-list css-r8u8y9')]//li//div//div"));
            for (int i = 0; i < gram.size(); i++) {
            if(gram.get(i).getText().startsWith("India"))
            {
             gram.get(i).click();
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
            }
            }
            Utils.clickXpath(driver, ActionXpath.sslccity, time, "sslccity");
            // Utils.clickXpath(driver, ActionXpath.sslcselectcity, time, "sslcselectcity");
            gram = driver
            .findElements(By.xpath("//ul[contains(@class,'MuiList-root MuiList-padding MuiMenu-list css-r8u8y9')]//li//div//div"));
            for (int i = 0; i < gram.size(); i++) {
            if(gram.get(i).getText().startsWith("Bangalore Rural"))
            {
             gram.get(i).click();
            }
            }
            Utils.clickXpath(driver, ActionXpath.ClickNext, time, "click on Next"); 

        
        }catch (Exception e) {
            log.warning("TC-6: Fill the Education test case FAILED \n");
        }
    }
    @Test(priority = 7)
    public static void other(String url,WebDriver driver, String Email){
        try{
            System.out.println("TC:7: Others Test Executation ");
            
            Utils.callSendkeys(driver, ActionXpath.SportAchievement, "NA", "SportAchievement");
            Utils.callSendkeys(driver, ActionXpath.ProfessionalAchievement, "NA", "ProfessionalAchievement");
            Utils.callSendkeys(driver, ActionXpath.CurricularActivities, "NA", "CurricularActivities");
            Utils.callSendkeys(driver, ActionXpath.AcademicAchievements, "NA", "AcademicAchievements");
            Utils.clickXpath(driver, ActionXpath.fundeducation, time, "fundeducation");
            Utils.clickXpath(driver, ActionXpath.fundselecteducation, time, "fundselecteducation");
            Utils.clickXpath(driver, ActionXpath.physicallychallenged, time, "physicallychallenged");
            Utils.callSendkeys(driver, ActionXpath.sharedetails, "NA", "sharedetails");
            Utils.callSendkeys(driver, ActionXpath.Statement, "NA", "Statement");
            Utils.callSendkeys(driver, ActionXpath.planmasterdegree, "NA", "planmasterdegree");
            Utils.clickXpath(driver, ActionXpath.Language, time, "Language"); 
            // Utils.clickXpath(driver, ActionXpath.SelectLanguage, time, "SelectLanguage");
            java.util.List<WebElement> gram = driver
            .findElements(By.xpath("//ul[contains(@class,'MuiList-root MuiList-padding MuiMenu-list css-r8u8y9')]//li//div//div"));
            for (int i = 0; i < gram.size(); i++) {
            if(gram.get(i).getText().startsWith("Kannada"))
            {
             gram.get(i).click();
            }
            }
            Utils.clickXpath(driver, ActionXpath.Proficiency, time, "Proficiency");
            Utils.clickXpath(driver, ActionXpath.SelectProficiency, time, "SelectProficiency");
            Utils.clickXpath(driver, ActionXpath.evaluation, time, "evaluation");
            Utils.clickXpath(driver, ActionXpath.Selectevaluation, time, "Selectevaluation");
            Utils.clickXpath(driver, ActionXpath.qualificationenglish, time, "qualificationenglish"); 
            Utils.clickXpath(driver, ActionXpath.selectlatestqualificationenglish, time, "selectlatestqualificationenglish");
            Utils.clickXpath(driver, ActionXpath.latestqualificationenglish, time, "latestqualificationenglish");
            Utils.clickXpath(driver, ActionXpath.selectlatestqualificationenglish, time, "selectlatestqualificationenglish");
            Utils.clickXpath(driver, ActionXpath.EducationConsultant, time, "EducationConsultant");
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
    public static void summaryanddeclaration(String url,WebDriver driver, String Email){
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
        
}


