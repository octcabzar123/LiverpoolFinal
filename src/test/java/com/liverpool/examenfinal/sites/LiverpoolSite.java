package com.liverpool.examenfinal.sites;

import org.openqa.selenium.WebDriver;

import com.liverpool.examenfinal.pages.CartPage;
import com.liverpool.examenfinal.pages.CreditQAPage;
import com.liverpool.examenfinal.pages.HelpPage;
import com.liverpool.examenfinal.pages.HomePage;
import com.liverpool.examenfinal.pages.ProductPage;
import com.liverpool.examenfinal.pages.ResultsPage;

public class LiverpoolSite {

	private final WebDriver driver;
	private HomePage home;
	private CreditQAPage credit;
	private HelpPage help;
	private ProductPage product;
	private ResultsPage results;
	private CartPage carrito;

	public LiverpoolSite(WebDriver driver) {
		this.driver = driver;
	}

	public HomePage getHome() {
		if (home == null) {
			home = new HomePage(driver);
		}
		return home;
	}

	public CreditQAPage getCredit() {
		if (credit == null) {
			credit = new CreditQAPage(driver);
		}
		return credit;
	}

	public HelpPage getHelp() {
		if (help == null) {
			help = new HelpPage(driver);
		}
		return help;
	}

	public ResultsPage getResults() {
		if (results == null) {
			results = new ResultsPage(driver);
		}
		return results;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public ProductPage getProduct() {
		if (product == null) {
			product = new ProductPage(driver);
		}
		return product;
	}

	public CartPage getCarrito() {
		if (carrito == null) {
			carrito = new CartPage(driver);
		}
		return carrito;
	}
}
