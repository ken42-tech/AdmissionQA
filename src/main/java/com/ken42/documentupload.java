package com.ken42;

import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class documentupload {
    public static Logger log = Logger.getLogger("App_portal");
    static int time = 2000;
    public static WebDriver driver;

    public static void login(String url, WebDriver driver, String[] csvCell) throws Exception {
        try {
            String Email = csvCell[2];
            String Password = csvCell[3];

            Thread.sleep(3000);
            Utils.callSendkeys(driver, ActionXpath.EnterEmail, Email, "Enter r mail address ");
            Utils.clickXpath(driver, ActionXpath.Verify, time, "verify");
            Utils.bigSleepBetweenClicks(1);
            Utils.getAndSentOTP(driver, Email, Password);
            Utils.clickXpath(driver, ActionXpath.Verifylogin, time, "Verift the Login ");
        } catch (Exception e) {
            Utils.printException(e);

            throw (e);
        }
    }

    public static void documents(String url, WebDriver driver, String[] csvCell) throws Exception {
        try {

            String mark10sheetupload = "C:\\Users\\Public\\Documents\\demo.pdf";

            Utils.clickXpath(driver, ActionXpath.clickdocument, time, "clickdocument");
            Utils.smallSleepBetweenClicks(1);
            Utils.clickXpath(driver, ActionXpath.selectdocumnentdropdown, time, "selectdocumnentdropdown");
            // Utils.callSendkeys(driver, ActionXpath.mark10sheetupload, mark10sheetupload,
            //
            Thread.sleep(4000);

            driver.findElement(By.xpath("//*[text()='Std 10th Mark sheet']/../..//input[@type='file']"));
            Thread.sleep(4000);

            Utils.clickXpath(driver, ActionXpath.mark10view, time, "mark10view");
        } catch (Exception e) {
            Utils.printException(e);
            throw (e);
        }
    }

    public static void documentUpload(String url, String sfurl, WebDriver driver, String[] csvCell, Logger log)
            throws Exception {
        try {
            System.out.println("TC-3: Fill form with validation test started Executation ");

            login(url, driver, csvCell);
            documents(url, driver, csvCell);

            log.info("TC-3: Fill form with validation test Completed and Passed ");

        } catch (Exception e) {
            log.warning("TC-3: Fill form with validation test Failed");
            Utils.printException(e);
            throw (e);

        }
    }
}
