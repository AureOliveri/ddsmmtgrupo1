package Usuarios;

import java.math.BigDecimal;
import java.util.Collection;

import com.lanchita.AerolineaLanchita;

import aerolineas.Aerolinea;

import Busquedas.Busqueda;
import Vuelos.Asiento;
import Vuelos.Vuelo;

public abstract class Usuario {
	
	protected String tipoUsuario;
	private BigDecimal recargo;	
	private Collection<Busqueda> historial;
	private Aerolinea aerolineaLanchita;
	
	public void compraAsiento(Asiento unAsiento, Vuelo unVuelo){
		if(unVuelo.yaNoEstasDisponible(unAsiento)){
			System.out.println("El asiento " + unAsiento + " del vuelo " + unVuelo + " no esta disponible.");
		}else {
			unAsiento.ocupate();
		}
	}
	
	public void setRecargo() {
		
		if (tipoUsuario == "ConRecargo") {
			this.recargo.add(new BigDecimal(20));
		}	
	}
	
	public String getTipoUsuario(){
		return tipoUsuario;
	}
	
	public BigDecimal getRecargo() {
		return recargo;
	}
	
	public Collection<Busqueda> getHistorial(){
		return historial;
	}
	public void buscar(String unOrigen, String unDestino,String unaFechaDeSalida, String unaFechaDeLlegada){
		
		
		aerolineaLanchita.busquedaDeAsientosDisponibles(unOrigen, unDestino, unaFechaDeSalida, unaFechaDeLlegada);
		
	}
}
