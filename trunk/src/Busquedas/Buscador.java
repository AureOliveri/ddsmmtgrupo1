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
            listaAsientos.add(new Asiento(asientosRecibidos[i]));
		}

		return listaAsientos;
	}

	public boolean noHayAsientosDisponibles(ArrayList<Asiento> asientos) {
		return asientos == null;
	}
	
	
	public ArrayList<Asiento> buscarAsientosSuperOferta(ArrayList<Asiento> asientos) {
		ArrayList<Asiento> asientosSuper = new ArrayList<Asiento>();
		
		for(Asiento asiento: asientos) {
			if(asiento.esSuperOferta(aerolineaLanchita.getImpuesto())) {
				asientosSuper.add(asiento);
			}
		}
		return asientosSuper;
		
	}
	
	public ArrayList<Asiento> buscarAsientosPorClase(ArrayList<Asiento> asientos, String clase) {
		ArrayList<Asiento> asientosPorClase = new ArrayList<Asiento>();
		
		for(Asiento asiento: asientos) {
			if(asiento.getClaseDeAsiento().equals(clase)) {
				asientosPorClase.add(asiento);
			}
		}
		return asientosPorClase;
		
	}
	
	public ArrayList<Asiento> buscarAsientosPorUbicacion(ArrayList<Asiento> asientos, String ubicacion) {
		ArrayList<Asiento> asientosUbicacion = new ArrayList<Asiento>();
		
		for(Asiento asiento: asientos) {
			if(asiento.getClaseDeAsiento().equals(ubicacion)) {
				asientosUbicacion.add(asiento);
			}
		}
		return asientosUbicacion;
		
	}
	
	
}
