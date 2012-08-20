package aerolineas;

import java.util.ArrayList;

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
}
