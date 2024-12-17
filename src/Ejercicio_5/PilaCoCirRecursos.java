package Ejercicio_5;

import java.util.Scanner;

public class PilaCoCirRecursos extends VectorPilaColCirRecursos {
    private int tope;

    public PilaCoCirRecursos() {
        this.tope = -1;
    }

    public boolean esVacia() {
        return this.tope == -1;  // Simplificado
    }

    public boolean esLlena() {
        return this.tope == max - 1;  // Ajuste en la condición para evitar overflow
    }

    public void adi(ColaCircularRecursos elem) {
        if (!esLlena()) {  // Si la pila no está llena
            this.tope++;    // Incrementa el tope
            this.v[this.tope] = elem;
        } else {
            System.out.println("Pila llena!!!");
        }
    }

    public ColaCircularRecursos eli() {
        ColaCircularRecursos elem = new ColaCircularRecursos();
        if (!esVacia()) {  // Si la pila no está vacía
            elem = this.v[this.tope];
            this.tope--;  // Decrementa el tope
        } else {
            System.out.println("Pila vacía!!!");
        }
        return elem;
    }

    public void mostrar() {
        PilaCoCirRecursos aux = new PilaCoCirRecursos();
        System.out.println("Datos de la pila:");
        while (!esVacia()) {
            ColaCircularRecursos elem = eli();
            System.out.println(elem);  // Asegúrate de que `toString()` esté implementado en ColaCircularRecursos
            aux.adi(elem);
        }
        vaciar(aux);  // Restaura los elementos en la pila original
    }

    public void vaciar(PilaCoCirRecursos p) {
        while (!p.esVacia()) {  // Mientras la pila `p` no esté vacía
            this.adi(p.eli());
        }
    }

    public void llenar(int n) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca datos:");
        for (int i = 1; i <= n; i++) {
            ColaCircularRecursos elem = new ColaCircularRecursos();
            elem.llenar(n);  // Aquí debes implementar el llenado en la clase ColaCircularRecursos
            this.adi(elem);
        }
        sc.close();  // Cerrar el Scanner
    }

    public int nroElem() {
        return tope + 1;  // Devuelve el número de elementos en la pila
    }
}

