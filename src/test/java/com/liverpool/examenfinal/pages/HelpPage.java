package com.liverpool.examenfinal.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HelpPage extends BasePage{
	
	@FindBy(css = "h2.ayuda")
	private WebElement logo;
	
	@FindBy(css = "[href='#/faq/credito/']")
	private WebElement creditoLink;

	public HelpPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void verificaAyuda() {
		Assert.assertTrue(logo.isDisplayed());
	}

	public void irACredito() {
		creditoLink.click();
	}

}
