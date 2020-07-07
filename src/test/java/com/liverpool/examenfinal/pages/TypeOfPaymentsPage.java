package com.liverpool.examenfinal.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.liverpool.examenfinal.utils.Utils;

public class TypeOfPaymentsPage extends BasePage{
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	@FindBy(css=".ans.active ul li")
	public List<WebElement> answers;
	
	@FindBy(css = "[ng-bind='actualCategory.titulo']")
	WebElement title;
	
	public TypeOfPaymentsPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
	public void verifyPage(){
		if(title.getText().equals(Utils.CREDIT)){
			System.out.println("Llegamos a preguntas de crédito");
		}
	}
	
	public void showAnswers(){
		for(WebElement answer : answers){
			System.out.println(answer.getText());
		}
	}
}
