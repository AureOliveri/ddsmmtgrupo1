package main.java.filtros;

import main.java.busquedas.Busqueda;
import main.java.usuarios.Usuario;
import main.java.vuelos.Asiento;

public class FiltroUbicacion implements Filtro {

	public boolean aplicarFiltro(Busqueda busqueda, Usuario usuario, Asiento asiento) { 
		if (busqueda.getOpcionales().getUbicaciones().isEmpty())
			return true;
		return busqueda.getOpcionales().getUbicaciones().contains(asiento.getUbicacion());
	}
}
