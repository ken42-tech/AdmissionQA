package com.ken42;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Fees_part {

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

	
	public static void sf_login(String Sfurl, String url, WebDriver driver, String[] csvCell, Logger log)
	{
		try {
			driver.get(Sfurl);
			String SfEmail = csvCell[74];
			String SfPassword = csvCell[75];
			
			
			Utils.callSendkeys(driver, ActionXpath.SalesforceEmail, SfEmail, "enter salesforce email");
			Utils.callSendkeys(driver, ActionXpath.SalesforcePassword, SfPassword, "Enter your password");
			Utils.clickXpath(driver, ActionXpath.loginSalesforce, time, "click on login salesforce");
			Utils.bigSleepBetweenClicks(1);

			WebDriverWait wait = new WebDriverWait(driver, 20);
			WebElement e = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Applications']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", e);

			System.out.println("click on Application");
			Thread.sleep(5000);

			List<WebElement> clickapplicant = driver.findElements(By.xpath("//table//tbody//td[3]//a"));
			String Applicant = csvCell[88];
			for (int i = 0; i < clickapplicant.size(); i++) {

				if (clickapplicant.get(i).getText().contains(Applicant)) {
					clickapplicant.get(i).click();

					break;
				}

			}
			Thread.sleep(3000);
			// driver.findElement(By.xpath("(//a[.='Applications'])[2]")).click();

			Utils.clickXpath(driver, ActionXpath.application, time, "click on application ");
			Thread.sleep(2000);
			// driver.findElement(By.xpath("//span[@id='window']")).click();
			Utils.clickXpath(driver, ActionXpath.window, time, "click on window ");

			// WebDriverWait wait=new WebDriverWait(driver, 20);
    			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='Mark Application Status as Complete']")));
    			((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);

			//Utils.clickXpath(driver, ActionXpath.mark, time, "click on mark");
			// WebDriverWait wait=new WebDriverWait(driver, 20);
//    			WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='Mark Application Status as Complete']")));
//    			((JavascriptExecutor)driver).executeScript("arguments[0].click();", element1);

			

		}
		
		catch (Exception e) {
			e.printStackTrace();
		}	
		
		
	}
	
	public static void Sf_Fees_part(String Sfurl, String url, WebDriver driver, String[] csvCell, Logger log)
			throws Exception {

		try {
		
			
			String email=csvCell[81];
			String fname=csvCell[82];
			String sname=csvCell[83];
			String addressofpayer=csvCell[84];
			String cityofpayer=csvCell[85];
			String pnumber=csvCell[86];
			String dateofbirth=csvCell[87];
			
			
//    					driver.get("https://dev-playground-admissionportal.ken42.com/login");
//    					System.out.print("pass  the url");
//    					
//    					System.out.println("enter the email");
//    					driver.findElement(By.xpath("//input[@name='id']")).sendKeys("sachin.jb@ken42.com");
//    					System.out.println("click on verify login");
//    					driver.findElement(By.xpath("//button[@type='submit']")).click();
//    					Thread.sleep(30000);
//    					System.out.println("click on verify");
//    					driver.findElement(By.xpath("//button[@type='submit']")).click();

		//	login(url, driver, csvCell, log);

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
			Thread.sleep(3000);

			Utils.callSendkeys(driver, ActionXpath.fname, fname, "Enter fname");

			//Thread.sleep(3000);

			Utils.callSendkeys(driver, ActionXpath.familyname,sname, "Enter familyname");

			Thread.sleep(1000);
			js.executeScript("window.scrollBy(0,300)");
			Thread.sleep(3000);
			Utils.callSendkeys(driver, ActionXpath.address1, addressofpayer, "Enter address");

			Thread.sleep(3000);

			Utils.callSendkeys(driver, ActionXpath.city1, cityofpayer, "Enter city");

			Thread.sleep(3000);

			Utils.callSendkeys(driver, ActionXpath.phno, pnumber, "Enter pno");

			js.executeScript("window.scrollBy(0,2000)");
			Thread.sleep(3000);

			Thread.sleep(5000);
			Utils.clickXpath(driver, ActionXpath.terms, time, "click on terms ");

			Thread.sleep(5000);
			js.executeScript("window.scrollBy(0,2000)");
			Utils.clickXpath(driver, ActionXpath.next, time, "click on next ");

			Thread.sleep(3000);

			Utils.callSendkeys(driver, ActionXpath.dobfe, dateofbirth, "Enter Date of birth");
			js.executeScript("window.scrollBy(0,2000)");

			Thread.sleep(5000);
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
			Thread.sleep(5000);

			driver.switchTo().frame(0);

			Actions action = new Actions(driver);
			System.out.println("click");
			WebElement eleme = driver.findElement(By.xpath("(//div[@class='sc-gXfVKN iaWjVc'])[2]"));

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
			Thread.sleep(8000);
			WebElement elea = driver.findElement(By.xpath("//h3[@class='sc-dlnjwi dRMjYq']"));

			String otp = elea.getText();
			System.out.println(otp);
			Thread.sleep(5000);
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys(otp);
			Thread.sleep(7000);
			WebElement l2 = driver.findElement(By.xpath("//span[text()='Continue']"));
			Actions c2 = new Actions(driver);
			c2.moveToElement(l2).click().perform();
			
			
			
			Thread.sleep(3000);
			
			// driver.findElement(By.xpath("//span[text()='Continue']")).click();
			driver.findElement(By.xpath("(//div[@class='sc-giAqHp ijQirQ'])[2]")).click();
			Thread.sleep(7000);
			WebElement l = driver.findElement(By.xpath("//span[text()='Continue']"));
			Actions c = new Actions(driver);
			c.moveToElement(l).click().perform();

			Thread.sleep(8000);
			WebElement elee = driver.findElement(By.xpath("//h3[@class='sc-dlnjwi dRMjYq']"));

			String otp1 = elee.getText();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys(otp1);
			Thread.sleep(6000);
			WebElement lv = driver.findElement(By.xpath("//button[@data-testid='continue-button']"));
			Actions cv = new Actions(driver);
			cv.moveToElement(lv).click().perform();

			Thread.sleep(6000);
			js.executeScript("window.scrollBy(0,1500)");

			Thread.sleep(6000);
			WebElement lve = driver.findElement(By.xpath("//button[@data-testid='returnCallToActionButton']"));
			Actions cve = new Actions(driver);
			cve.moveToElement(lve).click().perform();

			//    				

//    					ArrayList<String> tabs45651 = new ArrayList<String>(driver.getWindowHandles());
//    					driver.switchTo().window(tabs45651.get(0));
//    				
//    					Utils.clickXpath(driver, Actionxpath.fees, time, "click on fees Payment ");
//    					Thread.sleep(3000);
//    					WebElement element421 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@title='Toggle Row Expanded'])[1]")));
//    					((JavascriptExecutor)driver).executeScript("arguments[0].click();", element421);
//    			
//    					Thread.sleep(3000);
//    					WebElement element221 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h6[.='Download Receipt']")));
//    					((JavascriptExecutor)driver).executeScript("arguments[0].click();", element221);
//    			

		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
