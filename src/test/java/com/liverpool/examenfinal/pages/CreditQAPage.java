package com.liverpool.examenfinal.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CreditQAPage extends BasePage {

	public CreditQAPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

}
