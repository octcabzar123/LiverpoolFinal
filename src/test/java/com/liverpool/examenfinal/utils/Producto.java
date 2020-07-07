package com.liverpool.examenfinal.utils;

public class Producto {

	private String precio;
	private String nombre;

	public Producto(String precio, String nombre) {
		this.nombre = nombre.toLowerCase();
		this.precio = precio.toLowerCase();
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
