package busquedas;

import java.math.BigDecimal;
import java.util.ArrayList;

import usuarios.TipoUsuario;
import usuarios.Usuario;
import usuarios.UsuarioVIP;
import vuelos.Asiento;
import busquedas.BuscadorFinal;

import com.lanchita.AerolineaLanchita;

import aerolineas.AerolineaLancha;


public class BuscadorInicial implements BuscadorFinal{

	private AerolineaLancha aerolineaLanchita = new AerolineaLancha();
	private BigDecimal impuesto = aerolineaLanchita.getImpuesto();

	@Override
	public ArrayList<Asiento> buscarAsientos(Busqueda busqueda, Usuario usuario) {
		usuario.guardarBusqueda(busqueda);
		ArrayList<Asiento> asientos = new ArrayList<Asiento>();
		AerolineaLanchita aerolineaAux = AerolineaLanchita.getInstance();

		String[][] asientosDisponibles = aerolineaAux.asientosDisponibles(busqueda.getOrigen(), busqueda.getDestino(),
				busqueda.getFechaViaje(), null, null, null);
		int i;
		for (i = 0; i < asientosDisponibles.length; i++) {
			Asiento asiento = new Asiento(asientosDisponibles[i]);
			asientos.add(asiento);
		}
		
		return usuario.getAsientosQueLeCorreponden(asientos, this.impuesto);
		
	}

	//TODO Creo que este metodo esta de mas. Esta el metodo buscar asientos por precio de la entrega 3, borre su test.
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

	public ArrayList<Asiento> buscarAsientosSuperOferta(ArrayList<Asiento> asientos, Usuario usuario) {
		ArrayList<Asiento> asientosSuper = new ArrayList<Asiento>();

		for (Asiento asiento : asientos) {
			if (asiento.esSuperOferta(this.impuesto, usuario.getTipoUsuario())) {
				asientosSuper.add(asiento);
			}
		}
		return asientosSuper;

	}

//	public ArrayList<Asiento> buscarAsientosPorClase(Busqueda busqueda, String clase, Usuario usuario) {
//		ArrayList<Asiento> asientosPorClase = new ArrayList<Asiento>();
//		ArrayList<Asiento> asientosDeBusqueda = this.buscarAsientos(busqueda, usuario, null, null);
//		for (Asiento asiento : asientosDeBusqueda) {
//			if (asiento.getClaseDeAsiento().equals(clase)) {
//				asientosPorClase.add(asiento);
//			}
//		}
//		return asientosPorClase;
//
//	}

	public ArrayList<Asiento> buscarAsientosPorPrecio(Busqueda busqueda, Usuario usuario, BigDecimal precioMin, BigDecimal precioMax) {
		ArrayList<Asiento> asientosPorPrecio = new ArrayList<Asiento>();
		ArrayList<Asiento> asientosDeBusqueda = this.buscarAsientos(busqueda, usuario);

		for (Asiento asiento : asientosDeBusqueda) {
			BigDecimal precioTotal = asiento.precioTotal(this.impuesto , usuario.getTipoUsuario());
			if ((precioTotal.compareTo(precioMin) >= 0 ) && (precioTotal.compareTo(precioMax) <= 0)) {
				asientosPorPrecio.add(asiento);
			}
		}
		return asientosPorPrecio;
	}
	
	public ArrayList<ArrayList<String>> mostrarAsientosBusqueda(ArrayList<Asiento> asientos, Usuario usuario) {
		ArrayList<ArrayList<String>> asientosBusqueda = new ArrayList<ArrayList<String>>();
		int i;
		for (i = 0; i < asientos.size(); i++) {
			ArrayList<String> valores = asientos.get(i).mostrarAsiento(asientos.get(i), this.impuesto, usuario.getTipoUsuario());
			asientosBusqueda.add(valores);
		}
		return asientosBusqueda;
	}

	public BigDecimal getImpuesto() {
		return this.impuesto;
	}
}