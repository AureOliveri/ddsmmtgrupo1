package test.java.testBusquedas;

import java.util.ArrayList;

import org.junit.Assert;
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

public class TestReservaOceanic {

	private static Usuario usuarioEstandar1;
	private static Usuario usuarioEstandar2;
	private static Usuario usuarioVip1;
	private static Fecha fecha;
	private static Busqueda busqueda;
	private static Buscador buscador;
	private static ArrayList<Asiento> asientos;	
	private static Asiento asiento1;
	private static Asiento asiento2;
	private static Asiento asiento3;
	
	@Before
	public void inicializar(){
		usuarioEstandar1 = new Usuario("usuario Estandar 1", "11111111", new UsuarioEstandar());
		usuarioEstandar2 = new Usuario("Usuario Estandar 2", "22222222", new UsuarioEstandar());
		usuarioVip1 = new Usuario("usuario vip 1", "33333333", new UsuarioVIP());
		fecha = new Fecha("15/08/2012");
		busqueda = new Busqueda(Ciudad.BUENOS_AIRES, fecha, Ciudad.LOS_ANGELES, null);
		buscador = new Buscador();
		asientos = buscador.buscarAsientos(busqueda, usuarioVip1);
		asiento1 = asientos.get(0);
		asiento2 = asientos.get(1);
		asiento3 = asientos.get(2);
	}
	
	@Test
	public void usuarioConReserva(){
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
