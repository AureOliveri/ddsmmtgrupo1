package Usuarios;

import java.math.BigDecimal;
import java.util.Collection;

import Busquedas.Busqueda;
import Vuelos.Asiento;
import Vuelos.Vuelo;

public abstract class Usuario {
	
	protected String tipoUsuario;
	private BigDecimal recargo;	
	Collection<Busqueda> historial;
	
	
	
	public void compraAsiento(Asiento unAsiento, Vuelo unVuelo){
		if(unVuelo.yaNoEstasDisponible(unAsiento)){
			System.out.println("El asiento " + unAsiento + " del vuelo " + unVuelo + " no esta disponible.");
		}else {
			unAsiento.ocupate();
		}
	}
	
	public void setRecargo() {
		
		if (tipoUsuario == "NoRegistrado") {
			this.recargo.add(new BigDecimal(20));
		}	
	}
	
	public String getTipoUsuario(){
		return tipoUsuario;
	}
	
	public BigDecimal getRecargo() {
		return recargo;
	}

}
