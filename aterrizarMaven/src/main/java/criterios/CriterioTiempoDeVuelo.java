package main.java.criterios;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import main.java.usuarios.Usuario;
import main.java.vuelos.Asiento;

public class CriterioTiempoDeVuelo extends CriterioBusqueda {
	
	@Override
	public ArrayList<Asiento> armarListaBusqueda(ArrayList<Asiento> asientos, Usuario usuario) {
		Comparator<Asiento> comparatorAsiento = new Comparator<Asiento>() {
			public int compare (Asiento a, Asiento b) {
				BigDecimal tiempoA = new BigDecimal(a.getVuelo().getTiempoDeVuelo().getEnMilisegundos());
				BigDecimal tiempoB = new BigDecimal(b.getVuelo().getTiempoDeVuelo().getEnMilisegundos());
				return tiempoA.compareTo(tiempoB);
			}
		};
		Collections.sort(asientos, comparatorAsiento);
		
		return asientos;
	}
	
}
	
