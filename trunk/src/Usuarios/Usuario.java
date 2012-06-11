package Usuarios;

import java.math.BigDecimal;
import java.util.ArrayList;

import Busquedas.Busqueda;
import Vuelos.Asiento;
import Vuelos.Vuelo;

public abstract class Usuario {
	
	protected String tipoUsuario;
	private BigDecimal recargo;
	private BigDecimal montoCompras;
	private ArrayList<Busqueda> historialBusquedas = new ArrayList<Busqueda>();

	
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

