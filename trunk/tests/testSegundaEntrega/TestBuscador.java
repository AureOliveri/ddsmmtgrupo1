package testSegundaEntrega;

import java.math.BigDecimal;
import java.util.ArrayList;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import usuarios.*;
import vuelos.Asiento;

import busquedas.Buscador;
import busquedas.Busqueda;

public class TestBuscador {

	private Buscador buscador;
	private Usuario usuario;
	private TipoUsuario vip;
	private TipoUsuario conRecargo;
	private TipoUsuario estandar;
	private Busqueda busqueda;

	@Before
	public void inicializador() {
		buscador = new Buscador();
		usuario = new Usuario();
		vip = new UsuarioVIP();
		conRecargo = new UsuarioConRecargo();
		estandar = new UsuarioEstandar();
		busqueda = new Busqueda("BUE", "20121010", "LA", null);
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
	public void mostrarPrecioDeUnAsiento() {
		usuario.setTipoUsuario(conRecargo);
		BigDecimal precio1 = buscador.buscarAsientos(busqueda, usuario).get(1).getPrecio().add(new BigDecimal(20));
		System.out.println(precio1);
		Assert.assertNotNull(precio1);
	}

	@Test
	public void unUsuarioConRecargoBuscaAsientosPorPrecio() {
		usuario.setTipoUsuario(conRecargo);
		ArrayList<BigDecimal> precios = buscador.buscarAsientosYMostrarPrecio(busqueda, usuario);
		System.out.println(precios);
		Assert.assertNotNull(precios);
	}

	@Test
	public void buscarAsientosPorUbicacion() {
		usuario.setTipoUsuario(vip);
		ArrayList<Asiento> asientosSegunUbicacionElegida = buscador.buscarAsientosPorUbicacion(busqueda, "V", usuario);
		Assert.assertNotNull(asientosSegunUbicacionElegida);
	}

	@Test
	public void buscarAsientosPorClase() {
		usuario.setTipoUsuario(vip);
		ArrayList<Asiento> asientosPorClase = buscador.buscarAsientosPorClase(busqueda, "E", usuario);
		System.out.println(buscador.mostrarAsientosBusqueda(asientosPorClase, usuario));
		Assert.assertNotNull(asientosPorClase);
	}

	@Test
	public void buscarAsientosSuperOfertaConUsuarioEstandar() {
		usuario.setTipoUsuario(estandar);
		ArrayList<Asiento> asientos = buscador.buscarAsientos(busqueda, usuario);
		ArrayList<Asiento> asientosSuperOferta = buscador.buscarAsientosSuperOferta(asientos, usuario.getTipoUsuario());
		Assert.assertEquals("[]", asientosSuperOferta.toString());
	}

	@Test
	public void mostrarUnAsiento() {
		usuario.setTipoUsuario(estandar);
		Asiento unAsiento = buscador.buscarAsientos(busqueda, usuario).get(0);
		System.out.println(unAsiento.mostrarAsiento(unAsiento, buscador.getImpuesto(), usuario.getTipoUsuario()));
		Assert.assertNotNull(unAsiento.mostrarAsiento(unAsiento, buscador.getImpuesto(), usuario.getTipoUsuario()));

	}
}
