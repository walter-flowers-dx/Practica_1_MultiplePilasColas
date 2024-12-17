package Ejercicio_4;

import java.util.Scanner;

public class PilaPasajeros extends VectorPasajeros{
	private int tope;
	public PilaPasajeros() {
		this.tope = -1;
	}
	public boolean esVacia() {
		if(this.tope == -1) {
			return true; //pila vacia
		}
		else {
			return false; //pila no es vacia
		}
	}
	
	public boolean esLlena() {
		if(this.tope == max) {
			return true; //pila llena
		}
		else {
			return false;  //pila no es llena
		}
	}
	
	public void adi (Pasajeros elem) {
		if(!esLlena()) { //si la pila no es llena --> ! es negacion
			this.tope++;    //incrementa en una unidad tope = tope +1
			this.v[this.tope] = elem;
		}
		else {
			System.out.println("Pila llena!!!");
		}
	}
	
	public Pasajeros eli() {
		Pasajeros elem= new Pasajeros("",0);
		if(!esVacia()) { //si la pila no esta vacia
			elem = this.v[this.tope];
			this.tope--;  //decrementa en una unidad
		}
		else {
			System.out.println("Pila es vacia!!!");
			
		}
		return elem;
	}
	
	public void mostrar() {
		PilaPasajeros aux = new PilaPasajeros();
		System.out.println("Datos de la pila:");
		while(!esVacia()) {
			Pasajeros elem= new Pasajeros("",0);
			elem = eli();
			System.out.println(elem);
			aux.adi(elem);
		}
		vaciar(aux);
	}
	
	public void vaciar(PilaPasajeros p) {
		while(!p.esVacia()) { //mientras la pila p NO es vacia
			this.adi(p.eli());
		}
	}
	
	public void llenar(int n) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca datos: ");
		for(int i = 1;i<=n;i++) {
			Pasajeros elem= new Pasajeros("",0);
			elem.leer();
			this.adi(elem);
		}
	}
	
	public int nroElem() {
		return tope + 1;
	}
}
