package com.ken42;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;
import java.util.regex.Pattern;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.lang3.RandomStringUtils;

public class Utils {
	static Logger log = Logger.getLogger(Utils.class.getName());
	static int time = 1000;

	public static String clickXpath(WebDriver driver, String xpath, int time, String msg) throws Exception {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		int count = 0;
		int maxTries = 7;
		while (true) {
			try {
				Thread.sleep(250);
				log.info("Click on the:" + msg);
				new WebDriverWait(driver, 20, 500).until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)))
						.click();
				break;
			} catch (Exception e) {
				Thread.sleep(3000);
				log.warning("Failed to Click on the :" + msg);
				if (++count == maxTries) {
					Utils.printException(e);
					throw e;
				}
			}
		}
		return msg;

	}

	static void printException(Exception e) {
		log.warning("Exception is  " + e);

	}

	public static void callSendkeys(WebDriver driver, String Xpath, String Value, String string) throws Exception {
		int count = 0;
		int maxTries = 4;
		while (true) {
			try {
				log.info("Entering value" + Value);
				Thread.sleep(250);
				new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.xpath(Xpath)))
						.sendKeys(Value);
				Thread.sleep(250);

				break;
			} catch (Exception e) {
				Thread.sleep(250);
				log.warning("Failed to send value  " + Value);
				if (++count == maxTries) {
					Utils.printException(e);
					throw e;
				}
			}
		}
	}

	public static void getAndSentOTP(WebDriver driver, String email, String password) throws Exception {
		String OTP = "";
		OTP = readOTP.check("imap.gmail.com", "imap", email, password);

		// Thread.sleep(400);
		System.out.println("OTP ***** " + OTP);
		Utils.callSendkeys(driver, ActionXpath.Inputotp, OTP, "OTP");

	}

	public static String genrateRandomEmailid() {
		String emailAddress = "";
		String randomText = "abcdefghijklmnopqrstuvwxyz";
		String temp = RandomStringUtils.random(5, randomText);
		String domain = RandomStringUtils.random(3, randomText);
		emailAddress = temp + "@yay" + "." + domain;
		return emailAddress;
	}

	@Test
	public static void bigSleepBetweenClicks(int loop) throws InterruptedException {
		int total_time = 5000 * loop;
		System.out.println("Sleeping for " + total_time);
		Thread.sleep(5000 * loop);
	}

	@Test
	public static void smallSleepBetweenClicks(int loop) throws InterruptedException {
		int total_time = 2000 * loop;
		System.out.println("Sleeping for " + total_time);
		Thread.sleep(2000 * loop);
	}

	public static boolean checkWindowsOs() {
		String OS = "";
		OS = System.getProperty("os.name");
		System.out.println(OS);

		if (OS.contains("Windows")) {
			return true;
		}
		return false;

	}

	@Test
	public static void scrollUpOrDown(WebDriver driver, int pixel) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,125)");
	}

	public static void cleartext(WebDriver driver, String Xpath) throws Exception {
		int count = 0;
		int maxTries = 4;
		while (true) {
			try {
				log.info("clear value");

				Thread.sleep(250);
				WebElement elee = driver.findElement(By.xpath(Xpath));
				elee.sendKeys(Keys.CONTROL, "a", Keys.DELETE);

				break;
			} catch (Exception e) {
				Thread.sleep(250);
				log.warning("Failed to clear value  ");
				if (++count == maxTries) {
					Utils.printException(e);
					throw e;
				}
			}
		}
	}

	@Test
	public static String getTEXT(WebDriver driver, String xpath) throws Exception {
		int count = 0;
		int maxTries = 7;
		String HtmlText = "";
		while (true) {
			try {
				WebElement p = driver.findElement(By.xpath(xpath));
				HtmlText = p.getText();
				return HtmlText;
			} catch (Exception e) {
				Utils.smallSleepBetweenClicks(1);
				if (++count > maxTries) {
					throw (e);
				}
			}
		}
	}

	public static void selectFromDropDown(String listXpath, String choice, WebDriver driver) {
		java.util.List<WebElement> list = driver.findElements(By.xpath(listXpath));
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getText().startsWith(choice)) {
				list.get(i).click();
				break;
			}
		}
	}

	
	//// ..................................ltpct
	//// code...............................................////

	public static void clickXpathWithScroll(WebDriver driver, String xpath, int time, String msg) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int count = 0;
		int maxTries = 7;
		while (true) {
			try {
				Thread.sleep(1000);
				log.info("Click on the:" + msg);
				WebElement el = driver.findElement(By.xpath(xpath));
				js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'start' });", el);
				el.click();
				break;
			} catch (Exception e) {
				Thread.sleep(3000);
				Utils.printException(e);
				log.warning("Failed to Click on the :" + msg);
				if (++count == maxTries) {
					Utils.printException(e);
					throw e;
				}
			}
		}
	}

	@Test
	public static void goBackToHome(WebDriver driver, String url) throws InterruptedException {
		driver.navigate().to(url);
		smallSleepBetweenClicks(1);
	}

	@Test
	public static void vsmallSleepBetweenClicks(int loop) throws InterruptedException {
		int total_time = 2000 * loop;
		System.out.println("Sleeping for " + total_time);
		Thread.sleep(2000 * loop);
	}

	public static void smallSleepBetweenClicks1(int loop) throws InterruptedException {
		int total_time = 4000 * loop;
		System.out.println("Sleeping for " + total_time);
		Thread.sleep(4000 * loop);
	}

	@Test
	public static void bigSleepBetweenClicks1(int loop) throws InterruptedException {
		int total_time = 7000 * loop;
		System.out.println("Sleeping for " + total_time);
		Thread.sleep(7000 * loop);
	}

	@Test
	public static void vbigSleepBetweenClicks(int loop) throws InterruptedException {
		int total_time = 10000 * loop;
		System.out.println("Sleeping for " + total_time);
		Thread.sleep(10000 * loop);
	}

	@Test
	public static int generateRandom() {
		double num = (int) Math.round(Math.random() * 10000);
		int num1 = (int) num;
		return num1;
	}

	// public static void executeLongWait(String url) throws InterruptedException {
	// String urlToMatch = "ltpct";
	// Pattern pt = Pattern.compile(urlToMatch);
	// java.util.regex.Matcher m = pt.matcher(url);
	// while (m.find()) {
	// bigSleepBetweenClicks(2);
	// }
	// }

	@Test
	public static Boolean userlogin(String url) {
		String urlToMatch = "nitte|enquire-samsung";
		Pattern pt = Pattern.compile(urlToMatch);
		java.util.regex.Matcher m = pt.matcher(url);
		while (m.find()) {
			return true;
		}
		return false;
	}

	@Test
	public static Boolean checkmiddlename(String url) {
		String urlToMatch = "nitte|enquire-samsung";
		Pattern pt = Pattern.compile(urlToMatch);
		java.util.regex.Matcher m = pt.matcher(url);
		while (m.find()) {
			return true;
		}
		return false;
	}

	@Test
	public static Boolean checkadditionalphone(String url) {
		String urlToMatch = "nitte|enquire-samsung";
		Pattern pt = Pattern.compile(urlToMatch);
		java.util.regex.Matcher m = pt.matcher(url);
		while (m.find()) {
			return true;
		}
		return false;
	}

	@Test
	public static Boolean checkToskipdob(String url) {
		String urlToMatch = "nitte|enquire-samsung";
		Pattern pt = Pattern.compile(urlToMatch);
		java.util.regex.Matcher m = pt.matcher(url);
		while (m.find()) {
			return true;
		}
		return false;
	}

	@Test
	public static Boolean checkToskipcourse(String url) {
		String urlToMatch = "ltpct|nitte";
		Pattern pt = Pattern.compile(urlToMatch);
		java.util.regex.Matcher m = pt.matcher(url);
		while (m.find()) {
			return true;
		}
		return false;
	}

	@Test
	public static Boolean checkToskipcours(String url) {
		String urlToMatch = "ltpct|essci";
		Pattern pt = Pattern.compile(urlToMatch);
		java.util.regex.Matcher m = pt.matcher(url);
		while (m.find()) {
			return true;
		}
		return false;
	}

	@Test
	public static Boolean checkToskip(String url) {
		String urlToMatch = "enquire-samsung";
		Pattern pt = Pattern.compile(urlToMatch);
		java.util.regex.Matcher m = pt.matcher(url);
		while (m.find()) {
			return true;
		}
		return false;
	}

	@Test
	public static Boolean checkToskipnitte(String url) {
		String urlToMatch = "enquire-samsung|nitte";
		Pattern pt = Pattern.compile(urlToMatch);
		java.util.regex.Matcher m = pt.matcher(url);
		while (m.find()) {
			return true;
		}
		return false;
	}

	@Test
	public static Boolean checkTodropdown(String url) {
		String urlToMatch = "nitte";
		Pattern pt = Pattern.compile(urlToMatch);
		java.util.regex.Matcher m = pt.matcher(url);
		while (m.find()) {
			return true;
		}
		return false;
	}

	@Test
	public static Boolean checkage(String url) {
		String urlToMatch = "ltpct|nitte";
		Pattern pt = Pattern.compile(urlToMatch);
		java.util.regex.Matcher m = pt.matcher(url);
		while (m.find()) {
			return true;
		}
		return false;
	}

	@Test
	public static Boolean checkToskipurlnotmatching(String url) {
		String urlToMatch = "enquire-samsung";
		Pattern pt = Pattern.compile(urlToMatch);
		java.util.regex.Matcher m = pt.matcher(url);
		while (m.find()) {
			return true;
		}
		return false;
	}

	@Test
	public static Boolean checktraining(String url) {
		String urlToMatch = "enquire-samsung";
		Pattern pt = Pattern.compile(urlToMatch);
		java.util.regex.Matcher m = pt.matcher(url);
		while (m.find()) {
			return true;
		}
		return false;
	}

	@Test
	public static Boolean checkadhar(String url) {
		String urlToMatch = "ltpct|nitte";
		Pattern pt = Pattern.compile(urlToMatch);
		java.util.regex.Matcher m = pt.matcher(url);
		while (m.find()) {
			return true;
		}
		return false;
	}

	@Test
	public static Boolean checcourse(String url) {
		String urlToMatch = "ltpct|nitte";
		Pattern pt = Pattern.compile(urlToMatch);
		java.util.regex.Matcher m = pt.matcher(url);
		while (m.find()) {
			return true;
		}
		return false;
	}

	@Test
	public static Boolean checkaadhar(String url) {
		String urlToMatch = "enquire-samsung";
		Pattern pt = Pattern.compile(urlToMatch);
		java.util.regex.Matcher m = pt.matcher(url);
		while (m.find()) {
			return true;
		}
		return false;
	}

	@Test
	public static Boolean checkenquire(String url) {
		String urlToMatch = "enquire-samsung";
		Pattern pt = Pattern.compile(urlToMatch);
		java.util.regex.Matcher m = pt.matcher(url);
		while (m.find()) {
			return true;
		}
		return false;
	}

	@Test
	public static Boolean checkboxSkip(String url) {
		String urlToMatch = "enquire-samsung|nitte";
		Pattern pt = Pattern.compile(urlToMatch);
		java.util.regex.Matcher m = pt.matcher(url);
		while (m.find()) {
			return true;
		}
		return false;
	}

	@Test
	public static Boolean checkmarkasstatus(String url) {
		String urlToMatch = "ltpct|nitte";
		Pattern pt = Pattern.compile(urlToMatch);
		java.util.regex.Matcher m = pt.matcher(url);
		while (m.find()) {
			return true;
		}
		return false;
	}

}