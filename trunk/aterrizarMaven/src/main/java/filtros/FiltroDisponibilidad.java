package main.java.filtros;

import main.java.busquedas.Busqueda;
import main.java.usuarios.Usuario;
import main.java.vuelos.Asiento;

public class FiltroDisponibilidad implements Filtro {

	public boolean aplicarFiltro(Busqueda busqueda, Usuario usuario, Asiento asiento) { 
		if (busqueda.getOpcionales().getDisponibilidades().isEmpty())
			return true;
		return busqueda.getOpcionales().getDisponibilidades().contains(asiento.getDisponibilidad());
	}
}
