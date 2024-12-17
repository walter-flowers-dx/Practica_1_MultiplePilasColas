package Ejercicio_4;

import java.util.Scanner;

public class PilaVuelo extends VectorVuelo{
	private int tope;
	public PilaVuelo() {
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
	
	public void adi (Vuelo elem) {
		if(!esLlena()) { //si la pila no es llena --> ! es negacion
			this.tope++;    //incrementa en una unidad tope = tope +1
			this.v[this.tope] = elem;
		}
		else {
			System.out.println("Pila llena!!!");
		}
	}
	
	public Vuelo eli() {
		Vuelo elem= new Vuelo(0,0,null,0,0);
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
		PilaVuelo aux = new PilaVuelo();
		System.out.println("Datos de la pila:");
		while(!esVacia()) {
			Vuelo elem= new Vuelo(0,0,null,0,0);
			elem = eli();
			System.out.println(elem);
			aux.adi(elem);
		}
		vaciar(aux);
	}
	
	public void vaciar(PilaVuelo p) {
		while(!p.esVacia()) { //mientras la pila p NO es vacia
			this.adi(p.eli());
		}
	}
	
	public void llenar(int n) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca datos: ");
		for(int i = 1;i<=n;i++) {
			Vuelo elem= new Vuelo(0,0,null,0,0);
			elem.leer();
			this.adi(elem);
		}
	}
	
	public int nroElem() {
		return tope + 1;
	}
}
