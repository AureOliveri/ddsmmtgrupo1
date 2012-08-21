package aerolineas;

import java.util.ArrayList;

import busquedas.Busqueda;

import vuelos.Asiento;

public class Aerolineas {

	private AerolineaLanchita aerolineaLanchita = AerolineaLanchita.getInstance();
	private AerolineaOceanic aerolineaOceanic = AerolineaOceanic.getInstance();
	
	public ArrayList<Asiento> getAsientosAerolineas() { 
	
		ArrayList<Asiento> asientos = new ArrayList<Asiento>();
		asientos = aerolineaLanchita.getAsientosAerolinea();
		asientos.addAll(aerolineaOceanic.getAsientosAerolinea());
		return asientos;
	}
	
	public ArrayList<Asiento> filtrarAsientos(Busqueda busqueda) {
		ArrayList<Asiento> asientos = new ArrayList<Asiento>();
		try {
			asientos = aerolineaLanchita.asientosDisponibles(busqueda);
			asientos.addAll(aerolineaOceanic.asientosDisponibles(busqueda));
		}
		catch (NullPointerException e){
		}
		return asientos;
	}
}
