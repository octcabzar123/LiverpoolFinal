package com.liverpool.examenfinal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
    // atributos


    //WebElement = listaDeArticulos;


    public WebDriver driver;
    public WebDriverWait wait;

    //Constructor
    public ProductPage(WebDriver driver) {

        this.driver = driver;
    }

    public void verificarListaArticulos(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".o-listing__products")));

    }

    public void agregarArticulos(){


    }


}
