package com.bolsadeideas.springboot.injection.app.domain;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class ItemFactura {

	private Producto producto;
	private double cantidad;
	
	

	public ItemFactura(Producto producto, double cantidad) {
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	
	public double getTotalProducto() {
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.CEILING);
		return Double.parseDouble(df.format(producto.getPrecio() * cantidad).replace(",", "."));
	}

}
