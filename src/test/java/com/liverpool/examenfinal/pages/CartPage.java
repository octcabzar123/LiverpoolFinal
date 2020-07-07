package com.liverpool.examenfinal.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.liverpool.examenfinal.utils.Producto;

public class CartPage extends BasePage {

	private static final String SELECTOR_BOTON = ".a-product__buttonBuy";
	private static final String SELECTOR_MI_BOLSA = ".t-myBag__productList";
	private static final String SELECTOR_PRODUCTOS = ".o-myBag--giftTable";
	private static final String SELECTOR_SUBTOTAL = ".o-myBag__column .a-inlineElement--total";
	private static final String SELECTOR_CLASE_INDEFINIDA = ".o-myBag__column .a-inlineElement--total .undefined";
	private static final String SELECTOR_NOMBRE = ".a-inlineElement--enphasis";

	@FindBy(css = SELECTOR_BOTON)
	private WebElement boton;

	@FindBy(css = SELECTOR_MI_BOLSA)
	private WebElement miBolsa;

	public CartPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void verificaCarrito() {
		Assert.assertTrue(boton.isDisplayed());
	}

	public void validaProductos(List<Producto> productos) {
		int cont = 0;
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(SELECTOR_PRODUCTOS)));
		List<WebElement> lista = miBolsa.findElements(By.cssSelector(SELECTOR_PRODUCTOS));
		for (Producto producto : productos) {
			for (WebElement elemento : lista) {
				String nombre = elemento.findElement(By.cssSelector(SELECTOR_NOMBRE)).getText().toLowerCase();
				String decimales = elemento.findElement(By.cssSelector(SELECTOR_CLASE_INDEFINIDA)).getText();
				String precio = elemento.findElement(By.cssSelector(SELECTOR_SUBTOTAL)).getText();
				precio = precio.replace(decimales, "." + decimales);
				if (producto.getNombre().equals(nombre) && producto.getPrecio().equals(precio)) {
					cont++;
				}
			}
		}
		Assert.assertTrue(cont == 2);
	}
}
