package com.liverpool.examenfinal.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.liverpool.examenfinal.utils.Utils;

public class BasePage {

	public WebDriver driver;
	public WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Utils.LONG_WAIT);
	}
}
