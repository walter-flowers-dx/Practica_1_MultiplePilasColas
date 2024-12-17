package Ejercicio_2;
import java.util.HashSet;
import java.util.Scanner;
public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MultipleColaNumeros multipleCola = new MultipleColaNumeros(3);
        
        System.out.println("Llenando la primera cola...");
        multipleCola.llenar(0, 4); // Cola 1; Introducir: 3 2 19 19
        System.out.println("Llenando la segunda cola...");
        multipleCola.llenar(1, 6); // Cola 2; Introducir 1 20 5 7 13 7 
        System.out.println("Llenando la tercera cola...");
        multipleCola.llenar(2, 4); // Cola 3; Introducir 11 3 3 3
        
        System.out.println("a) Eliminar los números repetidos de cada cola:");
        eliminarRepetidos(multipleCola);
        multipleCola.mostrar();

        System.out.println("c) Ingrese el valor de X:");
        int X = sc.nextInt();  // Introducir, X = 3
        System.out.println("Ingrese el valor de Y:");
        int Y = sc.nextInt();  // Introducir, Y = 20
        if (X <= Y) {
            mostrarFibonacciEntreXY(multipleCola, X, Y);
        } else {
            System.out.println("Error: X debe ser menor o igual a Y.");
        }

        sc.close();
    }

    // A)
    public static void eliminarRepetidos(MultipleColaNumeros multipleCola) {
        for (int i = 0; i < 3; i++) { 
            HashSet<Integer> conjunto = new HashSet<>();
            ColaSimpleNum aux = new ColaSimpleNum();
            while (!multipleCola.esVacia(i)) {
                int num = multipleCola.eliminarCola(i);
                if (!conjunto.contains(num)) {
                    conjunto.add(num); 
                    aux.adi(num); 
                }
            }
            multipleCola.adicionarCola(i, aux); 
        }
    }
    
    public static boolean esFibonacci(int num) {
        int a = 0, b = 1, c = 0;
        while (c < num) {
            c = a + b;
            a = b;
            b = c;
        }
        return c == num || num == 0; 
    }

    public static void mostrarFibonacciEntreXY(MultipleColaNumeros multipleCola, int X, int Y) {
        for (int i = 0; i < 3; i++) { 
            ColaSimpleNum aux = new ColaSimpleNum();
            int countFibonacci = 0;
            while (!multipleCola.esVacia(i)) {
                int num = multipleCola.eliminarCola(i);
                if (num >= X && num <= Y && esFibonacci(num)) {
                    countFibonacci++;
                }
                aux.adi(num); 
            }
            System.out.println("Cola " + (i + 1) + ": tiene " + countFibonacci + " números Fibonacci entre " + X + " y " + Y);
            multipleCola.adicionarCola(i, aux);
        }
    }
}
