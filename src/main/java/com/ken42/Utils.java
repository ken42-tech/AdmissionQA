package com.ken42;

import java.util.logging.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;

public class Utils {
	static Logger log = Logger.getLogger(Utils.class.getName());
	static int time = 1000;
	private static CharSequence result;

	public static void clickXpath(WebDriver driver, String xpath, int time, String msg) throws Exception {
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		int count = 0;
		int maxTries = 4;
		while (true) {
			try {
				Thread.sleep(1000);
				log.info("Click on the:" + msg);
				new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();
				break;
			} catch (Exception e) {
				Thread.sleep(500);
				log.warning("Failed to Click on the :" + msg);
				if (++count == maxTries) {
					Utils.printException(e);
					throw e;
				}
			}
		}
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
				Thread.sleep(1000);
				new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.xpath(Xpath)))
						.sendKeys(Value);
				Thread.sleep(500);

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

	@Test
	public static void bigSleepBetweenClicks(int loop) throws InterruptedException {
		int total_time = 7000 * loop;
		System.out.println("Sleeping for " + total_time);
		Thread.sleep(7000 * loop);
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
		js.executeScript("window.scrollBy(0,100)");
	}

	public static void cleartext(WebDriver driver, String Xpath) throws Exception {
		int count = 0;
		int maxTries = 4;
		while (true) {
			try {
				log.info("clear value");

				Thread.sleep(4000);
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
}