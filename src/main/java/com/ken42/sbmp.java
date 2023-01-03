package com.ken42;

import org.apache.commons.lang3.Validate;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

            driver.navigate().refresh();
            Thread.sleep(3000);
            // ((JavascriptExecutor) driver).executeScript("window.open()");
            ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tab.get(0));
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
            String middlename = csvCell[92];
            String childfname = csvCell[158];
            String childlname = csvCell[159];
            String aadharnumber = csvCell[161];
            // String cdob = csvCell[120];
            String placeofbirth = csvCell[172];
            String mothertong = csvCell[173];
            String nosib = csvCell[174];

            String satsno = csvCell[175];
            String pickuppoint = csvCell[177];
            String caste = csvCell[181];
            String subcaste = csvCell[181];
            String religion = csvCell[178];
            String category = csvCell[179];
            String bloodgroup = csvCell[176];
            Utils.bigSleepBetweenClicks(1);

            if (validation.equals("TRUE")) {
                Utils.cleartext(driver, ActionXpath.childfirstName);
                validate.testForCharLength(driver, ActionXpath.childfirstName, ActionXpath.fnameerror, log, 13);
                Utils.cleartext(driver, ActionXpath.childfirstName);
                validate.specialcharacter(driver, ActionXpath.childfirstName, ActionXpath.fnameerror, log);
                Utils.cleartext(driver, ActionXpath.childfirstName);

            }

            Utils.cleartext(driver, ActionXpath.childfirstName);
            Utils.callSendkeys(driver, ActionXpath.childfirstName, childfname, "enter childfirstName");
            // Utils.scrollUpOrDown(driver, time);

            if (validation.equals("TRUE")) {
                Utils.cleartext(driver, ActionXpath.childMiddleName);
                validate.testForCharLength(driver, ActionXpath.childMiddleName, ActionXpath.mnameerror, log, 13);
                Utils.cleartext(driver, ActionXpath.childMiddleName);
                validate.specialcharacter(driver, ActionXpath.childMiddleName, ActionXpath.mnameerror, log);
                Utils.cleartext(driver, ActionXpath.childMiddleName);

            }
            Utils.cleartext(driver, ActionXpath.childMiddleName);

            Utils.callSendkeys(driver, ActionXpath.childMiddleName, middlename, "enter childMiddleName");

            if (validation.equals("TRUE")) {
                Utils.cleartext(driver, ActionXpath.childlastName);
                validate.testForCharLength(driver, ActionXpath.childlastName, ActionXpath.lnameerror, log, 13);
                Utils.cleartext(driver, ActionXpath.childlastName);
                validate.specialcharacter(driver, ActionXpath.childlastName, ActionXpath.lnameerror, log);
                Utils.cleartext(driver, ActionXpath.childlastName);

            }

            Utils.cleartext(driver, ActionXpath.childlastName);
            Utils.callSendkeys(driver, ActionXpath.childlastName, childlname, "enter childlastName");

            Utils.scrollUpOrDown(driver, time);
            Utils.cleartext(driver, ActionXpath.placeofbirth);
            Utils.callSendkeys(driver, ActionXpath.placeofbirth, placeofbirth, "enter placeofbirth");

            Utils.cleartext(driver, ActionXpath.mothertongue);
            Utils.callSendkeys(driver, ActionXpath.mothertongue, mothertong, "enter mothertongue");

            if (validation.equals("TRUE")) {
                Utils.cleartext(driver, ActionXpath.numberOfSiblingsInSchool);
                validate.testForCharLength(driver, ActionXpath.numberOfSiblingsInSchool, ActionXpath.passporterror, log,
                        13);
                Utils.cleartext(driver, ActionXpath.numberOfSiblingsInSchool);
                validate.specialcharacter(driver, ActionXpath.numberOfSiblingsInSchool, ActionXpath.passporterror, log);
                Utils.cleartext(driver, ActionXpath.numberOfSiblingsInSchool);

            }

            Utils.scrollUpOrDown(driver, time);
            Utils.cleartext(driver, ActionXpath.numberOfSiblingsInSchool);
            Utils.callSendkeys(driver, ActionXpath.numberOfSiblingsInSchool, nosib, "numberOfSiblingsInSchool");

            if (validation.equals("TRUE")) {
                Utils.cleartext(driver, ActionXpath.childaadharNumber);
                validate.testForCharLength(driver, ActionXpath.childaadharNumber, ActionXpath.passporterror, log, 13);
                Utils.cleartext(driver, ActionXpath.childaadharNumber);
                validate.specialcharacter(driver, ActionXpath.childaadharNumber, ActionXpath.passporterror, log);
                Utils.cleartext(driver, ActionXpath.childaadharNumber);

            }

            Utils.scrollUpOrDown(driver, time);
            Utils.cleartext(driver, ActionXpath.childaadharNumber);

            Utils.callSendkeys(driver, ActionXpath.childaadharNumber, aadharnumber, "enter childaadharNumber");

            Utils.scrollUpOrDown(driver, time);
            Utils.cleartext(driver, ActionXpath.satsNumber);

            Utils.callSendkeys(driver, ActionXpath.satsNumber, satsno, "enter satsNumber");

            Utils.clickXpath(driver, ActionXpath.clickonbloodgroup, time, "clickonbloodgroup");
            Utils.selectFromDropDown(ActionXpath.selectxpath, bloodgroup, driver);

            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.clickonTransport, time, " clickonTransport");
            Utils.clickXpath(driver, ActionXpath.selecttransport, time, " selecttransport");
            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.clickonTrip, time, " clickonTrip");
            Utils.clickXpath(driver, ActionXpath.selecttrip, time, " selecttrip");

            Utils.cleartext(driver, ActionXpath.pickuppoint);

            Utils.callSendkeys(driver, ActionXpath.pickuppoint, pickuppoint, "enter pickuppoint");

            Utils.clickXpath(driver, ActionXpath.clickonnationality, time, " clickonnationality");
            Utils.clickXpath(driver, ActionXpath.selectnationality1, time, " selectnationality1");

            Utils.clickXpath(driver, ActionXpath.clickonreligion, time, "clickonreligion");
            Utils.selectFromDropDown(ActionXpath.selectxpath, religion, driver);

            Utils.clickXpath(driver, ActionXpath.clickoncategory, time, "clickoncategory");
            Utils.selectFromDropDown(ActionXpath.selectxpath, category, driver);

            Utils.scrollUpOrDown(driver, time);

            Utils.cleartext(driver, ActionXpath.childcaste);

            Utils.callSendkeys(driver, ActionXpath.childcaste, caste, "enter childcaste");

            Utils.cleartext(driver, ActionXpath.childsubcaste);

            Utils.callSendkeys(driver, ActionXpath.childsubcaste, subcaste, "enter childsubcaste");

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
            String parentfirstName = csvCell[162];
            String parentmiddleName = csvCell[163];
            String parentlastName = csvCell[164];
            String parentphone = csvCell[165];
            String email = csvCell[166];
            String aadharnumber = csvCell[161];

            String annualIncome = csvCell[167];
            String validation = csvCell[6];
            Utils.smallSleepBetweenClicks(1);
            Utils.clickXpath(driver, ActionXpath.parentclickonrelationship, time, "parentclickonrelationship");

            Utils.clickXpath(driver, ActionXpath.parentsselectrelationship, time, "parentsselectrelationship");
            // Utils.smallSleepBetweenClicks(1);
            if (validation.equals("TRUE")) {
                validate.testForCharLength(driver, ActionXpath.parentfirstName, ActionXpath.fnameerror, log, 41);
                Utils.cleartext(driver, ActionXpath.parentfirstName);
                validate.specialcharacter(driver, ActionXpath.parentfirstName, ActionXpath.fnameerror, log);
                validate.testForMandatoryField(driver, ActionXpath.parentfirstName, ActionXpath.fnameerror, log);

            }
            Utils.cleartext(driver, ActionXpath.parentfirstName);
            Utils.callSendkeys(driver, ActionXpath.parentfirstName, parentfirstName, "Enter Fist name");
            // Utils.scrollUpOrDown(driver, time);
            Utils.cleartext(driver, ActionXpath.Parentmiddlename);
            Utils.callSendkeys(driver, ActionXpath.Parentmiddlename, parentmiddleName, "Enter Parentmiddlename");
            // Utils.scrollUpOrDown(driver, time);

            if (validation.equals("TRUE")) {
                validate.testForCharLength(driver, ActionXpath.parentlastName, ActionXpath.lnameerror, log, 41);
                Utils.cleartext(driver, ActionXpath.parentlastName);
                validate.specialcharacter(driver, ActionXpath.parentlastName, ActionXpath.lnameerror, log);
                validate.testForMandatoryField(driver, ActionXpath.parentlastName, ActionXpath.lnameerror, log);
            }
            Utils.callSendkeys(driver, ActionXpath.parentlastName, parentlastName, "Enter Last NAme");
            // Utils.scrollUpOrDown(driver, time);
            Utils.callSendkeys(driver, ActionXpath.familyphone, parentphone, "enter the parentphone");
            Thread.sleep(2000);
            if (validation.equals("TRUE")) {
                validate.email(driver, ActionXpath.familyemail, ActionXpath.emailerror, log);
            }
            email = Utils.genrateRandomEmailid();
            Utils.cleartext(driver, ActionXpath.familyemail);
            Utils.callSendkeys(driver, ActionXpath.familyemail, email, "Enter the Email");

            Utils.callSendkeys(driver, ActionXpath.familyaadhara, aadharnumber, "familyaadhara");
            // Utils.scrollUpOrDown(driver, time);

            Utils.scrollUpOrDown(driver, time);
            Utils.clickXpath(driver, ActionXpath.clickonQualification, time, "clickonQualification");
            Utils.clickXpath(driver, ActionXpath.Selecteducation, time, "Selecteducation");

            Utils.clickXpath(driver, ActionXpath.clickonoccuption, time, "clickonoccuption");
            Utils.clickXpath(driver, ActionXpath.Selectoccuption, time, "Selectoccuption");
            // Utils.scrollUpOrDown(driver, time);
            if (validation.equals("TRUE")) {
                validate.testForNumberLength(driver, ActionXpath.familyannualincome, ActionXpath.incomeerror, log, 16);
                Utils.cleartext(driver, ActionXpath.familyannualincome);
                validate.specialcharacter(driver, ActionXpath.familyannualincome, ActionXpath.incomeerror, log);
                Utils.cleartext(driver, ActionXpath.familyannualincome);
            }
            Utils.callSendkeys(driver, ActionXpath.familyannualincome, annualIncome, "Selct the Annual income");

            Utils.clickXpath(driver, ActionXpath.ClickNext, time, "click on Next");
            // Utils.smallSleepBetweenClicks(1);
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
            String coursecountry = csvCell[168];
            String coursestate = csvCell[169];
            String coursecity = csvCell[170];
            String perpincode = csvCell[171];

            Utils.clickXpath(driver, ActionXpath.clickoncoursecountry, time, " clickoncoursecountry");
            Utils.selectFromDropDown(ActionXpath.selectxpath, coursecountry, driver);

            Utils.clickXpath(driver, ActionXpath.clickoncoursestate, time, " clickoncoursestate");
            Utils.selectFromDropDown(ActionXpath.selectxpath, coursestate, driver);

            Utils.clickXpath(driver, ActionXpath.clickoncoursecity, time, " clickoncoursecity");
            Utils.selectFromDropDown(ActionXpath.selectxpath, coursecity, driver);

            Utils.scrollUpOrDown(driver, time);
            Utils.cleartext(driver, ActionXpath.coursepincode);
            Utils.callSendkeys(driver, ActionXpath.coursepincode, perpincode, "Enter coursepincode");

            Utils.scrollUpOrDown(driver, time);

            Utils.clickXpath(driver, ActionXpath.clickoncourseaddress, time, " clickoncourseaddress");
            Utils.clickXpath(driver, ActionXpath.selectcourseaddress, time, "selectcourseaddress");

            Utils.clickXpath(driver, ActionXpath.ClickNext, time, "click on Next");
            Utils.smallSleepBetweenClicks(1);
            log.info("TC-1:Sbmp Populating address info PASSED");
        } catch (Exception e) {
            Utils.printException(e);
            log.warning("TC-1: Sbmp Populating address info FAILED");
            throw (e);
        }
    }

    public static void sbmp_Education_details(String url, WebDriver driver, String[] csvCell, Logger log)
            throws Exception {
        try {
            String classcurrently = csvCell[182];
            String school = csvCell[183];
            String mediuminst = csvCell[184];
            String flang = csvCell[185];
            String slang = csvCell[186];
            String tlang = csvCell[187];
            Utils.clickXpath(driver, ActionXpath.clickoneducationclass, time, "clickonclass");
            Utils.selectFromDropDown(ActionXpath.selectxpath, classcurrently, driver);

            Utils.cleartext(driver, ActionXpath.eduschool);
            Utils.callSendkeys(driver, ActionXpath.eduschool, school, "eduschool");
            // Utils.scrollUpOrDown(driver, time);

            Utils.cleartext(driver, ActionXpath.clickonmedium);
            Utils.clickXpath(driver, ActionXpath.clickonmedium, time, "click on medium");
            Utils.selectFromDropDown(ActionXpath.selectxpath, mediuminst, driver);
            // Utils.scrollUpOrDown(driver, time);

            Utils.cleartext(driver, ActionXpath.clickonflanguage);
            Utils.clickXpath(driver, ActionXpath.clickonflanguage, time, "clickonflanguage");
            Utils.selectFromDropDown(ActionXpath.selectxpath, flang, driver);
            // Utils.scrollUpOrDown(driver, time);

            Utils.cleartext(driver, ActionXpath.clickonslanguage);
            Utils.clickXpath(driver, ActionXpath.clickonslanguage, time, "clickonslanguage");
            Utils.selectFromDropDown(ActionXpath.selectxpath, slang, driver);
            // Utils.scrollUpOrDown(driver, time);

            Utils.cleartext(driver, ActionXpath.clickonsTlanguage);
            Utils.clickXpath(driver, ActionXpath.clickonsTlanguage, time, "clickonsTlanguage");
            Utils.selectFromDropDown(ActionXpath.selectxpath, tlang, driver);
            // Utils.scrollUpOrDown(driver, time);
            Thread.sleep(4000);
            Utils.clickXpath(driver, ActionXpath.ClickNext, time, "click on Next");
            Thread.sleep(4000);

            log.info("TC-1: Sbmp Populating address info Passed");
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

            // Thread.sleep(4000);
            Utils.clickXpath(driver, ActionXpath.ClickNext, time, "click on Next");

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,2000)");
            Thread.sleep(4000);
            Utils.clickXpath(driver, ActionXpath.ClickNext, time, "click on Next");
            Thread.sleep(4000);
            Utils.clickXpath(driver, ActionXpath.clickonsubmit, time, "clickonsubmit");
            Thread.sleep(4000);
            log.info("TC-1: Populating Others section PASSED");
        } catch (Exception e) {
            Utils.printException(e);
            log.warning("TC-1: Populating Others section FAILED");
            throw (e);
        }
    }

    @Test(priority = 1)
    public static void Admissionfillform(String surl, WebDriver driver, String[] csvCell, Logger log) throws Exception {

        try {
            System.out.println("TC-1: Fill form with validation test started Executation ");
            String Sfurl = csvCell[9];
            String url = csvCell[0];
            // Thread.sleep(15000);

            sbmp.SalesforceBackendDELETE(driver, log, csvCell, Sfurl);
            driver.get(url);
            login(surl, driver, csvCell, log);
            sbmpApplyforCourse(Sfurl, driver, csvCell, log);
            sbmpBasicDetails(surl, driver, csvCell, log);
            sbmpFamilyInfo(Sfurl, driver, csvCell, log);
            sbmp_permanentaddress_Info(Sfurl, driver, csvCell, log);
            sbmp_Education_details(Sfurl, driver, csvCell, log);
            sbmp_document_upload(Sfurl, driver, csvCell, log);

            log.info("TC-1: Sbmp Fill form with validation test Completed and Passed ");

        } catch (Exception e) {
            log.warning("TC-1: Sbmp Fill form with validation test Failed");
            Utils.printException(e);
            throw (e);

        }
    }

    @Test(priority = 2)

    public static void SalesforceBackendDELETE(WebDriver driver, Logger log, String[] csvCell, String Tname)
            throws Exception {

        try {
            System.out.println("TC-2: Salesforce backend Verification along with delete  Test Executation ");

            // ((JavascriptExecutor) driver).executeScript("window.open()");
            ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
            if (!Tname.equals("T1")) {
                // driver.switchTo().window(tab.get(1));
            }
            String Sfurl = csvCell[9];
            driver.get(Sfurl);
            String SfEmail = csvCell[10];
            String SfPassword = csvCell[11];
            // String studentname = csvCell[12];
            String count = null;
            String row = null;
            System.out.println(SfEmail);
            Thread.sleep(2000);
            Utils.callSendkeys(driver, ActionXpath.SalesforceEmail, SfEmail, "enter salesforce email");
            Utils.callSendkeys(driver, ActionXpath.SalesforcePassword, SfPassword, "Enter your password");
            Utils.clickXpath(driver, ActionXpath.loginSalesforce, time, "click on login salesforce");
            Utils.bigSleepBetweenClicks(1);

            Utils.clickXpath(driver, ActionXpath.clickondots, time, "click on clickondots");

            Utils.clickXpath(driver, ActionXpath.sbmpdot, time, "click on sbmpdot");

            Thread.sleep(3000);
            WebDriverWait wait = new WebDriverWait(driver, 20);
            WebElement e = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Applications']")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", e);

            System.out.println("click on Application");
            Thread.sleep(5000);

            // String view = "(//span[text()='View All'])[1]";
            // Boolean isPresent2 = driver.findElements(By.xpath(view)).size() > 0;
            //
            // if (isPresent2) {

            count = Utils.getTEXT(driver, ActionXpath.deletecount1);
            Pattern pt = Pattern.compile("-?\\d+");
            java.util.regex.Matcher m = pt.matcher(count);
            while (m.find()) {
                row = m.group();
            }
            int count1 = Integer.parseInt(row);

            System.out.println(count1);

            for (int i = 0; i < count1; i++) {

                String apply = csvCell[12];
                Thread.sleep(5000);
                String xp1 = "(//*[. and contains(text(),'" + apply
                        + "')]/.././../..//*[@class='slds-cell-edit cellContainer'])[12]";
                // String xp2 = "(//*[text()='" + apply +
                // "']/.././../..//*[@class='slds-cell-edit cellContainer'])[12]";

                Boolean isPresent = driver.findElements(By.xpath(xp1)).size() > 0;
                if (isPresent) {
                    WebElement el = driver.findElement(By.xpath(xp1));
                    System.out.println("XP is there click it     " + el);
                    el.click();
                    Utils.smallSleepBetweenClicks(1);
                    Utils.clickXpath(driver, ActionXpath.delete, time, "Delete theapplciation ");
                    Utils.clickXpath(driver, ActionXpath.Delete2, time, "Delete theapplciation ");
                    Utils.smallSleepBetweenClicks(2);
                    continue;
                }
            }

            log.info("  TC-2:  the Salesforce backend  delete test case PASSED \n");

        }

        catch (Exception e) {
            log.warning("TC-2: the Salesforce backend  delete test case FAILED \n");
            Utils.printException(e);
            throw (e);
        }

    }
}