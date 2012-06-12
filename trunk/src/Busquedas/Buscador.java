package Busquedas;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.lanchita.AerolineaLanchita;

import aerolineas.AerolineaLancha;

import Usuarios.Usuario;
import Vuelos.Asiento;

public class Buscador {

	private AerolineaLancha aerolineaLanchita = new AerolineaLancha();
		
	public ArrayList<Asiento> buscarAsientos(Busqueda busqueda, Usuario usuario) {
		usuario.guardarBusqueda(busqueda);
		String[][] asientosDisponibles;
		ArrayList<Asiento> asientos = new ArrayList<Asiento>();
		AerolineaLanchita aerolineaAux = AerolineaLanchita.getInstance();
		asientosDisponibles = aerolineaAux.asientosDisponibles(busqueda.getOrigen(), busqueda.getDestino(), busqueda.getFechaSalida(), null, busqueda.getFechaLlegada(), null);
		int i;
		for(i=0; i<asientosDisponibles.length; i++){
			Asiento asiento = new Asiento(asientosDisponibles[i]);
			asientos.add(asiento);
		}
		return asientos;

	}
	
	public ArrayList<BigDecimal> buscarAsientosYMostrarPrecio(Busqueda busqueda, Usuario usuario){
		ArrayList<BigDecimal> precios = new ArrayList<BigDecimal>();
		ArrayList<Asiento> asientos = this.buscarAsientos(busqueda, usuario);
		int i;
		for(i=0; i<asientos.size(); i++ ){
			BigDecimal precio = (asientos.get(i).getPrecio().multiply(aerolineaLanchita.getImpuesto())).add(usuario.getRecargo());
			precio = precio.setScale(2, BigDecimal.ROUND_UP);
			precios.add(precio);
		}
		
		return precios;
	}
	

	public boolean noHayAsientosDisponibles(ArrayList<Asiento> asientos) {
		return asientos == null;
	}
	
	
	public ArrayList<Asiento> buscarAsientosSuperOferta(ArrayList<Asiento> asientos) {
		ArrayList<Asiento> asientosSuper = new ArrayList<Asiento>();
		
		for(Asiento asiento: asientos) {
			if(asiento.esSuperOferta( aerolineaLanchita.getImpuesto())) {
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
