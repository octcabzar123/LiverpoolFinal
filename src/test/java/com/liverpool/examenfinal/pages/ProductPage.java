package com.liverpool.examenfinal.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.liverpool.examenfinal.utils.Locators;
import com.liverpool.examenfinal.utils.Producto;

public class ProductPage extends BasePage {

	@FindBy(css = Locators.ProductPage.SELECTOR_NOMBRE)
	private WebElement nombre;

	@FindBy(css = Locators.ProductPage.SELECTOR_PRECIO)
	private WebElement precio;

	@FindBy(xpath = Locators.ProductPage.XPATH_BOTON_AGREGAR)
	private WebElement botonAgregar;

	@FindBy(css = Locators.ProductPage.SELECTOR_CAMPO_BUSQUEDA)
	private WebElement campoBusqueda;

	@FindBy(css = Locators.ProductPage.SELECTOR_BOLSA)
	private WebElement bolsa;

	@FindBy(css = Locators.ProductPage.SELECTOR_ICONO_BUSQUEDA)
	WebElement iconoBusqueda;

	// Constructor
	public ProductPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void agregarArticulo() {
		botonAgregar.click();
		Boolean statusFlag = true;
		while (statusFlag) {
			statusFlag = !wait.until(ExpectedConditions
					.invisibilityOfElementLocated(By.cssSelector(Locators.ProductPage.SELECTOR_MENSAJE_EXITO)));
		}
	}

	public Producto verificarProducto() {
		String nombreText = nombre.getText();
		String precioText = precio.getText().replace("\n", ".");
		Assert.assertTrue(nombre.isDisplayed() && precio.isDisplayed() && bolsa.isDisplayed());
		return new Producto(precioText, nombreText);
	}

	public ResultsPage buscarArticulo(String articulo) {
		campoBusqueda.sendKeys(articulo);
		iconoBusqueda.click();
		return new ResultsPage(driver);
	}

	public void veABolsa() {
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Locators.ProductPage.SELECTOR_BOLSA)));
		bolsa.click();
	}
}
