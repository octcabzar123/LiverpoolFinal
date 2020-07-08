package com.liverpool.examenfinal.utils;

public class Locators {
	
	public class HomePage {
		public static final String SELECTOR_LOGO = ".a-header__logo";
		public static final String SELECTOR_ICONO_BUSQUEDA = ".icon-zoom";
		public static final String SELECTOR_CAMPO_BUSQUEDA = ".form-control";
		public static final String SELECTOR_AYUDA_LIGA = ".a-header__strongLink[href='https://assetspwa.liverpool.com.mx/ayuda/#/']";
		public static final String SELECTOR_PRODUCTOS = ".o-myBag--giftTable";
	}
	
	public class CartPage {
		public static final String SELECTOR_LOGO = ".a-header__logo";
		public static final String SELECTOR_BOTON = ".a-product__buttonBuy";
		public static final String SELECTOR_MI_BOLSA = ".t-myBag__productList";
		public static final String SELECTOR_PRODUCTOS = ".o-myBag--giftTable";
		public static final String SELECTOR_SUBTOTAL = ".o-myBag__column .a-inlineElement--total";
		public static final String SELECTOR_CLASE_INDEFINIDA = ".o-myBag__column .a-inlineElement--total .undefined";
		public static final String SELECTOR_NOMBRE = ".a-inlineElement--enphasis";
	}
	
	public class ResultsPage{
		public static final String SELECTOR_RESULTADOS = ".m-figureCard__figure.card.m-plp-product-card.m-card";
		public static final String SELECTOR_BOLSA = ".a-header__bag";
		public static final String SELECTOR_PRODUCTO = ".m-figureCard__figure.card.m-plp-product-card.m-card";
		public static final String SELECTOR_MOSAICO = ".o-listing__products";
	}
	
	public class CreditQAPage{
		public static final String SELECTOR_RESPUESTAS = ".ans[style='display: block;'] ul li";
		public static final String SELECTOR_LOGO = "[ng-bind='actualCategory.titulo']";
		public static final String SELECTOR_ASK = ".ask";
	}
	
	public class HelpPage{
		public static final String SELECTOR_AYUDA = "h2.ayuda";
		public static final String SELECTOR_CREDITO_LIGA = "[href='#/faq/credito/']";
	}
	
	public class ProductPage{
		public static final String SELECTOR_NOMBRE = ".o-product__description .a-product__information--title";
		public static final String SELECTOR_PRECIO = ".o-product__description .a-product__paragraphDiscountPrice";
		public static final String XPATH_BOTON_AGREGAR = "//*[@id='opc_pdp_addCartButton']";
		public static final String SELECTOR_CAMPO_BUSQUEDA = ".form-control";
		public static final String SELECTOR_BOLSA = ".a-header__bag";
		public static final String SELECTOR_ICONO_BUSQUEDA = ".icon-zoom";
		public static final String SELECTOR_MENSAJE_EXITO = "[role='status']";
	}
}
