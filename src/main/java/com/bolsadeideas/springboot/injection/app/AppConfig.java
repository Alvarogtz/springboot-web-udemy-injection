package com.bolsadeideas.springboot.injection.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.bolsadeideas.springboot.injection.app.domain.ItemFactura;
import com.bolsadeideas.springboot.injection.app.domain.Producto;

@Configuration
public class AppConfig {

	@Bean("itemsFactura")
	public List<ItemFactura> registrarItems() {

		Producto producto1 = new Producto("Camara Sony", 35.95);
		Producto producto2 = new Producto("Bicicleta BH", 345.95);
		
		ItemFactura linea1 = new ItemFactura(producto1, 2);
		ItemFactura linea2 = new ItemFactura(producto2, 3);
		
		return Arrays.asList(linea1,linea2);
	}
	
	@Bean("itemsFacturaOficina")
	@Primary
	public List<ItemFactura> registrarItemsOficina() {

		Producto producto1 = new Producto("Monitor", 199.90);
		Producto producto2 = new Producto("Notebook", 855.25);
		Producto producto3 = new Producto("Teclado", 35.95);
		Producto producto4 = new Producto("Raton", 19.95);
		
		ItemFactura linea1 = new ItemFactura(producto1, 10);
		ItemFactura linea2 = new ItemFactura(producto2, 10);
		ItemFactura linea3 = new ItemFactura(producto3, 10);
		ItemFactura linea4 = new ItemFactura(producto4, 10);
		
		return Arrays.asList(linea1,linea2,linea3,linea4);
	}
}
