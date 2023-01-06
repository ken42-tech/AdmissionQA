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

public class esscisamsung {
    public static Logger log = Logger.getLogger("App_portal");
    static int time = 2000;
    public static WebDriver driver;

    public static void login(String url, WebDriver driver, String[] csvCell, Logger log) throws Exception {
        try {

            String email = csvCell[2];
            String password = csvCell[3];

            driver.navigate().refresh();
            Thread.sleep(3000);
            // ((JavascriptExecutor) driver).executeScript("window.open()");
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

            // String male = csvCell[35];
            String dateofbirth = csvCell[14];
            String highquali = csvCell[15];
            String training = csvCell[19];
            String aadhar = csvCell[20];
            String email = csvCell[21];
            Utils.smallSleepBetweenClicks(1);

            // Actions act1 = new Actions(driver);
            // WebElement ele1 = driver.findElement(By.xpath("//input[@value='Female']"));

            // String ee = ele1.getText();
            // System.out.println(ee);

            // act1.moveToElement(ele1).click().build().perform();

            // driver.findElement(By.xpath("//input[@value='Other']")).click();
            // Thread.sleep(2000);

            // Utils.cleartext(driver, ActionXpath.enterdateofbirth);
            // Utils.callSendkeys(driver, ActionXpath.enterdateofbirth, dateofbirth,
            // "Setdate of birth");
            // Thread.sleep(2000);
            // Utils.cleartext(driver, ActionXpath.enterhighquali);
            // Utils.callSendkeys(driver, ActionXpath.enterhighquali, highquali, "enter
            // highqualification");

            Utils.clickXpath(driver, ActionXpath.selecttrain, time, "open Training");
            Utils.clickXpath(driver, ActionXpath.selecttrainning, time, "select Training");

            Utils.clickXpath(driver, ActionXpath.selectnext, time, "click on Next");
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
            String firstName = csvCell[16];
            String lastName = csvCell[17];
            String Realtionship = csvCell[18];
            String validation = csvCell[6];

            Utils.clickXpath(driver, ActionXpath.selectreal, time, "open realtionship");
            Utils.selectFromDropDown(ActionXpath.selectdropdown, Realtionship, driver);

            if (validation.equals("TRUE")) {
                validate.testForCharLength(driver, ActionXpath.selectfirstname, ActionXpath.firsterror, log, 41);
                Utils.cleartext(driver, ActionXpath.selectfirstname);
                validate.specialcharacter(driver, ActionXpath.selectfirstname, ActionXpath.firsterror, log);
                validate.testForMandatoryField(driver, ActionXpath.selectfirstname, ActionXpath.firsterror, log);
            }
            Utils.callSendkeys(driver, ActionXpath.selectfirstname, firstName, "enter firstname");

            if (validation.equals("TRUE")) {
                validate.testForCharLength(driver, ActionXpath.selectlastname, ActionXpath.Lnameerror, log, 41);
                Utils.cleartext(driver, ActionXpath.selectlastname);
                validate.specialcharacter(driver, ActionXpath.selectlastname, ActionXpath.Lnameerror, log);
                validate.testForMandatoryField(driver, ActionXpath.selectlastname, ActionXpath.Lnameerror, log);
            }
            Utils.callSendkeys(driver, ActionXpath.selectlastname, lastName, "enter last name");

            Utils.clickXpath(driver, ActionXpath.selectnext, time, "click on Next");
            Utils.smallSleepBetweenClicks(1);

            log.info("TC-1: Populating Family info PASSED");
        } catch (Exception e) {
            Utils.printException(e);
            log.warning("TC-1: Populating Family info FAILED");
            throw (e);
        }
    }

    public static void addressInfo(String url, WebDriver driver, String[] csvCell, Logger log) throws Exception {
        try {
            String country = csvCell[22];
            String state = csvCell[20];
            String city = csvCell[21];
            String address = csvCell[24];
            String pincode = csvCell[23];

            Utils.clickXpath(driver, ActionXpath.selectcountryess, time, "open countryess");
            Utils.selectFromDropDown(ActionXpath.selectdropdown, country, driver);

            Utils.clickXpath(driver, ActionXpath.selectstateess, time, "open sstate");
            Utils.selectFromDropDown(ActionXpath.selectdropdown, state, driver);

            Utils.clickXpath(driver, ActionXpath.selectcityess, time, "open city");
            Utils.selectFromDropDown(ActionXpath.selectdropdown, city, driver);

            Utils.callSendkeys(driver, ActionXpath.selectaddress, address, "enter address");
            Utils.callSendkeys(driver, ActionXpath.selectpincode, pincode, "enter pincode");

            Utils.clickXpath(driver, ActionXpath.selectnext, time, "click on Next");
            Utils.smallSleepBetweenClicks(1);

            log.info("TC-1: Populating address info PASSED");
        } catch (Exception e) {
            Utils.printException(e);
            log.warning("TC-1: Populating address info FAILED");
            throw (e);
        }
    }

    public static void educationInfo(String url, WebDriver driver, String[] csvCell, Logger log) throws Exception {
        try {
            String highschool = csvCell[25];
            String graduated = csvCell[25];
            String univerenroll = csvCell[25];
            String finalgpa = csvCell[27];
            String universityname = csvCell[28];
            String major = csvCell[29];
            String cumulative = csvCell[31];
            String currentuniver = csvCell[30];
            String voccgp = csvCell[51];
            String Programe = csvCell[13];
            Utils.smallSleepBetweenClicks(2);
            Utils.callSendkeys(driver, ActionXpath.enterhighschool, highschool, "enter highschool");

            Utils.clickXpath(driver, ActionXpath.selectgraud, time, "open graud");
            // Utils.selectFromDropDown(ActionXpath.selectdropdown, graduated, driver);
            Utils.clickXpath(driver, ActionXpath.selecgr, time, "select graud");

            Utils.callSendkeys(driver, ActionXpath.enterfinalgpa, finalgpa, "enter finalgpa");

            Utils.clickXpath(driver, ActionXpath.selectenroll, time, "open enroll");
            Utils.clickXpath(driver, ActionXpath.selecrole, time, "select enroll");

            Utils.callSendkeys(driver, ActionXpath.enteruniversity, universityname, "enteruniversity");

            Utils.callSendkeys(driver, ActionXpath.entermajor, major, "enter major");

            Utils.clickXpath(driver, ActionXpath.currentuniversity, time, "open current university");
            Utils.selectFromDropDown(ActionXpath.selectdropdown, currentuniver, driver);

            Utils.callSendkeys(driver, ActionXpath.cumulativegpa, cumulative, "enter cumulativegpa");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,400)");
            // Utils.bigSleepBetweenClicks(1);
            // String Programe = csvCell[13];
            if (csvCell[13].equals("C and P")) {

                String prof = csvCell[52];
                String compskills = csvCell[53];
                Utils.smallSleepBetweenClicks(1);
                Utils.clickXpath(driver, ActionXpath.vocation, time, "open vocation");
                Utils.clickXpath(driver, ActionXpath.vocationselect, time, "click vocationselect");

                Utils.callSendkeys(driver, ActionXpath.vocationselectcgp, voccgp, "enter vocationselectcgp");
                Utils.clickXpath(driver, ActionXpath.selectnext, time, "click on Next");

                Utils.smallSleepBetweenClicks(2);

                Utils.clickXpath(driver, ActionXpath.proficimath, time, "open proficimath");
                Utils.selectFromDropDown(ActionXpath.selectdropdown, prof, driver);

                Utils.clickXpath(driver, ActionXpath.comforbasic, time, "open comforbasic");
                Utils.selectFromDropDown(ActionXpath.selectdropdown, compskills, driver);

                Utils.clickXpath(driver, ActionXpath.selectnext, time, "click on Next");

            }

            Utils.clickXpath(driver, ActionXpath.selectnext, time, "click on Next");
            Utils.smallSleepBetweenClicks(1);

            log.info("TC-1: Populating education info PASSED");
        } catch (Exception e) {
            Utils.printException(e);
            log.warning("TC-1: Populating education info FAILED");
            throw (e);
        }
    }

    public static void courseInfo(String url, WebDriver driver, String[] csvCell, Logger log) throws Exception {
        try {
            String Programe = csvCell[13];
            if (csvCell[13].equals("C and P")) {

                System.out.println("no course info");
            }

            else {
                String nameofcourse = csvCell[32];
                String nameofinstuation = csvCell[33];

                String plnameofcourse = csvCell[34];
                String plnameofinst = csvCell[35];
                // String Programe = csvCell[13];
                Utils.smallSleepBetweenClicks(2);
                Utils.clickXpath(driver, ActionXpath.coursecomp, time, "open course");

                Utils.clickXpath(driver, ActionXpath.selectcoyrse, time, "click on yes");

                Utils.callSendkeys(driver, ActionXpath.nameofcour, nameofcourse, "enter nameofcourse");

                Utils.callSendkeys(driver, ActionXpath.nameofinst, nameofinstuation, "enter nameofinst");

                Utils.clickXpath(driver, ActionXpath.planguage, time, "open plang");

                Utils.clickXpath(driver, ActionXpath.plcoyrse, time, "click on yes");

                Utils.callSendkeys(driver, ActionXpath.plcour, plnameofcourse, "enter pl nameofcourse");

                Utils.callSendkeys(driver, ActionXpath.plinst, plnameofinst, "enter pl nameofinst");

                if (csvCell[13].equals("Big Data")) {

                    Utils.clickXpath(driver, ActionXpath.clickdatabase, time, "open and clickdatabase");

                    Utils.clickXpath(driver, ActionXpath.selectdata, time, "click on no");

                    Utils.clickXpath(driver, ActionXpath.selectnext, time, "click on Next");

                }

                Utils.clickXpath(driver, ActionXpath.selectnext, time, "click on Next");

                Utils.smallSleepBetweenClicks(1);
            }
            log.info("TC-1: Populating course info PASSED");
        } catch (Exception e) {
            Utils.printException(e);
            log.warning("TC-1: Populating course info FAILED");
            throw (e);
        }
    }

    public static void priorInfo(String url, WebDriver driver, String[] csvCell, Logger log) throws Exception {
        try {

            String Programe = csvCell[13];
            if (csvCell[13].equals("C and P")) {

                System.out.println("no course info");
            }

            else {

                String pleaseexp = csvCell[36];
                String mat = csvCell[50];
                Utils.clickXpath(driver, ActionXpath.pythonpl, time, "open current pythonpl");

                Utils.clickXpath(driver, ActionXpath.selectexp, time, "select exp");

                Utils.clickXpath(driver, ActionXpath.havesomeexp, time, "open havesomeexp");

                Utils.clickXpath(driver, ActionXpath.selectsomeexp, time, "select some exp");

                if (csvCell[13].equals("Artificial Intelligence")) {

                    Utils.clickXpath(driver, ActionXpath.havemath, time, "open maths");

                    Utils.selectFromDropDown(ActionXpath.selectdropdown, mat, driver);

                    Utils.clickXpath(driver, ActionXpath.selectnext, time, "click on Next");
                }
                Utils.callSendkeys(driver, ActionXpath.expofpl, pleaseexp, "enter experience ofpl");

                Utils.clickXpath(driver, ActionXpath.selectnext, time, "click on Next");

                Utils.smallSleepBetweenClicks(1);
                log.info("TC-1: Populating prior info PASSED");
            }

        } catch (Exception e) {
            Utils.printException(e);
            log.warning("TC-1: Populating prior info FAILED");
            throw (e);
        }
    }

    public static void carrergoalsInfo(String url, WebDriver driver, String[] csvCell, Logger log) throws Exception {
        try {

            String carrergole = csvCell[37];
            String achieve = csvCell[38];

            String findoutsic = csvCell[39];
            Utils.smallSleepBetweenClicks(1);
            Utils.smallSleepBetweenClicks(1);
            Utils.callSendkeys(driver, ActionXpath.careergoal, carrergole, "enter carrergole");

            Utils.callSendkeys(driver, ActionXpath.achievethrosic, achieve, "enter achieve through sic");

            Utils.callSendkeys(driver, ActionXpath.findoutsic, findoutsic, "enter findout sic");

            Utils.clickXpath(driver, ActionXpath.selectnext, time, "click on Next");
            Utils.smallSleepBetweenClicks(1);
            log.info("TC-1: Populating carrer goals info PASSED");
        } catch (Exception e) {
            Utils.printException(e);
            log.warning("TC-1: Populating carrer goals info FAILED");
            throw (e);
        }
    }

    public static void workexperienceInfo(String url, WebDriver driver, String[] csvCell, Logger log) throws Exception {
        try {

            String organization = csvCell[40];
            String position = csvCell[41];

            String duration = csvCell[42];

            String role = csvCell[43];
            Utils.smallSleepBetweenClicks(1);
            Utils.callSendkeys(driver, ActionXpath.org, organization, "enter organization");

            Utils.callSendkeys(driver, ActionXpath.positi, position, "enter position");

            Utils.callSendkeys(driver, ActionXpath.dur, duration, "enter duration");

            Utils.callSendkeys(driver, ActionXpath.roledes, role, "enter role");

            Utils.clickXpath(driver, ActionXpath.selectnext, time, "click on Next");
            Utils.smallSleepBetweenClicks(1);
            log.info("TC-1: Populating work experience info PASSED");
        } catch (Exception e) {
            Utils.printException(e);
            log.warning("TC-1: Populating work experience info FAILED");
            throw (e);
        }
    }

    public static void certificationandotherInfo(String url, WebDriver driver, String[] csvCell, Logger log)
            throws Exception {
        try {

            String certification = csvCell[44];
            String organization = csvCell[45];

            String dob = csvCell[46];

            String desc = csvCell[47];

            String applysic = csvCell[48];

            String paasive = csvCell[49];
            Utils.smallSleepBetweenClicks(1);
            Utils.callSendkeys(driver, ActionXpath.certif, certification, "enter certification");

            Utils.callSendkeys(driver, ActionXpath.orgcert, organization, "enter organization");

            Utils.callSendkeys(driver, ActionXpath.date, dob, "enter dob");

            Utils.callSendkeys(driver, ActionXpath.certdes, desc, "enter desc");

            Utils.clickXpath(driver, ActionXpath.selectnext, time, "click on Next");

            Utils.bigSleepBetweenClicks(1);
            Utils.callSendkeys(driver, ActionXpath.essaysic, applysic, "enter applysic");

            Utils.callSendkeys(driver, ActionXpath.essaydesc, paasive, "enter paasive");

            Utils.clickXpath(driver, ActionXpath.selectnext, time, "click on Next");

            Utils.smallSleepBetweenClicks(1);
            Utils.clickXpath(driver, ActionXpath.unpriv, time, "click on unpriv");

            Utils.clickXpath(driver, ActionXpath.selectunpriv, time, "click on selectunpriv");

            Utils.clickXpath(driver, ActionXpath.selectnext, time, "click on Next");

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,2000)");

            Utils.clickXpath(driver, ActionXpath.selectnext, time, "click on Next");
            Utils.bigSleepBetweenClicks(1);
            driver.findElement(By.xpath("(//input[@type='file'])[1]"))
                    .sendKeys("C:\\Users\\Public\\Documents\\Screenshot (3).png");

            Utils.bigSleepBetweenClicks(1);

            driver.findElement(By.xpath("(//input[@type='file'])[4]"))
                    .sendKeys("C:\\Users\\Public\\Documents\\demo.pdf");
            Utils.bigSleepBetweenClicks(1);
            driver.findElement(By.xpath("(//input[@type='file'])[5]"))
                    .sendKeys("C:\\Users\\Public\\Documents\\demo.pdf");
            Utils.bigSleepBetweenClicks(1);
            Utils.clickXpath(driver, ActionXpath.submitesci, time, "click on submitesci");

            Utils.clickXpath(driver, ActionXpath.returnhomeessci, time, "click on returnhomeessci");

            Utils.smallSleepBetweenClicks(1);
            log.info("TC-1: Populating certification info PASSED");
        } catch (Exception e) {
            Utils.printException(e);
            log.warning("TC-1: Populating certification goals info FAILED");
            throw (e);
        }
    }

    @Test(priority = 1)
    public static void Admissionfillform(String url, WebDriver driver, String[] csvCell, Logger log) throws Exception {

        try {
            System.out.println("TC-1: Fill form with validation test started Executation ");
            String Sfurl = csvCell[9];
            String surl = csvCell[0];
            // esscisamsung.SalesforceBackendDELETE(driver, log, csvCell, Sfurl);
            // driver.get(surl);
            login(url, driver, csvCell, log);
            ApplyforCourse(surl, driver, csvCell, log);
            BasicDetails(surl, driver, csvCell, log);
            FamilyInfo(surl, driver, csvCell, log);
            addressInfo(surl, driver, csvCell, log);
            educationInfo(surl, driver, csvCell, log);
            courseInfo(surl, driver, csvCell, log);

            priorInfo(surl, driver, csvCell, log);

            carrergoalsInfo(surl, driver, csvCell, log);

            workexperienceInfo(surl, driver, csvCell, log);

            certificationandotherInfo(surl, driver, csvCell, log);

            log.info("TC-1: Fill form with validation test Completed and Passed ");

        } catch (Exception e) {
            log.warning("TC-1: Fill form with validation test Failed");
            Utils.printException(e);
            throw (e);

        }
    }

    @Test(priority = 2)

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
            Utils.smallSleepBetweenClicks(1);
            Utils.callSendkeys(driver, ActionXpath.SalesforceEmail, SfEmail, "enter salesforce email");
            Utils.callSendkeys(driver, ActionXpath.SalesforcePassword, SfPassword, "Enter your password");
            Utils.clickXpath(driver, ActionXpath.loginSalesforce, time, "click on login salesforce");
            Utils.bigSleepBetweenClicks(1);
            Utils.clickXpath(driver, ActionXpath.applauncher, time, "click on applauncher");
            Utils.callSendkeys(driver, ActionXpath.search, "Contacts", "click on contacts ");
            Utils.clickXpath(driver, ActionXpath.contacts, time, "click on clickcontacts");
            Utils.cleartext(driver, ActionXpath.listsearch);
            Thread.sleep(2000);
            Utils.callSendkeys(driver, ActionXpath.listsearch, studentemail, "Search for student name");
            Utils.clickXpath(driver, ActionXpath.listsearch, time, "listsearch");
            Utils.bigSleepBetweenClicks(1);
            Actions qq = new Actions(driver);
            // qq.moveByOffset(40, 40).click().perform();
            WebDriverWait wait21 = new WebDriverWait(driver, 20);
            WebElement elem21 = wait21.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("(//*[text()='" + studentname + "'])[1]")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem21);
            Utils.smallSleepBetweenClicks(1);

            Actions act1 = new Actions(driver);
            WebElement ele1 = driver.findElement(By.xpath("(//span[text()='View All'])[1]"));
            act1.moveToElement(ele1).click().build().perform();

            // WebDriverWait wait211 = new WebDriverWait(driver, 20);
            // WebElement elem211 = wait211.until(ExpectedConditions.elementToBeClickable(
            // By.xpath("(//span[text()='View All'])[1]")));
            // ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
            // elem211);

            // Utils.clickXpath(driver, ActionXpath.vie, time, "click on view all");

            // Utils.bigSleepBetweenClicks(1);

            Thread.sleep(4000);
            Actions aa = new Actions(driver);
            WebElement ee = driver.findElement(By.xpath(
                    "//*[@id='brandBand_2']/div/div/div[3]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr/td[3]/span/div/a"));
            aa.moveToElement(ee).click().build().perform();

            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement we1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Delete']")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", we1);

            ///// a[@title='Delete']

            Thread.sleep(5000);
            WebElement le = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='Delete']")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", le);

            Thread.sleep(5000);

            // driver.switchTo().window(tab.get(0));

            log.info("  TC-2:  the Salesforce backend  delete test case PASSED \n");

        }

        catch (Exception e) {
            log.warning("TC-2: the Salesforce backend  delete test case FAILED \n");
            Utils.printException(e);
            throw (e);
        }

    }
}
