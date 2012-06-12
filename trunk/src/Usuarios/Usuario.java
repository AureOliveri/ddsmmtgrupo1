package Usuarios;

import java.math.BigDecimal;
import java.util.ArrayList;

import Busquedas.Busqueda;
import Vuelos.Asiento;


public abstract class Usuario {
	
	protected String tipoUsuario;
	protected BigDecimal recargo = new BigDecimal(20);
	private BigDecimal montoCompras;
	private ArrayList<Busqueda> historialBusquedas = new ArrayList<Busqueda>();

	public void comprarAsiento(Asiento unAsiento){
		unAsiento.setDisponibilidad("R");
		
	}
	
	public String getTipoUsuario(){
		return tipoUsuario;
	}
	
	public BigDecimal getRecargo() {
		return recargo;
	}
	
	public ArrayList<Busqueda> getHistorial(){
		return historialBusquedas;
	}
	


	public void setMontoCompras(BigDecimal montoCompras) {
		this.montoCompras = montoCompras;
	}

	public BigDecimal getMontoCompras() {
		return montoCompras;
	}

	public void guardarBusqueda(Busqueda busqueda) {
		historialBusquedas.add(busqueda);	
	}

}

