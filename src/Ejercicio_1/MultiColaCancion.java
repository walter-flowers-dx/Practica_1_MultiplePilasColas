package Ejercicio_1;
import java.util.Scanner;

public class MultiColaCancion {
    private int n;
    private ColaSimpleCancion c[] = new ColaSimpleCancion[100];

    public MultiColaCancion(int n) {
        this.n = n;
        for (int i = 0; i < n; i++) {
            c[i] = new ColaSimpleCancion();
        }
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

    public void adicionarCola(int i, ColaSimpleCancion cola) {
        c[i] = cola;
    }

    public Cancion eliminarCola(int i) {
        return c[i].eli();
    }
    
    
    public void adicionarCancion(int i, Cancion est) {
	    if (!c[i].esLlena()) {
	        c[i].adi(est);
	    } else {
	        System.out.print("Pila " + i + " está llena");
	    }
	}
	public Cancion eliminarCancion(int i) {
		Cancion e = new Cancion("","","",0);
		if (!c[i].esVacia())
			e = c[i].eli();
		else
			System.out.print("pila " + i + " esta vacia");
		return e;
	}

    public void llenar(int i, int n) {
        c[i].llenar(n);
    }

    public void llenar(int n) {
        this.n = n;
        Scanner lee = new Scanner(System.in);
        for (int i = 0; i < this.n; i++) {
            c[i] = new ColaSimpleCancion();
            System.out.println("Número de Cancions en la cola:");
            int nroEst = lee.nextInt();
            c[i].llenar(nroEst);
        }
    }

    public void mostrar() {
    	System.out.print("Datos de la Multicola!!");
        for (int i = 0; i < this.n; i++) {
            c[i].mostrar();
        }
    }

    public void mostrar(int i) {
        c[i].mostrar();
    }

    public void vaciar(int i, ColaSimpleCancion z) {
        c[i].vaciar(z);
    }

    public void vaciar(int i, int j) {
        c[i].vaciar(c[j]);
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
}
