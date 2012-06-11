package TestTDD;

import junit.framework.Assert;

import org.junit.Test;

import Usuarios.UsuarioEstandar;

import Busquedas.Busqueda;
import Busquedas.Buscador;


public class testBuscador {

	@Test
	public void unUsuarioBuscaAsientosDisponiblesYNoHay(){ //TODO revisar que da rojo.
		Buscador buscador = new Buscador();
		UsuarioEstandar usuario = new UsuarioEstandar();
		Busqueda busqueda = new Busqueda("BUE", "20121010", "LA"
						,null);
		Assert.assertTrue(buscador.noHayAsientosDisponibles
					(buscador.buscarAsientos(busqueda, usuario)));
	}
	
}
