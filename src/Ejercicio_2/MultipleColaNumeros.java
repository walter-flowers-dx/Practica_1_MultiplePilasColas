package Ejercicio_2;
import java.util.Scanner;

public class MultipleColaNumeros {
    private int n;
    private ColaSimpleNum[] c;

    // Constructor que crea 'n' colas simples.
    public MultipleColaNumeros(int n) {
        this.n = n;
        c = new ColaSimpleNum[n];
        for (int i = 0; i < n; i++) {
            c[i] = new ColaSimpleNum();
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

    public void adicionarCola(int i, ColaSimpleNum cola) {
        c[i] = cola;
    }

    public int eliminarCola(int i) {
        return c[i].eli();
    }

    public void llenar(int i, int n) {
        c[i].llenar(n);
    }

    public void mostrar() {
        System.out.println("Datos de la Multicola:");
        for (int i = 0; i < n; i++) {
            System.out.println("Cola " + (i + 1) + ":");
            c[i].mostrar();
        }
    }
}