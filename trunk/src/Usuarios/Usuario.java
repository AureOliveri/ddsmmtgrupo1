package Usuarios;

import java.util.Collection;

import Busquedas.Busqueda;
import Vuelos.Asiento;
import Vuelos.Vuelo;

public abstract class Usuario {
	
	protected String tipoUsuario;
	
	public String getTipoUsuario(){
		return tipoUsuario;
	}
	
	Collection<Busqueda> historial;
	
	public void compraAsiento(Asiento unAsiento, Vuelo unVuelo){
		if(unVuelo.yaNoEstasDisponible(unAsiento)){
			System.out.println("El asiento " + unAsiento + " del vuelo " + unVuelo + " no esta disponible.");
		}else {
			unAsiento.ocupate();
		}
	}

}
