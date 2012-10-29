package main.java.aerolineas;

import java.util.ArrayList;
import java.util.Collection;
import main.java.busquedas.Busqueda;
import main.java.enumeraciones.Ciudad;
import main.java.vuelos.Asiento;
import main.java.vuelos.Vuelo;


public class Aerolineas {

	private static AerolineaLanchita aerolineaLanchita = AerolineaLanchita
			.getInstance();
	private static AerolineaOceanic aerolineaOceanic = AerolineaOceanic.getInstance();

	Collection<Aerolinea> aerolineas = new ArrayList<Aerolinea>();

	public Aerolineas() {
		this.aerolineas.add(aerolineaLanchita);
		this.aerolineas.add(aerolineaOceanic);
	}

	public static ArrayList<Vuelo> getVuelosAerolineas(){
		
		ArrayList<Vuelo> vuelos = new ArrayList<Vuelo>();
		for (Asiento asiento : getAsientosAerolineas()) {
				if(!(vuelos.contains(asiento.getVuelo()))){
				vuelos.add(asiento.getVuelo());
			}			
		}
		return vuelos;
	}
	
	public ArrayList<Vuelo> vuelosConEscala(Ciudad origen,Ciudad destino){
		
		ArrayList<Vuelo> vuelosConEscala = new ArrayList<Vuelo>();
		for (Vuelo unVuelo : getVuelosAerolineas()) {
			if(unVuelo.esVueloConEscala(origen,destino)){
				vuelosConEscala.add(unVuelo);
			}
		}
		return vuelosConEscala;
	}
	
	public static ArrayList<Asiento> getAsientosAerolineas() {

		ArrayList<Asiento> asientos = new ArrayList<Asiento>();
		asientos = aerolineaLanchita.getAsientosAerolinea();
		asientos.addAll(aerolineaOceanic.getAsientosAerolinea());
		return asientos;
	}

	public ArrayList<Asiento> filtrarAsientos(Busqueda busqueda) {
		ArrayList<Asiento> asientos = new ArrayList<Asiento>();
		for (Aerolinea aerolinea : this.aerolineas) {
			asientos.addAll(aerolinea.asientosDisponibles(busqueda));
		}
		return asientos;

	}

}
