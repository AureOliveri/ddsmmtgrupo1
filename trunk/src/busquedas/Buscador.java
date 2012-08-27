package busquedas;

import java.util.Iterator;
import java.util.ArrayList;

import criterios.CriterioBusqueda;
import filtros.Filtro;

import usuarios.TipoUsuario;
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
		return usuario.getAsientosQueLeCorreponden(asientos, usuario.getTipoUsuario());
	}

	public boolean noHayAsientosDisponibles(ArrayList<Asiento> asientos) {
		return asientos == null;
	}

	public ArrayList<Asiento> armarListaConLaBusqueda(
			ArrayList<Asiento> asientos, Usuario usuario) {
		if (this.getCriterio() == null) {
			return asientos;
		} else {
			return this.getCriterio().armarListaBusqueda(asientos, usuario);
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

	public void mostrarAsientos(ArrayList<Asiento> resultado, TipoUsuario usuario) {
		if (resultado.isEmpty()) {
			System.out.println("         []");
		} else {
			for (Asiento asiento : resultado) {
				asiento.mostrar(usuario);
			}
		}
	}

}
