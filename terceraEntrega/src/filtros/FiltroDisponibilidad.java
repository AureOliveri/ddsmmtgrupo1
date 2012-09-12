package filtros;

import busquedas.Busqueda;
import usuarios.Usuario;
import vuelos.Asiento;

public class FiltroDisponibilidad implements Filtro {

	public boolean aplicarFiltro(Busqueda busqueda, Usuario usuario, Asiento asiento) { 
		if (busqueda.getOpcionales().getDisponibilidades().isEmpty())
			return true;
		return busqueda.getOpcionales().getDisponibilidades().contains(asiento.getDisponibilidad());
	}
}
