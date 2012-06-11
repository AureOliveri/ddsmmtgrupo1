package Busquedas;

import java.util.ArrayList;

import aerolineas.Aerolinea;

import Usuarios.Usuario;
import Vuelos.Asiento;

public class Buscador {

	private Aerolinea aerolineaLanchita;
	private ArrayList<Asiento> asientos;
		
	public ArrayList<Asiento> buscarAsientos(Busqueda busqueda, Usuario usuario) {
		usuario.guardarBusqueda(busqueda);
		aerolineaLanchita.busquedaDeAsientosDisponibles(busqueda.getOrigen(), busqueda.getDestino(),
											busqueda.getFechaSalida(), busqueda.getFechaLlegada());
	
		
		return asientos;
		
	}
	
	
	
}
