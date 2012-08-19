package testSegundaEntrega;

import java.math.BigDecimal;
import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;


import usuarios.TipoUsuario;
import usuarios.Usuario;
import usuarios.UsuarioConRecargo;
import usuarios.UsuarioEstandar;
import usuarios.UsuarioVIP;
import vuelos.Asiento;
import busquedas.Buscador;
import busquedas.Busqueda;
import busquedas.CriterioBusqueda;
import busquedas.CriterioPrecioAscendente;
import busquedas.CriterioPrecioDescendente;
import busquedas.CriterioTiempoDeVuelo;
import busquedas.FiltroClase;
import busquedas.FiltroPrecio;
import busquedas.FiltroSuperOferta;
import busquedas.FiltroUbicacion;
import busquedas.Opcionales;
import enumeraciones.ClaseDeAsiento;
import enumeraciones.UbicacionDeAsiento;
import fechas.Fecha;

public class TestBuscador {

	private Buscador buscador;
	private CriterioBusqueda precioDes;
	private CriterioBusqueda precioAsc;
	private CriterioBusqueda tiempoVuelo;
	private Usuario usuario;
	private TipoUsuario vip;
	private TipoUsuario conRecargo;
	private TipoUsuario estandar;
	private Busqueda busqueda;
	private BigDecimal precioMin;
	private BigDecimal precioMax;
	private Opcionales opciones;
	private ArrayList<ClaseDeAsiento> clases;
	private ArrayList<UbicacionDeAsiento> ubicaciones;
	private FiltroClase fC;
	private FiltroUbicacion fU;
	private FiltroPrecio fP;
	private FiltroSuperOferta fSO;
	private Fecha fechaV;
	

	@Before
	public void inicializador() {
		opciones = new Opcionales();
		buscador = new Buscador();
		precioDes = new CriterioPrecioDescendente();
		precioAsc = new CriterioPrecioAscendente();
		tiempoVuelo = new CriterioTiempoDeVuelo();
		usuario = new Usuario();
		vip = new UsuarioVIP();
		conRecargo = new UsuarioConRecargo();
		estandar = new UsuarioEstandar();
		precioMin = new BigDecimal(100.00);
		precioMax = new BigDecimal(460.00);
		clases = new ArrayList<ClaseDeAsiento>();
		ubicaciones = new ArrayList<UbicacionDeAsiento>();
		fechaV = new Fecha("20/12/2012");
		busqueda = new Busqueda("EZE", fechaV, "USA", opciones);
		fC = new FiltroClase();
		fU = new FiltroUbicacion();
		fP = new FiltroPrecio();
		fSO = new FiltroSuperOferta();
}

	@Test
	public void usuarioVipBuscaAsientosPorVentana() {
		usuario.setTipoUsuario(vip);
		buscador.setCriterio(precioAsc);
		buscador.getFiltros().add(fU);
		ubicaciones.add(UbicacionDeAsiento.VENTANA);
		opciones.setOpcionales(clases, ubicaciones, precioMin, precioMax);
		ArrayList<Asiento> asientosSegunUbicacionElegida = buscador.buscarAsientos(busqueda, usuario);
		System.out.println("Vip Ubic. Ventana " + buscador.mostrarAsientosBusqueda(asientosSegunUbicacionElegida, usuario));
		Assert.assertEquals(1, asientosSegunUbicacionElegida.size());
	}

	@Test
	public void usuarioVipBuscaAsientosPorPrimera() {
		usuario.setTipoUsuario(vip);
		buscador.setCriterio(precioAsc);
		clases.add(ClaseDeAsiento.PRIMERA);
		buscador.getFiltros().add(fC);
		opciones.setOpcionales(clases, ubicaciones, precioMin, precioMax); 
		ArrayList<Asiento> asientosPorClase = buscador.buscarAsientos(busqueda, usuario);
		System.out.println("Vip clase Ejecutiva " + buscador.mostrarAsientosBusqueda(asientosPorClase, usuario));
		Assert.assertEquals(1, asientosPorClase.size());
	}
	
	@Test
	public void usuarioVipBuscaAsientosPorPrimeraYVentana() {
		usuario.setTipoUsuario(vip);
		buscador.setCriterio(precioAsc);
		buscador.getFiltros().add(fU);
		buscador.getFiltros().add(fC);
		ubicaciones.add(UbicacionDeAsiento.VENTANA);
		clases.add(ClaseDeAsiento.PRIMERA);
		opciones.setOpcionales(clases, ubicaciones, precioMin, precioMax);
		ArrayList<Asiento> asientosPorPrecioYVentana = buscador.buscarAsientos(busqueda, usuario);
		System.out.println("Vip Primera y Ventana " + buscador.mostrarAsientosBusqueda(asientosPorPrecioYVentana, usuario));
		Assert.assertEquals(1, asientosPorPrecioYVentana.size());
	}
	
	@Test
	public void usuarioVipBuscaAsientosPorPrimeraYEjecutiva() {
		usuario.setTipoUsuario(vip);
		buscador.setCriterio(precioAsc);
		buscador.getFiltros().add(fC);
		clases.add(ClaseDeAsiento.PRIMERA);
		clases.add(ClaseDeAsiento.EJECUTIVA);
		opciones.setOpcionales(clases, ubicaciones, precioMin, precioMax);
		ArrayList<Asiento> asientosPorPrecioYVentana = buscador.buscarAsientos(busqueda, usuario);
		System.out.println("Vip Primera y Ejecutiva " + buscador.mostrarAsientosBusqueda(asientosPorPrecioYVentana, usuario));
		Assert.assertEquals(3, asientosPorPrecioYVentana.size());
	}
	
	@Test
	public void usuarioEstandarBuscaAsientosPorPrimeraYEjecutiva() {
		usuario.setTipoUsuario(estandar);
		buscador.setCriterio(precioAsc);
		buscador.getFiltros().add(fC);
		clases.add(ClaseDeAsiento.PRIMERA);
		clases.add(ClaseDeAsiento.EJECUTIVA);
		opciones.setOpcionales(clases, ubicaciones, precioMin, precioMax);
		ArrayList<Asiento> asientosPorPrecioYVentana = buscador.buscarAsientos(busqueda, usuario);
		System.out.println("Estandar Primer y Ejecutiva " + buscador.mostrarAsientosBusqueda(asientosPorPrecioYVentana, usuario));
		Assert.assertEquals(0, asientosPorPrecioYVentana.size());
	}
	
	@Test
	public void usuarioConRecargoBuscaAsientosPorPrecio() {
		usuario.setTipoUsuario(conRecargo);
		buscador.setCriterio(precioAsc);
		buscador.getFiltros().add(fP);
		opciones.setOpcionales(clases, ubicaciones, precioMin, precioMax);
		ArrayList<Asiento> asientosPorPrecio = buscador.buscarAsientos(busqueda, usuario);
		System.out.println("ConRecargo precio entre 100 y 460: " + buscador.mostrarAsientosBusqueda(asientosPorPrecio, usuario));
		Assert.assertEquals(0, asientosPorPrecio.size());
	}

	
	@Test
	public void usuarioEstandarBuscaAsientosPorPrecio() {
		usuario.setTipoUsuario(estandar);
		buscador.setCriterio(precioAsc);
		buscador.getFiltros().add(fP);
		opciones.setOpcionales(clases, ubicaciones, precioMin, precioMax);
		ArrayList<Asiento> asientosPorPrecio = buscador.buscarAsientos(busqueda, usuario);
		System.out.println("Estandar precio entre 100 y 461: " + buscador.mostrarAsientosBusqueda(asientosPorPrecio, usuario));
		Assert.assertEquals(0, asientosPorPrecio.size());
	}
	
	@Test
	public void usuarioVipBuscaAsientosPorPrecioDescendente() {
		usuario.setTipoUsuario(vip);
		buscador.setCriterio(precioDes);
		buscador.getFiltros().add(fP);
		opciones.setOpcionales(clases, ubicaciones, precioMin, precioMax);
		ArrayList<Asiento> asientosPorPrecio = buscador.buscarAsientos(busqueda, usuario);
		System.out.println("Vip precio entre 100 y 461: " + buscador.mostrarAsientosBusqueda(asientosPorPrecio, usuario));
		Assert.assertTrue(asientosPorPrecio.get(1).getPrecio().compareTo(asientosPorPrecio.get(2).getPrecio()) >= 0);
	}
	
	@Test
	public void usuarioVipBuscaAsientosPorPrecioAscendente() {
		usuario.setTipoUsuario(vip);
		buscador.setCriterio(precioAsc);
		buscador.getFiltros().add(fP);
		opciones.setOpcionales(clases, ubicaciones, precioMin, precioMax);
		ArrayList<Asiento> asientosPorPrecio = buscador.buscarAsientos(busqueda, usuario);
		System.out.println("Vip precio entre 100 y 461: " + buscador.mostrarAsientosBusqueda(asientosPorPrecio, usuario));
		Assert.assertTrue(asientosPorPrecio.get(1).getPrecio().compareTo(asientosPorPrecio.get(2).getPrecio()) <= 0);
	}
	
	@Test
	public void buscarAsientosSuperOfertaConUsuarioEstandar() {
		usuario.setTipoUsuario(estandar);
		buscador.setCriterio(precioAsc);
		buscador.getFiltros().add(fSO);
		ArrayList<Asiento> asientosSuperOferta = buscador.buscarAsientos(busqueda, usuario);
		System.out.println("Estandar busca SuperOferta: " + buscador.mostrarAsientosBusqueda(asientosSuperOferta, usuario));
		Assert.assertEquals("[]", asientosSuperOferta.toString());
	}
	
	@Test
	public void buscarAsientosSuperOfertaConUsuarioVip() {
		usuario.setTipoUsuario(vip);
		buscador.setCriterio(tiempoVuelo);
		buscador.getFiltros().add(fSO);
		ArrayList<Asiento> asientosSuperOferta = buscador.buscarAsientos(busqueda, usuario);
		System.out.println("Vip busca SuperOferta: " + buscador.mostrarAsientosBusqueda(asientosSuperOferta, usuario));
		Assert.assertEquals(3, asientosSuperOferta.size());
	}

}
