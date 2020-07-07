package com.liverpool.examenfinal.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.liverpool.examenfinal.hooks.Hooks;
import com.liverpool.examenfinal.pages.CreditQAPage;
import com.liverpool.examenfinal.pages.HelpPage;
import com.liverpool.examenfinal.pages.HomePage;
import com.liverpool.examenfinal.sites.LiverpoolSite;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class FAQStepDefs {
	
	public LiverpoolSite liverpoolSite;
	
	public FAQStepDefs(Hooks hook) {
		this.liverpoolSite = hook.getLiverpoolSite();
	}

	@Given("^Necesito entrar a la página de Ayuda$")
	public void necesito_entrar_a_la_pgina_de_ayuda() {
		HomePage home = liverpoolSite.getHome();
		home.navegarSitio();
		liverpoolSite.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".a-header__logo")));
		home.verificarInicio();
		home.irAAyuda();
	}

	@Then("^Veo los tipos de pago$")
	public void veo_los_tipos_de_pago() {
		CreditQAPage preguntas = liverpoolSite.getCredit();
		preguntas.verificaCredito();
		liverpoolSite.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-bind='actualCategory.titulo']")));
		preguntas.buscaPreguntas("formas de pago");	
	}

	@And("^Voy a la sección de credito$")
	public void voy_a_la_seccin_de_credito() {
		HelpPage ayuda = liverpoolSite.getHelp();
		liverpoolSite.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2.ayuda")));
		ayuda.verificaAyuda();
		ayuda.irACredito();
	}
}
