package com.liverpool.examenfinal.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.liverpool.examenfinal.utils.Locators;
import com.liverpool.examenfinal.utils.Producto;

public class CartPage extends BasePage {

	@FindBy(css = Locators.CartPage.SELECTOR_BOTON)
	private WebElement boton;

	@FindBy(css = Locators.CartPage.SELECTOR_MI_BOLSA)
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
		wait.until(ExpectedConditions
				.presenceOfAllElementsLocatedBy(By.cssSelector(Locators.CartPage.SELECTOR_PRODUCTOS)));
		List<WebElement> lista = miBolsa.findElements(By.cssSelector(Locators.CartPage.SELECTOR_PRODUCTOS));
		for (Producto producto : productos) {
			for (WebElement elemento : lista) {
				String nombre = elemento.findElement(By.cssSelector(Locators.CartPage.SELECTOR_NOMBRE)).getText()
						.toLowerCase();
				String decimales = elemento.findElement(By.cssSelector(Locators.CartPage.SELECTOR_CLASE_INDEFINIDA))
						.getText();
				String precio = elemento.findElement(By.cssSelector(Locators.CartPage.SELECTOR_SUBTOTAL)).getText();
				precio = precio.replace(decimales, "." + decimales);
				String[] valores_1 = producto.getNombre().split(" ");
				String[] valores_2 = nombre.split(" ");
				int contIguales = 0;
				for (String valor1 : valores_1) {
					for (String valor2 : valores_2) {
						if (valor1.equals(valor2)) {
							contIguales++;
							break;
						}
					}
					if (contIguales > 1) {
						cont++;
						break;
					}
				}
			}
		}
		Assert.assertTrue(cont == 2);
	}
}
