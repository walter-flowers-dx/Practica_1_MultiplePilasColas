package Ejercicio_5;

import java.util.Scanner;

public class ColaCircularRecursos extends ColaRecursos {
    public ColaCircularRecursos() {
        super();
    }

    public int nroElem() {
        return (fi - fr + MAX) % MAX;
    }

    public boolean esVacia() {
        return nroElem() == 0;
    }

    public boolean esLlena() {
        return nroElem() == MAX - 1;
    }

    public void adi(Recursos elem) {
        if (!esLlena()) {
            fi = (fi + 1) % MAX;
            v[fi] = elem;
        } else {
            System.out.println("Cola circular llena!!!");
        }
    }

    public Recursos eli() {
        Recursos elem = null;
        if (!esVacia()) {
            fr = (fr + 1) % MAX;
            elem = v[fr];
        } else {
            System.out.println("Cola circular vacía!!");
        }
        return elem;
    }

    public void vaciar(ColaCircularRecursos z) {
        while (!z.esVacia()) {
            adi(z.eli());
        }
    }

    public void llenar(int n) {
        Scanner lee = new Scanner(System.in);

        for (int i = 1; i <= n; i++) {
            System.out.println("Introduce un Recursos (como objeto):");
            // Aquí podrías leer los atributos de un Recursos
            Recursos elem = new Recursos("","",0);  // Ajusta según tu implementación de Recursos
            elem.leer(); // Supón que tienes un método para llenar los datos del Recursos
            adi(elem);
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ColaCircularRecursos aux = new ColaCircularRecursos();
        
        while (!esVacia()) {
            Recursos elem = eli();
            sb.append(elem.toString()).append("\n");
            aux.adi(elem);
        }
        
        vaciar(aux);  // Restaurar los elementos de la cola original
        return sb.toString();
    }

    public void mostrar() {
        ColaCircularRecursos aux = new ColaCircularRecursos();
        while (!esVacia()) {
            Recursos elem = eli();
            System.out.println(elem);  // Debes sobrescribir el método toString() en la clase Recursos para que imprima correctamente
            aux.adi(elem);
        }
        vaciar(aux);
    }
}

