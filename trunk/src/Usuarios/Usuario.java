package Usuarios;

import java.util.Collection;

import Vuelos.Asiento;
import Vuelos.Vuelo;

public abstract class Usuario {
	
	public abstract String getTipoUsuario();
	
	Collection<Busqueda> historial;
	
	public void compraVuelo(Asiento unAsiento, Vuelo unVuelo){
		unVuelo.yaNoEstasDisponible(unAsiento);
	}

}
