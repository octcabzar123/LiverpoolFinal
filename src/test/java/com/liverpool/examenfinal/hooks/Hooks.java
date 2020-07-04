package com.liverpool.examenfinal.hooks;

import com.liverpool.examenfinal.sites.LiverpoolSite;
import com.liverpool.examenfinal.utils.Utils;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {

	public WebDriver driver;
	public LiverpoolSite liverpoolSite;

	public WebDriver getDriver() {
		return driver;
	}

	public LiverpoolSite getLiverpoolSite() {
		return liverpoolSite;
	}

	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Utils.SHORT_WAIT, TimeUnit.SECONDS);
		liverpoolSite = new LiverpoolSite(driver);
	}

	@After
	public void tearDown() {
		driver.quit();
	}

}
