package com.liverpool.examenfinal.hooks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.liverpool.examenfinal.sites.LiverpoolSite;
import com.liverpool.examenfinal.utils.Utils;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	public WebDriver driver;
	public WebDriverWait wait;
	public LiverpoolSite liverpoolSite;

	public WebDriver getDriver() {
		return driver;
	}

	public LiverpoolSite getLiverpoolSite() {
		return liverpoolSite;
	}

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/kzgk290/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Utils.SHORT_WAIT, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver,Utils.LONG_WAIT);
		liverpoolSite = new LiverpoolSite(driver, wait);
	}

	@After
	public void tearDown() {
		driver.quit();
	}

}
