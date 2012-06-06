package Vuelos;

public class Vuelo {
	
	public Vuelo(){
		
	}
	
	boolean disponibilidad = true;
	
	public boolean estaDisponible(){
		return disponibilidad;
	}

	public void yaNoEstasDisponible() {
		disponibilidad = false;
		
	}
}
