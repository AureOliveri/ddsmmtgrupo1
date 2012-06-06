package Usuarios;

import java.util.Collection;

import Vuelos.Vuelo;

public abstract class Usuario {
	
	public abstract String getTipoUsuario();
	
	Collection<Busqueda> historial;
	
	public void compraVuelo(Vuelo unVuelo){
		unVuelo.yaNoEstasDisponible();
	}

}
