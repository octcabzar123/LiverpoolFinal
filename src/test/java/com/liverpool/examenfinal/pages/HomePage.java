package com.liverpool.examenfinal.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.liverpool.examenfinal.utils.Utils;

public class HomePage extends BasePage {

	private static final String SELECTOR_LOGO = ".a-header__logo";
	private static final String SELECTOR_ICONO_BUSQUEDA = ".icon-zoom";
	private static final String SELECTOR_CAMPO_BUSQUEDA = ".form-control";
	private static final String SELECTOR_AYUDA_LIGA = ".a-header__strongLink[href='https://assetspwa.liverpool.com.mx/ayuda/#/']";

	@FindBy(css = SELECTOR_LOGO)
	private WebElement logoLiverpool;

	@FindBy(css = SELECTOR_ICONO_BUSQUEDA)
	private WebElement iconoBusqueda;

	@FindBy(css = SELECTOR_CAMPO_BUSQUEDA)
	private WebElement campoBusqueda;

	@FindBy(css = SELECTOR_AYUDA_LIGA)
	private WebElement ayudaLiga;

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void navegarSitio() {
		driver.manage().window().maximize();
		driver.get(Utils.URL);
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
}
