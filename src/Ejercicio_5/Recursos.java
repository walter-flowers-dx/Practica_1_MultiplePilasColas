package Ejercicio_5;

import java.util.Scanner;

public class Recursos {
	private String nombre;
	private String tipo;
	private int cantidad;
	
	public Recursos(String nombre, String tipo, int cantidad) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.cantidad = cantidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public void leer() {
		Scanner lee = new Scanner(System.in);
		System.out.println("Intr. Datos: nombre,tipo,cantidad");
		nombre = lee.next();
		tipo = lee.next();
		cantidad = lee.nextInt();
	}
	@Override
    public String toString() {
        return nombre + ", " + tipo + ", " + cantidad;
    }

    public void mostrar() {
        System.out.println(toString());
    }
	
//	public void mostrar() {
//		System.out.println("Datos de Recursos: ");
//		System.out.println("Nombre: " + nombre);
//		System.out.println("Tipo: " + tipo);
//		System.out.println("Cantidad: " + cantidad);
//	}
}
