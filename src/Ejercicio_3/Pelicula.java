package Ejercicio_3;

import java.util.Scanner;

public class Pelicula {
    private String titulo;
    private String director;
    private int anoLanzamiento;
    private String clasificacion;
    private double duracion;

    public Pelicula(String titulo, String director, int anoLanzamiento, String clasificacion, double duracion) {
        this.titulo = titulo;
        this.director = director;
        this.anoLanzamiento = anoLanzamiento;
        this.clasificacion = clasificacion;
        this.duracion = duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getAnoLanzamiento() {
        return anoLanzamiento;
    }

    public void setAnoLanzamiento(int anoLanzamiento) {
        this.anoLanzamiento = anoLanzamiento;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public void leer() {
        Scanner lee = new Scanner(System.in);
        System.out.println("Introduzca Datos: titulo, director, anoLanzamiento, clasificacion, duracion");
        titulo = lee.nextLine();
        director = lee.nextLine();
        anoLanzamiento = lee.nextInt();
        clasificacion = lee.next();
        duracion = lee.nextDouble();		
    }

    public void mostrar() {
        System.out.println("Datos de la Película: ");
        System.out.println("Título: " + titulo);
        System.out.println("Director: " + director);
        System.out.println("Año Lanzamiento: " + anoLanzamiento);
        System.out.println("Clasificación: " + clasificacion);
        System.out.println("Duración: " + duracion);
    }
}
