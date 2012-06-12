package TestTDD;

import java.math.BigDecimal;
import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;

import com.lanchita.AerolineaLanchita;

import Usuarios.*;
import Vuelos.Asiento;

import Busquedas.Busqueda;
import Busquedas.Buscador;


public class testBuscador {

	@Test
	public void unUsuarioBuscaAsientosDisponiblesYNoHay(){
		Buscador buscador = new Buscador();
		UsuarioEstandar usuario = new UsuarioEstandar();
		Busqueda busqueda = new Busqueda("BUE", "20121010", "LA"
						,null);
		ArrayList<Asiento> asientos = buscador.buscarAsientos(busqueda, usuario);
		Assert.assertFalse(buscador.noHayAsientosDisponibles
					(asientos));
	}
	@Test
	public void unUsuarioEstandarBuscaAsientos(){
		Buscador buscador = new Buscador();
		UsuarioEstandar usuario = new UsuarioEstandar();
		Busqueda busqueda = new Busqueda("BUE", "20121010", "LA"
						,null);
		Assert.assertNotNull(buscador.buscarAsientos(busqueda, usuario));
		}
	@Test
	public void unUsuarioConRecargoBuscaAsientos(){
		Buscador buscador = new Buscador();
		UsuarioConRecargo usuario = new UsuarioConRecargo();
		Busqueda busqueda = new Busqueda("BUE", "20121010", "LA"
						,null);
		Assert.assertNotNull(buscador.buscarAsientos(busqueda, usuario));
		}
	@Test
	public void unUsuarioVIPBuscaAsientos(){
		Buscador buscador = new Buscador();
		UsuarioVIP usuario = new UsuarioVIP();
		Busqueda busqueda = new Busqueda("BUE", "20121010", "LA"
						,null);
		Assert.assertNotNull(buscador.buscarAsientos(busqueda, usuario));
		}
	@Test
	public void mostrarPrecioDeUnAsiento(){
		UsuarioConRecargo usuario = new UsuarioConRecargo();
		Buscador buscador = new Buscador();
		Busqueda busqueda = new Busqueda("BUE", "20121010", "LA"
						,null);
		BigDecimal precio1 = buscador.buscarAsientos(busqueda,usuario).get(1).getPrecio().add(new BigDecimal(20));
		System.out.println(precio1);
		Assert.assertNotNull(precio1);
	}
	@Test
	public void unUsuarioConRecargoBuscaAsientosPorPrecio(){
		Buscador buscador = new Buscador();
		UsuarioConRecargo usuario = new UsuarioConRecargo();
		Busqueda busqueda = new Busqueda("BUE", "20121010", "LA"
						,null);
		ArrayList<BigDecimal> precios = buscador.buscarAsientosYMostrarPrecio(busqueda, usuario);
		System.out.println(precios);
		Assert.assertNotNull(precios);
		}
	
}
