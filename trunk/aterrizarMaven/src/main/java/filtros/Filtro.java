package main.java.filtros;

import main.java.busquedas.Busqueda;
import main.java.usuarios.Usuario;
import main.java.vuelos.Asiento;

public interface Filtro {
	
	public boolean aplicarFiltro(Busqueda busqueda, Usuario usuario, Asiento asiento);

}
