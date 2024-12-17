package Ejercicio_4;

import java.util.Scanner;

public class Mp_PilaVuelo {
	private int n;
    private PilaVuelo[] c = new PilaVuelo[100];

    public Mp_PilaVuelo(int n) {
        this.n = n;
        for (int i = 0; i < n; i++) {
            c[i] = new PilaVuelo();
        }
    }
    public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public PilaVuelo[] getC() {
		return c;
	}

	public void setC(PilaVuelo[] c) {
		this.c = c;
	}

	public int nroElem(int i) {
        return c[i].nroElem();
    }

    public boolean esVacia(int i) {
        return c[i].esVacia();
    }

    public boolean esLlena(int i) {
        return c[i].esLlena();
    }
    
    public PilaVuelo[] getPilas() {
        return c;
    }
    
    public void adicionarPila(int i, PilaVuelo pila) {
        c[i] = pila;
    }

    public Vuelo eliminarPila(int i) {
        return c[i].eli();
    }

    public void mostrar() {
        System.out.println("Datos de la MultiPila:");
        for (int i = 0; i < this.n; i++) {
            c[i].mostrar();
        }
    }
}
