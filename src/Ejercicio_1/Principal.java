package Ejercicio_1;

public class Principal {

	public static void main(String[] args) {
		ColaSimpleCancion csc1 = new ColaSimpleCancion();
		Cancion c1 = new Cancion("Bohemian Rhapsody", "Rock", "Freddie Mercury", 354);
		Cancion c2 = new Cancion("Shape of You", "Trap", "Ed Sheeran", 233);
		Cancion c3 = new Cancion("Rolling in the Deep", "Soul", "Adele", 228);
		csc1.adi(c1);
		csc1.adi(c2);
		csc1.adi(c3);
		
		ColaSimpleCancion csc2 = new ColaSimpleCancion();
		Cancion c4 = new Cancion("Billie Jean", "Pop", "Michael Jackson", 294);
		Cancion c5 = new Cancion("Despacito", "Trap", "Luis Fonsi", 229);
		csc2.adi(c4);
		csc2.adi(c5);
		
		ColaSimpleCancion csc3 = new ColaSimpleCancion();
		Cancion c6 = new Cancion("Rolling Stone", "Rap", "Peso Pluma", 223);
		Cancion c7 = new Cancion("One", "Heavy Metal", "James Hetfield", 447);
		Cancion c8 = new Cancion("Hey Jude", "Rock", "Paul McCartney", 431);
		Cancion c9 = new Cancion("Lose Yourself", "Rap", "Eminem", 326);
		csc3.adi(c6);
		csc3.adi(c7);
		csc3.adi(c8);
		csc3.adi(c9);
		
		ColaSimpleCancion csc4 = new ColaSimpleCancion();
		Cancion c10 = new Cancion("Noche y de Dia", "Reggaeton", "Enrique Iglesias", 325);
		csc4.adi(c10);
		
		ColaSimpleCancion csc5 = new ColaSimpleCancion();
		Cancion c11 = new Cancion("Bohemian Rhapsody", "Rock", "Freddie Mercury", 354);
		Cancion c12 = new Cancion("Billie Jean", "Pop", "Michael Jackson", 294);
		Cancion c13 = new Cancion("Rolling Stone", "Rap", "Peso Pluma", 223);
		csc5.adi(c11);
		csc5.adi(c12);
		csc5.adi(c13);
		
		MultiColaCancion mcc = new MultiColaCancion(5);
		mcc.adicionarCola(0, csc1);
		mcc.adicionarCola(1, csc2);
		mcc.adicionarCola(2, csc3);
		mcc.adicionarCola(3, csc4);
		mcc.adicionarCola(4, csc5);
		mcc.mostrar();
		
		System.out.println("A) Mover todas las canciones del cantante X a la última Cola");
		moverCancionesCantante(mcc, "Freddie Mercury");
		mcc.mostrar();
		
		
		System.out.println("\nC) Eliminar todas las canciones de la multiple cola que pertenecen al género 'Trap'");
		eliminarCancionesPorGenero(mcc, "Trap");
		mcc.mostrar();
	}// A)
	public static void moverCancionesCantante(MultiColaCancion mcc, String cantante) {
	    int ultimaCola = mcc.getN() - 1; 
	    for (int i = 0; i < mcc.getN(); i++) {
	        if (i == ultimaCola) {
	            continue;
	        }
	        ColaSimpleCancion aux = new ColaSimpleCancion();
	        while (!mcc.esVacia(i)) {
	            Cancion cancion = mcc.eliminarCancion(i);
	            if (cancion.getCantante().equals(cantante)) {
	                if (!mcc.esLlena(ultimaCola)) {
	                    mcc.adicionarCancion(ultimaCola, cancion);
	                } else {
	                    System.out.println("La última cola está llena, no se puede mover la canción: " + cancion.getTitulo());
	                }
	            } else {
	                aux.adi(cancion);
	            }
	        }
	        mcc.vaciar(i, aux);
	    }
	}
	// C)
	public static void eliminarCancionesPorGenero(MultiColaCancion mcc, String genero) {
	    for (int i = 0; i < mcc.getN(); i++) {
	        ColaSimpleCancion aux = new ColaSimpleCancion();
	        while (!mcc.esVacia(i)) {
	            Cancion cancion = mcc.eliminarCancion(i);
	            System.out.println("Verificando canción: " + cancion.getTitulo() + " de género " + cancion.getGenero());
	            if (!cancion.getGenero().trim().equalsIgnoreCase(genero.trim())) {
	                aux.adi(cancion);
	            } else {
	                System.out.println("Eliminando canción: " + cancion.getTitulo() + " de género " + cancion.getGenero());
	            }
	        }
	        mcc.vaciar(i, aux);
	    }
	}


}