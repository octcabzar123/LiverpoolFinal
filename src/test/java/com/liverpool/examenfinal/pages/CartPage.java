package com.liverpool.examenfinal.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.liverpool.examenfinal.utils.Producto;

public class CartPage extends BasePage {

	@FindBy(css = ".a-product__buttonBuy")
	private WebElement boton;

	@FindBy(css = ".o-myBag--giftTable") 
	private List<WebElement> lista;

	public CartPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void verificaCarrito() {
		Assert.assertTrue(boton.isDisplayed());
	}

	public void validaProductos(List<Producto> productos) {
		int cont = 0;
		for (Producto producto : productos) {
			for (WebElement elemento : lista) {
				String nombre = elemento
						.findElement(By
								.cssSelector(".t-myBag__productList .o-myBag__description .a-inlineElement--enphasis"))
						.getText();
				String decimales = elemento
						.findElement(By.cssSelector(
								".t-myBag__productList [name='columnPrice'] .a-inlineElement--enphasis .undefined"))
						.getText();
				String precio = elemento
						.findElement(
								By.cssSelector(".t-myBag__productList [name='columnPrice'] .a-inlineElement--enphasis"))
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
