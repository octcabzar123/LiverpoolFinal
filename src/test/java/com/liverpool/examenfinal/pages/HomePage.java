package com.liverpool.examenfinal.pages;

import org.junit.Assert;
import com.liverpool.examenfinal.utils.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.liverpool.examenfinal.utils.Utils;

public class HomePage extends BasePage {

	@FindBy(css = Locators.HomePage.SELECTOR_LOGO)
	private WebElement logoLiverpool;

	@FindBy(css = Locators.HomePage.SELECTOR_ICONO_BUSQUEDA)
	private WebElement iconoBusqueda;

	@FindBy(css = Locators.HomePage.SELECTOR_CAMPO_BUSQUEDA)
	private WebElement campoBusqueda;

	@FindBy(css = Locators.HomePage.SELECTOR_AYUDA_LIGA)
	private WebElement ayudaLiga;

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void navegarSitio() {
		driver.manage().window().maximize();
		driver.get(Utils.URL);
	}

	public boolean verificarPagina() {
		return logoLiverpool.isDisplayed() && campoBusqueda.isDisplayed() && iconoBusqueda.isDisplayed();
	}

	public void verificarInicio() {
		Assert.assertTrue(logoLiverpool.isDisplayed() && campoBusqueda.isDisplayed() && iconoBusqueda.isDisplayed());
	}

	public ResultsPage buscarArticulo(String articulo) {
		campoBusqueda.sendKeys(articulo);
		iconoBusqueda.click();
		return new ResultsPage(driver);
	}

	public void irAAyuda() {
		ayudaLiga.click();
	}

	public void esperaALogo() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Locators.HomePage.SELECTOR_LOGO)));
	}

	public void esperaProductos() {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(Locators.HomePage.SELECTOR_PRODUCTOS)));
		
	}
}
