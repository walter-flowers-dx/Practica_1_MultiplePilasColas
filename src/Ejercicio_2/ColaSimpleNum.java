package Ejercicio_2;

import java.util.Scanner;

public class ColaSimpleNum extends ColaNum {

    // Constructor que llama al constructor de la clase base.
    public ColaSimpleNum() {
        super();
    }

    // Método que verifica si la cola está vacía.
    public boolean esVacia() {
        return fr == fi;
    }

    // Método que verifica si la cola está llena.
    public boolean esLlena() {
        return fi == MAX - 1;
    }

    // Método para adicionar un elemento a la cola.
    public void adi(int elem) {
        if (esLlena()) {
            System.out.println("Cola Simple Llena!!!");
        } else {
            fi++;
            v[fi] = elem;
        }
    }

    // Método para eliminar y retornar el primer elemento de la cola.
    public int eli() {
        if (esVacia()) {
            System.out.println("Cola Simple Vacia!!!");
            return -1; // Valor indicativo de error si la cola está vacía.
        } else {
            fr++;
            return v[fr];
        }
    }

    // Método que retorna el número de elementos en la cola.
    public int nroElem() {
        return fi - fr;
    }

    // Método que vacía una cola dada en la cola actual.
    public void vaciar(ColaSimpleNum z) {
        while (!z.esVacia()) {
            adi(z.eli());
        }
    }

    // Método que llena la cola con 'n' números ingresados por el usuario.
    public void llenar(int n) {
        Scanner lee = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            System.out.println("Ingrese un número:");
            int num = lee.nextInt();
            adi(num); // Se añade directamente el número.
        }
    }

    // Método para mostrar todos los elementos de la cola.
    public void mostrar() {
        ColaSimpleNum aux = new ColaSimpleNum();
        while (!esVacia()) {
            int x = eli(); // Extrae el elemento.
            System.out.println(x); // Muestra el elemento.
            aux.adi(x); // Lo coloca en la cola auxiliar.
        }
        vaciar(aux); // Vuelve a colocar los elementos en la cola original.
    }
}