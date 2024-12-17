package Ejercicio_1;
import java.util.Scanner;

public class ColaSimpleCancion extends ColaCancion{

	public ColaSimpleCancion() {
		super();
	}
	
	public boolean esVacia() {
		if(fr == fi) 
			return true;
		return false;
	}
	
	public boolean esLlena() {
		if(fi == MAX-1)
			return true;
		return false;
	}
	
	public void adi(Cancion elem) {
		if(esLlena()) {
			System.out.println("Cola Simple Llena!!!");
		}else {
			fi++;
			v[fi] = elem;
		}
	}
	
	public Cancion eli() {
		Cancion elem = new Cancion("","","",0);
		if(esVacia()) {
			System.out.println("Cola Simple Vacia!!!");
		}else {
			fr++;
			elem = v[fr];
		}
		return elem;
	}
	
	public int nroElem() {
		return (fi - fr);
	}
	
	public void vaciar(ColaSimpleCancion z) {
		while(!z.esVacia()) {
			adi(z.eli());
		}
	}
	
	public void llenar(int n) {
		Scanner lee = new Scanner(System.in);
		
		for(int i = 1; i<= n; i++) {
			System.out.println("Intr, titulo,genero,cantante,duracion");
			String titulo = lee.next();
			String genero = lee.next();
			String cantante = lee.next();
			double duracion = lee.nextDouble();
			
			Cancion x = new Cancion(titulo, genero, cantante, duracion);
			adi(x);
		}
	}
	
	public void mostrar() {
		ColaSimpleCancion aux = new ColaSimpleCancion();
		Cancion x;
		while(!esVacia()) {
			x = eli();
			x.mostrar();
			aux.adi(x);
		}
		vaciar(aux);
	}
	
}
