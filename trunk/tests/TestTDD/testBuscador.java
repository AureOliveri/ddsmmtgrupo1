package TestTDD;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;

import Usuarios.UsuarioEstandar;
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
	
}
