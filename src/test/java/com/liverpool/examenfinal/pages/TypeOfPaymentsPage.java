package com.liverpool.examenfinal.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TypeOfPaymentsPage extends BasePage{
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	private WebElement pregunta;
	
	@FindBy(css=".ans.active ul li")
	public List<WebElement> answers;
	
	@FindBy(css = "[ng-bind='actualCategory.titulo']")
	WebElement title;
	
	public TypeOfPaymentsPage(WebElement pregunta, WebDriver driver){
		super(driver);
		this.pregunta = pregunta;
		PageFactory.initElements(this.driver, this);
	}
}
