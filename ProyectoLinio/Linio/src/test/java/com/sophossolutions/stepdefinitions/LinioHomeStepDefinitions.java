package com.sophossolutions.stepdefinitions;

import com.sophossolutions.pages.LinioHome;

//import com.sophossolutions.pages.LinioHome.java;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LinioHomeStepDefinitions {

	LinioHome linioHome;

	@Given("Yo deseo buscar mi producto en la pagina de linio")
	public void yoDeseoBuscarMiProductoEnLaPaginaDeLinio() {
		linioHome.open();
	}

	@When("busco {string}")
	public void busco(String strBusqueda) {
		linioHome.buscarProducto(strBusqueda);
		linioHome.seleccionarMasReseñas();
	}

	@Then("Agrego al carrito el {string} con más reseñas")
	public void agregoAlCarritoElConMásReseñas(String strBusqueda) {
		linioHome.agregarProducto(strBusqueda);
	}
}
