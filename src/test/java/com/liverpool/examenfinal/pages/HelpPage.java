package com.liverpool.examenfinal.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HelpPage extends BasePage {

	private static final String SELECTOR_AYUDA = "h2.ayuda";
	private static final String SELECTOR_CREDITO_LIGA = "[href='#/faq/credito/']";
	@FindBy(css = SELECTOR_AYUDA)
	private WebElement logo;

	@FindBy(css = SELECTOR_CREDITO_LIGA)
	private WebElement creditoLiga;

	public HelpPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void verificaAyuda() {
		Assert.assertTrue(logo.isDisplayed());
	}

	public void irACredito() {
		creditoLiga.click();
	}
}
