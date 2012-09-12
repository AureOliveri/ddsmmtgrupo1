package testPrimerEntrega;

import org.junit.Assert;
import org.junit.Test;

import fechas.Fecha;
import fechas.parserException;


public class TestEvar {
	@Test
	public void tieneFormatoLatinoamericano() throws parserException{
		Fecha fecha = new Fecha("27  / 03/19  91");
		System.out.println("El formato es:"+fecha.getFormato());
		Assert.assertTrue(fecha.getFormato().equals("Latinoamericano"));
	}
	
	@Test
	public void tieneFormatoISO8601() throws parserException{
		Fecha fecha = new Fecha("1991-03-27");
		System.out.println("El formato es: "+fecha.getFormato());
		Assert.assertTrue(fecha.getFormato().equals("ISO8601"));
	}
}