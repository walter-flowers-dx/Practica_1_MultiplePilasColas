package Ejercicio_4;

import java.util.Scanner;

public class Vuelo {
	private int nroVuelo;
	private int capacidad;
	PilaPasajeros pilaPasajeros;
	private int horaPartida;
	private int horaLlegada;
	
	public Vuelo(int nroVuelo, int capacidad, PilaPasajeros pilaPasajeros, int horaPartida, int horaLlegada) {
		super();
		this.nroVuelo = nroVuelo;
		this.capacidad = capacidad;
		this.pilaPasajeros = pilaPasajeros;
		this.horaPartida = horaPartida;
		this.horaLlegada = horaLlegada;
	}

	public int getNroVuelo() {
		return nroVuelo;
	}

	public void setNroVuelo(int nroVuelo) {
		this.nroVuelo = nroVuelo;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public PilaPasajeros getPilaPasajeros() {
		return pilaPasajeros;
	}

	public void setPilaPasajeros(PilaPasajeros pilaPasajeros) {
		this.pilaPasajeros = pilaPasajeros;
	}

	public int getHoraPartida() {
		return horaPartida;
	}

	public void setHoraPartida(int horaPartida) {
		this.horaPartida = horaPartida;
	}

	public int getHoraLlegada() {
		return horaLlegada;
	}

	public void setHoraLlegada(int horaLlegada) {
		this.horaLlegada = horaLlegada;
	}
	
	public void leer() {
		Scanner lee = new Scanner(System.in);
		System.out.println("Intr. Datos: nroVuelo,capacidad,PilaPasajeros,horaPartida,horaLlegada");
		nroVuelo = lee.nextInt();
		capacidad = lee.nextInt();
		horaPartida = lee.nextInt();
		horaLlegada = lee.nextInt();
	}
	
	public void mostrar() {
		System.out.println("Datos del Vuelo: ");
		System.out.println("NroVuelo: " + nroVuelo);
		System.out.println("Capacidad: " + capacidad);
		System.out.println("HoraPartida: " + horaPartida);
		System.out.println("HoraLlegada: " + horaLlegada);
	}
}
