package com.liverpool.examenfinal.steps;

import java.util.ArrayList;
import java.util.List;

import com.liverpool.examenfinal.hooks.Hooks;
import com.liverpool.examenfinal.pages.CartPage;
import com.liverpool.examenfinal.pages.HomePage;
import com.liverpool.examenfinal.pages.ProductPage;
import com.liverpool.examenfinal.pages.ResultsPage;
import com.liverpool.examenfinal.sites.LiverpoolSite;
import com.liverpool.examenfinal.utils.Producto;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class CarritoStepDefs {

	public LiverpoolSite liverpoolSite;
	private List<Producto> productos;

	public CarritoStepDefs(Hooks hook) {
		this.liverpoolSite = hook.getLiverpoolSite();
		productos = new ArrayList<Producto>();
	}

	@Given("^Entro a la página Tienda en línea de Liverpool$")
	public void entro_a_la_pgina_tienda_en_lnea_de_liverpool() {
		HomePage home = this.liverpoolSite.getHome();
		home.navegarSitio();
		home.esperaALogo();
		home.verificarInicio();
	}

	@And("^Verifico la informacion$")
	public void verifico_la_informacion() {
		HomePage home = this.liverpoolSite.getHome();
		home.esperaProductos();
		CartPage carrito = liverpoolSite.getCarrito();
		carrito.verificaCarrito();
		carrito.validaProductos(productos);
	}

	@When("Busco primer {word} en la página")
	public void busco_primer_en_la_pgina(String primero) {
		HomePage home = this.liverpoolSite.getHome();
		ResultsPage results = home.buscarArticulo(primero);
		results.verificarListaArticulos();
		results.entrarArticulo();
		ProductPage producto = this.liverpoolSite.getProduct();
		productos.add(producto.verificarProducto());
		producto.agregarArticulo();
	}

	@And("Busco segundo {word} en página de producto")
	public void busco_segundo_en_pgina_de_producto(String segundo) {
		ProductPage producto = this.liverpoolSite.getProduct();
		ResultsPage results = producto.buscarArticulo(segundo);
		results.esperaResultados();
		results.verificarListaArticulos();
		results.entrarArticulo();
		results.esperaBolsa();
		ProductPage producto2 = this.liverpoolSite.getProduct();
		productos.add(producto2.verificarProducto());
		producto2.agregarArticulo();
		producto2.veABolsa();
	}
}
