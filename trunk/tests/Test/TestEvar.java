package Test;

import org.junit.Assert;
import org.junit.Test;
import claseUnica.Fecha;


public class TestEvar {
	@Test
	public void tieneFormatoLatinoamericano(){
		Fecha fecha = new Fecha("27  / 03/19  91");
		System.out.println("El formato es:"+fecha.getFormato());
		Assert.assertTrue(fecha.getFormato().equals("Latinoamericano"));
	}
	@Test
	public void tieneFormatoISO8601(){
		Fecha fecha = new Fecha("1991-27-03");
		System.out.println("El formato es: "+fecha.getFormato());
		Assert.assertTrue(fecha.getFormato().equals("ISO8601"));
	}
}