package com.sophossolutions.actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.screenplay.waits.Wait;

public class Action {


	//Buscar productos
	public static void buscarProducto(WebDriver driver, 
			By byTextoBuscar, By byBtnBuscar, 
			String strProducto) {
		String nombre= "Jonathan";
		int edad =12;
		String[] strBusqueda = strProducto.split("-");
		driver.findElement(byTextoBuscar).sendKeys(strBusqueda[0]);
		driver.findElement(byBtnBuscar).click();
	}
	
	//Seleccionar producto con mas reseñas
	public static void seleccionarMasReseñas(WebDriver driver, 
			By byResultado, By byResultados) {
		
		WebElement selectResultado = driver.findElement(byResultado);
		List<WebElement> valorados = selectResultado.findElements(byResultados);
		
		int intNumReseñas = 0;
		WebElement productoSeleccionado = valorados.get(0);
		
		for(WebElement rActual : valorados) {
			int intActual = Integer.parseInt(rActual.getText());
			if( intActual > intNumReseñas ){
				productoSeleccionado = rActual;
				intNumReseñas= intActual;
			}
		}
		System.out.println(productoSeleccionado.getText());
		productoSeleccionado.click();
	}

	//Agregar Producto a carrito
	public static void agregarProducto(WebDriver driver,
			String strBusqueda) {
		
		String[] strElementos = strBusqueda.split("-");
		
		driver.findElement(By.xpath("//button[contains(@class,'select-dropdown-button-product-quantity')]")).click();
		driver.findElement(By.xpath("//ul[contains(@class,'select-dropdown-list')]")).click();
		WebElement select = driver.findElement(By.xpath("//ul[contains(@class,'select-dropdown-list')]"));
		List<WebElement> elementos = select.findElements(By.xpath("//ul[contains(@class,'select-dropdown-list')]//li"));
		
		int iterador = 1; 
		for(WebElement elemento: elementos) {
			
			if((iterador) == Integer.parseInt(strElementos[1])) {
				elemento.isSelected(); 
				break;
			}
			iterador++;
		}
		
		driver.findElement(By.id("buy-now")).click();
		driver.findElement(By.xpath("//a[@class='btn btn-sm btn-go-to-cart added-product']")).click();
		System.out.println(driver.findElement(By.xpath("//div[@class='item-title col-xs-10 col-10']/span/a")).getText());
	}
	
	//Tiempo de espera
	public static void esperarElemento(WebDriver driver, By elemento) {
		WebDriverWait tiempoEspera = new WebDriverWait(driver,10);
		tiempoEspera.until(ExpectedConditions.visibilityOfElementLocated(elemento));
	}
	

}
