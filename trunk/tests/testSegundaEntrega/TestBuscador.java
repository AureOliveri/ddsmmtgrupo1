package testSegundaEntrega;

import java.math.BigDecimal;
import java.util.ArrayList;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import enumeraciones.ClaseDeAsiento;

import usuarios.*;
import vuelos.Asiento;
import vuelos.Vuelo;

import busquedas.BuscaPorClase;
import busquedas.BuscaPorPrecio;
import busquedas.BuscaPorSuperOferta;
import busquedas.BuscaPorUbicacion;
import busquedas.BuscadorFinal;
import busquedas.BuscadorInicial;
import busquedas.Busqueda;
import busquedas.CriterioBusqueda;
import busquedas.CriterioPrecioAscendente;
import busquedas.CriterioPrecioDescendente;
import busquedas.Opcionales;

public class TestBuscador {

	private BuscadorFinal buscador;
	private BuscaPorClase buscadorPC;
	private BuscaPorUbicacion buscadorPU;
	private BuscaPorPrecio buscadorPP;
	private BuscaPorSuperOferta buscadorPSO;
	private CriterioBusqueda precioDes;
	private CriterioBusqueda precioAsc;
	private Usuario usuario;
	private TipoUsuario vip;
	private TipoUsuario conRecargo;
	private TipoUsuario estandar;
	private Busqueda busqueda;
	private BigDecimal precioMin;
	private BigDecimal precioMax;
	private Opcionales opciones;
	private ArrayList<String> clases;
	private ArrayList<String> ubicaciones;
	private Vuelo vuelo;

	@Before
	public void inicializador() {
		opciones = new Opcionales();
		buscador = new BuscadorInicial();
		buscadorPC = new BuscaPorClase(buscador);
		buscadorPU = new BuscaPorUbicacion(buscador);
		buscadorPP = new BuscaPorPrecio(buscador);
		buscadorPSO = new BuscaPorSuperOferta(buscador);
		precioDes = new CriterioPrecioDescendente();
		precioAsc = new CriterioPrecioAscendente();
		usuario = new Usuario();
		vip = new UsuarioVIP();
		conRecargo = new UsuarioConRecargo();
		estandar = new UsuarioEstandar();
		vuelo = new Vuelo();
		precioMin = new BigDecimal(100.00);
		precioMax = new BigDecimal(461.00);
		clases = new ArrayList<String>();
		ubicaciones = new ArrayList<String>();
		busqueda = new Busqueda("BUE", "20121010", "LA", opciones);
	
	}

// TODO Falta ver si hay que diferenciar clases y ubicaciones de asientos.
//	@Test
//	public void unUsuarioBuscaAsientosDisponiblesYNoHay() {
//		usuario.setTipoUsuario(estandar);
//		ArrayList<Asiento> asientos = buscador.buscarAsientos(busqueda, usuario, null, null);
//		System.out.println("Normal:   " + buscador.mostrarAsientosBusqueda(asientos, usuario));
//		Assert.assertFalse(buscador.noHayAsientosDisponibles(asientos));
//	}
//
//	@Test
//	public void unUsuarioEstandarBuscaAsientos() {
//		usuario.setTipoUsuario(estandar);
//		ArrayList<Asiento> asientosBuscados = buscador.buscarAsientos(busqueda, usuario, null, null);
//		System.out.println("Estandar: " + buscador.mostrarAsientosBusqueda(asientosBuscados, usuario));
//		Assert.assertNotNull(asientosBuscados);
//	}
//	
//	@Test
//	public void unUsuarioConRecargoBuscaAsientos() {
//		usuario.setTipoUsuario(conRecargo);
//		System.out.println("Recargo:  " + buscador.mostrarAsientosBusqueda(buscador.buscarAsientos(busqueda, usuario, null, null), usuario));
//		Assert.assertNotNull(buscador.buscarAsientos(busqueda, usuario, null, null));
//	}
//
//	@Test
//	public void unUsuarioVIPBuscaAsientos() {
//		usuario.setTipoUsuario(vip);
//		ArrayList<Asiento> asientosBuscados = buscador.buscarAsientos(busqueda, usuario, null, null);
//		System.out.println("Vip:      " + buscador.mostrarAsientosBusqueda(asientosBuscados, usuario));
//		Assert.assertNotNull(asientosBuscados);
//	}

	@Test
	public void usuarioVipBuscaAsientosPorUbicacion() {
		usuario.setTipoUsuario(vip);
		buscador.setCriterio(precioAsc);
		ubicaciones.add("C");
		opciones.setOpcionales(clases, ubicaciones, precioMin, precioMax);
		ArrayList<Asiento> asientosSegunUbicacionElegida = buscadorPU.buscarAsientos(busqueda, usuario);
		System.out.println("Vip Ubic. Ventana " + buscadorPU.mostrarAsientosBusqueda(asientosSegunUbicacionElegida, usuario));
		Assert.assertNotNull(asientosSegunUbicacionElegida);
	}

	@Test
	public void usuarioVipBuscaAsientosPorClase() {
		usuario.setTipoUsuario(vip);
		buscador.setCriterio(precioAsc);
		clases.add("P");
//		clases.add("E");
		opciones.setOpcionales(clases, ubicaciones, precioMin, precioMax); 
		ArrayList<Asiento> asientosPorClase = buscadorPC.buscarAsientos(busqueda, usuario);
		System.out.println("Vip clase Ejecutiva " + buscadorPC.mostrarAsientosBusqueda(asientosPorClase, usuario));
		Assert.assertNotNull(asientosPorClase);
	}
	
	@Test
	public void usuarioConRecargoBuscaAsientosPorPrecio() {
		usuario.setTipoUsuario(conRecargo);
		buscador.setCriterio(precioAsc);
		ArrayList<Asiento> asientosPorPrecio = buscador.buscarAsientos(busqueda, usuario);
		System.out.println("ConRecargo precio entre 100 y 461: " + buscador.mostrarAsientosBusqueda(asientosPorPrecio, usuario));
		Assert.assertNotNull(asientosPorPrecio);
	}

	
	@Test
	public void usuarioEstandarBuscaAsientosPorPrecio() {
		usuario.setTipoUsuario(estandar);
		buscador.setCriterio(precioAsc);
		ArrayList<Asiento> asientosPorPrecio = buscador.buscarAsientos(busqueda, usuario);
		System.out.println("Estandar precio entre 100 y 461: " + buscador.mostrarAsientosBusqueda(asientosPorPrecio, usuario));
		Assert.assertNotNull(asientosPorPrecio);
	}
	
	@Test
	public void usuarioVipBuscaAsientosPorPrecioDescendente() {
		usuario.setTipoUsuario(vip);
		buscador.setCriterio(precioDes);
		ArrayList<Asiento> asientosPorPrecio = buscador.buscarAsientos(busqueda, usuario);
		System.out.println("Vip precio entre 100 y 461: " + buscador.mostrarAsientosBusqueda(asientosPorPrecio, usuario));
		Assert.assertNotNull(asientosPorPrecio);
	}
	
	@Test
	public void usuarioVipBuscaAsientosPorPrecioAscendente() {
		usuario.setTipoUsuario(vip);
		buscador.setCriterio(precioAsc);
		ArrayList<Asiento> asientosPorPrecio = buscador.buscarAsientos(busqueda, usuario);
		System.out.println("Vip precio entre 100 y 461: " + buscador.mostrarAsientosBusqueda(asientosPorPrecio, usuario));
		Assert.assertNotNull(asientosPorPrecio);
	}
	
	@Test
	public void buscarAsientosSuperOfertaConUsuarioEstandar() {
		usuario.setTipoUsuario(estandar);
		buscador.setCriterio(precioAsc);
		ArrayList<Asiento> asientosSuperOferta = buscadorPSO.buscarAsientos(busqueda, usuario);
		System.out.println("Estandar busca SuperOferta: " + buscadorPSO.mostrarAsientosBusqueda(asientosSuperOferta, usuario));
		Assert.assertEquals("[]", asientosSuperOferta.toString());
	}
	
	@Test
	public void buscarAsientosSuperOfertaConUsuarioVip() {
		usuario.setTipoUsuario(vip);
		buscador.setCriterio(precioAsc);
		ArrayList<Asiento> asientosSuperOferta = buscadorPSO.buscarAsientos(busqueda, usuario);
		System.out.println("Vip busca SuperOferta: " + buscadorPSO.mostrarAsientosBusqueda(asientosSuperOferta, usuario));
		Assert.assertNotNull(asientosSuperOferta);
	}

//	@Test
//	public void mostrarUnAsiento() {
//		usuario.setTipoUsuario(estandar);
//		Asiento unAsiento = buscador.buscarAsientos(busqueda, usuario, null, null).get(1);
//		System.out.println(unAsiento.mostrarAsiento(unAsiento, buscador.getImpuesto(), usuario.getTipoUsuario()));
//		Assert.assertNotNull(unAsiento.mostrarAsiento(unAsiento, buscador.getImpuesto(), usuario.getTipoUsuario()));
//
//	}
}
