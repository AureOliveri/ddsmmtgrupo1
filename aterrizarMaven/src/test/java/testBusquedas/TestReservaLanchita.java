package test.java.testBusquedas;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;


import main.java.busquedas.Buscador;
import main.java.busquedas.Busqueda;
import main.java.enumeraciones.Ciudad;
import main.java.excepciones.ReservaNoEstandarException;
import main.java.fechas.Fecha;
import main.java.usuarios.Usuario;
import main.java.usuarios.UsuarioEstandar;
import main.java.usuarios.UsuarioVIP;
import main.java.vuelos.Asiento;

public class TestReservaLanchita {
	private static Usuario usuarioEstandar1;
	private static Usuario usuarioEstandar2;
	private static Usuario usuarioVip1;
	private static Buscador buscador;
	private static Fecha fecha;
	private static Busqueda busqueda;
	private static ArrayList<Asiento> asientos;
	private static Asiento asiento1;
	private static Asiento asiento2;
	private static Asiento asiento3;
	
	@Before
	public void inicializar() {
		usuarioEstandar1 = new Usuario("usuario 1", "11111111", new UsuarioEstandar());
		usuarioEstandar2 = new Usuario("usuario2", "22222222", new UsuarioEstandar());
		usuarioVip1 = new Usuario("usuario 3", "33333333", new UsuarioVIP());
		buscador = new Buscador();
		fecha = new Fecha("20/12/2012");
		busqueda = new Busqueda(Ciudad.PERU, fecha, Ciudad.ESTADOS_UNIDOS, null);
		asientos = buscador.buscarAsientos(busqueda, usuarioEstandar1);
		asiento1 = asientos.get(0);
		asiento2 = asientos.get(1);
		asiento3 = asientos.get(2);
	}
	
	
	
	@Test
	public void usuarioConReserva() {
		usuarioEstandar1.getTipoUsuario().reservarAsiento(asiento1, usuarioEstandar1);
		Assert.assertFalse(usuarioEstandar1.noTieneReserva(asiento1));
	}
	
	@Test (expected = ReservaNoEstandarException.class)
	public void reservaNoEstandar(){
		usuarioVip1.getTipoUsuario().reservarAsiento(asiento1, usuarioVip1);
	}
	
	@Test
	public void usuarioSinReserva(){
		Assert.assertTrue(usuarioEstandar2.noTieneReserva(asiento2));
	}
	
	@Test
	public void dobleReservaDeAsiento(){
		usuarioEstandar1.getTipoUsuario().reservarAsiento(asiento1, usuarioEstandar1);
		usuarioEstandar2.getTipoUsuario().reservarAsiento(asiento1, usuarioEstandar2);
		Assert.assertFalse(usuarioEstandar2.noTieneReserva(asiento1));
	}	

	@Test 
	public void ReservaExpirada(){
		usuarioEstandar1.getTipoUsuario().reservarAsiento(asiento3, usuarioEstandar1);
		asiento3.expirarReserva();
		Assert.assertTrue(usuarioEstandar1.noTieneReserva(asiento3));
	}
}
