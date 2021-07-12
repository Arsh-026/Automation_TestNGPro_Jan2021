package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page.BasePage;

public class BrowserFactory extends BasePage{
	
	static WebDriver driver;
	static String browser=null;
	static String url=null;
	
	public static void readConfigFile() {
		
		Properties prop = new Properties();
		
		try {
			InputStream input = new FileInputStream("src\\main\\java\\config\\config.properties");
			prop.load(input);
			browser = prop.getProperty("browser");
			url = prop.getProperty("url");
			
			
		}catch (IOException e) {
			
			e.printStackTrace();
		}
			
		}
		
		@Test
		public static WebDriver init() {
			
			readConfigFile();
			
			if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			}else if(browser.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
				driver = new FirefoxDriver(); 						
			}
			
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(url);
			return driver;
	}
	
		public static void tearDown() {
			driver.close();
			driver.quit();
		}

}


