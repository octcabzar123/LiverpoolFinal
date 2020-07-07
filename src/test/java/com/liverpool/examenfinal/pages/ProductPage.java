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

	private static final String SELECTOR_NOMBRE = ".o-product__description .a-product__information--title";
	private static final String SELECTOR_PRECIO = ".o-product__description .a-product__paragraphDiscountPrice";
	private static final String XPATH_BOTON_AGREGAR = "//*[@id='opc_pdp_addCartButton']";
	private static final String SELECTOR_CAMPO_BUSQUEDA = ".form-control";
	private static final String SELECTOR_BOLSA = ".a-header__bag";
	private static final String SELECTOR_ICONO_BUSQUEDA = ".icon-zoom";
	private static final String SELECTOR_MENSAJE_EXITO = "[role='status']";

	@FindBy(css = SELECTOR_NOMBRE)
	private WebElement nombre;

	@FindBy(css = SELECTOR_PRECIO)
	private WebElement precio;

	@FindBy(xpath = XPATH_BOTON_AGREGAR)
	private WebElement botonAgregar;

	@FindBy(css = SELECTOR_CAMPO_BUSQUEDA)
	private WebElement campoBusqueda;

	@FindBy(css = SELECTOR_BOLSA)
	private WebElement bolsa;

	@FindBy(css = SELECTOR_ICONO_BUSQUEDA)
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
			statusFlag = !wait
					.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(SELECTOR_MENSAJE_EXITO)));
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
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(SELECTOR_BOLSA)));
		bolsa.click();
	}
}
