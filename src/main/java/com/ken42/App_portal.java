package com.ken42;

import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

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
	public static String[] students;

	@Override
	public void run() {
		System.out.println("Thread- Started" + Thread.currentThread().getName());
		String threadname = Thread.currentThread().getName();
		System.out.println(threadname);
		try {
			if (threadname.equals("T1")) {
				System.out.println("Skipping Thread1 to read first line as header");
				testDeleteAllApplications(this.csvLineData, this.count);
			} else {
				Thread.sleep(1000);
				testAdmissionPortal(this.csvLineData, this.count);
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (java.lang.Exception e) {
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
		int ThreadCount = 0;
		csvReader1 = new CSVReader(new FileReader(CSV_PATH));

		String[] csvCell1;
		while ((csvCell1 = csvReader1.readNext()) != null) {
			// students[ThreadCount] = csvCell1[12];
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
			t.start();
			if (count == 0) {
				Utils.smallSleepBetweenClicks(1);
			} else {
				Utils.bigSleepBetweenClicks(2);
			}
			count++;
		}
	}

	public static void testAdmissionPortal(String[] csvCell, int count) throws Exception {
		String url = csvCell[0];
		String browser = csvCell[1];
		String Email = csvCell[2];
		String password = csvCell[3];
		String From = csvCell[4];
		String To = csvCell[5];
		String sfurl = csvCell[9];
		String vali = csvCell[6];
		System.out.println("**********************************" + vali);
		int from = Integer.parseInt(From);
		int to = Integer.parseInt(To);
		Logger log = Logger.getLogger("App_portal" + count);
		String folder = "";
		// folder = getFolderPath();
		String logFileName = "";
		boolean append = false;
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
		logFileName = String.format("C:\\Users\\Public\\Documents\\Testresult_%s.HTML", timeStamp);
		FileHandler logFile = new FileHandler(logFileName, append);
		logFile.setFormatter(new MyHtmlFormatter());
		log.addHandler(logFile);
		WebDriver driver = null;

		driver = initDriver(browser, url);
		log.info("**********************Testing for  Portal  " + url);

		// Below If will execute all Student related test cases
		for (int i = from; i <= to; i++) {
			switch (i) {
				case 1:
					spjain.Admissionfillform(url, driver, csvCell, log);
					break;
				case 2:
					spjain.fess_spjain(sfurl, timeStamp, driver, csvCell, log);
					break;
				case 3:
					documentupload.documentUpload(sfurl, url, driver, csvCell, log);
					break;
				case 4:
					spjain.SalesforceBackendDELETE(driver, log, csvCell);
					break;
			}
		}
		log.info("***************** COMPLETED TESTTING OF PORTAL" + url);
		// SendMail.sendEmail(logFileName);
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
				// url="https://ltpct-reg-stg-w2l.ken42.com/form";
			}
			System.out.println("Browser is $$$$$$" + Browser);
			System.out.println("URL is " + url);
			if ("chrome".equals(Browser)) {
				System.setProperty("webdriver.chrome.driver", ChromeDriver);
				ChromeOptions op = new ChromeOptions();
				op.addArguments("--disable-notifications");
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

	public static void testDeleteAllApplications(String[] csvCell, int count) throws Exception {
		int len = students.length;
		for (int i = 0; i < len; i++) {
			System.out.println(students[i]);
		}

	}

	@AfterMethod
	public static void quitDriver(String Url, WebDriver driver) throws Exception {
		// log.info("Completed testing of portal" + Url);
		log.info("\n");
		driver.quit();
	}
}