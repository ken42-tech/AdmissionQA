package com.ken42;

import java.util.ArrayList;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
            Utils.smallSleepBetweenClicks(1);
            Utils.getAndSentOTP(driver, Email, Password);
            Utils.clickXpath(driver, ActionXpath.Verifylogin, time, "Verift the Login ");
        } catch (Exception e) {
            Utils.printException(e);

            throw (e);
        }
    }

    public static void documents(String url, WebDriver driver, String[] csvCell) throws Exception {
        try {

            String subject = csvCell[13];
            String mark10sheetupload = "C:\\Users\\Public\\Documents\\demo.pdf";
            String mark12sheetupload = "C:\\Users\\Public\\Documents\\demo.pdf";

            Utils.clickXpath(driver, ActionXpath.clickdocument, time, "clickdocument");
            Utils.smallSleepBetweenClicks(1);
            System.out.println(subject);
            Utils.smallSleepBetweenClicks(2);
            // Actions act=new Actions(driver);

            WebDriverWait wait = new WebDriverWait(driver, 20);
            WebElement elem = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("(//*[. and contains(text(),'" + subject + "')]/../../..//*[local-name()='svg'])[1]/..")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);
            Thread.sleep(2000);

            // Utils.clickXpath(driver, ActionXpath.selectdocumnentdropdown, time,
            // "selectdocumnentdropdown");

            Thread.sleep(4000);

            driver.findElement(By.xpath("(//*[text()='Std 10th Mark sheet']/../..//input[@type='file'])[1]"))
                    .sendKeys(mark10sheetupload);

            Utils.smallSleepBetweenClicks(2);
            Utils.clickXpath(driver, ActionXpath.mark10download, time, "mark10download");
            Utils.bigSleepBetweenClicks(1);

            Utils.clickXpath(driver, ActionXpath.mark10view, time, "mark10view");

            driver.navigate().refresh();

            Utils.bigSleepBetweenClicks(1);

            Utils.clickXpath(driver, ActionXpath.clickdocument, time, "clickdocument");
            Utils.smallSleepBetweenClicks(1);
            System.out.println(subject);
            Utils.smallSleepBetweenClicks(2);

            WebDriverWait wait23 = new WebDriverWait(driver, 20);
            WebElement elem23 = wait23.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("(//*[. and contains(text(),'" + subject + "')]/../../..//*[local-name()='svg'])[1]/..")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem23);
            Thread.sleep(2000);
            driver.findElement(By.xpath("(//*[text()='Std 12th Mark sheet']/../..//input[@type='file'])[1]"))
                    .sendKeys(mark12sheetupload);

            Utils.smallSleepBetweenClicks(1);
            Utils.clickXpath(driver, ActionXpath.mark12download, time, "mark12download");
            Utils.bigSleepBetweenClicks(1);

            Utils.clickXpath(driver, ActionXpath.mark12view, time, "mark12view");
            driver.navigate().refresh();

        } catch (Exception e) {
            Utils.printException(e);
            throw (e);
        }
    }

    public static void sf_login(String url, WebDriver driver, String[] csvCell, Logger log) {
        try {
            ((JavascriptExecutor) driver).executeScript("window.open()");
            ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tab.get(1));
            String Sfurl = csvCell[9];

            driver.get(Sfurl);
            String SfEmail = csvCell[10];
            String SfPassword = csvCell[11];

            Utils.callSendkeys(driver, ActionXpath.SalesforceEmail, SfEmail, "enter salesforce email");
            Utils.callSendkeys(driver, ActionXpath.SalesforcePassword, SfPassword, "Enter your password");
            Utils.clickXpath(driver, ActionXpath.loginSalesforce, time, "click on login salesforce");
            Utils.bigSleepBetweenClicks(1);

            Utils.clickXpath(driver, ActionXpath.clickondots, time, "click on clickondots");

            Utils.clickXpath(driver, ActionXpath.spadmin, time, "click on spadmin");

            Thread.sleep(7000);
            WebDriverWait wait = new WebDriverWait(driver, 20);
            WebElement e = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Applications']")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", e);

            System.out.println("click on Application");
            Thread.sleep(5000);
            String Applicant = csvCell[12];
            Utils.callSendkeys(driver, ActionXpath.listsearch, Applicant, "Search for student name");
            Utils.clickXpath(driver, ActionXpath.clickstudent, time, "click on clickstudent");

            // List<WebElement> clickapplicant =
            // driver.findElements(By.xpath("//table//tbody//td[3]//a"));

            // for (int i = 0; i < clickapplicant.size(); i++) {

            // if (clickapplicant.get(i).getText().contains(Applicant)) {
            // clickapplicant.get(i).click();

            // break;
            // }

            // }
            Thread.sleep(3000);

            Utils.clickXpath(driver, ActionXpath.application, time, "click on application ");
            Thread.sleep(2000);

            Utils.clickXpath(driver, ActionXpath.window, time, "click on window ");

            WebElement element = wait.until(ExpectedConditions
                    .elementToBeClickable(By.xpath("//span[.='Mark Application Status as Complete']")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            Thread.sleep(4000);
            // driver.switchTo().window(tab.get(0));

            WebElement element41 = wait.until(ExpectedConditions
                    .elementToBeClickable(By.xpath("//span[.='Mark Application Status as Complete']")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element41);
            Thread.sleep(4000);
            // driver.switchTo().window(tab.get(0));

            WebElement element42 = wait.until(ExpectedConditions
                    .elementToBeClickable(By.xpath("//span[.='Mark Application Status as Complete']")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element42);
            Thread.sleep(4000);
            driver.switchTo().window(tab.get(0));

            // driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "\t");

        }

        catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void documentUpload(String url, String sfurl, WebDriver driver, String[] csvCell, Logger log)
            throws Exception {
        try {
            System.out.println("TC-3: Fill form with validation test started Executation ");
            login(url, driver, csvCell);

            // fess.sf_login(sfurl, driver, csvCell, log);
            sf_login(sfurl, driver, csvCell, log);
            documents(url, driver, csvCell);

            log.info("TC-3: Fill form with validation test Completed and Passed ");

        } catch (Exception e) {
            log.warning("TC-3: Fill form with validation test Failed");
            Utils.printException(e);
            throw (e);

        }
    }
}
