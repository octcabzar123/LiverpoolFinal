package com.liverpool.examenfinal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ResultsPage extends BasePage{

	public ResultsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(css = ".m-figureCard__figure.card.m-plp-product-card.m-card")
	WebElement primero;
	
	@FindBy(css=".o-listing__products")
	WebElement mosaico;
	
	@FindBy(css= ".a-header__bag")
	private WebElement bolsa;
	
	public void verificarListaArticulos() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".o-listing__products")));
	}

	public void entrarArticulo(){
		primero.click();
		Actions ac = new Actions(driver);
		ac.moveToElement(bolsa).perform();
	}
}
