package testBusquedas;

import java.math.BigDecimal;
import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import criterios.CriterioBusqueda;
import criterios.CriterioPrecioAscendente;
import criterios.CriterioPrecioDescendente;
import criterios.CriterioTiempoDeVuelo;


import usuarios.TipoUsuario;
import usuarios.Usuario;
import usuarios.UsuarioConRecargo;
import usuarios.UsuarioEstandar;
import usuarios.UsuarioVIP;
import vuelos.Asiento;
import busquedas.Buscador;
import busquedas.Busqueda;
import busquedas.Opcionales;
import enumeraciones.ClaseDeAsiento;
import enumeraciones.DisponibilidadDeAsiento;
import enumeraciones.UbicacionDeAsiento;
import fechas.Fecha;
import filtros.FiltroClase;
import filtros.FiltroDisponibilidad;
import filtros.FiltroPrecio;
import filtros.FiltroSuperOferta;
import filtros.FiltroUbicacion;

public class TestBusquedasLanchita {

	private Buscador buscador;
	private CriterioBusqueda precioDes;
	private CriterioBusqueda precioAsc;
	private CriterioBusqueda tiempoVuelo;
	private Usuario usuarioA;
	private Usuario usuarioB;
	private TipoUsuario vip;
	private TipoUsuario conRecargo;
	private TipoUsuario estandar;
	private Busqueda busquedaA;
	private Busqueda busquedaB;
	private BigDecimal precioMin;
	private BigDecimal precioMax;
	private Opcionales opciones;
	private ArrayList<ClaseDeAsiento> clases;
	private ArrayList<UbicacionDeAsiento> ubicaciones;
	private ArrayList<DisponibilidadDeAsiento> disponibilidades;
	private FiltroClase fC;
	private FiltroUbicacion fU;
	private FiltroPrecio fP;
	private FiltroSuperOferta fSO;
	private FiltroDisponibilidad fD;
	private Fecha fechaA;
	

	@Before
	public void inicializador() {
		opciones = new Opcionales();
		buscador = new Buscador();
		precioDes = new CriterioPrecioDescendente();
		precioAsc = new CriterioPrecioAscendente();
		tiempoVuelo = new CriterioTiempoDeVuelo();
		usuarioA = new Usuario();
		usuarioB = new Usuario();
		vip = new UsuarioVIP();
		conRecargo = new UsuarioConRecargo();
		estandar = new UsuarioEstandar();
		precioMin = new BigDecimal(100.00);
		precioMax = new BigDecimal(8000.00);
		clases = new ArrayList<ClaseDeAsiento>();
		ubicaciones = new ArrayList<UbicacionDeAsiento>();
		disponibilidades = new ArrayList<DisponibilidadDeAsiento>();
		fechaA = new Fecha("20/12/2012");
		busquedaA = new Busqueda("EZE", fechaA, "USA", opciones);
		busquedaB = new Busqueda("PER", fechaA, "USA", opciones);
		fC = new FiltroClase();
		fU = new FiltroUbicacion();
		fP = new FiltroPrecio();
		fSO = new FiltroSuperOferta();
		fD = new FiltroDisponibilidad();
}

	@Test
	public void usuarioEstandarBuscaAsientosDisponiblesDeEzeAUsa() {
		usuarioA.setTipoUsuario(estandar);
		ArrayList<Asiento> asientosDisponibles = buscador.buscarAsientos(busquedaA, usuarioA);
		busquedaA.setResultado(buscador.armarListaConLaBusqueda(asientosDisponibles, usuarioA));
		System.out.println("Busqueda estandar EZE A USA no tiene asientos en turista: \n       "
							+ busquedaA.getResultado());
		Assert.assertEquals(0, asientosDisponibles.size());
	}
	
	@Test
	public void usuarioVipBuscaAsientosDisponiblesDeEzeAUsa() {
		usuarioA.setTipoUsuario(vip);
		ArrayList<Asiento> asientosDisponibles = buscador.buscarAsientos(busquedaA, usuarioA);
		busquedaA.setResultado(buscador.armarListaConLaBusqueda(asientosDisponibles, usuarioA));
		System.out.println("Busqueda vip de EZE a USA:\n       "
							+ busquedaA.getResultado());
		Assert.assertEquals(3, asientosDisponibles.size());
	}
	
	@Test
	public void usuarioEstandarBuscaAsientosDisponiblesDePerAUsa() {
		usuarioA.setTipoUsuario(estandar);
		ArrayList<Asiento> asientosDisponibles = buscador.buscarAsientos(busquedaB, usuarioA);
		busquedaA.setResultado(buscador.armarListaConLaBusqueda(asientosDisponibles, usuarioA));
		System.out.println("Busqueda estandar PER A USA: \n       "
							+ busquedaA.getResultado());
		Assert.assertEquals(3, asientosDisponibles.size());
	}
	
	@Test
	public void usuarioVipBuscaAsientosDisponiblesPorVentana() {
		usuarioA.setTipoUsuario(vip);
		buscador.setCriterio(precioAsc);
		buscador.getFiltros().add(fU);
		buscador.getFiltros().add(fD);
		ubicaciones.add(UbicacionDeAsiento.VENTANA);
		opciones.setOpcionales(clases, ubicaciones, disponibilidades, precioMin, precioMax);
		ArrayList<Asiento> asientosSegunUbicacionElegida = buscador.buscarAsientos(busquedaA, usuarioA);
		busquedaA.setResultado(buscador.armarListaConLaBusqueda(asientosSegunUbicacionElegida, usuarioA));
		System.out.println("Vip Ubic. Ventana " + busquedaA.getResultado());
		Assert.assertEquals(1, asientosSegunUbicacionElegida.size());
	}

	@Test
	public void usuarioVipBuscaAsientosPorPrimera() {
		usuarioA.setTipoUsuario(vip);
		buscador.setCriterio(precioAsc);
		clases.add(ClaseDeAsiento.PRIMERA);
		buscador.getFiltros().add(fC);
		opciones.setOpcionales(clases, ubicaciones, disponibilidades, precioMin, precioMax); 
		ArrayList<Asiento> asientosPorClase = buscador.buscarAsientos(busquedaA, usuarioA);
		busquedaA.setResultado(buscador.armarListaConLaBusqueda(asientosPorClase, usuarioA));
		System.out.println("Vip clase Ejecutiva " + busquedaA.getResultado());
		Assert.assertEquals(1, asientosPorClase.size());
	}
	
	@Test
	public void usuarioVipBuscaAsientosPorPrimeraYVentana() {
		usuarioA.setTipoUsuario(vip);
		buscador.setCriterio(precioAsc);
		buscador.getFiltros().add(fU);
		buscador.getFiltros().add(fC);
		ubicaciones.add(UbicacionDeAsiento.VENTANA);
		clases.add(ClaseDeAsiento.PRIMERA);
		opciones.setOpcionales(clases, ubicaciones, disponibilidades, precioMin, precioMax);
		ArrayList<Asiento> asientosPorPrecioYVentana = buscador.buscarAsientos(busquedaA, usuarioA);
		busquedaA.setResultado(buscador.armarListaConLaBusqueda(asientosPorPrecioYVentana, usuarioA));
		System.out.println("Vip Primera y Ventana " + busquedaA.getResultado());
		Assert.assertEquals(1, asientosPorPrecioYVentana.size());
	}
	
	@Test
	public void usuarioVipBuscaAsientosPorPrimeraYEjecutiva() {
		usuarioA.setTipoUsuario(vip);
		buscador.setCriterio(precioAsc);
		buscador.getFiltros().add(fC);
		clases.add(ClaseDeAsiento.PRIMERA);
		clases.add(ClaseDeAsiento.EJECUTIVA);
		opciones.setOpcionales(clases, ubicaciones, disponibilidades, precioMin, precioMax);
		ArrayList<Asiento> asientosPorPrecioYEjecutiva = buscador.buscarAsientos(busquedaA, usuarioA);
		busquedaA.setResultado(buscador.armarListaConLaBusqueda(asientosPorPrecioYEjecutiva, usuarioA));
		System.out.println("Vip Primera y Ejecutiva " + busquedaA.getResultado());
		Assert.assertEquals(3, asientosPorPrecioYEjecutiva.size());
	}
	
	@Test
	public void usuarioEstandarBuscaAsientosPorPrimeraYEjecutiva() {
		usuarioA.setTipoUsuario(estandar);
		buscador.setCriterio(precioAsc);
		buscador.getFiltros().add(fC);
		clases.add(ClaseDeAsiento.PRIMERA);
		clases.add(ClaseDeAsiento.EJECUTIVA);
		opciones.setOpcionales(clases, ubicaciones, disponibilidades, precioMin, precioMax);
		ArrayList<Asiento> asientosPorPrecioYVentana = buscador.buscarAsientos(busquedaA, usuarioA);
		busquedaA.setResultado(buscador.armarListaConLaBusqueda(asientosPorPrecioYVentana, usuarioA));
		System.out.println("Estandar Primer y Ejecutiva " + busquedaA.getResultado());
		Assert.assertEquals(0, asientosPorPrecioYVentana.size());
	}
	
	@Test
	public void usuarioConRecargoBuscaAsientosPorPrecio() {
		usuarioA.setTipoUsuario(conRecargo);
		buscador.setCriterio(precioAsc);
		buscador.getFiltros().add(fP);
		opciones.setOpcionales(clases, ubicaciones, disponibilidades, precioMin, precioMax);
		ArrayList<Asiento> asientosPorPrecio = buscador.buscarAsientos(busquedaA, usuarioA);
		busquedaA.setResultado(buscador.armarListaConLaBusqueda(asientosPorPrecio, usuarioA));
		System.out.println("ConRecargo precio entre 100 y 460: " + busquedaA.getResultado());
		Assert.assertEquals(0, asientosPorPrecio.size());
	}

	
	@Test
	public void usuarioEstandarBuscaAsientosPorPrecio() {
		usuarioA.setTipoUsuario(estandar);
		buscador.setCriterio(precioAsc);
		buscador.getFiltros().add(fP);
		opciones.setOpcionales(clases, ubicaciones, disponibilidades, precioMin, precioMax);
		ArrayList<Asiento> asientosPorPrecio = buscador.buscarAsientos(busquedaA, usuarioA);
		busquedaA.setResultado(buscador.armarListaConLaBusqueda(asientosPorPrecio, usuarioA));
		System.out.println("Estandar precio entre 100 y 461: " + busquedaA.getResultado());
		Assert.assertEquals(0, asientosPorPrecio.size());
	}
	
	@Test
	public void usuarioVipBuscaAsientosPorPrecioDescendenteEnOceanic() {
		usuarioA.setTipoUsuario(vip);
		buscador.setCriterio(precioDes);
		buscador.getFiltros().add(fP);
		opciones.setOpcionales(clases, ubicaciones, disponibilidades, precioMin, precioMax);
		ArrayList<Asiento> asientosPorPrecio = buscador.buscarAsientos(busquedaA, usuarioA);
		busquedaA.setResultado(buscador.armarListaConLaBusqueda(asientosPorPrecio, usuarioA));
		System.out.println("Vip precio entre 100 y 461: " + busquedaA.getResultado());
		Assert.assertTrue(asientosPorPrecio.get(1).getPrecio().compareTo(asientosPorPrecio.get(2).getPrecio()) >= 0);
	}
	
	@Test
	public void usuarioVipBuscaAsientosPorPrecioAscendente() {
		usuarioA.setTipoUsuario(vip);
		buscador.setCriterio(precioAsc);
		buscador.getFiltros().add(fP);
		opciones.setOpcionales(clases, ubicaciones, disponibilidades, precioMin, precioMax);
		ArrayList<Asiento> asientosPorPrecio = buscador.buscarAsientos(busquedaA, usuarioA);
		busquedaA.setResultado(buscador.armarListaConLaBusqueda(asientosPorPrecio, usuarioA));
		System.out.println("Vip precio entre 100 y 461: " + busquedaA.getResultado());
		Assert.assertTrue(asientosPorPrecio.get(1).getPrecio().compareTo(asientosPorPrecio.get(2).getPrecio()) <= 0);
	}
	
	@Test
	public void buscarAsientosSuperOfertaConUsuarioEstandar() {
		usuarioA.setTipoUsuario(estandar);
		buscador.setCriterio(precioAsc);
		buscador.getFiltros().add(fSO);
		ArrayList<Asiento> asientosSuperOferta = buscador.buscarAsientos(busquedaA, usuarioA);
		busquedaA.setResultado(buscador.armarListaConLaBusqueda(asientosSuperOferta, usuarioA));
		System.out.println("Estandar busca SuperOferta: " + busquedaA.getResultado());
		Assert.assertEquals("[]", asientosSuperOferta.toString());
	}
	
	@Test
	public void buscarAsientosSuperOfertaConUsuarioVip() {
		usuarioA.setTipoUsuario(vip);
		buscador.setCriterio(tiempoVuelo);
		buscador.getFiltros().add(fSO);
		ArrayList<Asiento> asientosSuperOferta = buscador.buscarAsientos(busquedaA, usuarioA);
		busquedaA.setResultado(buscador.armarListaConLaBusqueda(asientosSuperOferta, usuarioA));
		System.out.println("Vip busca SuperOferta: " + busquedaA.getResultado());
		Assert.assertEquals(3, asientosSuperOferta.size());
	}

}
