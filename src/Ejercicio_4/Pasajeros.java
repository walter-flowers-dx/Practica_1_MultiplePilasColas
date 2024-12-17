package Ejercicio_4;

import java.util.Scanner;

public class Pasajeros {
	private String nombre;
	private int edad;
	
	public Pasajeros(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public void leer() {
		Scanner lee = new Scanner(System.in);
		System.out.println("Intr. Datos: nombre,edad");
		nombre = lee.next();
		edad = lee.nextInt();
	}
	
	public void mostrar() {
		System.out.println("Nombre: " + nombre);
		System.out.println("Edad: " + edad);
	}
}
