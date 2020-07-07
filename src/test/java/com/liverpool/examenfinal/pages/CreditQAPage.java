package com.liverpool.examenfinal.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.liverpool.examenfinal.utils.Locators;

public class CreditQAPage extends BasePage {

	@FindBy(css = Locators.CreditQAPage.SELECTOR_LOGO)
	private WebElement logo;

	@FindBy(css = Locators.CreditQAPage.SELECTOR_ASK)
	private List<WebElement> preguntas;

	public CreditQAPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void verificaCredito() {
		Assert.assertTrue(logo.isDisplayed());
	}
	
	public void esperaATituloFAQ(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Locators.CreditQAPage.SELECTOR_LOGO)));
	}

	public void buscaPreguntas(String preguntaBuscar) {
		for (WebElement pregunta : preguntas) {
			if (pregunta.getText().contains(preguntaBuscar)) {
				pregunta.click();
				List<WebElement> respuestas = driver.findElements(By.cssSelector(Locators.CreditQAPage.SELECTOR_RESPUESTAS));
				Actions ac = new Actions(driver);
				for (WebElement respuesta : respuestas) {
					ac.moveToElement(respuesta).perform();
					System.out.println(respuesta.getText());
				}
			}
		}
	}
}
