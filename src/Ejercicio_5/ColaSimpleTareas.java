package Ejercicio_5;
import java.util.Scanner;

public class ColaSimpleTareas extends ColaTareas{

	public ColaSimpleTareas() {
		super();
	}
	
	public boolean esVacia() {
		if(fr == fi) 
			return true;
		return false;
	}
	
	public boolean esLlena() {
		if(fi == MAX-1)
			return true;
		return false;
	}
	
	public void adi(Tareas elem) {
		if(esLlena()) {
			System.out.println("Cola Simple Llena!!!");
		}else {
			fi++;
			v[fi] = elem;
		}
	}
	
	public Tareas eli() {
		Tareas elem = new Tareas("","","",null);
		if(esVacia()) {
			System.out.println("Cola Simple Vacia!!!");
		}else {
			fr++;
			elem = v[fr];
		}
		return elem;
	}
	
	public int nroElem() {
		return (fi - fr);
	}
	
	public void vaciar(ColaSimpleTareas z) {
		while(!z.esVacia()) {
			adi(z.eli());
		}
	}
	
	public void llenar(int n) {
		Scanner lee = new Scanner(System.in);
		
		for(int i = 1; i<= n; i++) {
			System.out.println("Intr, nombre,prioridad,decsripcion,PilaColasCircularesRecursos");
			String nombre = lee.next();
			String prioridad = lee.next();
			String descripcion = lee.next();
			Tareas x = new Tareas(nombre, prioridad, descripcion,null);
			adi(x);
		}
	}
	
	public void mostrar() {
		ColaSimpleTareas aux = new ColaSimpleTareas();
		Tareas x;
		while(!esVacia()) {
			x = eli();
			x.mostrar();
			aux.adi(x);
		}
		vaciar(aux);
	}
	
}
