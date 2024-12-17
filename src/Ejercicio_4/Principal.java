package Ejercicio_4;
public class Principal {
    public static void main(String[] args) {
        Pasajeros p1 = new Pasajeros("Juan", 17);
        Pasajeros p2 = new Pasajeros("Maria", 22);
        Pasajeros p3 = new Pasajeros("Pedro", 15); 
        Pasajeros p4 = new Pasajeros("Ana", 30);

        PilaPasajeros pilaPasajeros1 = new PilaPasajeros();
        pilaPasajeros1.adi(p1); 
        pilaPasajeros1.adi(p2);

        PilaPasajeros pilaPasajeros2 = new PilaPasajeros();
        pilaPasajeros2.adi(p3);  
        pilaPasajeros2.adi(p4);

        Vuelo vuelo1 = new Vuelo(101, 25, pilaPasajeros1, 10, 18); 
        Vuelo vuelo2 = new Vuelo(102, 15, pilaPasajeros2, 8, 17);
        Vuelo vuelo3 = new Vuelo(103, 30, pilaPasajeros1, 7, 16); 
        
        vuelo1.mostrar();
        vuelo2.mostrar();
        vuelo3.mostrar();

        Mp_PilaVuelo mpVuelos = new Mp_PilaVuelo(2);

        PilaVuelo pilaVuelo1 = new PilaVuelo();
        pilaVuelo1.adi(vuelo1);
        pilaVuelo1.adi(vuelo2);

        PilaVuelo pilaVuelo2 = new PilaVuelo();
        pilaVuelo2.adi(vuelo3);

        mpVuelos.adicionarPila(0, pilaVuelo1);
        mpVuelos.adicionarPila(1, pilaVuelo2);

        // a)
        System.out.println("a) Vuelos con capacidad mayor a 20 pasajeros y que transportaron\n al menos a un menor:");
        mostrarVuelosCapacidadMayor20ConMenor(mpVuelos);

        // c)
        System.out.println("\nc) Cantidad de vuelos que llegaron entre 5 y 7 de la tarde:");
        int cantidad = contarVuelosLlegadaEntre5y7(mpVuelos);
        System.out.println("Cantidad de vuelos: " + cantidad);
    }

    // a)
    public static void mostrarVuelosCapacidadMayor20ConMenor(Mp_PilaVuelo mpVuelos) {
        for (int i = 0; i < mpVuelos.getN(); i++) {
            PilaVuelo pilaVuelo = mpVuelos.getC()[i];
            PilaVuelo aux = new PilaVuelo();  

            while (!pilaVuelo.esVacia()) {
                Vuelo vuelo = pilaVuelo.eli();  
                aux.adi(vuelo);    

                if (vuelo.getCapacidad() > 20) {
                    PilaPasajeros pilaPasajeros = vuelo.getPilaPasajeros();
                    boolean hayMenor = false;
                    PilaPasajeros auxPasajeros = new PilaPasajeros();
                    while (!pilaPasajeros.esVacia()) {
                        Pasajeros pasajero = pilaPasajeros.eli();
                        auxPasajeros.adi(pasajero); 

                        if (pasajero.getEdad() < 18) {
                            hayMenor = true;
                        }
                    }
                    pilaPasajeros.vaciar(auxPasajeros);

                    if (hayMenor) {
                        vuelo.mostrar();
                    }
                }
            }
            pilaVuelo.vaciar(aux);
        }
    }

    // c)
    public static int contarVuelosLlegadaEntre5y7(Mp_PilaVuelo mpVuelos) {
        int contador = 0;

        for (int i = 0; i < mpVuelos.getN(); i++) {
            PilaVuelo pilaVuelo = mpVuelos.getC()[i];
            PilaVuelo aux = new PilaVuelo(); 

            while (!pilaVuelo.esVacia()) {
                Vuelo vuelo = pilaVuelo.eli();
                aux.adi(vuelo);  

                if (vuelo.getHoraLlegada() >= 17 && vuelo.getHoraLlegada() <= 19) {
                    contador++;
                }
            }
            pilaVuelo.vaciar(aux);
        }

        return contador;
    }
}
