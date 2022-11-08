package com.ken42;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

import org.testng.annotations.Test;

import com.mongodb.util.Util;

public class Application {
    public static Logger log = Logger.getLogger("App_portal");
    static int time = 2000;
    @Test(priority = 1)
	public static void testApp(String url,WebDriver driver, String Email,String[] csvCell) throws Exception {

        try {

			Thread.sleep(3000);
            System.out.println("TC-1: Starting Application Login  test case execution ");
            Utils.callSendkeys(driver, ActionXpath.EnterEmail, "sprutirajtest@gmail.com", "sp");
            Utils.clickXpath(driver, ActionXpath.Verify, time, "verify");
            Utils.bigSleepBetweenClicks(3);
            Utils.getAndSentOTP();
            Utils.bigSleepBetweenClicks(3);
            Utils.clickXpath(driver, ActionXpath.Verifylogin, time, "Verift the Login ");
            log.info("  TC-1: Application login test case PASSED \n");

        } catch (Exception e) {
			log.warning("TC-1: Application login test case FAILED \n");
		}
    }
    @Test(priority = 2)
    public static void ApplyforCourse(String url,WebDriver driver, String Email){
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
            Utils.clickXpath(driver, ActionXpath.Specilization, time, "Select the Specilization");
            Utils.clickXpath(driver, ActionXpath.ClickNext, time, "click on Next");

        
            log.info("  TC-2: Apply for Course programe test case PASSED \n");

        } catch (Exception e) {
			log.warning("TC-2: Apply for Course programe test case FAILED \n");
		}
    }
    
    @Test(priority = 3)
    public static void BasicDetails(String url,WebDriver driver, String Email,String[] csvCell ){
        try{
            String dob =csvCell[6];
			String nationality=csvCell[7];
			String passport=csvCell[8];
		
			String street=csvCell[9];
			String PostalCode=csvCell[10];
            System.out.println("TC:3: Starting BasicDetails Test Executation ");
            Utils.callSendkeys(driver,ActionXpath.dob, dob, "Set tu date of birth");
            Utils.callSendkeys(driver, ActionXpath.nationality,nationality, "Enter Your Nationality");
            Utils.callSendkeys(driver, ActionXpath.passport,passport, "Enter your Passport");
            Utils.clickXpath(driver, ActionXpath.Gender, time, "Selct ur gender");
            Utils.clickXpath(driver, ActionXpath.Mstatus, time, "Select your material status");
            Utils.clickXpath(driver,ActionXpath.country, time, "Select your Country");
            Utils.clickXpath(driver, ActionXpath.State, time, "Selct the State");
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
    public static void FamilyInfo(String url,WebDriver driver, String Email){
        try{
            System.out.println("TC:3: Starting FamilyInfo Test Executation ");
            Utils.clickXpath(driver, ActionXpath.relationType, time, "Select the relationhip Type");
            Utils.callSendkeys(driver, ActionXpath.firstName, "Akash", "Enter Fist name");
            Utils.callSendkeys(driver, ActionXpath.lastName, "Mishar", "Enter Last NAme");
            Utils.callSendkeys(driver, ActionXpath.Phone, "090989898888", "enter the Phone");
            Utils.callSendkeys(driver, ActionXpath.Email, "akash21@gamil.com", "Enter the Emial");
            Utils.callSendkeys(driver, ActionXpath.Age, "56", "Selct age");
            Utils.callSendkeys(driver, ActionXpath.occupation, "Manager", "Select the manager");
            Utils.callSendkeys(driver, ActionXpath.annualIncome, "400000", "Selct the Annual income");
            Utils.clickXpath(driver, ActionXpath.ClickNext, time, "click on Next");
            log.info("  TC-3: Fill the FamilyInfo test case PASSED \n");

}catch (Exception e) {
    log.warning("TC-3: Fill the FamilyInfo test case FAILED \n");
}
    }
    @Test(priority = 5)
    public static void EmploymentInfo(String url,WebDriver driver, String Email){
        try{
            System.out.println("TC:5: Starting EmploymentInfo Test Executation ");
            Utils.clickXpath(driver, ActionXpath.ClickNext, time, "click on Next");
            log.info("  TC-5: Fill the EmploymentInfo test case PASSED \n");


        
        }catch (Exception e) {
            log.warning("TC-5: Fill the EmploymentInfo test case FAILED \n");
        }
    }

}


