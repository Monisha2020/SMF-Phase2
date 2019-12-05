package com.smf.phase2.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.smf.phase2.TestUtils.Utils;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;
	
	public  BaseClass() throws IOException {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("C:\\Users\\rmonsha\\eclipse-workspace\\SMF_Phase2\\src\\main\\java\\com\\smf\\phase2\\Config\\configuration.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		String Browsername = prop.getProperty("Browser");
		if (Browsername.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\rmonsha\\Documents\\Selenium Softwares\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (Browsername.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\rmonsha\\Documents\\Selenium Softwares\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Utils.page_load, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Utils.implicit_wait, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("URL"));
		
	}

}
