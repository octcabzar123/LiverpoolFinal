package com.liverpool.examenfinal.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreditQAPage extends BasePage {

	@FindBy(css = "[ng-bind='actualCategory.titulo']")
	private WebElement logo;
	
	@FindBy(css=".ask" )
	private List<WebElement> preguntas;
	
	public CreditQAPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void verificaCredito() {
		Assert.assertTrue(logo.isDisplayed());
	}

	public void buscaPreguntas(String preguntaBuscar) {
		for(WebElement pregunta : preguntas){
			if(pregunta.getText().contains(preguntaBuscar)){
				pregunta.click();
				List<WebElement> respuestas = driver.findElements(By.cssSelector(".ans[style='display: block;'] ul li"));
				for(WebElement respuesta: respuestas){
					System.out.println(respuesta.getText());
				}
			}
		}
	}
}
