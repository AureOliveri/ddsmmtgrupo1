package Usuarios;

import java.util.Collection;

import Vuelos.Asiento;
import Vuelos.Vuelo;

public abstract class Usuario {
	
	public abstract String getTipoUsuario();
	
	Collection<Busqueda> historial;
	
	public void compraAsiento(Asiento unAsiento, Vuelo unVuelo){
		if(unVuelo.yaNoEstasDisponible(unAsiento)){
			System.out.println("El asiento " + unAsiento + " del vuelo " + unVuelo + " no esta disponible.");
		}else {
			unAsiento.ocupate();
		}
	}

}
