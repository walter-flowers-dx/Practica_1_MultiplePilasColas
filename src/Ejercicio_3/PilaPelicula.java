package Ejercicio_3;

public class PilaPelicula extends VectorPelicula {
    private int tope;

    public PilaPelicula() {
        this.tope = -1;
    }

    public boolean esVacia() {
        return this.tope == -1;
    }

    public boolean esLlena() {
        return this.tope == max - 1; // Se cambia para coincidir con el tamaño del array
    }

    public void adi(Pelicula elem) {
        if (!esLlena()) {
            this.tope++;
            this.v[this.tope] = elem;
        } else {
            System.out.println("Pila llena!!!");
        }
    }

    public Pelicula eli() {
        Pelicula elem = null;
        if (!esVacia()) {
            elem = this.v[this.tope];
            this.tope--;
        } else {
            System.out.println("Pila vacía!!!");
        }
        return elem;
    }

    public void mostrar() {
        PilaPelicula aux = new PilaPelicula();
        System.out.println("Datos de la pila:");
        while (!esVacia()) {
            Pelicula elem = eli();
            elem.mostrar();
            aux.adi(elem);
        }
        vaciar(aux);
    }

    public void vaciar(PilaPelicula p) {
        while (!p.esVacia()) {
            this.adi(p.eli());
        }
    }

    public void llenar(int n) {
        for (int i = 1; i <= n; i++) {
            Pelicula elem = new Pelicula("", "", 0, "", 0);
            elem.leer();
            this.adi(elem);
        }
    }

    public int nroElem() {
        return tope + 1;
    }
}

