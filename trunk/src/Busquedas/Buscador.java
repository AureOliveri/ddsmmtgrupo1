package Busquedas;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.lanchita.AerolineaLanchita;

import aerolineas.AerolineaLancha;

import Usuarios.TipoUsuario;
import Usuarios.Usuario;
import Usuarios.UsuarioVIP;
import Vuelos.Asiento;

public class Buscador {

	private AerolineaLancha aerolineaLanchita = new AerolineaLancha();
	private BigDecimal impuesto = aerolineaLanchita.getImpuesto();

	public ArrayList<Asiento> buscarAsientos(Busqueda busqueda, Usuario usuario) {
		usuario.guardarBusqueda(busqueda);
		ArrayList<Asiento> asientos = new ArrayList<Asiento>();
		AerolineaLanchita aerolineaAux = AerolineaLanchita.getInstance();

		String[][] asientosDisponibles = aerolineaAux.asientosDisponibles(busqueda.getOrigen(), busqueda.getDestino(),
				busqueda.getFechaSalida(), null, busqueda.getFechaLlegada(), null);
		int i;
		for (i = 0; i < asientosDisponibles.length; i++) {
			Asiento asiento = new Asiento(asientosDisponibles[i]);
			asientos.add(asiento);
		}
		
		return usuario.getAsientosQueLeCorreponden(asientos, this.impuesto);
		
	}

	public ArrayList<BigDecimal> buscarAsientosYMostrarPrecio(Busqueda busqueda, Usuario usuario) {
		ArrayList<BigDecimal> precios = new ArrayList<BigDecimal>();
		ArrayList<Asiento> asientos = this.buscarAsientos(busqueda, usuario);
		int i;
		for (i = 0; i < asientos.size(); i++) {
			Asiento asiento = asientos.get(i);
			BigDecimal precio = (asiento.precioTotal(this.impuesto, usuario.getTipoUsuario()));
			precios.add(precio);
		}

		return precios;
	}

	public boolean noHayAsientosDisponibles(ArrayList<Asiento> asientos) {
		return asientos == null;
	}

	public ArrayList<Asiento> buscarAsientosSuperOferta(ArrayList<Asiento> asientos, TipoUsuario usuario) {
		ArrayList<Asiento> asientosSuper = new ArrayList<Asiento>();

		for (Asiento asiento : asientos) {
			if (asiento.esSuperOferta(this.impuesto, usuario)) {
				asientosSuper.add(asiento);
			}
		}
		return asientosSuper;

	}

	public ArrayList<Asiento> buscarAsientosPorClase(Busqueda busqueda, String clase, Usuario usuario) {
		ArrayList<Asiento> asientosPorClase = new ArrayList<Asiento>();
		ArrayList<Asiento> asientosDeBusqueda = this.buscarAsientos(busqueda, usuario);
		for (Asiento asiento : asientosDeBusqueda) {
			if (asiento.getClaseDeAsiento().equals(clase)) {
				asientosPorClase.add(asiento);
			}
		}
		return asientosPorClase;

	}

	public ArrayList<Asiento> buscarAsientosPorUbicacion(Busqueda busqueda, String ubicacion, Usuario usuario) {
		ArrayList<Asiento> asientosUbicacion = new ArrayList<Asiento>();
		ArrayList<Asiento> asientosDeBusqueda = this.buscarAsientos(busqueda, usuario);

		for (Asiento asiento : asientosDeBusqueda) {
			if (asiento.getClaseDeAsiento().equals(ubicacion)) {
				asientosUbicacion.add(asiento);
			}
		}
		return asientosUbicacion;

	}

	public ArrayList<ArrayList<String>> mostrarAsientosBusqueda(ArrayList<Asiento> asientos, Usuario usuario) {
		ArrayList<ArrayList<String>> asientosBusquedaLindos = new ArrayList<ArrayList<String>>();
		int i;
		for (i = 0; i < asientos.size(); i++) {
			ArrayList<String> valores = asientos.get(i).mostrarAsiento(asientos.get(i), this.impuesto, usuario.getTipoUsuario());
			asientosBusquedaLindos.add(valores);
		}
		return asientosBusquedaLindos;
	}

	public BigDecimal getImpuesto() {
		return this.impuesto;
	}
}
