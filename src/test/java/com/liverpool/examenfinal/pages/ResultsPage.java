package com.liverpool.examenfinal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.liverpool.examenfinal.utils.Locators;

public class ResultsPage extends BasePage {

	@FindBy(css = Locators.ResultsPage.SELECTOR_PRODUCTO)
	WebElement primero;

	@FindBy(css = Locators.ResultsPage.SELECTOR_MOSAICO)
	WebElement mosaico;

	@FindBy(css = Locators.ResultsPage.SELECTOR_BOLSA)
	private WebElement bolsa;

	public ResultsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void verificarListaArticulos() {
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Locators.ResultsPage.SELECTOR_MOSAICO)));
	}

	public void entrarArticulo() {
		primero.click();
		Actions ac = new Actions(driver);
		esperaBolsa();
		ac.moveToElement(bolsa).perform();
	}

	public void esperaResultados() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector(Locators.ResultsPage.SELECTOR_RESULTADOS)));
	}

	public void esperaBolsa() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Locators.ResultsPage.SELECTOR_BOLSA)));

	}
}
