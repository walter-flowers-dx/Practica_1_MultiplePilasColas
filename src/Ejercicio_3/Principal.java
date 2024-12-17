package Ejercicio_3;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        PilaPelicula pp1 = new PilaPelicula();
        Pelicula p1 = new Pelicula("Inception", "Christopher Nolan", 2010, "Ciencia Ficcion", 148);
        Pelicula p2 = new Pelicula("Forrest Gump", "Robert Zemeckis", 1994, "Comedia", 142);
        Pelicula p3 = new Pelicula("Gladiator", "Ridley Scott", 2000, "Drama Historico", 155);
        pp1.adi(p1);
        pp1.adi(p2);
        pp1.adi(p3);

        PilaPelicula pp2 = new PilaPelicula();
        Pelicula p4 = new Pelicula("El Padrino", "Francis Ford Coppola", 1972, "Drama", 175);
        Pelicula p5 = new Pelicula("The Matrix", "Lana Wachowski, Lilly Wachowski", 1999, "Ciencia Ficcion", 136);
        pp2.adi(p4);
        pp2.adi(p5);

        PilaPelicula pp3 = new PilaPelicula();
        Pelicula p6 = new Pelicula("Parasite", "Bong Joon-ho", 2019, "Thriller", 132);
        Pelicula p7 = new Pelicula("Interstellar", "Christopher Nolan", 2014, "Ciencia Ficcion", 169);
        Pelicula p8 = new Pelicula("La La Land", "Damien Chazelle", 2016, "Romance", 128);
        Pelicula p9 = new Pelicula("Mad Max: Fury Road", "George Miller", 2015, "Accion", 120);
        pp3.adi(p6);
        pp3.adi(p7);
        pp3.adi(p8);
        pp3.adi(p9);

        Mp_PilaPelicula mpp = new Mp_PilaPelicula(3);
        mpp.adicionarPila(0, pp1);
        mpp.adicionarPila(1, pp2);
        mpp.adicionarPila(2, pp3);

        mpp.mostrar();

        Scanner sc = new Scanner(System.in);
        System.out.println("\na) Ingrese el nombre del director para sumar las duraciones de sus películas:");
        String directorX = sc.nextLine();
        double sumaDuracion = sumarDuracionesPorDirector(mpp, directorX);
        System.out.println("La suma de las duraciones de las películas dirigidas por " + directorX + " es: " + sumaDuracion + " minutos");

        System.out.println("\nc) Ingrese el nombre del director:");
        String directorY = sc.nextLine();
        System.out.println("Ingrese la clasificación:");
        String clasificacionY = sc.nextLine();
        moverPeliculasAlPrincipio(mpp, directorY, clasificacionY);
        mpp.mostrar();
    }

    // a)
    public static double sumarDuracionesPorDirector(Mp_PilaPelicula mpp, String directorX) {
        double suma = 0;
        PilaPelicula[] pilas = mpp.getPilas();  
        
        for (int i = 0; i < mpp.getN(); i++) {
            PilaPelicula pila = pilas[i];
            PilaPelicula aux = new PilaPelicula();
            
            while (!pila.esVacia()) {
                Pelicula p = pila.eli();
                if (p.getDirector().equalsIgnoreCase(directorX)) {
                    suma += p.getDuracion();
                }
                aux.adi(p);
            }
            pila.vaciar(aux);  
        }
        return suma;
    }


    // c)
    public static void moverPeliculasAlPrincipio(Mp_PilaPelicula mpp, String directorX, String clasificacionY) {
        PilaPelicula[] pilas = mpp.getPilas(); 
        
        for (int i = 0; i < mpp.getN(); i++) {
            PilaPelicula pila = pilas[i];
            PilaPelicula aux = new PilaPelicula();
            PilaPelicula temp = new PilaPelicula();
            
            while (!pila.esVacia()) {
                Pelicula p = pila.eli();
                if (p.getDirector().equalsIgnoreCase(directorX) && p.getClasificacion().equalsIgnoreCase(clasificacionY)) {
                    aux.adi(p); 
                } else {
                    temp.adi(p);
                }
            }
            pila.vaciar(aux);
            pila.vaciar(temp);
        }
    }

}
