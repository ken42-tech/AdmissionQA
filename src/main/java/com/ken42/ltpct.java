package com.ken42;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.reporters.jq.Main;

import io.github.bonigarcia.wdm.WebDriverManager;

import com.opencsv.CSVReader;

import java.util.logging.*;
import java.util.logging.FileHandler;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;

public class ltpct {

    private static final Exception Exception = null;
    private static WebDriver driver;
    static int time = 1000;
    public static Logger log = Logger.getLogger("w2l_portal");

    @Test
    public static void login_ltpct(String app_url, WebDriver driver, String[] csvCell) throws Exception

    {

        try {
            driver.navigate().refresh();
            Thread.sleep(3000);
            ((JavascriptExecutor) driver).executeScript("window.open()");
            ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tab.get(0));

            String mobile = csvCell[90];
            int time = 2000;
            Utils.smallSleepBetweenClicks(1);
            String regex = "Null";
            Utils.callSendkeys(driver, ActionXpath.mob, mobile, "enter mob");
            Utils.clickXpath(driver, ActionXpath.Verify, time, "Request OTP");
            int count = 0;
            int maxTries = 7;
            String alertMessage = "";
            while (true) {
                try {
                    Alert alert = driver.switchTo().alert(); // switch to alert
                    alertMessage = driver.switchTo().alert().getText(); // capture alert message
                    alert.accept();
                    break;
                } catch (Exception e) {
                    Utils.smallSleepBetweenClicks(1);
                    if (++count > maxTries) {
                        log.warning("Max retry of OTP reached");
                        throw (e);
                    }
                }

            }
            System.out.println(alertMessage); // Print Alert Message
            Pattern pt = Pattern.compile("-?\\d+");
            Matcher m = pt.matcher(alertMessage);
            while (m.find()) {
                regex = m.group();
            }
            // smallSleepBetweenClicks();
            driver.findElement(By.xpath("//input")).sendKeys(alertMessage);

            Utils.clickXpath(driver, ActionXpath.Verifylogin, time, "Verify otp");
            System.out.println(
                    "Sleeping after login for 7 seconds so that goBacktoHome function does not automatically logout user");
            Utils.bigSleepBetweenClicks(1);

        } catch (Exception e) {

            System.err.println("login failed");
            // driver.quit();
            throw (e);
        }

    }

    public static void ApplyforCourse(String url, WebDriver driver, String[] csvCell, Logger log) throws Exception {
        try {

            log.info("apply course execution started");
            String Programe = csvCell[13];

            Utils.callSendkeys(driver, ActionXpath.searchthecourse, Programe, "Enter program");
            WebElement textbox = driver.findElement(By.xpath("//input[@placeholder='Search...']"));
            textbox.sendKeys(Keys.ENTER);
            Utils.smallSleepBetweenClicks(3);
            Utils.clickXpath(driver, ActionXpath.ApplyNow, time, "Click on apply");
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

    @Test
    public static void w2l_basic_info(WebDriver driver, String[] csvCell, String url) throws Throwable {
        String firstname = csvCell[5];

        String middlename = csvCell[6];
        String lastname = csvCell[7];
        String Email = csvCell[8];
        String mobile = csvCell[9];
        String mobilephone = csvCell[10];
        String dob = csvCell[11];

        System.out.println(firstname);
        System.out.println(firstname);
        System.out.println(Email);

        // String exp = csvCell[48];
        String validation = csvCell[6];

        Thread.sleep(2000);

        if (validation.equals("TRUE")) {
            validate.testForCharLength(driver, ActionXpath.firstname, ActionXpath.erorxpath, log, 20);
            Utils.cleartext(driver, ActionXpath.firstname);
            validate.specialcharacter(driver, ActionXpath.firstname, ActionXpath.erorxpath, log);
            Utils.cleartext(driver, ActionXpath.firstname);
            validate.testForMandatoryField(driver, ActionXpath.firstname, ActionXpath.erorxpath, log);
        }

        Utils.callSendkeys(driver, ActionXpath.firstname, firstname, "enter firstname");

        if (validation.equals("TRUE")) {
            validate.testForCharLength(driver, ActionXpath.middlename, ActionXpath.erorxpath, log, 201);
            Utils.cleartext(driver, ActionXpath.middlename);
            validate.specialcharacter(driver, ActionXpath.middlename, ActionXpath.erorxpath, log);
            Utils.cleartext(driver, ActionXpath.middlename);
            validate.testForMandatoryField(driver, ActionXpath.middlename, ActionXpath.erorxpath, log);
        }

        Utils.callSendkeys(driver, ActionXpath.middlename, middlename, "enter middlename");

        if (validation.equals("TRUE")) {
            validate.testForCharLength(driver, ActionXpath.lastName2, ActionXpath.erorxpath, log, 20);
            Utils.cleartext(driver, ActionXpath.lastName2);
            validate.specialcharacter(driver, ActionXpath.lastName2, ActionXpath.erorxpath, log);
            Utils.cleartext(driver, ActionXpath.lastName2);
            validate.testForMandatoryField(driver, ActionXpath.lastName2, ActionXpath.erorxpath, log);
        }

        Utils.callSendkeys(driver, ActionXpath.lastName2, lastname, "enter lastname");

        if (validation.equals("TRUE")) {
            validate.email(driver, ActionXpath.email2, ActionXpath.erorxpath, log);
        }
        Email = Utils.genrateRandomEmailid();
        Utils.cleartext(driver, ActionXpath.email2);
        Utils.callSendkeys(driver, ActionXpath.email2, Email, "Enter the Email");

        if (validation.equals("TRUE")) {
            validate.testForCharLength(driver, ActionXpath.mobile, ActionXpath.erorxpath, log, 13);
            Utils.cleartext(driver, ActionXpath.mobile);
            validate.specialcharacter(driver, ActionXpath.mobile, ActionXpath.erorxpath, log);
            Utils.cleartext(driver, ActionXpath.mobile);
            validate.testForMandatoryField(driver, ActionXpath.mobile, ActionXpath.erorxpath, log);
        }

        Utils.callSendkeys(driver, ActionXpath.mobile, mobile, "enter mobileno");

        Utils.callSendkeys(driver, ActionXpath.mobilePhone, mobilephone, "enter mobileno");

        Utils.callSendkeys(driver, ActionXpath.dob2, dob, "enter dob");

        Thread.sleep(2000);

        Utils.callSendkeys(driver, ActionXpath.ageselect, "18", "enter age");

        Utils.callSendkeys(driver, ActionXpath.aadhar, "123456789012", "enter aadhar");

        Utils.callSendkeys(driver, ActionXpath.enquiry, "12", "enter enquiry");

        Utils.clickXpath(driver, ActionXpath.qualif, 2000, "qualif");

        driver.findElement(By.xpath("//li[.='12th']")).click();

        Utils.clickXpath(driver, ActionXpath.trainingcenter, time, "trainingcenter");

        driver.findElement(By.xpath("//li[.='NSIC, Delhi']")).click();

        Utils.clickXpath(driver, ActionXpath.course1, time, "course1");

        driver.findElement(By.xpath("//li[.='Big Data']")).click();

        Utils.clickXpath(driver, ActionXpath.clickoncheckox, time, "clickoncheckox");

    }

    @Test
    public static void w2l_address_info(WebDriver driver, String[] csvCell, String url) throws Throwable {

        // Thread.sleep(2000);
        Utils.clickXpath(driver, ActionXpath.clickonstate, time, "click on state");

        List<WebElement> values = driver
                .findElements(By.xpath("//ul[contains(@class,'MuiList-root MuiMenu-list MuiList-padding')]//li"));
        String statesel = csvCell[50];
        for (int i = 0; i < values.size(); i++) {

            if (values.get(i).getText().contains(statesel)) {
                values.get(i).click();
                break;
            }

        }

        Utils.clickXpath(driver, ActionXpath.clickoncity, time, "click on city");
        List<WebElement> city = driver
                .findElements(By.xpath("//ul[contains(@class,'MuiList-root MuiMenu-list MuiList-padding')]//li"));
        String citysel = csvCell[51];

        for (int i = 0; i < city.size(); i++) {

            if (city.get(i).getText().contains(citysel)) {

                city.get(i).click();
                break;
            }

        }

        // Thread.sleep(2000);
        Utils.clickXpath(driver, ActionXpath.course, time, "course");

        Utils.clickXpath(driver, ActionXpath.taluku, time, "taluku");

        List<WebElement> taluku = driver
                .findElements(By.xpath("//ul[contains(@class,'MuiList-root MuiMenu-list MuiList-padding')]//li"));
        String talkusel = csvCell[52];
        for (int i = 0; i < taluku.size(); i++) {

            if (taluku.get(i).getText().contains(talkusel)) {
                taluku.get(i).click();
                break;
            }

        }
        Thread.sleep(2000);
        Utils.clickXpath(driver, ActionXpath.gramPanchayat, time, "gramPanchayat");

        List<WebElement> gram = driver
                .findElements(By.xpath("//ul[contains(@class,'MuiList-root MuiMenu-list MuiList-padding')]//li"));
        String gramsel = csvCell[53];
        for (int i = 0; i < gram.size(); i++) {

            if (gram.get(i).getText().contains(gramsel)) {
                gram.get(i).click();
            }

        }
        // String talaku = csvCell[12];
        // String grampanchayat = csvCell[13];
        String village = csvCell[14];
        String hamlet = csvCell[15];

        // Utils.callSendkeys(driver, ActionXpath.taluku, talaku);
        // Utils.callSendkeys(driver, ActionXpath.gramPanchayat, grampanchayat);
        //
        Utils.callSendkeys(driver, ActionXpath.village, village, "enter village ");
        //
        Utils.callSendkeys(driver, ActionXpath.hamlet, hamlet, "enter hamlet");
    }

    @Test
    public static void w2l_other_info(WebDriver driver, String[] csvCell, String url) throws Throwable {

        Utils.clickXpath(driver, ActionXpath.clickonqualification, time, "click on qualification");

        List<WebElement> Qualification = driver
                .findElements(By.xpath("//ul[contains(@class,'MuiList-root MuiMenu-list MuiList-padding')]//li"));
        String qualisel = csvCell[54];
        for (int i = 0; i < Qualification.size(); i++) {

            if (Qualification.get(i).getText().contains(qualisel)) {
                Qualification.get(i).click();
                break;
            }

        }
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)");
        Utils.clickXpath(driver, ActionXpath.clickonApplyto, time, "click on Applyto");

        List<WebElement> apply = driver
                .findElements(By.xpath("//ul[contains(@class,'MuiList-root MuiMenu-list MuiList-padding')]//li"));
        String Applysel = csvCell[55];
        for (int i = 0; i < apply.size(); i++) {

            if (apply.get(i).getText().contains(Applysel)) {
                apply.get(i).click();
                break;
            }

        }

        Utils.clickXpath(driver, ActionXpath.clickonreferral, time, "click on referral");

        List<WebElement> referral = driver
                .findElements(By.xpath("//ul[contains(@class,'MuiList-root MuiMenu-list MuiList-padding')]//li"));
        String referalsel = csvCell[56];
        for (int i = 0; i < referral.size(); i++) {

            if (referral.get(i).getText().contains(referalsel)) {
                referral.get(i).click();
                break;
            }

        }

        // WebElement ref = driver.findElement(By.xpath("(//li[@role='option'])[5]"));
        // String referral = ref.getText();
        // System.out.println(referral);
        // Thread.sleep(2000);
        // driver.findElement(By.xpath("//li[@data-value='" + referral + "']")).click();

        // Utils.callSendkeys(driver, ActionXpath.referalname, "surya");

        Utils.clickXpath(driver, ActionXpath.clickonmobiliser, time, "click on mobilizer");

        List<WebElement> mobiliser = driver
                .findElements(By.xpath("//ul[contains(@class,'MuiList-root MuiMenu-list MuiList-padding')]//li"));
        String mobilizersel = csvCell[57];
        for (int i = 0; i < mobiliser.size(); i++) {

            if (mobiliser.get(i).getText().contains(mobilizersel)) {
                mobiliser.get(i).click();
                break;
            }

        }

        // WebElement mobi = driver.findElement(By.xpath("(//li[@role='option'])[5]"));
        // String mobilizer = mobi.getText();
        // System.out.println(mobilizer);
        // Thread.sleep(2000);
        // driver.findElement(By.xpath("//li[@data-value='" + mobilizer +
        // "']")).click();

        Utils.clickXpath(driver, ActionXpath.clickonreligion2, time, "click on religion");
        List<WebElement> religion = driver
                .findElements(By.xpath("//ul[contains(@class,'MuiList-root MuiMenu-list MuiList-padding')]//li"));
        String religionsel = csvCell[58];
        for (int i = 0; i < religion.size(); i++) {

            if (religion.get(i).getText().contains(religionsel)) {
                religion.get(i).click();

                break;
            }

        }

        // WebElement reli = driver.findElement(By.xpath("(//li[@role='option'])[5]"));
        // String religion = reli.getText();
        // System.out.println(religion);
        // Thread.sleep(2000);
        // driver.findElement(By.xpath("//li[@data-value='" + religion + "']")).click();

        Utils.clickXpath(driver, ActionXpath.clickoncaste, time, "click on caste");

        List<WebElement> caste = driver
                .findElements(By.xpath("//ul[contains(@class,'MuiList-root MuiMenu-list MuiList-padding')]//li"));
        String castesel = csvCell[59];
        for (int i = 0; i < caste.size(); i++) {

            if (caste.get(i).getText().contains(castesel)) {
                caste.get(i).click();
                break;
            }

        }

        // WebElement cas = driver.findElement(By.xpath("(//li[@role='option'])[3]"));
        // String caste = cas.getText();
        // System.out.println(caste);
        // Thread.sleep(2000);
        // driver.findElement(By.xpath("//li[@data-value='" + caste + "']")).click();

        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@aria-disabled='false']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", e);

    }

    @Test
    public static void submit_info(WebDriver driver, String[] csvCell, String url) throws Throwable {

        Thread.sleep(1000);
        Actions ac1 = new Actions(driver);
        WebElement ele1 = driver.findElement(By.xpath("//span[.='Submit']|//span[.='SUBMIT']"));
        ac1.doubleClick(ele1).perform();
        Thread.sleep(2000);
    }

    @Test
    public static void Appbasic_info(String app_url, WebDriver driver, String[] csvCell, Logger log) throws Throwable {
        String vocation = csvCell[66];
        String firstname = csvCell[91];
        String surename = csvCell[102];
        String fathername = csvCell[103];

        String dob = csvCell[97];

        String occupation = csvCell[156];

        String grampanchayat = csvCell[99];
        String village = csvCell[100];
        String hamlet = csvCell[101];

        String religion = csvCell[105];
        String age = csvCell[106];
        String batch = csvCell[189];
        String mothername = csvCell[107];
        String bloodsel = csvCell[143];
        String guardianname = csvCell[108];
        String hobbies = csvCell[109];
        String castesel = csvCell[142];

        String passbankholder = csvCell[152];
        String passbankname = csvCell[153];
        String passbranchname = csvCell[154];
        String passifsc = csvCell[155];

        try {
            Utils.smallSleepBetweenClicks(1);
            Utils.cleartext(driver, ActionXpath.firstname);

            Utils.callSendkeys(driver, ActionXpath.firstname, firstname, "enter fname");

            Utils.cleartext(driver, ActionXpath.surename);

            Utils.callSendkeys(driver, ActionXpath.surename, surename, "enter sname ");

            Utils.cleartext(driver, ActionXpath.enterfathername);

            Utils.callSendkeys(driver, ActionXpath.enterfathername, fathername, "enter fathername");
            Thread.sleep(1000);
            Utils.cleartext(driver, ActionXpath.mother);

            Utils.callSendkeys(driver, ActionXpath.mother, mothername, "enter mother NAME ");

            // Utils.cleartext(driver, ActionXpath.enterdob);

            // Utils.callSendkeys(driver, ActionXpath.enterdob, dob, "enter dob ");
            Thread.sleep(1000);
            Utils.clickXpath(driver, ActionXpath.batch, time, "click on batch");

            Utils.selectFromDropDown(ActionXpath.scrolldropdown, batch, driver);

            Utils.cleartext(driver, ActionXpath.presentoccupation);

            Utils.callSendkeys(driver, ActionXpath.presentoccupation, occupation, "enter occupation ");

            Utils.cleartext(driver, ActionXpath.gramPanchayat1);

            Utils.callSendkeys(driver, ActionXpath.gramPanchayat1, grampanchayat, "enter grampanchayat");

            Utils.cleartext(driver, ActionXpath.Hamlet);

            Utils.callSendkeys(driver, ActionXpath.Hamlet, hamlet, "enter hamlet ");

            Utils.cleartext(driver, ActionXpath.Village);

            Utils.callSendkeys(driver, ActionXpath.Village, village, "enter village");

            Utils.cleartext(driver, ActionXpath.religion);

            Utils.callSendkeys(driver, ActionXpath.religion, religion, "enter religion ");

            Utils.cleartext(driver, ActionXpath.age);

            Utils.callSendkeys(driver, ActionXpath.age, age, "enter age ");

            Utils.cleartext(driver, ActionXpath.enterguardianname);

            Utils.callSendkeys(driver, ActionXpath.enterguardianname, guardianname, "enter guardianname ");

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,2000)");

            Utils.cleartext(driver, ActionXpath.enterhobbies);

            Utils.callSendkeys(driver, ActionXpath.enterhobbies, hobbies, "enter hobbies ");
            Thread.sleep(1000);
            Utils.clickXpath(driver, ActionXpath.clickonbloodgroup2, time, "clickonbloodgroup");

            Utils.selectFromDropDown(ActionXpath.scrolldropdown, bloodsel, driver);
            Thread.sleep(1000);
            Utils.clickXpath(driver, ActionXpath.clickoncaste1, time, "clickoncaste1");
            Utils.selectFromDropDown(ActionXpath.scrolldropdown, castesel, driver);

            Utils.vsmallSleepBetweenClicks(1);

            Utils.cleartext(driver, ActionXpath.bankholder);

            Utils.callSendkeys(driver, ActionXpath.bankholder, passbankholder, "enter bankholder ");

            Utils.cleartext(driver, ActionXpath.bankname);

            Utils.callSendkeys(driver, ActionXpath.bankname, passbankname, "enter bankname ");

            Utils.cleartext(driver, ActionXpath.branchname);

            Utils.callSendkeys(driver, ActionXpath.branchname, passbranchname, "enter branchname ");

            Utils.cleartext(driver, ActionXpath.ifsccode);

            Utils.callSendkeys(driver, ActionXpath.ifsccode, passifsc, "enter ifsccode ");

            // Actions a = new Actions(driver);
            // WebElement eee =
            // driver.findElement(By.xpath("(//button[@name='gender'])[3]"));
            // a.doubleClick(eee).build().perform();
            // Utils.vsmallSleepBetweenClicks(1);

            // driver.findElement(By.xpath("(//button[@name='gender'])[1]")).click();

            // WebElement el =
            // driver.findElement(By.xpath("(//button[@name='gender'])[3]"));
            //
            // boolean actual = el.isSelected();
            //
            // if (actual) {
            // System.out.println("true");
            //
            // } else {
            // el.click();
            // }
            Utils.vsmallSleepBetweenClicks(1);
            Utils.clickXpath(driver, ActionXpath.clickonnext, time, "clickonnext");
            log.info("apply vasic info passed");

        } catch (Exception e) {
            e.printStackTrace();
            log.warning("App_basic info Failled");
        }
    }

    @Test
    public static void family_info(String app_url, WebDriver driver, String[] csvCell, Logger log) throws Exception {

        String firstname = csvCell[91];
        String surename = csvCell[102];

        String workingMembers = csvCell[110];
        String nonWorkingMembers = csvCell[111];
        String familyIncome = csvCell[112];

        String noOfFamilymembers = csvCell[113];
        String noOfFamilymembersAdults = csvCell[114];
        String noOfFamilymembersChildren = csvCell[115];
        String martialsel = csvCell[61];

        String imponfosel = csvCell[157];
        Thread.sleep(3000);
        try {
            Utils.cleartext(driver, ActionXpath.ffname);
            Utils.vsmallSleepBetweenClicks(1);
            Utils.callSendkeys(driver, ActionXpath.ffname, firstname, "enter fname");

            Utils.cleartext(driver, ActionXpath.flname);

            Utils.callSendkeys(driver, ActionXpath.flname, surename, "enter sname ");

            Utils.callSendkeys(driver, ActionXpath.noOfFamilymembers, noOfFamilymembers, "enter nooffamilymember");
            // Thread.sleep(2000);
            Utils.callSendkeys(driver, ActionXpath.noOfFamilymembersAdults, noOfFamilymembersAdults,
                    "enter  nooffamilymemberadult");
            Utils.callSendkeys(driver, ActionXpath.noOfFamilymembersChildren, noOfFamilymembersChildren,
                    "enter nooffamilymemberchild ");

            Utils.callSendkeys(driver, ActionXpath.workingMembers, workingMembers, "enter  working member");
            Utils.callSendkeys(driver, ActionXpath.nonWorkingMembers, nonWorkingMembers, "enter no of nonworking");

            // Utils.clickXpath(driver, ActionXpath.clickonmaritalstatus, time,
            // "clickonmaritalstatus");
            // Thread.sleep(2000);

            // Utils.selectFromDropDown(ActionXpath.scrolldropdown, martialsel, driver);

            // // WebElement mar =
            // driver.findElement(By.xpath("(//li[@role='option'])[1]"));
            // String marital = mar.getText();
            // System.out.println(marital);
            // Thread.sleep(2000);
            // driver.findElement(By.xpath("//li[@data-value='" + marital + "']")).click();

            Utils.callSendkeys(driver, ActionXpath.familyIncome, familyIncome, "enter  fincome");

            Utils.clickXpath(driver, ActionXpath.clickonanyImpInformation, time, "clickonanyImpInformation");

            Utils.selectFromDropDown(ActionXpath.scrolldropdown, imponfosel, driver);

            // WebElement imp = driver.findElement(By.xpath("(//li[@role='option'])[1]"));
            // String Information = imp.getText();
            // System.out.println(Information);
            // Thread.sleep(2000);
            // driver.findElement(By.xpath("//li[@data-value='" + Information +
            // "']")).click();

            // JavascriptExecutor js = (JavascriptExecutor) driver;
            // js.executeScript("window.scrollBy(0,2000)");

            // Utils.callSendkeys(driver, ActionXpath.bankholder, "suri", "enter
            // bankholder");
            // Utils.callSendkeys(driver, ActionXpath.bankname, "sbi", "enter bankname");
            // Utils.callSendkeys(driver, ActionXpath.branchname, "bangaluru", "enter
            // branchname ");
            // Utils.callSendkeys(driver, ActionXpath.ifsccode, "C00678", "enter ifsccode");

            Utils.clickXpath(driver, ActionXpath.clickon2ndnext, time, "clickon2ndnext");

            Thread.sleep(2000);
            log.info("family info screen passed");

            // Utils.clickXpath(driver, ActionXpath.clickon2ndnext, time, "clickon2ndnext");
        }

        catch (Exception e) {
            e.printStackTrace();
            log.warning("family info screen Failed");
        }
    }

    @Test
    public static void Address_info(String app_url, WebDriver driver, String[] csvCell, Logger log) throws Throwable

    {

        try {

            String address = csvCell[116];
            String city = csvCell[31];
            String pincode = csvCell[118];
            String contrysel = csvCell[63];
            String stateselc = csvCell[64];
            Utils.vsmallSleepBetweenClicks(1);

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,-2000)");
            Utils.smallSleepBetweenClicks(1);

            Utils.callSendkeys(driver, ActionXpath.address2, address, "enter address");

            // Utils.clickXpath(driver, ActionXpath.clickoncountry, time, "clickoncountry");

            // Utils.selectFromDropDown(ActionXpath.scrolldropdown, contrysel, driver);

            // Utils.clickXpath(driver, ActionXpath.clickonstate1, time, "clickonstate1");

            // Utils.selectFromDropDown(ActionXpath.scrolldropdown, stateselc, driver);

            // Utils.cleartext(driver, ActionXpath.addcity);
            // Utils.callSendkeys(driver, ActionXpath.addcity, city, "enter city");

            Utils.callSendkeys(driver, ActionXpath.pincode, pincode, "enter pincode");
            Utils.smallSleepBetweenClicks(1);

            Utils.clickXpath(driver, ActionXpath.currentaddressrole, time, "click on  current address");

            // JavascriptExecutor js = (JavascriptExecutor) driver;
            // js.executeScript("window.scrollBy(0,2000)");
            // Thread.sleep(2000);
            Utils.clickXpath(driver, ActionXpath.currentadd, time, "click on  current address");
            // Thread.sleep(2000);
            //
            // List<WebElement> country1 = driver
            // .findElements(By.xpath("//ul[contains(@class,'MuiList-root MuiMenu-list
            // MuiList-padding')]//li"));
            // String contrysel1=csvCell[63];
            // for (int i = 0; i < country1.size(); i++) {
            //
            // if (country1.get(i).getText().contains(contrysel1)) {
            // country1.get(i).click();
            // break;
            // }
            //
            // }

            // WebElement coun1 =
            // driver.findElement(By.xpath("(//li[@role='option'])[27]"));
            // String country1 = coun1.getText();
            // System.out.println(country1);
            // Thread.sleep(2000);
            // driver.findElement(By.xpath("//li[@data-value='" + country1 + "']")).click();
            //
            // // Thread.sleep(2000);

            Utils.clickXpath(driver, ActionXpath.clickon3rdnext, time, "clickon3rdnext");
            Utils.smallSleepBetweenClicks(1);
            log.warning("address screen passed");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            log.warning("address screen Failed");
        }
    }

    @Test
    public static void qualification_info(String app_url, WebDriver driver, String[] csvCell, Logger log)
            throws Exception

    {

        try {

            String quali = csvCell[119];
            String finic = csvCell[120];

            String startingdate = csvCell[121];
            String joiningdate = csvCell[122];
            String enddate = csvCell[123];

            String iwanttojoin = csvCell[124];
            String aftercompletion = csvCell[125];
            String batchsel1 = csvCell[148];
            Thread.sleep(4000);
            Utils.cleartext(driver, ActionXpath.educationquali);
            // Thread.sleep(2000);
            Utils.callSendkeys(driver, ActionXpath.educationquali, quali, "enter education");
            // Thread.sleep(2000);
            Utils.clickXpath(driver, ActionXpath.clickonbatch, time, "clickonbatch");

            Utils.selectFromDropDown(ActionXpath.scrolldropdown, batchsel1, driver);

            Utils.cleartext(driver, ActionXpath.finicial);
            // Thread.sleep(2000);
            Utils.callSendkeys(driver, ActionXpath.finicial, finic, "enter finic");

            // Thread.sleep(2000);
            Utils.cleartext(driver, ActionXpath.startingdate);
            // Thread.sleep(2000);
            Utils.callSendkeys(driver, ActionXpath.startingdate, startingdate, "enter start date");

            // Thread.sleep(2000);
            Utils.cleartext(driver, ActionXpath.joiningdate);
            // Thread.sleep(2000);
            Utils.callSendkeys(driver, ActionXpath.joiningdate, joiningdate, "enter joining date");

            // Thread.sleep(2000);
            Utils.cleartext(driver, ActionXpath.enddate);

            // Thread.sleep(2000);
            Utils.callSendkeys(driver, ActionXpath.enddate, enddate, "enter enddate");

            // Thread.sleep(2000);
            Utils.cleartext(driver, ActionXpath.iwanttojoin);
            // Thread.sleep(2000);
            Utils.callSendkeys(driver, ActionXpath.iwanttojoin, iwanttojoin, "enter joining");

            // Thread.sleep(2000);
            Utils.cleartext(driver, ActionXpath.aftercompletion);

            Utils.callSendkeys(driver, ActionXpath.aftercompletion, aftercompletion, "enter aftercomplietion");
            // Thread.sleep(2000);

            Utils.clickXpath(driver, ActionXpath.clickon4thnext, time, "clickonnext");
            Utils.bigSleepBetweenClicks(1);

            log.info("qualification screen passed");

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            log.info("qualification screen Failled");
        }
    }

    @Test
    public static void uploadfile_info(String app_url, WebDriver driver, String[] csvCell) throws Throwable

    {

        Utils.bigSleepBetweenClicks(1);

        Utils.callSendkeys(driver, ActionXpath.passport, "C:\\Users\\Public\\Documents\\samplepptx.pptx",
                "upload passport");

        WebElement getalert = driver.findElement(By.xpath("//div[@role='alert']"));
        String message = getalert.getText();
        System.out.println(message);
    }

    @Test
    public static void Multipleuploadfile_info(String app_url, WebDriver driver, String[] csvCell, Logger log)
            throws Throwable

    {

        try {

            Utils.smallSleepBetweenClicks(1);

            driver.findElement(By.xpath("(//input[@type='file'])[1]"))
                    .sendKeys("C:\\Users\\Public\\Documents\\passport.jpg");
            Utils.smallSleepBetweenClicks(1);
            driver.findElement(By.xpath("(//input[@type='file'])[2]"))
                    .sendKeys("C:\\Users\\Public\\Documents\\passport.jpg");

            Utils.smallSleepBetweenClicks(1);

            // Utils.callSendkeys(driver, ActionXpath.passport2,
            // "C:\\Users\\Public\\Documents\\passport.png",
            // "upload passport");
            // Utils.smallSleepBetweenClicks(1);
            // Utils.callSendkeys(driver, ActionXpath.addhar,
            // "C:\\Users\\Public\\Documents\\aadhar.png", "upload aadhar");
            // Utils.smallSleepBetweenClicks(1);
            // Utils.callSendkeys(driver, ActionXpath.school,
            // "C:\\Users\\Public\\Documents\\school.png", "upload school");

            // Utils.bigSleepBetweenClicks(1);
            // JavascriptExecutor js = (JavascriptExecutor) driver;
            // js.executeScript("window.scrollBy(0,2000)");
            Utils.clickXpath(driver, ActionXpath.clickon5thnext, time, "clickonnext");
            log.info("upload screen passed");

        } catch (Exception e) {
            e.printStackTrace();
            log.info("upload screen Failled");
        }
    }

    @Test
    public static void checkbox(String app_url, WebDriver driver, String[] csvCell) throws Throwable

    {
        Utils.vsmallSleepBetweenClicks(1);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement e1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@aria-disabled='false']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", e1);
        Utils.clickXpath(driver, ActionXpath.clickon6thnext, time, "clickonnext");

    }

    @Test
    public static void submit_app(String app_url, WebDriver driver, String[] csvCell) throws Throwable

    {
        Utils.bigSleepBetweenClicks(1);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement e11 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.='Submit']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", e11);

    }

    @Test
    public static void w2l_firstname_validate(WebDriver driver, String[] csvCell, String url) throws Throwable {
        String firstname = csvCell[5];

        String middlename = csvCell[6];
        String lastname = csvCell[7];
        String Email = csvCell[8];
        String mobile = csvCell[9];
        String mobilephone = csvCell[10];
        String dob = csvCell[11];

        System.out.println(firstname);
        System.out.println(firstname);
        System.out.println(Email);

        // String exp = csvCell[48];
        String validation = csvCell[6];

        Thread.sleep(2000);

        if (validation.equals("TRUE")) {
            validate.testForCharLength(driver, ActionXpath.firstname, ActionXpath.erorxpath, log, 20);
            Utils.cleartext(driver, ActionXpath.firstname);
            validate.specialcharacter(driver, ActionXpath.firstname, ActionXpath.erorxpath, log);
            Utils.cleartext(driver, ActionXpath.firstname);
            validate.testForMandatoryField(driver, ActionXpath.firstname, ActionXpath.erorxpath, log);
        }

        Utils.callSendkeys(driver, ActionXpath.firstname, firstname, "enter firstname");

        if (validation.equals("TRUE")) {
            validate.testForCharLength(driver, ActionXpath.middlename, ActionXpath.erorxpath, log, 201);
            Utils.cleartext(driver, ActionXpath.middlename);
            validate.specialcharacter(driver, ActionXpath.middlename, ActionXpath.erorxpath, log);
            Utils.cleartext(driver, ActionXpath.middlename);
            validate.testForMandatoryField(driver, ActionXpath.middlename, ActionXpath.erorxpath, log);
        }

        Utils.callSendkeys(driver, ActionXpath.middlename, middlename, "enter middlename");

        if (validation.equals("TRUE")) {
            validate.testForCharLength(driver, ActionXpath.lastName2, ActionXpath.erorxpath, log, 20);
            Utils.cleartext(driver, ActionXpath.lastName2);
            validate.specialcharacter(driver, ActionXpath.lastName2, ActionXpath.erorxpath, log);
            Utils.cleartext(driver, ActionXpath.lastName2);
            validate.testForMandatoryField(driver, ActionXpath.lastName2, ActionXpath.erorxpath, log);
        }

        Utils.callSendkeys(driver, ActionXpath.lastName2, lastname, "enter lastname");

        if (validation.equals("TRUE")) {
            validate.email(driver, ActionXpath.email2, ActionXpath.erorxpath, log);
        }
        Email = Utils.genrateRandomEmailid();
        Utils.cleartext(driver, ActionXpath.email2);
        Utils.callSendkeys(driver, ActionXpath.email2, Email, "Enter the Email");

        if (validation.equals("TRUE")) {
            validate.testForCharLength(driver, ActionXpath.mobile, ActionXpath.erorxpath, log, 13);
            Utils.cleartext(driver, ActionXpath.mobile);
            validate.specialcharacter(driver, ActionXpath.mobile, ActionXpath.erorxpath, log);
            Utils.cleartext(driver, ActionXpath.mobile);
            validate.testForMandatoryField(driver, ActionXpath.mobile, ActionXpath.erorxpath, log);
        }

        Utils.callSendkeys(driver, ActionXpath.mobile, mobile, "enter mobileno");

        Utils.callSendkeys(driver, ActionXpath.mobilePhone, mobilephone, "enter mobileno");

        Utils.callSendkeys(driver, ActionXpath.dob2, dob, "enter dob");

        Thread.sleep(2000);

        Utils.callSendkeys(driver, ActionXpath.ageselect, "18", "enter age");

        Utils.callSendkeys(driver, ActionXpath.aadhar, "123456789012", "enter aadhar");

        Utils.callSendkeys(driver, ActionXpath.enquiry, "12", "enter enquiry");

        Utils.clickXpath(driver, ActionXpath.qualif, 2000, "qualif");

        driver.findElement(By.xpath("//li[.='12th']")).click();

        Utils.clickXpath(driver, ActionXpath.trainingcenter, time, "trainingcenter");

        driver.findElement(By.xpath("//li[.='NSIC, Delhi']")).click();

        Utils.clickXpath(driver, ActionXpath.course1, time, "course1");

        driver.findElement(By.xpath("//li[.='Big Data']")).click();

        Utils.clickXpath(driver, ActionXpath.clickoncheckox, time, "clickoncheckox");

    }

    @Test

    public static void salesforce_login(String sal_url, WebDriver driver, String[] csvCell) throws Exception {

        String username = csvCell[10];
        String password = csvCell[11];

        Utils.callSendkeys(driver, ActionXpath.username, username, "enter username");

        Utils.callSendkeys(driver, ActionXpath.password2, password, "enter password");

        Utils.clickXpath(driver, ActionXpath.logintosalesforce, time, "login to salesforce");

    }

    @Test

    public static void clickonleadandselect(String sal_url, WebDriver driver, String[] csvCell) throws Exception {

        Thread.sleep(10000);

        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Leads']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", e);
        System.out.println("click on leads");
        Thread.sleep(5000);

        Utils.clickXpath(driver, ActionXpath.clickondropdown, time, "clickondropdown");

        Thread.sleep(5000);

        // WebDriverWait wait = new WebDriverWait(driver, 20);

        WebElement e1 = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//span[.='w2l automation']|(//span[.='w2l automation'])[1]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", e1);
        Thread.sleep(5000);

        WebElement e11 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-refid='recordId']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", e11);

    }

    @Test

    public static void clickonApplicationandselect(String sal_url, WebDriver driver, String[] csvCell)
            throws Exception {

        Thread.sleep(10000);

        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Applications']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", e);
        System.out.println("click on Application");
        Thread.sleep(5000);

        List<WebElement> clickapplicant = driver.findElements(By.xpath("//table//tbody//td[3]//a"));
        String Applicant = csvCell[12];
        for (int i = 0; i < clickapplicant.size(); i++) {

            if (clickapplicant.get(i).getText().contains(Applicant)) {
                clickapplicant.get(i).click();

                break;
            }

        }

        WebDriverWait wait2 = new WebDriverWait(driver, 20);
        WebElement elem2 = wait2.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//span[@class='view-all-label'])[1]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem2);
        // JavascriptExecutor js = (JavascriptExecutor) driver;
        // js.executeScript("window.scrollBy(0,100)");
        Thread.sleep(4000);
        Actions aa = new Actions(driver);
        WebElement ee = driver.findElement(By.xpath(
                "/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr/td[3]/span/div/a"));
        aa.moveToElement(ee).click().build().perform();

        // Thread.sleep(5000);
        // WebElement elqq = wait.until(ExpectedConditions
        // .elementToBeClickable(By.xpath(
        // "//*[@class='forceVirtualActionMarker forceVirtualAction']")));
        // ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elqq);

        WebElement we1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Delete']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", we1);

        ///// a[@title='Delete']

        Thread.sleep(5000);
        WebElement le = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='Delete']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", le);

        Thread.sleep(5000);

        // Thread.sleep(3000);

        // Thread.sleep(4000);
        // JavascriptExecutor js = (JavascriptExecutor) driver;
        // js.executeScript("window.scrollBy(0,2300)");
        // Thread.sleep(3000);
        // WebElement e111 = wait.until(ExpectedConditions.elementToBeClickable(
        // By.xpath("(//button[@class='slds-button slds-button_icon-border
        // slds-button_icon-x-small'])[4]")));
        // ((JavascriptExecutor) driver).executeScript("arguments[0].click();", e111);
        // Thread.sleep(3000);
        // driver.findElement(By.xpath("//a[@title='Delete']")).click();
        // Thread.sleep(3000);
        // driver.findElement(By.xpath("//span[.='Delete']")).click();

        // Thread.sleep(8000);
        // // JavascriptExecutor js = (JavascriptExecutor) driver;
        // js.executeScript("window.scrollBy(0,1200)");

        // Thread.sleep(3000);
        // // WebDriverWait wait = new WebDriverWait(driver, 20);
        // WebElement e111q = wait.until(ExpectedConditions.elementToBeClickable(
        // By.xpath("(//button[@class='slds-button slds-button_icon-border
        // slds-button_icon-x-small'])[4]")));
        // ((JavascriptExecutor) driver).executeScript("arguments[0].click();", e111q);

        // WebElement e1q =
        // wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Delete']")));
        // ((JavascriptExecutor) driver).executeScript("arguments[0].click();", e1q);

        // Thread.sleep(3000);
        // driver.findElement(By.xpath("//span[.='Delete']")).click();

        // Thread.sleep(8000);
        // // JavascriptExecutor js = (JavascriptExecutor) driver;
        // js.executeScript("window.scrollBy(0,-3000)");

        // Thread.sleep(3000);

        // WebElement e11q = wait.until(ExpectedConditions.elementToBeClickable(
        // By.xpath("(//button[@class='slds-button slds-button_icon-border
        // slds-button_icon-x-small'])[1]")));
        // ((JavascriptExecutor) driver).executeScript("arguments[0].click();", e11q);

        // WebElement eq =
        // wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Delete']")));
        // ((JavascriptExecutor) driver).executeScript("arguments[0].click();", eq);

        // Thread.sleep(3000);
        // driver.findElement(By.xpath("//span[.='Delete']")).click();
        // Thread.sleep(3000);

        // WebElement elqq = wait.until(ExpectedConditions
        // .elementToBeClickable(By.xpath("(//div[@class='uiMenu'])[4]")));
        // ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elqq);

        // WebElement we1 =
        // wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Delete']")));
        // ((JavascriptExecutor) driver).executeScript("arguments[0].click();", we1);

        // ///// a[@title='Delete']

        // Thread.sleep(5000);
        // WebElement le =
        // wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[.='Delete'])[2]")));
        // ((JavascriptExecutor) driver).executeScript("arguments[0].click();", le);

        // Thread.sleep(5000);

    }

    @Test

    public static void clickonApplicationview(String sal_url, WebDriver driver, String[] csvCell) throws Exception {

        Thread.sleep(10000);

        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Applications']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", e);
        System.out.println("click on Application");
        Thread.sleep(5000);

        Utils.clickXpath(driver, ActionXpath.clickondropdown, time, "clickondropdown");

        Thread.sleep(5000);

        WebElement e1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='w2lead']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", e1);

        Thread.sleep(5000);

        WebElement e1a = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-refid='recordId'])[1]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", e1a);

        Thread.sleep(5000);

        WebElement e12 = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@title='Application View']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", e12);

        Thread.sleep(5000);

        WebElement e1aq = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.='Edit']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", e1aq);

        Thread.sleep(5000);
        WebElement ele = driver.findElement(By.xpath("//input[@name='FirstName']"));
        String se = ele.getText();
        System.out.println(se);

        Thread.sleep(2000);
        driver.navigate().back();

        Thread.sleep(5000);
        WebElement elqq = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//a[@class='rowActionsPlaceHolder slds-button slds-button--icon-x-small slds-button--icon-border-filled keyboardMode--trigger']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elqq);

        Thread.sleep(5000);
        WebElement le = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Delete']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", le);

        Thread.sleep(5000);
        WebElement eqeq = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Delete']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", eqeq);

    }

    @Test

    public static void markasStatus(String sal_url, WebDriver driver, String[] csvCell) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        Thread.sleep(5000);
        WebElement e111 = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='Mark Status as Complete']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", e111);

        Thread.sleep(5000);

        WebElement e1111 = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='Mark Status as Complete']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", e1111);

    }

    @Test

    public static void selectsaveanddelete(String sal_url, WebDriver driver, String[] csvCell) throws Exception {
        Thread.sleep(5000);

        Select s = new Select(driver.findElement(By.xpath("//select[@class='stepAction required-field select']")));
        s.selectByValue("converted");

        Thread.sleep(3000);

        s.selectByValue("Registration Complete");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement e5 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[.='Save'])[2]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", e5);
        Thread.sleep(4000);

        WebElement e51 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.='Delete']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", e51);
        Thread.sleep(3000);

        WebElement e511 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[.='Delete'])[2]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", e511);

    }

    @Test

    public static void profile_logout(String sal_url, WebDriver driver, String[] csvCell) throws Exception {
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement e6 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='uiImage'])[1]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", e6);
        Thread.sleep(3000);
        WebElement e61 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[.='Log Out']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", e61);

    }

    @Test
    public static void signout_app(String app_url, WebDriver driver, String[] csvCell) throws Throwable

    {
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement e111 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.='Sign out']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", e111);

    }

    @Test
    public static void salesforce_applicationviewanddelete(String sal_url, WebDriver driver, String[] csvCell)
            throws java.lang.Exception

    {
        String url = csvCell[40];
        driver.get(url);
        ltpct.salesforce_login(sal_url, driver, csvCell);
        ltpct.clickonApplicationandselect(sal_url, driver, csvCell);

        ltpct.profile_logout(sal_url, driver, csvCell);
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(4));

    }

    @Test

    public static void clickonApplicationandverify(String sal_url, WebDriver driver, String[] csvCell)
            throws Exception {

        Thread.sleep(10000);

        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Applications']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", e);
        System.out.println("click on Application");
        Thread.sleep(5000);

        List<WebElement> clickapplicant = driver.findElements(By.xpath("//table//tbody//td[3]//a"));
        String Applicant = csvCell[67];
        for (int i = 0; i < clickapplicant.size(); i++) {

            if (clickapplicant.get(i).getText().contains(Applicant)) {
                clickapplicant.get(i).click();

                break;
            }

        }
        SoftAssert softassert = new SoftAssert();
        Thread.sleep(3000);
        String firstname = csvCell[5];

        String surename = csvCell[16];

        String expectedname = firstname + " " + surename;
        System.out.println(expectedname + " expected_Firstname");
        WebElement re = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-tab-value='detailTab']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", re);
        Thread.sleep(3000);
        WebElement firstnameverify = driver.findElement(By.xpath(
                "(//span[@class='test-id__field-value slds-form-element__static slds-grow word-break-ie11'])[1]"));

        String actualfirstnameverification = firstnameverify.getText();
        System.out.println(actualfirstnameverification + " actualFirstname");
        softassert.assertEquals(expectedname, actualfirstnameverification);
        softassert.assertTrue(true, actualfirstnameverification);

        String expectedmobilenumber = csvCell[9];
        System.out.println(expectedmobilenumber + " expected_mobile_number");
        Thread.sleep(3000);
        WebElement phonenumberverify = driver.findElement(By.xpath(
                "(//span[@class='test-id__field-value slds-form-element__static slds-grow word-break-ie11'])[2]"));

        String actualphonenumberverifybefore = phonenumberverify.getText();
        System.out.println(actualphonenumberverifybefore + " before_number");
        String str = "918147751055";
        // Remove a substring from a string in Java
        // System.out.println("String after removing the first '91' substring =
        // "+str.replaceFirst("91", ""));
        String actualphonenumber = str.replaceFirst("91", "");
        System.out.println(actualphonenumber + " actual_phone_numberafter");

        softassert.assertEquals(expectedmobilenumber, actualphonenumber);
        softassert.assertTrue(true, actualphonenumber);

        String expectedemail = csvCell[8];
        System.out.println(expectedemail + " expected email");
        Thread.sleep(3000);
        WebElement actualemailverify = driver.findElement(By.xpath(
                "(//span[@class='test-id__field-value slds-form-element__static slds-grow word-break-ie11'])[4]"));

        String actualemailverification = actualemailverify.getText();
        System.out.println(actualemailverification + " actual email");
        softassert.assertEquals(expectedemail, actualemailverification);
        softassert.assertTrue(true, actualemailverification);
        softassert.assertAll();

    }

    @Test(priority = 1)
    public static void EmptyW2l_fillform_check(String url, WebDriver Driver, String[] csvCell)
            throws Throwable, Throwable {

        try {
            ((JavascriptExecutor) driver).executeScript("window.open()");
            ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tab.get(1));

            String web_url = csvCell[0];
            Driver.get(web_url);

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,2000)");

            ltpct.submit_info(driver, csvCell, web_url);

            WebElement empty = driver.findElement(By.xpath("//span[@style='color: rgb(255, 153, 31);']"));
            String emptycheckform = empty.getText();
            System.out.println(emptycheckform);
            log.warning("Tc1:- validation  failed because field's are not entered  ");

            log.info("Tc1:-EmptyW2l_fillform_check testcase passed");
            System.out.println("Tc1:-EmptyW2l_fillform_check testcase passed");

        }

        catch (Exception e) {
            e.printStackTrace();
            log.info("Tc1:-EmptyW2l_fillform_check testcase failed");
            System.out.println("Tc1:-EmptyW2l_fillform_check testcase failed");
        }
    }

    @Test(priority = 2)
    public static void validate_without_firstname(String url, WebDriver Driver, String[] csvCell)
            throws Throwable, Throwable {
        try {
            ((JavascriptExecutor) driver).executeScript("window.open()");
            ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tab.get(9));
            String web_url = csvCell[0];
            Driver.get(web_url);
            ltpct.w2l_firstname_validate(Driver, csvCell, url);

            ltpct.w2l_address_info(Driver, csvCell, url);

            ltpct.w2l_other_info(driver, csvCell, web_url);

            ltpct.submit_info(driver, csvCell, web_url);

            WebElement fnamevalidatewithfullform = driver
                    .findElement(By.xpath("//span[@style='color: rgb(255, 153, 31);']"));
            String fncheckform = fnamevalidatewithfullform.getText();
            System.out.println(fncheckform);

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,-2000)");

            log.info("Tc2:-firstname validate with complete form fill web2Lead  testcase Passed");
            System.out.println("Tc2:-firstname validate with complete form fill web2Lead  testcase Passed");
        } catch (Exception e) {
            e.printStackTrace();

            log.info("Tc2:-firstname validate with complete form fill web2Lead  testcase Failed");
            System.out.println("Tc2:-firstname validate with complete form fill web2Lead  testcase Failed");
        }
    }

    @Test(priority = 3)
    public static void web2lead_fillform(String url, WebDriver Driver, String[] csvCell) throws Throwable, Throwable {
        try {
            log.info("Tc3:-Started to fill web2Lead form testcase ");
            // ((JavascriptExecutor) driver).executeScript("window.open()");
            // ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
            // driver.switchTo().window(tab.get(2));
            String web_url = csvCell[0];
            Driver.get(web_url);
            ltpct.w2l_basic_info(Driver, csvCell, url);

            ltpct.w2l_address_info(Driver, csvCell, url);

            ltpct.w2l_other_info(driver, csvCell, web_url);

            ltpct.submit_info(driver, csvCell, web_url);
            Utils.bigSleepBetweenClicks(1);

            log.info("Tc3:-web2Lead formfillup testcase passed");
            System.out.println("Tc3:-web2Lead formfillup testcase passed");

        } catch (Exception e) {

            e.printStackTrace();
            log.info("Tc3:-web2Lead formfillup testcase failed");
            System.out.println("Tc3:-web2Lead formfillup testcase failed");

        }
    }

    @Test(priority = 4)
    public static void Apploginwithinvalidnumber(String app_url, WebDriver driver2, String[] csvCell) throws Throwable

    {
        try {
            ((JavascriptExecutor) driver).executeScript("window.open()");
            ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tab.get(6));

            String url = csvCell[1];
            driver2.get(url);
            Utils.callSendkeys(driver, ActionXpath.addphone, "9080504030", "enter no");
            Utils.clickXpath(driver, ActionXpath.getotp, time, "getotp");
            Thread.sleep(3000);
            WebElement getalert = driver.findElement(By.xpath("//div[@role='alert']"));
            String message = getalert.getText();

            System.out.println(message);

            log.info("Tc4:-Application with invalidnumber testcase passed");
            System.out.println("Tc4:-Application with invalidnumber testcase passed");
        } catch (Exception e) {
            e.printStackTrace();

            log.info("Tc4:-Application with invalidnumber testcase failed");
            System.out.println("Tc4:-Application with invalidnumber testcase failed");
        }
    }

    @Test(priority = 5)
    public static void Application_fillandfilesizecheck(String app_url, WebDriver driver, String[] csvCell, Logger log)
            throws Throwable

    {
        try {
            ((JavascriptExecutor) driver).executeScript("window.open()");
            ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tab.get(7));

            String url = csvCell[1];
            driver.get(url);

            ltpct.login_ltpct(app_url, driver, csvCell);
            ltpct.Appbasic_info(app_url, driver, csvCell, log);
            ltpct.family_info(app_url, driver, csvCell, log);
            ltpct.Address_info(app_url, driver, csvCell, log);
            ltpct.qualification_info(app_url, driver, csvCell, log);
            ltpct.uploadfile_info(app_url, driver, csvCell);
            ltpct.signout_app(app_url, driver, csvCell);

            ltpct.salesforce_applicationviewanddelete(url, driver, csvCell);

            log.info("Tc5:-Application form_fill and file_size check testcase and application delete passed");
            System.out.println("Tc5:-Application form_fill and file_size check testcase and application delete passed");
        } catch (Exception e) {
            e.printStackTrace();

            log.info("Tc5:-Application form_fill and file_size check testcase and application delete failed");
            System.out.println("Tc5:-Application form_fill and file_size check testcase and application delete failed");
        }
    }

    @Test(priority = 6)
    public static void Admissionfillform(String app_url, WebDriver driver, String[] csvCell, Logger log)
            throws Throwable {
        try {

            log.info("Tc:-Started filling Application form");
            String Sfurl = csvCell[9];
            String url = csvCell[0];

            ltpct.SalesforceBackendDELETE(driver, log, csvCell, Sfurl);

            driver.get(url);
            ltpct.login_ltpct(app_url, driver, csvCell);
            ltpct.ApplyforCourse(url, driver, csvCell, log);
            ltpct.Appbasic_info(app_url, driver, csvCell, log);
            ltpct.family_info(app_url, driver, csvCell, log);
            ltpct.Address_info(app_url, driver, csvCell, log);
            ltpct.qualification_info(app_url, driver, csvCell, log);
            ltpct.Multipleuploadfile_info(app_url, driver, csvCell, log);
            // ltpct.checkbox(app_url, driver, csvCell);
            ltpct.submit_app(app_url, driver, csvCell);

            // ltpct.signout_app(app_url, driver, csvCell);
            log.info("Tc:-Application login,fileuploadandsubmit testcase passed");

        } catch (Exception e) {
            e.printStackTrace();
            log.warning("Tc:-Application login,fileuploadandsubmit testcase failed");

        }
    }

    @Test(priority = 7)
    public static void salesforce_applicationviewverification(String sal_url, WebDriver driver, String[] csvCell)
            throws java.lang.Exception

    {
        try {

            // ((JavascriptExecutor) driver).executeScript("window.open()");
            // ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
            // driver.switchTo().window(tab.get(4));

            String url = csvCell[40];
            driver.get(url);
            ltpct.salesforce_login(sal_url, driver, csvCell);
            ltpct.clickonApplicationandverify(sal_url, driver, csvCell);

            // Utils.profile_logout(sal_url, driver, csvCell);
            log.info("Tc7:-Salesforce Application view and verification passed");
            System.out.println("Tc7:-Salesforce Application view and verification testcase passed");
        } catch (Exception e) {
            e.printStackTrace();
            log.info("Tc7:-Salesforce Application view and verification failed");
            System.out.println("Tc7:-Salesforce Application view and verification testcase failed");

        }
    }

    @Test(priority = 8)
    public static void SalesforceBackendDELETE(WebDriver driver, Logger log, String[] csvCell, String Tname)
            throws Exception {
        try {

            ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
            if (!Tname.equals("T1")) {
                // driver.switchTo().window(tab.get(1));
            }

            // ((JavascriptExecutor) driver).executeScript("window.open()");
            // ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
            // driver.switchTo().window(tab.get(5));

            // String url = csvCell[40];
            String sal_url = csvCell[9];
            driver.get(sal_url);
            ltpct.salesforce_login(sal_url, driver, csvCell);
            ltpct.clickonApplicationandselect(sal_url, driver, csvCell);

            // ltpct.profile_logout(sal_url, driver, csvCell);
            log.info("Tc8:-Salesforce Application view and delete testcase passed");
            System.out.println("Tc8:-Salesforce Application view and delete testcase passed");
        } catch (Exception e) {
            e.printStackTrace();
            log.info("Tc8:-Salesforce Application view and delete testcase failed");
            System.out.println("Tc8:-Salesforce Application view and delete testcase failed");

        }
    }

    @Test(priority = 9)
    public static void salesforce_loginviewMarkdelete(String sal_url, WebDriver driver2, String[] csvCell)
            throws java.lang.Exception

    {
        try {
            ((JavascriptExecutor) driver).executeScript("window.open()");
            ArrayList<String> tab11 = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tab11.get(8));

            String url = csvCell[40];
            driver.get(url);
            ltpct.salesforce_login(sal_url, driver2, csvCell);
            ltpct.clickonleadandselect(sal_url, driver2, csvCell);
            ltpct.markasStatus(sal_url, driver2, csvCell);
            ltpct.selectsaveanddelete(sal_url, driver2, csvCell);
            ltpct.profile_logout(sal_url, driver2, csvCell);
            log.info("Tc9:-Salesforce login,view,mark and delete testcase passed");
            System.out.println("Tc9:-Salesforce login,view,mark and delete testcase passed");
        } catch (Exception e) {
            e.printStackTrace();
            log.info("Tc9:-Salesforce login,view,mark and delete testcase Failed");
            System.out.println("Tc9:-Salesforce login,view,mark and delete testcase Failed");
        }
    }

    @AfterMethod
    public static void quitDriver(String Url) throws Exception {
        log.info("Close window  of portal" + Url);
        log.info("\n");
        // driver.quit();
    }
}