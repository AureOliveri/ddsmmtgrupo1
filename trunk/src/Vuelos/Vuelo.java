package Vuelos;

import java.util.Collection;

public class Vuelo {

	String origen;
	String fechaSalida;
	String horaSalida;
	String destino;
	String fechaLlegada;
	String horaLlegada;
	Collection<Asiento> asientos;
	
	public Vuelo(){
		
	}
	
	public boolean estaDisponible(Asiento unAsiento){
		return (unAsiento.disponibilidad == "D");
		
	}
}
