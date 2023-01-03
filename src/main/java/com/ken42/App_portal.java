package com.ken42;

import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.core.net.UrlConnectionFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import java.util.logging.*;
import java.util.logging.FileHandler;

import com.opencsv.CSVReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class App_portal extends Thread {
	private String[] csvLineData;
	private int count;
	static int time = 1000;
	public static Logger log = Logger.getLogger("App_portal");
	public static String[] students = new String[5];
	public static int ThreadCount = 0;
	public static Boolean headless;

	@Override
	public void run() {
		System.out.println("Thread- Started" + Thread.currentThread().getName());
		String threadname = Thread.currentThread().getName();
		System.out.println(threadname);
		try {
			if (threadname.equals("T1")) {
				System.out.println("In T1 calling SF delete function");
				testDeleteAllApplications();
			} else {
				testAdmissionPortal(this.csvLineData, this.count);
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		} catch (Throwable e) {

			e.printStackTrace();
		}
		System.out.println("Thread- END " + Thread.currentThread().getName());
	}

	public App_portal(String[] csvCell, int count) {
		this.csvLineData = csvCell;
		this.count = count;
	}

	public static void main(String[] args) throws Exception {
		String CSV_PATH = "";
		CSV_PATH = "C:\\Users\\Public\\Documents\\APplication.csv";
		CSVReader csvReader;
		int count = 0;
		CSVReader csvReader1;
		// int ThreadCount = 0;
		csvReader1 = new CSVReader(new FileReader(CSV_PATH));

		String[] csvCell1;
		while ((csvCell1 = csvReader1.readNext()) != null) {
			ThreadCount++;
		}
		System.out.println("Number of threads to start  " + ThreadCount);

		Thread[] threads = new Thread[ThreadCount];

		csvReader = new CSVReader(new FileReader(CSV_PATH));

		String[] csvCell;
		while ((csvCell = csvReader.readNext()) != null) {
			Thread t = new App_portal(csvCell, count);
			threads[count] = t;
			threads[count].setName("T" + String.valueOf(count + 1));
			if (count == 0) {
				count++;
				t.start();
				t.join();
				continue;
			} else {
				Utils.bigSleepBetweenClicks(1);
				t.start();
			}
			count++;
			// Utils.bigSleepBetweenClicks(2);
		}
	}

	public static void testAdmissionPortal(String[] csvCell, int count) throws Throwable {
		String url = csvCell[0];
		String browser = csvCell[1];
		String Email = csvCell[2];
		String password = csvCell[3];
		String From = csvCell[4];
		String To = csvCell[5];
		String sfurl = csvCell[9];
		String vali = csvCell[6];
		int from = Integer.parseInt(From);
		int to = Integer.parseInt(To);
		Logger log = Logger.getLogger("App_portal" + count);
		int portal = 0;
		String folder = "";
		String logFileName = "";
		boolean append = false;
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
		logFileName = String.format("C:\\Users\\Public\\Documents\\Testresult_%s.HTML", timeStamp);
		FileHandler logFile = new FileHandler(logFileName, append);
		logFile.setFormatter(new MyHtmlFormatter());
		log.addHandler(logFile);
		WebDriver driver = null;
		headless = getHeadless(csvCell);
		if (url.contains("sp-jain")) {
			portal = 1;
		} else if (url.contains("apply-sbmpps")) {
			portal = 2;
		} else if (url.contains("ltpct")) {
			portal = 3;
		}

		driver = initDriver(browser, url);
		log.info("**********************Testing for  Portal  " + url);

		// Below If will execute all Student related test cases
		for (int i = from; i <= to; i++) {
			headless = getHeadless(csvCell);

			switch (i) {
				case 1:
					switch (portal) {
						case 1:
							spjain.Admissionfillform(url, driver, csvCell, log);
							break;
						case 2:
							sbmp.Admissionfillform(url, driver, csvCell, log);
							break;
						case 3:
							ltpct.Admissionfillform(sfurl, driver, csvCell, log);
							break;
					}
					break;
				case 2:
					switch (portal) {
						case 1:
							spjain.fess_spjain(sfurl, timeStamp, driver, csvCell, log);
							break;
						case 2:
							System.out.println("SBMP no fee test case");
							break;
						case 3:
							// ltpct.Admissionfillform(sfurl, driver, csvCell);
							break;
					}
					break;
				case 3:
					switch (portal) {
						case 1:
							documentupload.documentUpload(sfurl, url, driver, csvCell, log);
							break;
						case 2:
							System.out.println("SBMP no fee test case");
							break;
					}
					break;
				case 4:
					switch (portal) {
						case 1:
							spjain.SalesforceBackendDELETE(driver, log, csvCell, logFileName);
							break;
						case 2:
							sbmp.SalesforceBackendDELETE(driver, log, csvCell, logFileName);
							break;
						case 3:
							ltpct.SalesforceBackendDELETE(driver, log, csvCell, logFileName);
							break;

					}
					break;
				default:
					System.out.println("Entered Default");
			}
		}
		log.info("***************** COMPLETED TESTTING OF PORTAL" + url);
		// SendMail.sendEmail(logFileName);
		driver.quit();
	}

	@BeforeSuite
	public static WebDriver initDriver(String Browser, String url) throws Exception {

		try {
			WebDriver driver = null;
			String ChromeDriver = "";
			String EdgeDriver = "";
			String FirefoxDriver = "";
			if (Utils.checkWindowsOs()) {
				ChromeDriver = "C:\\Users\\Public\\Documents\\chromedriver.exe";
				EdgeDriver = "C:\\Users\\Public\\Documents\\msedgedriver.exe";
				FirefoxDriver = "C:\\Users\\Public\\Documents\\geckodriver.exe";
			} else {
				ChromeDriver = "Users/shared/chromedriver.exe";
				EdgeDriver = "Users/shared/msedgedriver.exe";
				FirefoxDriver = "Users/shared/geckodriver.exe";
			}

			System.out.println("Browser is $$$$$$" + Browser);
			System.out.println("URL is " + url);
			if ("chrome".equals(Browser)) {
				System.setProperty("webdriver.chrome.driver", ChromeDriver);
				ChromeOptions op = new ChromeOptions();
				if (headless) {
					op.addArguments("--headless", "--window-size=1920,1080");
				} else {
					op.addArguments("--disable-notifications", "--force-device-scale-factor=0.95");
				}
				// op.addArguments("--disable-notifications");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(op);
				driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			} else if ("edge".equals(Browser)) {
				System.setProperty("webdriver.edge.driver", EdgeDriver);
				driver = new EdgeDriver();
				driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			} else if ("firefox".equals(Browser)) {
				System.setProperty("webdriver.edge.driver", FirefoxDriver);
				FirefoxOptions fx = new FirefoxOptions();
				fx.addArguments("--disable-notifications");
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver(fx);
				driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			} else if ("safari".equals(Browser)) {
				driver = new SafariDriver();
				driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			}

			System.out.println("##########" + driver);
			if (driver != null) {
				driver.get(url);
				driver.manage().window().maximize();
				return driver;
			}
		} catch (Exception e) {
			// Utils.printException(e);
			log.warning("UNABLE TO LAUNCH BROWSER \n\n\n");
			// Utils.printException(e);
			System.exit(01);
		}
		return null;
	}

	public static void testDeleteAllApplications() throws Exception {
		String Tname = "T1";
		WebDriver driver = null;
		String CSV_PATH = "";
		CSV_PATH = "C:\\Users\\Public\\Documents\\APplication.csv";
		CSVReader csvReader2;
		csvReader2 = new CSVReader(new FileReader(CSV_PATH));
		int count1 = 0;

		String[] csvCell;
		while ((csvCell = csvReader2.readNext()) != null) {
			String url = csvCell[0];
			String browser = csvCell[1];
			String sfurl = csvCell[9];
			String Multiple = csvCell[7];
			if (count1 == 0) {
				System.out.println("Skipping header row");
				count1++;
				continue;
			}
			if (Multiple.equals("1")) {
				headless = getHeadless(csvCell);
				driver = initDriver(browser, sfurl);
				if (url.contains("sp-jain")) {
					spjain.SalesforceBackendDELETE(driver, log, csvCell, Tname);
				} else if (url.contains("apply-sbmp")) {
					sbmp.SalesforceBackendDELETE(driver, log, csvCell, Tname);
				} else if (url.contains("ltpct")) {
					ltpct.SalesforceBackendDELETE(driver, log, csvCell, Tname);
				}
				quitDriver(sfurl, driver);
				count1++;
			}

		}

	}

	public static Boolean getHeadless(String[] csvCell) throws Exception {
		try {
			String headless = csvCell[8];
			System.out.println("Headless is set to " + headless);
			if ("TRUE".equals(headless)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			Utils.printException(e);
		}
		return false;
	}

	@AfterMethod
	public static void quitDriver(String Url, WebDriver driver) throws Exception {
		// log.info("Completed testing of portal" + Url);
		log.info("\n");
		driver.quit();
	}
}