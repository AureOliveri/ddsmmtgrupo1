package aerolineas;

import java.util.ArrayList;
import java.util.Collection;

import busquedas.Busqueda;

import vuelos.Asiento;

public class Aerolineas {

	private AerolineaLanchita aerolineaLanchita = AerolineaLanchita.getInstance();
	private AerolineaOceanic aerolineaOceanic = AerolineaOceanic.getInstance();
	
	Collection<Aerolinea> aerolineas = new ArrayList<Aerolinea>();
	
	public Aerolineas() {
		this.aerolineas.add(aerolineaLanchita);
		this.aerolineas.add(aerolineaOceanic);
	}
	
	public ArrayList<Asiento> getAsientosAerolineas() { 
	
		ArrayList<Asiento> asientos = new ArrayList<Asiento>();
		asientos = aerolineaLanchita.getAsientosAerolinea();
		asientos.addAll(aerolineaOceanic.getAsientosAerolinea());
		return asientos;
	}
	
	public ArrayList<Asiento> filtrarAsientos(Busqueda busqueda) {
		ArrayList<Asiento> asientos = new ArrayList<Asiento>();
		for(Aerolinea aerolinea:this.aerolineas) {
		try {
			asientos.addAll(aerolinea.asientosDisponibles(busqueda));
		} 
		catch (RuntimeException e) {
			// sigo con otra aerolineaF
		}
		}
		return asientos;
		
		

		
	}
}
