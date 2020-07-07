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

	@FindBy(css = ".a-product__buttonBuy")
	private WebElement boton;

	@FindBy(css = ".t-myBag__productList") 
	private WebElement previo;

	public CartPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void verificaCarrito() {
		Assert.assertTrue(boton.isDisplayed());
	}

	public void validaProductos(List<Producto> productos) {
		int cont = 0;
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".o-myBag--giftTable")));
		List<WebElement> lista = previo.findElements(By.cssSelector(".o-myBag--giftTable"));
		for (Producto producto : productos) {
			for (WebElement elemento : lista) {
				String nombre = elemento
						.findElement(By
								.cssSelector(".a-inlineElement--enphasis"))
						.getText().toLowerCase();
				String decimales = elemento
						.findElement(By.cssSelector(
								".o-myBag__column .a-inlineElement--total .undefined"))
						.getText();
				String precio = elemento
						.findElement(
								By.cssSelector(".o-myBag__column .a-inlineElement--total"))
						.getText();
				precio = precio.replace(decimales, "." + decimales);
				if (producto.getNombre().equals(nombre) && producto.getPrecio().equals(precio)) {
					cont++;
				}
			}
		}
		Assert.assertTrue(cont == 2);
	}
}
