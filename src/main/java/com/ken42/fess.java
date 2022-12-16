package com.ken42;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class fess {

    public static Logger log = Logger.getLogger("App_portal");
    static int time = 2000;
    public static WebDriver driver;

    public static void login(String url, WebDriver driver, String[] csvCell, Logger log) throws Exception {
        try {

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
            driver.switchTo().window(tab.get(0));

            // driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "\t");

        }

        catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void Sf_Fees_part(String Sfurl, String url, WebDriver driver, String[] csvCell, Logger log)
            throws Exception {

        try {

            ((JavascriptExecutor) driver).executeScript("window.open()");
            ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tab.get(0));
            // login(url, driver, csvCell, log);
            driver.navigate().refresh();

            String email = csvCell[83];
            String fname = csvCell[84];
            String sname = csvCell[85];
            String addressofpayer = csvCell[86];
            String cityofpayer = csvCell[87];
            String pnumber = csvCell[88];
            String dateofbirth = csvCell[89];

            Utils.clickXpath(driver, ActionXpath.fees, time, "click on fees Payment ");

            Utils.clickXpath(driver, ActionXpath.pay, time, "click on pay ");

            Utils.clickXpath(driver, ActionXpath.paynow, time, "click on paynow ");

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,2000)");
            Thread.sleep(5000);

            Utils.clickXpath(driver, ActionXpath.paynow, time, "click on paynow again ");
            Thread.sleep(10000);

            Set<String> allWindowHandles = driver.getWindowHandles();
            for (String handle : allWindowHandles) {
                driver.switchTo().window(handle);
            }
            Thread.sleep(15000);
            // JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,2000)");
            Thread.sleep(5000);
            Utils.clickXpath(driver, ActionXpath.next, time, "click on next ");

            Thread.sleep(5000);
            Utils.clickXpath(driver, ActionXpath.trusty, time, "click on trusty ");

            Utils.callSendkeys(driver, ActionXpath.email, email, "Enter email");

            Utils.callSendkeys(driver, ActionXpath.fname, fname, "Enter fname");

            // Thread.sleep(3000);

            Utils.callSendkeys(driver, ActionXpath.familyname, sname, "Enter familyname");

            // Thread.sleep(1000);
            js.executeScript("window.scrollBy(0,300)");
            // Thread.sleep(3000);
            Utils.callSendkeys(driver, ActionXpath.address1, addressofpayer, "Enter address");

            // Thread.sleep(3000);

            Utils.callSendkeys(driver, ActionXpath.city1, cityofpayer, "Enter city");

            // Thread.sleep(3000);

            Utils.callSendkeys(driver, ActionXpath.phno, pnumber, "Enter pno");

            js.executeScript("window.scrollBy(0,2000)");
            // Thread.sleep(3000);

            // Thread.sleep(5000);
            Utils.clickXpath(driver, ActionXpath.terms, time, "click on terms ");

            // Thread.sleep(5000);
            js.executeScript("window.scrollBy(0,2000)");
            Utils.clickXpath(driver, ActionXpath.next, time, "click on next ");

            Thread.sleep(3000);

            Utils.callSendkeys(driver, ActionXpath.dobfe, dateofbirth, "Enter Date of birth");
            js.executeScript("window.scrollBy(0,2000)");

            Thread.sleep(7000);
            WebElement ele = driver.findElement(By.xpath("//span[.='Next']"));
            Actions act = new Actions(driver);
            act.moveToElement(ele).click().perform();

            Thread.sleep(3000);

            js.executeScript("window.scrollBy(0,2000)");

            Thread.sleep(4000);
            WebElement elem = driver.findElement(By.xpath("//span[.='Pay']"));
            Actions acti = new Actions(driver);
            acti.moveToElement(elem).click().perform();

            Thread.sleep(15000);

            js.executeScript("window.scrollBy(0,500)");
            Thread.sleep(30000);

            driver.switchTo().frame(0);

            Actions action21 = new Actions(driver);
            System.out.println("click");
            WebElement eleme21 = driver.findElement(By.xpath("//*[text()='Pay with Trustly']/.."));
            action21.moveToElement(eleme21).click().build().perform();
            Thread.sleep(5000);
            Actions action = new Actions(driver);
            System.out.println("click");
            WebElement eleme = driver.findElement(By.xpath("(//div[@class='sc-jgPyTC irGRoe'])[2]"));

            action.moveToElement(eleme).click().build().perform();
            Thread.sleep(5000);
            WebElement ele1 = driver.findElement(By.xpath("//span[text()='Continue']"));
            Actions act1 = new Actions(driver);
            act1.moveToElement(ele1).click().perform();

            Thread.sleep(8000);

            WebElement scroll = driver.findElement(By.xpath("//span[text()='Continue']"));
            js.executeScript("arguments[0].scrollIntoView(true);", scroll);
            scroll.click();

            Thread.sleep(10000);
            WebElement le1 = driver.findElement(By.xpath("//span[text()='Continue']"));
            Actions ct1 = new Actions(driver);
            ct1.moveToElement(le1).click().perform();

            Thread.sleep(8000);
            driver.findElement(By.xpath("//input[@name='loginid']")).sendKeys("1234");
            Thread.sleep(6000);
            WebElement le12 = driver.findElement(By.xpath("//span[text()='Continue']"));
            Actions ct12 = new Actions(driver);
            ct12.moveToElement(le12).click().perform();

            // reading otp
            Thread.sleep(10000);
            WebElement elea = driver.findElement(By.xpath("//*[text()='One-time code']/../..//h3"));

            String otp = elea.getText();
            System.out.println(otp);
            Thread.sleep(5000);
            driver.findElement(By.xpath("//input[@type='password']")).sendKeys(otp);
            Thread.sleep(7000);
            WebElement l2 = driver.findElement(By.xpath("//span[text()='Continue']"));
            Actions c2 = new Actions(driver);
            c2.moveToElement(l2).click().perform();

            Thread.sleep(31000);

            // driver.findElement(By.xpath("//span[text()='Continue']")).click();
            driver.findElement(By.xpath("(//*[@data-testid='headline'])[2]/../..")).click();
            Thread.sleep(7000);
            WebElement l = driver.findElement(By.xpath("//span[text()='Continue']"));
            Actions c = new Actions(driver);
            c.moveToElement(l).click().perform();

            Thread.sleep(18000);
            WebElement elee = driver.findElement(By.xpath("//*[text()='One-time code']/../..//h3"));

            String otp1 = elee.getText();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//input[@type='password']")).sendKeys(otp1);
            Thread.sleep(5000);
            WebElement lv = driver.findElement(By.xpath("//button[@data-testid='continue-button']"));
            Actions cv = new Actions(driver);
            cv.moveToElement(lv).click().perform();

            Thread.sleep(8000);
            js.executeScript("window.scrollBy(0,1500)");

            Thread.sleep(2000);
            WebElement lve = driver.findElement(By.xpath("//button[@data-testid='returnCallToActionButton']"));
            Actions cve = new Actions(driver);
            cve.moveToElement(lve).click().perform();

            //

            // ArrayList<String> tabs45651 = new
            // ArrayList<String>(driver.getWindowHandles());
            // driver.switchTo().window(tabs45651.get(0));
            //
            // Utils.clickXpath(driver, Actionxpath.fees, time, "click on fees Payment ");
            // Thread.sleep(3000);
            // WebElement element421 =
            // wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@title='Toggle
            // Row Expanded'])[1]")));
            // ((JavascriptExecutor)driver).executeScript("arguments[0].click();",
            // element421);
            //
            // Thread.sleep(3000);
            // WebElement element221 =
            // wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h6[.='Download
            // Receipt']")));
            // ((JavascriptExecutor)driver).executeScript("arguments[0].click();",
            // element221);
            //

        }

        catch (Exception e) {
            e.printStackTrace();
        }

    }

}