package busquedas;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.ArrayList;

import criterios.CriterioBusqueda;
import filtros.Filtro;

import usuarios.Usuario;
import vuelos.Asiento;

import aerolineas.Aerolineas;

public class Buscador {

	private Aerolineas aerolineas = new Aerolineas();
	protected CriterioBusqueda criterio;
	private ArrayList<Filtro> filtros = new ArrayList<Filtro>();

	public ArrayList<Asiento> buscarAsientos(Busqueda busqueda, Usuario usuario) {
		usuario.guardarBusqueda(busqueda);
		ArrayList<Asiento> asientos = new ArrayList<Asiento>();
		asientos = aerolineas.filtrarAsientos(busqueda);

		ArrayList<Asiento> asientosDeBusqueda = new ArrayList<Asiento>();

		if (!getFiltros().isEmpty()) {
			for (Asiento asiento : asientos) {
				boolean cumple = true;
				Filtro filtro = null;
				for (Iterator<Filtro> itFiltros = filtros.iterator(); itFiltros
						.hasNext() && cumple;) {
					filtro = itFiltros.next();
					cumple = filtro.aplicarFiltro(busqueda, usuario, asiento);
				}
				if (cumple) {
					asientosDeBusqueda.add(asiento);
				}
			}
			asientos = asientosDeBusqueda;
		}
		return usuario.getAsientosQueLeCorreponden(asientos);
	}

	public boolean noHayAsientosDisponibles(ArrayList<Asiento> asientos) {
		return asientos == null;
	}

	public ArrayList<ArrayList<String>> armarListaConLaBusqueda(
			ArrayList<Asiento> asientos, Usuario usuario) {
		if (this.getCriterio() == null) {
			ArrayList<ArrayList<String>> asientosBusqueda = new ArrayList<ArrayList<String>>();
			for (int i = 0; i < asientos.size(); i++) {
				BigDecimal impuesto = asientos.get(i).getVuelo().getAerolinea()
						.getImpuesto();
				ArrayList<String> valores = asientos.get(i).mostrarAsiento(
						asientos.get(i), impuesto, usuario.getTipoUsuario());
				asientosBusqueda.add(valores);
			}
			return asientosBusqueda;
		} else {
			return this.getCriterio()
					.mostrarAsientosBusqueda(asientos, usuario);
		}

	}

	public void setCriterio(CriterioBusqueda criterio) {
		this.criterio = criterio;
	}

	public CriterioBusqueda getCriterio() {
		return criterio;
	}

	public void setFiltros(ArrayList<Filtro> filtros) {
		this.filtros = filtros;
	}

	public ArrayList<Filtro> getFiltros() {
		return filtros;
	}

}
