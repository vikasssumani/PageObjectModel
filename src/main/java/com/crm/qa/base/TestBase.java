package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.crm.qa.util.WebEventListner;

public class TestBase {
	
	public static Properties p;
	public static WebDriver driver;
	WebEventListner wel;
	EventFiringWebDriver e_driver;
	public static WebDriverWait explictwait ;
	public TestBase() {
		p = new Properties();
		try {
		FileInputStream fio = new FileInputStream("C:\\Users\\vikassum\\workspace_photon\\PageObjectModel\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		p.load(fio);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void intialinzation() {
		
		String Browser = p.getProperty("browser");
		if(Browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Software\\LatestChormeDriver\\chromedriver.exe");
//			ChromeOptions co = new ChromeOptions();
//			co.addArguments("window-size=1400,800");
//			co.addArguments("headless");
			driver = new ChromeDriver();
			
		}else if(Browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver","C:\\Software\\LatestChormeDriver\\chromedriver.exe");
			driver = new FirefoxDriver();
		}
		else if(Browser.equals("PhantomJS")) {
				System.setProperty("phantomjs.binary.path","C:\\Software\\phantomjs-2.1.1-windows\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
				driver = new PhantomJSDriver();
		}
		explictwait = new WebDriverWait(driver,30000L); 
		e_driver = new EventFiringWebDriver(driver);
		wel = new WebEventListner();
		e_driver.register(wel);
		driver = e_driver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(p.getProperty("url"));
		
	}

}
