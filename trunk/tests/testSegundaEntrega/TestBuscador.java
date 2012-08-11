package testSegundaEntrega;

import java.math.BigDecimal;
import java.util.ArrayList;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import usuarios.*;
import vuelos.Asiento;
import vuelos.Vuelo;

import busquedas.Buscador;
import busquedas.Busqueda;

public class TestBuscador {

	private Buscador buscador;
	private Usuario usuario;
	private TipoUsuario vip;
	private TipoUsuario conRecargo;
	private TipoUsuario estandar;
	private Busqueda busqueda;
	private BigDecimal precioMin;
	private BigDecimal precioMax;
	private Vuelo vuelo;

	@Before
	public void inicializador() {
		buscador = new Buscador();
		usuario = new Usuario();
		vip = new UsuarioVIP();
		conRecargo = new UsuarioConRecargo();
		estandar = new UsuarioEstandar();
		vuelo = new Vuelo();
		precioMin = new BigDecimal(200.00);
		precioMax = new BigDecimal(461.00);
		busqueda = new Busqueda("BUE", "20121010", "LA");
	}

// TODO Falta ver si hay que diferenciar clases y ubicaciones de asientos.
	@Test
	public void unUsuarioBuscaAsientosDisponiblesYNoHay() {
		usuario.setTipoUsuario(estandar);
		ArrayList<Asiento> asientos = buscador.buscarAsientos(busqueda, usuario);
		System.out.println("Normal:   " + buscador.mostrarAsientosBusqueda(asientos, usuario));
		Assert.assertFalse(buscador.noHayAsientosDisponibles(asientos));
	}

	@Test
	public void unUsuarioEstandarBuscaAsientos() {
		usuario.setTipoUsuario(estandar);
		ArrayList<Asiento> asientosBuscados = buscador.buscarAsientos(busqueda, usuario);
		System.out.println("Estandar: " + buscador.mostrarAsientosBusqueda(asientosBuscados, usuario));
		Assert.assertNotNull(asientosBuscados);
	}
	
	@Test
	public void unUsuarioConRecargoBuscaAsientos() {
		usuario.setTipoUsuario(conRecargo);
		System.out.println("Recargo:  " + buscador.mostrarAsientosBusqueda(buscador.buscarAsientos(busqueda, usuario), usuario));
		Assert.assertNotNull(buscador.buscarAsientos(busqueda, usuario));
	}

	@Test
	public void unUsuarioVIPBuscaAsientos() {
		usuario.setTipoUsuario(vip);
		ArrayList<Asiento> asientosBuscados = buscador.buscarAsientos(busqueda, usuario);
		System.out.println("Vip:      " + buscador.mostrarAsientosBusqueda(asientosBuscados, usuario));
		Assert.assertNotNull(asientosBuscados);
	}

	@Test
	public void usuarioVipBuscaAsientosPorUbicacion() {
		usuario.setTipoUsuario(vip);
		ArrayList<Asiento> asientosSegunUbicacionElegida = buscador.buscarAsientosPorUbicacion(busqueda, "V", usuario);
		System.out.println("Vip Ubic. Ventana " + buscador.mostrarAsientosBusqueda(asientosSegunUbicacionElegida, usuario));
		Assert.assertNotNull(asientosSegunUbicacionElegida);
	}

	@Test
	public void usuarioVipBuscaAsientosPorClase() {
		usuario.setTipoUsuario(vip);
		ArrayList<Asiento> asientosPorClase = buscador.buscarAsientosPorClase(busqueda, "E", usuario);
		System.out.println("Vip clase Ejecutiva " + buscador.mostrarAsientosBusqueda(asientosPorClase, usuario));
		Assert.assertNotNull(asientosPorClase);
	}
	
	@Test
	public void usuarioConRecargoBuscaAsientosPorPrecio() {
		usuario.setTipoUsuario(conRecargo);
		ArrayList<Asiento> asientosPorPrecio = buscador.buscarAsientosPorPrecio(busqueda, usuario, precioMin, precioMax);
		System.out.println("ConRecargo precio entre 100 y 461: " + buscador.mostrarAsientosBusqueda(asientosPorPrecio, usuario));
		Assert.assertNotNull(asientosPorPrecio);
	}

	@Test
	public void usuarioEstandarBuscaAsientosPorPrecio() {
		usuario.setTipoUsuario(estandar);
		ArrayList<Asiento> asientosPorPrecio = buscador.buscarAsientosPorPrecio(busqueda, usuario, precioMin, precioMax);
		System.out.println("Estandar precio entre 100 y 461: " + buscador.mostrarAsientosBusqueda(asientosPorPrecio, usuario));
		Assert.assertNotNull(asientosPorPrecio);
	}
	
	@Test
	public void usuarioVipBuscaAsientosPorPrecio() {
		usuario.setTipoUsuario(vip);
		ArrayList<Asiento> asientosPorPrecio = buscador.buscarAsientosPorPrecio(busqueda, usuario, precioMin, precioMax);
		System.out.println("Vip precio entre 100 y 461: " + buscador.mostrarAsientosBusqueda(asientosPorPrecio, usuario));
		Assert.assertNotNull(asientosPorPrecio);
	}
	@Test
	public void buscarAsientosSuperOfertaConUsuarioEstandar() {
		usuario.setTipoUsuario(estandar);
		ArrayList<Asiento> asientos = buscador.buscarAsientos(busqueda, usuario);
		ArrayList<Asiento> asientosSuperOferta = buscador.buscarAsientosSuperOferta(asientos, usuario);
		System.out.println("Estandar busca SuperOferta: " + buscador.mostrarAsientosBusqueda(asientosSuperOferta, usuario));
		Assert.assertEquals("[]", asientosSuperOferta.toString());
	}

	@Test
	public void mostrarUnAsiento() {
		usuario.setTipoUsuario(estandar);
		Asiento unAsiento = buscador.buscarAsientos(busqueda, usuario).get(1);
		System.out.println(unAsiento.mostrarAsiento(unAsiento, buscador.getImpuesto(), usuario.getTipoUsuario()));
		Assert.assertNotNull(unAsiento.mostrarAsiento(unAsiento, buscador.getImpuesto(), usuario.getTipoUsuario()));

	}
}
