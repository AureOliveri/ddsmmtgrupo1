package test.java.testBusquedas;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.lanchita.AerolineaLanchita;
import com.lanchita.excepciones.EstadoErroneoException;

import main.java.busquedas.Buscador;
import main.java.busquedas.Busqueda;
import main.java.fechas.Fecha;
import main.java.usuarios.Usuario;
import main.java.usuarios.UsuarioEstandar;
import main.java.vuelos.Asiento;

public class TestReservaLanchita {
	private static Usuario usuario1;
	private static Usuario usuario2;
	private static Buscador buscador;
	private static Fecha fecha;
	private static Busqueda busqueda;
	private static AerolineaLanchita aerolinea;
	private static ArrayList<Asiento> asientos;
	private static Asiento asiento1;
	private static Asiento asiento2;
	private static Asiento asiento3;
	

	@Before
	public void inicializar() {
		usuario1 = new Usuario("usuario 1", "11111111", new UsuarioEstandar());
		usuario2 = new Usuario("usuario2", "22222222", new UsuarioEstandar());
		buscador = new Buscador();
		fecha = new Fecha("20/12/2012");
		busqueda = new Busqueda("PER", fecha, "USA", null);
		asientos = buscador.buscarAsientos(busqueda, usuario1);
		asiento1 = asientos.get(0);
		asiento2 = asientos.get(1);
		asiento3 = asientos.get(2);
		usuario1.reservar(asiento1);
	}

	@Test
	public void usuarioSinReservas(){
		Assert.assertTrue(usuario1.noTieneReserva(asiento2));
	}
	
	@Test
	public void usuarioConReserva(){
		Assert.assertFalse(usuario1.noTieneReserva(asiento1));
	}


	@Test (expected = EstadoErroneoException.class)
	public void reservarAsientoOcupado(){
		usuario2.reservar(asiento1);
	}
}
