package criterios;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import usuarios.Usuario;
import vuelos.Asiento;

public class CriterioPopularidad extends CriterioBusqueda {
	
	@Override
	public ArrayList<Asiento> armarListaBusqueda(ArrayList<Asiento> asientos, Usuario usuario) {
		Comparator<Asiento> comparatorAsiento = new Comparator<Asiento>() {
			public int compare (Asiento a, Asiento b) {
				BigDecimal popuA = new BigDecimal(a.getVuelo().getPopularidad());
				BigDecimal popuB = new BigDecimal(b.getVuelo().getPopularidad());
				return popuB.compareTo(popuA);
			}
		};
		Collections.sort(asientos, comparatorAsiento);
		
		return asientos;
	}
	
}
	
