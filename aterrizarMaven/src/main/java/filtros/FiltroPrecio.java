package main.java.filtros;

import main.java.busquedas.Busqueda;

import main.java.usuarios.Usuario;
import main.java.vuelos.Asiento;

public class FiltroPrecio implements Filtro {

	public boolean aplicarFiltro(Busqueda busqueda, Usuario usuario, Asiento asiento) { 
		boolean cumplePrecioMin = true;
		boolean cumplePrecioMax = true;
		if (busqueda.getOpcionales().getPrecioMin() == null) {
			cumplePrecioMin = true;
		} else {
			cumplePrecioMin = asiento.getPrecioFinal().compareTo(busqueda.getOpcionales().getPrecioMin()) >= 0;
		}
		if (busqueda.getOpcionales().getPrecioMax() == null) {
			cumplePrecioMax = true;
		} else {
			cumplePrecioMax = asiento.getPrecioFinal().compareTo(busqueda.getOpcionales().getPrecioMax()) <= 0;
		}
		return cumplePrecioMin && cumplePrecioMax;
	}
}
