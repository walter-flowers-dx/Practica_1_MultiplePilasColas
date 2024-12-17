package Ejercicio_3;

import java.util.Scanner;

public class Mp_PilaPelicula {
	private int n;
    private PilaPelicula[] c = new PilaPelicula[100];

    public Mp_PilaPelicula(int n) {
        this.n = n;
        for (int i = 0; i < n; i++) {
            c[i] = new PilaPelicula();
        }
    }
    public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public PilaPelicula[] getC() {
		return c;
	}

	public void setC(PilaPelicula[] c) {
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
    
    public PilaPelicula[] getPilas() {
        return c;
    }
    
    public void adicionarPila(int i, PilaPelicula pila) {
        c[i] = pila;
    }

    public Pelicula eliminarPila(int i) {
        return c[i].eli();
    }

    public void mostrar() {
        System.out.println("Datos de la MultiPila:");
        for (int i = 0; i < this.n; i++) {
            c[i].mostrar();
        }
    }
}
