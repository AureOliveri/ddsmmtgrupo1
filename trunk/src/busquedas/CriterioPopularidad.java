package busquedas;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import usuarios.Usuario;
import vuelos.Asiento;

public class CriterioPopularidad extends CriterioBusqueda {
	
	@Override
	public ArrayList<ArrayList<String>> mostrarAsientosBusqueda(ArrayList<Asiento> asientos, Usuario usuario) {
		ArrayList<ArrayList<String>> asientosBusqueda = new ArrayList<ArrayList<String>>();
		int i;
		Comparator<Asiento> comparatorAsiento = new Comparator<Asiento>() {
			public int compare (Asiento a, Asiento b) {
				BigDecimal popuA = new BigDecimal(a.getVuelo().getPopularidad());
				BigDecimal popuB = new BigDecimal(b.getVuelo().getPopularidad());
				return popuB.compareTo(popuA);
			}
		};
		Collections.sort(asientos, comparatorAsiento);
		for (i = 0; i < asientos.size(); i++) {
			BigDecimal impuesto = asientos.get(i).getVuelo().getAerolinea().getImpuesto();
			ArrayList<String> valores = asientos.get(i).mostrarAsiento(asientos.get(i), impuesto, usuario.getTipoUsuario());
			asientosBusqueda.add(valores);
		}
		
		return asientosBusqueda;
	}
	
}
	
