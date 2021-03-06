package com.sophossolutions.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sophossolutions.actions.Action;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.linio.com.co")
public class LinioHome extends PageObject {
	
	//Elementos para la busqueda del producto
	By byTextoBuscar = By.xpath("//div[@class='input-group-search']//input[@name='q']");
	By byBtnBuscar = By.xpath("//button[contains(@class,'btn-search')]");
	//Elementos para seleccionar el mejor calificado
	By byResultado = By.xpath("//div[contains(@class,'switchable')]");
	By byResultados = By.xpath("//div[contains(@class,'switchable')]//div/span[@class='body-base-sm rate']");
	
	//Buscar productos
	public void buscarProducto(String strBusqueda) {
		Action.buscarProducto(getDriver(), byTextoBuscar, byBtnBuscar, strBusqueda);
	}
	
	//Seleccionar el mejor calificado
	public void seleccionarMasRese├▒as() {
		Action.seleccionarMasRese├▒as(getDriver(),byResultado, byResultados);
		
	}
	
	//Agregar al carrito 
	public void agregarProducto(String strBusqueda) {
		Action.agregarProducto(getDriver(), strBusqueda);
	}
	
	
}
