package Ejercicio_5;

import java.util.Scanner;

public class Tareas {
    private String nombre;
    private String prioridad;
    private String descripcion;
    private PilaCoCirRecursos pilaRecursos;

    // Constructor
    public Tareas(String nombre, String prioridad, String descripcion, PilaCoCirRecursos pilaRecursos) {
        this.nombre = nombre;
        this.prioridad = prioridad;
        this.descripcion = descripcion;
        this.pilaRecursos = pilaRecursos;
    }

    // Métodos getters
    public String getNombre() {
        return nombre;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public PilaCoCirRecursos getPilaRecursos() {
        return pilaRecursos;
    }

	
	public void leer() {
		Scanner lee = new Scanner(System.in);
		System.out.println("Intr. Datos: nombre,prioridad,descripcion,PilaColasCircularesRecursos");
		nombre = lee.next();
		prioridad = lee.next();
		descripcion = lee.next();
		int n = 0;
		pilaRecursos.llenar(n);
	}
	
	public void mostrar() {
        System.out.println("Datos de la Tarea: ");
        System.out.println("Nombre: " + nombre);
        System.out.println("Prioridad: " + prioridad);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Datos de la pila de recursos:");
        pilaRecursos.mostrar();  // Llamada al método mostrar() de la pila de recursos
    }
}
