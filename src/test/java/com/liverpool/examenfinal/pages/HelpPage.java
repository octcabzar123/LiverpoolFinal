package com.liverpool.examenfinal.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.liverpool.examenfinal.utils.Locators;

public class HelpPage extends BasePage {

	@FindBy(css = Locators.HelpPage.SELECTOR_AYUDA)
	private WebElement logo;

	@FindBy(css = Locators.HelpPage.SELECTOR_CREDITO_LIGA)
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
