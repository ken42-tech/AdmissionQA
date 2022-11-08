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
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.util.logging.*;
import java.util.logging.FileHandler;

import com.opencsv.CSVReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class App_portal {
    public static WebDriver driver;
	static int time = 1000;
	private static final Exception Exception = null;
    public static Logger log = Logger.getLogger("App_portal");


    public static void main(String[] args) throws Exception {
        String CSV_PATH = "";
        String logFileName = "";

        boolean append = false;
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        CSV_PATH = "C:\\Users\\Public\\Documents\\APplication.csv";
        logFileName = String.format("C:\\Users\\Public\\Documents\\Application_Test_results%s.HTML", timeStamp);
        FileHandler logFile = new FileHandler(logFileName, append);
        logFile.setFormatter(new MyHtmlFormatter());
        log.addHandler(logFile);
		CSVReader csvReader;
		int count = 0;
		csvReader = new CSVReader(new FileReader(CSV_PATH));
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		String[] csvCell;
		while ((csvCell = csvReader.readNext()) != null) {

			if (count == 0) {
				count = count + 1;
				continue;
			}
			String url = csvCell[0];
			String browser = csvCell[1];
			String Email = csvCell[2];
			String password = csvCell[3];
			String From =csvCell[4];
			String To =csvCell[5];
			

			int from = Integer.parseInt(From);
			int to = Integer.parseInt(To);
			initDriver(browser, url);
			log.info("**********************Testing for  Portal  "+url);
			// Below If will execute all Student related test cases
			for(int i=from;i<=to;i++){  
				switch (i){
					case 1 :Application.testApp(url, driver, Email, csvCell);
					break;
					case 2:Application.ApplyforCourse(url, driver, Email);
					break;
					case 3: Application.BasicDetails(url, driver, Email, csvCell);
					break;
					case 4: Application.EmploymentInfo(url, driver, Email);


					

				}
			}
			log.info("***************** COMPLETED TESTTING OF PORTAL" + url);
		}
			SendMail.sendEmail(logFileName);
	}
				
				
    
	@BeforeSuite
    public static void initDriver(String Browser, String url) throws Exception {
        
        
        try {
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
            System.out.println("Browser is $$$$$$"+Browser);
            System.out.println("URL is "+url);
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
            } else if("safari".equals(Browser)){
                driver = new SafariDriver();
                driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            }
         
			System.out.println("##########"+driver);
            driver.get(url);
            
            driver.manage().window().maximize();
        } catch (Exception e) {
           // Utils.printException(e);
            log.warning("UNABLE TO LAUNCH BROWSER \n\n\n");
			//Utils.printException(e);
            System.exit(01);
        }
    }
@AfterMethod
	public static void quitDriver(String Url) throws Exception {
		// log.info("Completed testing of portal" + Url);
		log.info("\n");
		driver.quit();
	}
}

