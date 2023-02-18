package com.bolsadeideas.springboot.injection.app.domain;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@RequestScope
//@SessionScope
public class Factura implements Serializable{

	private static final long serialVersionUID = 8779449246247974821L;
	@Value("${factura.descripcion}")
	private String descripcion;
	@Autowired
	private Cliente cliente;
	@Autowired
	private List<ItemFactura> items;
	
	@PostConstruct
	public void init() {
		cliente.setNombre(cliente.getNombre() + " ZG");
		descripcion += " del cliente: " + cliente.getNombre();
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Factura destuida " + descripcion);
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemFactura> getItems() {
		return items;
	}

	public void setItems(List<ItemFactura> items) {
		this.items = items;
	}

}
