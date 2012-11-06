package main.java.busquedas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import main.java.aerolineas.Aerolineas;
import main.java.criterios.CriterioBusqueda;
import main.java.filtros.Filtro;
import main.java.usuarios.TipoUsuario;
import main.java.usuarios.Usuario;
import main.java.vuelos.Asiento;
import main.java.vuelos.Vuelo;


public class Buscador {

	private static final Buscador INSTANCE = new Buscador();
	private Aerolineas aerolineas = new Aerolineas();
	protected CriterioBusqueda criterio;
	private ArrayList<Filtro> filtros = new ArrayList<Filtro>();

	public static Buscador getInstance() {
		return INSTANCE;
	}

	public ArrayList<Asiento> buscarAsientos(Busqueda busqueda, Usuario usuario) {
		usuario.guardarBusqueda(busqueda);
		ArrayList<Asiento> asientos = getAerolineas().filtrarAsientos(busqueda);
		asientos = aplicarFiltros(busqueda, usuario, asientos);
		for (Vuelo vuelo : getAerolineas().vuelosConEscala(busqueda.getOrigen(), busqueda.getDestino())) {
			asientos.addAll(vuelo.getAsientos());
		}
		return usuario.getAsientosQueLeCorreponden(asientos,
				usuario.getTipoUsuario());
	}

	private ArrayList<Asiento> aplicarFiltros(Busqueda busqueda,
			Usuario usuario, ArrayList<Asiento> asientos) {
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
		return asientos;
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

	public void mostrarAsientos(List<Asiento> resultado, TipoUsuario usuario) {
		if (resultado.isEmpty()) {
			System.out.println("         []");
		} else {
			for (Asiento asiento : resultado) {
				asiento.mostrar(usuario);
			}
		}
	}

	public void setAerolineas(Aerolineas aerolineas) {
		this.aerolineas = aerolineas;
	}

	public Aerolineas getAerolineas() {
		return aerolineas;
	}

}
