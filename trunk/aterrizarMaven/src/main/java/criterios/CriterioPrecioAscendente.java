package main.java.criterios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import main.java.usuarios.Usuario;
import main.java.vuelos.Asiento;

public class CriterioPrecioAscendente extends CriterioBusqueda {
	
	@Override
	public ArrayList<Asiento> armarListaBusqueda(ArrayList<Asiento> asientos, Usuario usuario) {
		Comparator<Asiento> comparatorAsiento = new Comparator<Asiento>() {
			public int compare (Asiento a, Asiento b) {
				return a.getPrecioInicial().compareTo(b.getPrecioInicial());
			}
		};
		Collections.sort(asientos, comparatorAsiento);
		
		return asientos;
	}
	
}
	
