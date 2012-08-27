package filtros;


import busquedas.Busqueda;

import usuarios.Usuario;
import vuelos.Asiento;

public class FiltroSuperOferta implements Filtro {

	public boolean aplicarFiltro(Busqueda busqueda, Usuario usuario, Asiento asiento) { 
	
		return asiento.esSuperOferta();
	}
}
