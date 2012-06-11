package Busquedas;

import java.util.ArrayList;

import aerolineas.AerolineaLancha;

import Usuarios.Usuario;
import Vuelos.Asiento;

public class Buscador {

	private AerolineaLancha aerolineaLanchita;
	private ArrayList<Asiento> asientos;
		
	public ArrayList<Asiento> buscarAsientos(Busqueda busqueda, Usuario usuario) {
		usuario.guardarBusqueda(busqueda);
		return this.armarListaAsientos(aerolineaLanchita.busquedaDeAsientosDisponibles(busqueda.getOrigen(), busqueda.getDestino(),
											busqueda.getFechaSalida(), busqueda.getFechaLlegada()));

	}
	
	private ArrayList<Asiento> armarListaAsientos(String[][] asientosRecibidos) {

		ArrayList<Asiento> listaAsientos = new ArrayList<Asiento>();

		for (int i = 0; i < asientosRecibidos.length; i++) {
            asientos.add(new Asiento(asientosRecibidos[i]));
		}

		return listaAsientos;
	}

	public boolean noHayAsientosDisponibles(ArrayList<Asiento> asientos) {
		return asientos == null;
	}
	
	
	
}
