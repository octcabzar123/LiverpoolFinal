package com.liverpool.examenfinal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ResultsPage extends BasePage {

	private static final String SELECTOR_PRODUCTO = ".m-figureCard__figure.card.m-plp-product-card.m-card";
	private static final String SELECTOR_MOSAICO = ".o-listing__products";
	private static final String SELECTOR_BOLSA = ".a-header__bag";

	@FindBy(css = SELECTOR_PRODUCTO)
	WebElement primero;

	@FindBy(css = SELECTOR_MOSAICO)
	WebElement mosaico;

	@FindBy(css = SELECTOR_BOLSA)
	private WebElement bolsa;

	public ResultsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void verificarListaArticulos() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(SELECTOR_MOSAICO)));
	}

	public void entrarArticulo() {
		primero.click();
		Actions ac = new Actions(driver);
		ac.moveToElement(bolsa).perform();
	}
}
