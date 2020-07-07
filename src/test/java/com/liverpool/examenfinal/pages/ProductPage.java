package com.liverpool.examenfinal.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.liverpool.examenfinal.utils.Producto;

public class ProductPage extends BasePage {

	@FindBy(css = ".o-product__description .a-product__information--title")
	private WebElement nombre;

	@FindBy(css = ".o-product__description .a-product__paragraphDiscountPrice")
	private WebElement precio;

	@FindBy(xpath = "//*[@id='opc_pdp_addCartButton']")
	private WebElement botonAgregar;

	@FindBy(css= ".form-control")
	private WebElement campoBusqueda;
	
	@FindBy(css= ".a-header__bag")
	private WebElement bolsa;
	
	@FindBy(css = ".icon-zoom")
	WebElement iconoBusqueda;

	// Constructor
	public ProductPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void agregarArticulo() {
		botonAgregar.click();
		Boolean statusFlag = true;
		while(statusFlag){
			statusFlag = !wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[role='status']")));
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
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".a-header__bag")));
		bolsa.click();
	}
}
