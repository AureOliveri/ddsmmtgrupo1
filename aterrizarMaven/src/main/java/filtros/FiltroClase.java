package main.java.filtros;

import main.java.busquedas.Busqueda;
import main.java.usuarios.Usuario;
import main.java.vuelos.Asiento;

public class FiltroClase implements Filtro {

	public boolean aplicarFiltro(Busqueda busqueda, Usuario usuario, Asiento asiento) { 
		if (busqueda.getOpcionales().getClases().isEmpty())
			return true;
		return busqueda.getOpcionales().getClases().contains(asiento.getClaseDeAsiento());
	}
}
