package Ejercicio_1;

import java.util.Scanner;

public class Cancion {
	String titulo;
	String genero;
	String cantante;
	double duracion;
	
	public Cancion(String titulo, String genero, String cantante, double duracion) {
		super();
		this.titulo = titulo;
		this.genero = genero;
		this.cantante = cantante;
		this.duracion = duracion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCantante() {
		return cantante;
	}

	public void setCantante(String cantante) {
		this.cantante = cantante;
	}

	public double getDuracion() {
		return duracion;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}
	
	public void leer() {
		Scanner lee = new Scanner(System.in);
		System.out.println("Intr. Datos: titulo,genero,cantante,duracion");
		titulo = lee.next();
		genero = lee.next();
		cantante = lee.next();
		duracion = lee.nextDouble();
	}
	
	public void mostrar() {
		System.out.println("\nDatos de la Cancion: ");
		System.out.println("Titulo: " + titulo);
		System.out.println("Genero: " + genero);
		System.out.println("Cantante: " + cantante);
		System.out.println("Duracion: " + duracion);
	}
}
