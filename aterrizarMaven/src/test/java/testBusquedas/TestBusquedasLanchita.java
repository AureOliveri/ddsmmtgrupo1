package test.java.testBusquedas;

import java.math.BigDecimal;
import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import main.java.criterios.CriterioBusqueda;
import main.java.criterios.CriterioPrecioAscendente;
import main.java.criterios.CriterioPrecioDescendente;
import main.java.criterios.CriterioTiempoDeVuelo;


import main.java.usuarios.TipoUsuario;
import main.java.usuarios.Usuario;
import main.java.usuarios.UsuarioConRecargo;
import main.java.usuarios.UsuarioEstandar;
import main.java.usuarios.UsuarioVIP;
import main.java.vuelos.Asiento;
import main.java.busquedas.Buscador;
import main.java.busquedas.Busqueda;
import main.java.busquedas.Opcionales;
import main.java.enumeraciones.ClaseDeAsiento;
import main.java.enumeraciones.DisponibilidadDeAsiento;
import main.java.enumeraciones.UbicacionDeAsiento;
import main.java.fechas.Fecha;
import main.java.filtros.FiltroClase;
import main.java.filtros.FiltroDisponibilidad;
import main.java.filtros.FiltroPrecio;
import main.java.filtros.FiltroSuperOferta;
import main.java.filtros.FiltroUbicacion;

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
		System.out.println("Busqueda estandar EZE A USA no tiene asientos en turista:");
		buscador.mostrarAsientos(busquedaA.getResultado(), usuarioA.getTipoUsuario());
		Assert.assertEquals(0, asientosDisponibles.size());
	}
	
	@Test
	public void usuarioVipBuscaAsientosDisponiblesDeEzeAUsa() {
		usuarioA.setTipoUsuario(vip);
		ArrayList<Asiento> asientosDisponibles = buscador.buscarAsientos(busquedaA, usuarioA);
		busquedaA.setResultado(buscador.armarListaConLaBusqueda(asientosDisponibles, usuarioA));
		System.out.println("Busqueda vip de EZE a USA:");
		buscador.mostrarAsientos(busquedaA.getResultado(), usuarioA.getTipoUsuario());
		Assert.assertEquals(3, asientosDisponibles.size());
	}

	@Test
	public void usuarioEstandarBuscaAsientosDisponiblesDePerAUsa() {
		usuarioA.setTipoUsuario(estandar);
		ArrayList<Asiento> asientosDisponibles = buscador.buscarAsientos(busquedaB, usuarioA);
		busquedaB.setResultado(buscador.armarListaConLaBusqueda(asientosDisponibles, usuarioA));
		System.out.println("Busqueda estandar PER A USA:");
		buscador.mostrarAsientos(busquedaB.getResultado(), usuarioA.getTipoUsuario());
		Assert.assertEquals(3, asientosDisponibles.size());
	}
	
	@Test
	public void usuarioConRecargoBuscaAsientosDisponiblesDePerAUsa() {
		usuarioA.setTipoUsuario(conRecargo);
		usuarioB.setTipoUsuario(estandar);
		ArrayList<Asiento> asientosDisponiblesEstandar = buscador.buscarAsientos(busquedaB, usuarioB);
		ArrayList<Asiento> asientosDisponiblesConRecargo = buscador.buscarAsientos(busquedaB, usuarioA);
		busquedaB.setResultado(buscador.armarListaConLaBusqueda(asientosDisponiblesConRecargo, usuarioA));
		System.out.println("Busqueda con Recargo PER A USA:");
		buscador.mostrarAsientos(busquedaB.getResultado(), usuarioA.getTipoUsuario());
		Assert.assertEquals(asientosDisponiblesConRecargo.get(0).getPrecioConRecargo(), asientosDisponiblesEstandar.get(0).getPrecioFinal().add(usuarioA.getRecargo()));
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
		System.out.println("Vip Ubic. Ventana:");
		buscador.mostrarAsientos(busquedaA.getResultado(), usuarioA.getTipoUsuario());
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
		System.out.println("Vip clase Ejecutiva:");
		buscador.mostrarAsientos(busquedaA.getResultado(), usuarioA.getTipoUsuario());
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
		System.out.println("Vip Primera y Ventana:");
		buscador.mostrarAsientos(busquedaA.getResultado(), usuarioA.getTipoUsuario());
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
		System.out.println("Vip Primera y Ejecutiva:");
		buscador.mostrarAsientos(busquedaA.getResultado(), usuarioA.getTipoUsuario());
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
		System.out.println("Estandar Primer y Ejecutiva ");
		buscador.mostrarAsientos(busquedaA.getResultado(), usuarioA.getTipoUsuario());
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
		System.out.println("ConRecargo precio entre 100 y 460:");
		buscador.mostrarAsientos(busquedaA.getResultado(), usuarioA.getTipoUsuario());
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
		System.out.println("Estandar precio entre 100 y 461:");
		buscador.mostrarAsientos(busquedaA.getResultado(), usuarioA.getTipoUsuario());
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
		System.out.println("Vip precio entre 100 y 461:");
		buscador.mostrarAsientos(busquedaA.getResultado(), usuarioA.getTipoUsuario());
		Assert.assertTrue(asientosPorPrecio.get(1).getPrecioInicial().compareTo(asientosPorPrecio.get(2).getPrecioInicial()) >= 0);
	}
	
	@Test
	public void usuarioVipBuscaAsientosPorPrecioAscendente() {
		usuarioA.setTipoUsuario(vip);
		buscador.setCriterio(precioAsc);
		buscador.getFiltros().add(fP);
		opciones.setOpcionales(clases, ubicaciones, disponibilidades, precioMin, precioMax);
		ArrayList<Asiento> asientosPorPrecio = buscador.buscarAsientos(busquedaA, usuarioA);
		busquedaA.setResultado(buscador.armarListaConLaBusqueda(asientosPorPrecio, usuarioA));
		System.out.println("Vip precio entre 100 y 461:");
		buscador.mostrarAsientos(busquedaA.getResultado(), usuarioA.getTipoUsuario());
		Assert.assertTrue(asientosPorPrecio.get(1).getPrecioInicial().compareTo(asientosPorPrecio.get(2).getPrecioInicial()) <= 0);
	}
	
	@Test
	public void buscarAsientosSuperOfertaConUsuarioEstandar() {
		usuarioA.setTipoUsuario(estandar);
		buscador.setCriterio(precioAsc);
		buscador.getFiltros().add(fSO);
		ArrayList<Asiento> asientosSuperOferta = buscador.buscarAsientos(busquedaA, usuarioA);
		busquedaA.setResultado(buscador.armarListaConLaBusqueda(asientosSuperOferta, usuarioA));
		System.out.println("Estandar busca SuperOferta:");
		buscador.mostrarAsientos(busquedaA.getResultado(), usuarioA.getTipoUsuario());
		Assert.assertEquals("[]", asientosSuperOferta.toString());
	}
	
	@Test
	public void buscarAsientosSuperOfertaConUsuarioVip() {
		usuarioA.setTipoUsuario(vip);
		buscador.setCriterio(tiempoVuelo);
		buscador.getFiltros().add(fSO);
		ArrayList<Asiento> asientosSuperOferta = buscador.buscarAsientos(busquedaA, usuarioA);
		busquedaA.setResultado(buscador.armarListaConLaBusqueda(asientosSuperOferta, usuarioA));
		System.out.println("Vip busca SuperOferta:");
		buscador.mostrarAsientos(busquedaA.getResultado(), usuarioA.getTipoUsuario());
		Assert.assertEquals(3, asientosSuperOferta.size());
	}

}
