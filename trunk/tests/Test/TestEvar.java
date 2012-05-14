package Test;

import org.junit.Assert;
import org.junit.Test;
import claseUnica.Fecha;


public class TestEvar {
	@Test
	public void tieneFormatoLatinoamericano(){
		Fecha fecha = new Fecha("29  / 03/19  91");
		System.out.println("El formato es:"+fecha.getFormato());
		Assert.assertTrue(fecha.getFormato().equals("Latinoamericano"));
	}
}